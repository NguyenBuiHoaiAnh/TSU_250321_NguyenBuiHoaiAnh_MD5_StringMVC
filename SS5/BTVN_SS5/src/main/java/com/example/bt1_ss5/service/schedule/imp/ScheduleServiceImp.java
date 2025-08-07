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

    @Override
    public List<Schedule> getAllSchedules() {
        return scheduleDao.getAllSchedule();
    }

    @Override
    public boolean addSchedules(Schedule schedule) {
        return scheduleDao.addSchedules(schedule);
    }

    @Override
    public Schedule getSchedulesById(int id) {
        return null;
    }

    @Override
    public boolean updateSchedules(Schedule schedule) {
        return false;
    }

    @Override
    public boolean deleteSchedules(int id) {
        return false;
    }
}
