package edu.service.imp;

import edu.repo.AnlServiceRepo;
import edu.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import edu.model.entity.AnlService;


@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private AnlServiceRepo anlServiceRepo;

    @Override
    public Page<AnlService> getAllServices(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").descending());
        return anlServiceRepo.findAll(pageable);
    }

    @Override
    public AnlService findById(Long id) {
        return anlServiceRepo.findById(id).orElse(null);
    }

    @Override
    public AnlService save(AnlService anlService) {
        return anlServiceRepo.save(anlService);
    }

    @Override
    public void delete(AnlService anlService) {
        anlServiceRepo.delete(anlService);
    }

}
