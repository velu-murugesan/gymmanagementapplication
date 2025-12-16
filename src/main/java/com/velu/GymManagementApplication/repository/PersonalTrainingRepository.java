package com.velu.GymManagementApplication.repository;
import com.velu.GymManagementApplication.entity.PersonalTraining;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalTrainingRepository extends JpaRepository<PersonalTraining,Long> {
}
