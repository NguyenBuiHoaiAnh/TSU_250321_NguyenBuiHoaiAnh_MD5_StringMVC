package edu.service;

import edu.model.entity.Schedule;
import org.springframework.data.domain.Page;

public interface ScheduleService {

    Page<Schedule> findAll(int page, int size);

    Schedule findById(Long id);

    Schedule save(Schedule schedule);

    void delete(Schedule schedule);
}
