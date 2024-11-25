package org.renu.Model;

public class Floor {
    private int floorNo;
    private boolean hasRequest;

    public Floor(int floorNo){
        this.floorNo = floorNo;
        this.hasRequest = false;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public boolean HasRequest() {
        return hasRequest;
    }

    public void setHasRequest(boolean hasRequest) {
        this.hasRequest = hasRequest;
    }
}




