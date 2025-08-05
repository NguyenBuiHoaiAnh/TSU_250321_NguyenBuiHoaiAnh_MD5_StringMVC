package com.example.bt1_ss5.model;

public class ScreenRoom {
    private int id;
    private String screenRoomName;
    private int totalSeat;

    public ScreenRoom() {
    }

    public ScreenRoom(int id, String screenRoomName, int totalSeat) {
        this.id = id;
        this.screenRoomName = screenRoomName;
        this.totalSeat = totalSeat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getScreenRoomName() {
        return screenRoomName;
    }

    public void setScreenRoomName(String screenRoomName) {
        this.screenRoomName = screenRoomName;
    }

    public int getTotalSeat() {
        return totalSeat;
    }

    public void setTotalSeat(int totalSeat) {
        this.totalSeat = totalSeat;
    }
}
