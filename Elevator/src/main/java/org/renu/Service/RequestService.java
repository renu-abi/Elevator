package org.renu.Service;

import org.renu.Dal.RequestRepository;
import org.renu.Model.Direction;
import org.renu.Model.Elevator;
import org.renu.Model.Request;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RequestService {
    private  Queue<Request> pendingRequest;
    private RequestRepository requestRepository;

    public RequestService(RequestRepository requestRepository){
        this.requestRepository = requestRepository;
        this.pendingRequest = new LinkedList<>();
    }
    //create new request
    public void createRequest(int requestId,int sourceFloor,int destinationFloor,Direction direction){
        Request request = new Request(requestId,sourceFloor,destinationFloor,direction);
        pendingRequest.add(request); // add to queue
        requestRepository.saveRequest(request); // save to repository
    }
    //get all pending request
    public Queue<Request> getPendingRequest(){
        return new LinkedList<>(pendingRequest);
    }

    //get all requests
    public List<Request> getAllRequest(){
        return requestRepository.getAllRequests();
    }
    //process request
    public boolean processRequest(ElevatorService elevatorService){
        List<Request> pendingRequest = requestRepository.getAllRequests();
        if(pendingRequest.isEmpty()) {
            return false;
        }
            // Find the nearest elevator and move it to the requesting floor
        for(Request request : pendingRequest){
            Elevator nearestElevator = findNearestElevator(elevatorService.getAllElevator(),request.getSourceFloor(),request.getDirection());
            if(nearestElevator != null){
                elevatorService.moveElevator(nearestElevator.getElevatorId(),request.getSourceFloor());
                elevatorService.moveElevator(nearestElevator.getElevatorId(),request.getDestinationFloor());
                requestRepository.deleteRequest(request.getRequestId());
                return true; //process successful
            }
        }
        return false; // request not found
    }

    //find nearest elevator
    private Elevator findNearestElevator(List<Elevator> elevator,int sourceFloor,Direction direction){
        Elevator nearestElevator = null;
        int minDistance = Integer.MAX_VALUE;
        for(Elevator elevators : elevator){
            int distance = Math.abs(elevators.getCurrentFloor() - sourceFloor);
            if(distance < minDistance){
                nearestElevator = elevators;
                minDistance = distance;
            }
        }
        return nearestElevator;
    }
    // cancel request
    public void cancelRequest(int requestId){
        requestRepository.deleteRequest(requestId);
    }
    //update request
    public boolean updateRequest(int requestId,int newDestinationFloor){
        Request request = requestRepository.findRequestById(requestId);
        if(request != null){
            request.setDestinationFloor(newDestinationFloor);
            requestRepository.updateRequest(request);
            return true;
        }
        return false;
    }
}
