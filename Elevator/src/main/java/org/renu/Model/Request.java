package org.renu.Model;

import java.util.LinkedList;
import java.util.Queue;

public class Request {
    private int requestId;
    private int sourceFloor;
    private int destinationFloor;
    private Direction direction;
    private Queue<Request> pendingRequest;

    public Request(int sourceFloor, int destinationFloor, int floor, Direction direction){
        this.sourceFloor = sourceFloor;
        this.destinationFloor = destinationFloor;
        this.direction = direction;
        this.pendingRequest = new LinkedList<>();
    }

        //add a new request to the queue
    public void addRequest(Request request){
        pendingRequest.offer(request);
    }
    //get next request from queue
    public Request getNextRequest(){
        return pendingRequest.poll();
    }
    //check if any pending request
    public boolean hasPendingRequest(){
        return !pendingRequest.isEmpty();

    }


    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}

