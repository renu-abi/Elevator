package org.renu.InMemoryRepository;

import org.renu.Dal.ElevatorRepository;
import org.renu.Model.Elevator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryElevatorRepository implements ElevatorRepository {
    private ConcurrentHashMap<Integer, Elevator> elevatorMap = new ConcurrentHashMap<>();

    @Override
    public Elevator findElevatorById(int elevatorId) {
        return elevatorMap.get(elevatorId);
    }

    @Override
    public List<Elevator> getAllElevator() {
        return new ArrayList<>(elevatorMap.values()); //return a copy of all elevators
    }

    @Override
    public void addElevator(Elevator elevator) {
        elevatorMap.put(elevator.getElevatorId(), elevator); //thread safe add elevator
    }

    @Override
    public void updateElevator(Elevator elevator) {
        elevatorMap.put(elevator.getElevatorId(), elevator); //thread safe update
    }

    @Override
    public void deleteElevator(int elevatorId) {
        elevatorMap.remove(elevatorId);
    }
}
