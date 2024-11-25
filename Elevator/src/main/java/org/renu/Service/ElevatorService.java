package org.renu.Service;

import org.renu.Dal.ElevatorRepository;
import org.renu.Model.Elevator;

import java.util.List;

public class ElevatorService {
    private ElevatorRepository elevatorRepository;

    public ElevatorService(ElevatorRepository elevatorRepository){
        this.elevatorRepository = elevatorRepository;
    }
    
    
    //get all elevators
    public List<Elevator> getAllElevator(){
        return elevatorRepository.getAllElevator();
    }
    //find an elevator by it id
    public Elevator getElevatorById(int elevatorId){
        return elevatorRepository.findElevatorById(elevatorId);
    }
    // move the elevator to target floor
    public boolean moveElevator(int elevatorId,int targetFloor){
        Elevator elevator = elevatorRepository.findElevatorById(elevatorId);
        if(elevator != null){
            if(elevator.getCurrentFloor() == targetFloor){
                return false; // no movement necessary
            }
            elevator.setCurrentFloor(targetFloor);
            elevatorRepository.updateElevator(elevator);// update elevator state in repository
            return true; //movement successful
        }
        return false;
    }
    // add new elevator
    public void addElevator(Elevator elevator){
        elevatorRepository.addElevator(elevator);
    }
    // remove an elevator
    public void removeElevator(int elevatorId){
         elevatorRepository.deleteElevator(elevatorId);
    }
    //check if elevator is full
    public boolean isElevatorFull(int elevatorId){
        Elevator elevator = elevatorRepository.findElevatorById(elevatorId);
        if(elevator != null) {
            return elevator.getCapacity() <= elevator.getCurrentOccupancy();
        }
        return false; // if elevator is not found
    }
    //update occupancy
    public boolean updateOccupancy(int elevatorId,int occupancy){
        Elevator elevator = elevatorRepository.findElevatorById(elevatorId);
        // check if occupancy is within elevator capacity
        if(elevator!= null){
            if(occupancy <= elevator.getCapacity()){
                elevator.setCurrentOccupancy(occupancy);
                elevatorRepository.updateElevator(elevator);
                return true;
            }
            return false;
        }
        return false;
    }

    public void createElevator(int elevatorId, int capacity, int i){
        Elevator elevator = new Elevator(elevatorId,capacity);
        elevatorRepository.addElevator(elevator);
    }
}
