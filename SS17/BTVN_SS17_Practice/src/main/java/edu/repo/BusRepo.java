package edu.repo;

import edu.model.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepo extends JpaRepository<Bus, Long> {
    boolean findByLicensePlate(String licensePlate);
}
