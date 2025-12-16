package com.velu.GymManagementApplication.service;
import com.velu.GymManagementApplication.dto.MemberDto;
import com.velu.GymManagementApplication.entity.Member;
import com.velu.GymManagementApplication.entity.MemberShip;
import com.velu.GymManagementApplication.entity.PackageType;
import com.velu.GymManagementApplication.enums.MemberStatus;
import com.velu.GymManagementApplication.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public  MemberDto createMember( MemberDto memberDto) {

        Optional<Member> exist_member =  memberRepository.findByPhoneNo(memberDto.getPhoneNo());

        if(exist_member.isPresent()){
            throw new RuntimeException("member  already exist with this phone number");
        }

        Member member = new Member();

        member.setName(memberDto.getName());
        member.setJoinDate(LocalDate.now());
        member.setDob(memberDto.getDob());
        member.setAddress(memberDto.getAddress());
        member.setStatus(MemberStatus.IN_ACTIVE);
        member.setAssignedTrainer(memberDto.getAssignedTrainer());
        member.setPhoneNo(memberDto.getPhoneNo());

        Member saved = memberRepository.save(member);
        return convertToDto(saved);
    }


    private MemberDto convertToDto(Member member) {
        MemberDto dto = new MemberDto();

        dto.setName(member.getName());
        dto.setDob(member.getDob());
        dto.setPhoneNo(member.getPhoneNo());
        dto.setAddress(member.getAddress());
        dto.setEmergencyContact(member.getEmergencyContact());
        dto.setAssignedTrainer(member.getAssignedTrainer());

        // Read last membership
        if (member.getMemberShips() != null && !member.getMemberShips().isEmpty()) {

            MemberShip latest = member.getMemberShips()
                    .get(member.getMemberShips().size() - 1);

            PackageType pkg = latest.getPackageType();

            if (pkg != null) {
                dto.setPackageType(pkg.getPackageName().name());
                dto.setPackagePrice(pkg.getPrice());
                dto.setPackageDuration(pkg.getDuration_months());
            }

            dto.setMembershipStartDate(latest.getStartDate());
            dto.setMembershipEndDate(latest.getEndDate());
            dto.setTotalAmount(latest.getTotalAmount());
            dto.setBalance(latest.getBalance());
            dto.setAmountReceived(latest.getAmountReceived());
            dto.setBalanceStatus(
                    latest.getBalanceStatus() != null ? latest.getBalanceStatus().name() : null
            );
        }

        return dto;
    }


    public  MemberDto updateMember( Long id, MemberDto memberDto) {

      Member existing_member =  memberRepository.findById(id).orElseThrow( () -> new RuntimeException("Member is not exist"));

      if(memberDto.getName() != null){
           existing_member.setName(memberDto.getName());
      }

      if(memberDto.getAddress() != null){
          existing_member.setName(memberDto.getName());
      }

      if(memberDto.getDob() != null){
          existing_member.setDob(memberDto.getDob());
      }

      if(memberDto.getAssignedTrainer() != null){
          existing_member.setAssignedTrainer(memberDto.getAssignedTrainer());
      }

      if(memberDto.getPhoneNo() != null){
          existing_member.setPhoneNo(memberDto.getPhoneNo());
      }

      Member saved =   memberRepository.save(existing_member);
      return convertToDto(saved);

    }

    public  void deleteMember( Long id) {
       memberRepository.deleteById(id);
    }

    public List<MemberDto> getMembers() {
        List<Member> saved = memberRepository.findAll();
        return saved.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public  MemberDto getMember(Long id) {
        Member member =  memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member id is not exist" + id));
        return convertToDto(member);
    }
}
