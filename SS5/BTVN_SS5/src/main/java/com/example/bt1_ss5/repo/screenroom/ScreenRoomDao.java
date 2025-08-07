package com.example.bt1_ss5.repo.screenroom;

import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;

import java.util.List;

public interface ScreenRoomDao {
    List<ScreenRoom> getAllScreenRoom();

    List<Schedule> getAllScheduleByMovieID(int id);
}
