package org.renu;

import org.renu.Dal.ElevatorRepository;
import org.renu.Dal.RequestRepository;
import org.renu.InMemoryRepository.InMemoryElevatorRepository;
import org.renu.InMemoryRepository.InMemoryRequestRepository;
import org.renu.Model.Direction;
import org.renu.Model.Elevator;
import org.renu.Model.Request;
import org.renu.Service.ElevatorService;
import org.renu.Service.RequestService;


import java.util.Queue;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Initialize repositories
        RequestRepository requestRepository = new InMemoryRequestRepository();
        ElevatorRepository elevatorRepository = new InMemoryElevatorRepository();

        // Initialize services
        ElevatorService elevatorService = new ElevatorService(elevatorRepository);
        RequestService requestService = new RequestService(requestRepository);

        // Add elevators
        elevatorService.addElevator(new Elevator(1, 5)); // Elevator 1 with capacity 5
        elevatorService.addElevator(new Elevator(2, 5)); // Elevator 2 with capacity 5
        elevatorService.addElevator(new Elevator(3, 5)); // Elevator 3 with capacity 5

        // Create requests
        requestService.createRequest(1, 0, 5, Direction.UP);
        requestService.createRequest(2, 5, 0, Direction.DOWN);
        requestService.createRequest(3, 2, 6, Direction.UP);
        requestService.createRequest(4, 3, 1, Direction.DOWN);

        // Process requests
        boolean isProcessed = requestService.processRequest(elevatorService);


        // Output the status of the request processing
        if (isProcessed) {
            System.out.println("Requests processed successfully.");
        } else {
            System.out.println("No requests were processed.");
        }

        // Check remaining requests
        System.out.println("\nRemaining Requests:");
        Queue<Request> pendingRequests = requestService.getPendingRequest();
        if (pendingRequests.isEmpty()) {
            System.out.println("No remaining requests.");
        } else {
            for (Request request : pendingRequests) {
                System.out.println("Request ID: " + request.getRequestId() +
                        ", From Floor: " + request.getSourceFloor() +
                        ", To Floor: " + request.getDestinationFloor() +
                        ", Direction: " + request.getDirection());
            }
        }
    }
}


