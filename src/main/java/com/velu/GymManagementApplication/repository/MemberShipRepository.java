package com.velu.GymManagementApplication.repository;
import com.velu.GymManagementApplication.entity.MemberShip;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberShipRepository extends JpaRepository<MemberShip,Long> {
}
