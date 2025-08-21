package edu.repo;

import edu.model.entity.AnlService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnlServiceRepo extends JpaRepository<AnlService, Long> {
}
