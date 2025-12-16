package com.velu.GymManagementApplication.service;

import com.velu.GymManagementApplication.dto.PersonalTrainingDto;
import com.velu.GymManagementApplication.entity.Member;
import com.velu.GymManagementApplication.entity.PersonalTraining;
import com.velu.GymManagementApplication.entity.Trainer;
import com.velu.GymManagementApplication.enums.Pt;
import com.velu.GymManagementApplication.repository.MemberRepository;
import com.velu.GymManagementApplication.repository.PersonalTrainingRepository;
import com.velu.GymManagementApplication.repository.TrainerRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonalTrainingService {

    @Autowired
    private PersonalTrainingRepository personalTrainingRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private MemberRepository memberRepository;

    public @Nullable PersonalTraining create(PersonalTrainingDto personalTrainingDto) {

       Member member = memberRepository.findById(personalTrainingDto.getMember_id()).orElseThrow(() -> new RuntimeException("member id is not exist"));
       Trainer trainer = trainerRepository.findById(personalTrainingDto.getTrainer_id()).orElseThrow(() -> new RuntimeException("trainer id is not exist"));

       PersonalTraining personalTraining = new PersonalTraining();

       personalTraining.setMember(member);
       personalTraining.setTrainer(trainer);
        personalTraining.setPurchasedOn(personalTrainingDto.getPurchasedOn());
       personalTraining.setPt(personalTrainingDto.getPt());

       if(personalTraining.getPt() == Pt.PT_12_SESSION){
           personalTraining.setAmount(4000.00);
           personalTraining.setExpiryDate(LocalDate.now().plusMonths(1));
       }else if(personalTraining.getPt() == Pt.PT_24_SESSION){
           personalTraining.setAmount(8000.00);
           personalTraining.setExpiryDate(LocalDate.now().plusMonths(2));
       }else{
           personalTraining.setAmount(10000.00);
           personalTraining.setExpiryDate(LocalDate.now().plusMonths(3));
       }

       return personalTrainingRepository.save(personalTraining);

    }

    public @Nullable PersonalTraining update(Long id,PersonalTrainingDto personalTrainingDto) {
        Member member = memberRepository.findById(personalTrainingDto.getMember_id()).orElseThrow(() -> new RuntimeException("member id is not exist"));
        Trainer trainer = trainerRepository.findById(personalTrainingDto.getTrainer_id()).orElseThrow(() -> new RuntimeException("trainer id is not exist"));
       PersonalTraining existing_personal_training =  personalTrainingRepository.findById(id).orElseThrow(() -> new RuntimeException("personal training id is not exist"));

       if(personalTrainingDto.getMember_id() != null){
           existing_personal_training.setMember(member);
       }

       if(personalTrainingDto.getTrainer_id() != null){
           existing_personal_training.setTrainer(trainer);
       }

       if(personalTrainingDto.getPt() != null){
           existing_personal_training.setPt(personalTrainingDto.getPt());
       }

       if(personalTrainingDto.getPurchasedOn() != null){
           existing_personal_training.setPurchasedOn(personalTrainingDto.getPurchasedOn());
       }

       return personalTrainingRepository.save(existing_personal_training);

    }

    public  void delete(Long id) {
        personalTrainingRepository.deleteById(id);
    }

    public @Nullable PersonalTraining getPersonalTraining(Long id) {
        return personalTrainingRepository.findById(id).orElseThrow(() -> new RuntimeException("Personal Training id is not exist"));
    }

    public @Nullable List<PersonalTraining> getPersonalTrainings() {
        return personalTrainingRepository.findAll();
    }
}
