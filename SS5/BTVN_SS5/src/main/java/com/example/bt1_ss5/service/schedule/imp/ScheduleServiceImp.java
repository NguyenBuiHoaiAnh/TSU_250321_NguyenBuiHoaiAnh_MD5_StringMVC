package com.example.bt1_ss5.service.schedule.imp;

import com.example.bt1_ss5.model.Movie;
import com.example.bt1_ss5.model.Schedule;
import com.example.bt1_ss5.repo.schedule.ScheduleDao;
import com.example.bt1_ss5.repo.schedule.imp.ScheduleDaoImp;
import com.example.bt1_ss5.service.schedule.ScheduleService;

import java.util.List;

public class ScheduleServiceImp implements ScheduleService {
    private ScheduleDao scheduleDao;

    public ScheduleServiceImp() {
        scheduleDao = new ScheduleDaoImp();
    }

    // Display
    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleDao.getAllSchedule();
    }

    // Add
    @Override
    public boolean addSchedules(Schedule schedule) {
        return scheduleDao.addSchedules(schedule);
    }

    // Update
    @Override
    public Schedule getSchedulesById(int id) {
        return scheduleDao.getScheduleById(id);
    }

    @Override
    public boolean updateSchedules(Schedule schedule) {
        return scheduleDao.updateSchedule(schedule);
    }

    // Delete
    @Override
    public boolean deleteSchedules(int id) {
        return scheduleDao.deleteSchedules(id);
    }
}
