package com.example.bt1_ss5.service.screenroom;

import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;

import java.util.List;

public interface ScreenRoomService {
    // Display

    List<ScreenRoom> getScreenRooms();

    List<Schedule> getScheduleByMovieID(int id);
}
