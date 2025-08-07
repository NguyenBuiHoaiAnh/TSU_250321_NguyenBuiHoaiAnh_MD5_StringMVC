package com.example.bt1_ss5.repo.schedule;

import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.model.ScreenRoom;

import java.util.List;

public interface ScheduleDao {
    // Display
    List<Schedule> getAllSchedule();

    // Add
    boolean addSchedules(Schedule schedule);

    // Update
    Schedule getScheduleById(int id);

    boolean updateSchedule(Schedule schedule);

    // Delete
    boolean deleteSchedules(int id);

}
