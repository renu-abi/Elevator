package org.renu.Model;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Elevator {
    private int elevatorId;
    private int currentFloor;
    private int capacity;
    private int currentOccupancy;
    private Direction direction;
    private Queue<Integer> targetFloor;
    private boolean isMoving;

    public Elevator(int elevatorId,int capacity){
        this.elevatorId = elevatorId;
        this.capacity = capacity;
        this.currentFloor = 0;
        this.currentOccupancy = 0;
        this.direction = Direction.IDLE;
        this.targetFloor = new LinkedList<>();
        this.isMoving = false;
    }
    //move the elevator to a specific floor
    public void moveToFloor(int floor){
        this.currentFloor = floor;
        //once elevator reaches thr floor,remove the floor from target queue
        targetFloor.poll();
    }
    //add passenger ensure capacity is not exceeded
    public boolean addPassenger(){
        if(currentOccupancy < capacity){
            currentOccupancy++;
            return true;
        }
        else{
            return false;
        }
    }
    //remove passenger
    public void removePassenger(){
        if(currentOccupancy > 0){
            currentOccupancy--;
        }
    }

    public int getElevatorId(){
        return elevatorId;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getCapacity() {
        return capacity;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getCurrentOccupancy() {
        return currentOccupancy;
    }

    public void setCurrentOccupancy(int currentOccupancy) {
        this.currentOccupancy = currentOccupancy;
    }

    public Queue<Integer> getTargetFloor() {
        return targetFloor;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

}
