package edu.service.imp;

import edu.model.entity.Bus;
import edu.repo.BusRepo;
import edu.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private BusRepo busRepo;

    @Override
    public Page<Bus> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return busRepo.findAll(pageable);
    }

    @Override
    public List<Bus> findAll() {
        return busRepo.findAll();
    }

    @Override
    public boolean findByLicensePlate(String licensePlate) {
        return busRepo.findByLicensePlate(licensePlate);
    }

    @Override
    public Bus save(Bus bus) {
        return busRepo.save(bus);
    }

    @Override
    public Bus findById(Long id) {
        return busRepo.findById(id).orElse(null);
    }

    @Override
    public void delete(Bus bus) {
        busRepo.delete(bus);
    }
}
