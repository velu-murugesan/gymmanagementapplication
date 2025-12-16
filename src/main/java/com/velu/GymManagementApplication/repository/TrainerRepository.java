package com.velu.GymManagementApplication.repository;
import com.velu.GymManagementApplication.entity.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer,Long> {
    Optional<Trainer> findByPhoneNo(String phoneNo);
}
