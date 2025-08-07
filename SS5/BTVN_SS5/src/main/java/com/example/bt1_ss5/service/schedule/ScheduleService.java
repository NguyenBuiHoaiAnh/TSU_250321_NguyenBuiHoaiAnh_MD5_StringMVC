package com.example.bt1_ss5.service.schedule;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.model.Schedule;

import java.util.List;

public interface ScheduleService {
    // Display
    List<Schedule> getAllSchedules();

    // Add
    boolean addSchedules(Schedule schedule);

    // Update And Delete
    Schedule getSchedulesById(int id);

    boolean updateSchedules(Schedule schedule);

    boolean deleteSchedules(int id);

}
