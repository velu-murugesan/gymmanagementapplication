package com.velu.GymManagementApplication.repository;

import com.velu.GymManagementApplication.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
