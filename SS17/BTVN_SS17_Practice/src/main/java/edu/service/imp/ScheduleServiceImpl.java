package edu.service.imp;

import edu.model.entity.Bus;
import edu.model.entity.Schedule;
import edu.model.entity.TypeSeat;
import edu.repo.ScheduleRepo;
import edu.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepo scheduleRepo;

    public Page<Schedule> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return scheduleRepo.findAll(pageable);
    }

    public Schedule save(Schedule schedule) {
        // Set price theo loại ghế
        TypeSeat type = schedule.getBus().getTypeSeat();
        double price = switch (type) {
            case STANDARD -> 50000;
            case VIP -> 70000;
            case LUXURY -> 90000;
        };
        schedule.setPrice(price);
        return scheduleRepo.save(schedule);
    }

    public Schedule findById(Long id) {
        return scheduleRepo.findById(id).orElse(null);
    }

    public void delete(Schedule schedule) {
        scheduleRepo.delete(schedule);
    }
}
