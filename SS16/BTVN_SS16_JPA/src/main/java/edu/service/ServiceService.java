package edu.service;

import edu.model.entity.AnlService;
import org.springframework.data.domain.Page;

public interface ServiceService {

    Page<AnlService> getAllServices (int page, int size);

    AnlService findById(Long id);

    AnlService save(AnlService anlService);

    void delete(AnlService anlService);
}
