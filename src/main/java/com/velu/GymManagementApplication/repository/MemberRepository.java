package com.velu.GymManagementApplication.repository;

import com.velu.GymManagementApplication.dto.MemberDto;
import com.velu.GymManagementApplication.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {

     Optional<Member> findByPhoneNo(String phoneNo);

}
