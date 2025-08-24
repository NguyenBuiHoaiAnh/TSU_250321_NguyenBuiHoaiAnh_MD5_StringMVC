package edu.service;

import edu.model.entity.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface BusService {
    Page<Bus> findAll(int page, int size);

    List<Bus> findAll();

    boolean findByLicensePlate(String licensePlate);

    Bus save(Bus bus);

    Bus findById(Long id);

    void delete(Bus bus);
}
