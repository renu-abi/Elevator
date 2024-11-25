package org.renu.Dal;

import org.renu.Model.Elevator;
import org.renu.Service.ElevatorService;

import java.util.List;

public interface ElevatorRepository {
    Elevator findElevatorById(int elevatorId);
    List<Elevator> getAllElevator();
    void addElevator(Elevator elevator);
    void updateElevator(Elevator elevator);
    void deleteElevator(int elevatorId);

}
