package com.velu.GymManagementApplication.service;
import com.velu.GymManagementApplication.dto.MemberShipDto;
import com.velu.GymManagementApplication.entity.Member;
import com.velu.GymManagementApplication.entity.MemberShip;
import com.velu.GymManagementApplication.entity.PackageType;
import com.velu.GymManagementApplication.enums.BalanceStatus;
import com.velu.GymManagementApplication.repository.MemberRepository;
import com.velu.GymManagementApplication.repository.MemberShipRepository;
import com.velu.GymManagementApplication.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class MemberShipService {

    @Autowired
    private MemberShipRepository memberShipRepository;

    @Autowired
    private PackageTypeRepository packageTypeRepository;

    @Autowired
    private MemberRepository memberRepository;

    public  MemberShip create(MemberShipDto memberShipDto) {

        Member member = memberRepository.findById(memberShipDto.getMember_id()).orElseThrow(() -> new RuntimeException("Member id is not exist"));
       PackageType packageType = packageTypeRepository.findById(memberShipDto.getPackageType_id()).orElseThrow(() -> new RuntimeException("Package type id is not exist"));


       MemberShip memberShip = new MemberShip();

       memberShip.setMember(member);
       memberShip.setPackageType(packageType);

       if(memberShipDto.getAmountReceived() < 0  || memberShipDto.getAmountReceived() > packageType.getPrice()){
            throw new RuntimeException("Invalid Amount Received");
       }

       memberShip.setAmountReceived(memberShipDto.getAmountReceived());
       Double total = packageType.getPrice();

       memberShip.setTotalAmount(total);

       double balance = total - memberShipDto.getAmountReceived();

       memberShip.setBalance(balance);

       if(balance == 0){
            memberShip.setBalanceStatus(BalanceStatus.PAID);
       }else if(balance > 0){
           memberShip.setBalanceStatus(BalanceStatus.PENDING);
       }

       memberShip.setStartDate(memberShipDto.getStartDate());
       memberShip.setEndDate(LocalDate.now().plusMonths(packageType.getDuration_months()));

       return memberShipRepository.save(memberShip);
    }

    public  MemberShip update(Long id, MemberShipDto memberShipDto) {

       MemberShip existing_membership = memberShipRepository.findById(id).orElseThrow(() -> new RuntimeException("Membership is not exist"));

        PackageType packageType = packageTypeRepository.findById(memberShipDto.getPackageType_id()).orElseThrow(() -> new RuntimeException("Package type id is not exist"));

        Member member = memberRepository.findById(memberShipDto.getMember_id()).orElseThrow(() -> new RuntimeException("Member id is not exist"));

        if(memberShipDto.getAmountReceived() != null){
              existing_membership.setAmountReceived(memberShipDto.getAmountReceived());
         }

         if(memberShipDto.getStartDate() != null){
             existing_membership.setStartDate(memberShipDto.getStartDate());
         }

         if(memberShipDto.getPackageType_id() != null){
             existing_membership.setPackageType(packageType);
         }
        if(memberShipDto.getMember_id() != null){
            existing_membership.setMember(member);
        }

        return memberShipRepository.save(existing_membership);

    }

    public void delete(Long id) {
        memberShipRepository.deleteById(id);
    }

    public  MemberShip getMemberShip(Long id) {
       return memberShipRepository.findById(id).orElseThrow(() -> new RuntimeException("MemberShip id is not exist"));
    }

    public  List<MemberShip> getMemberShips() {
         return memberShipRepository.findAll();
    }
}
