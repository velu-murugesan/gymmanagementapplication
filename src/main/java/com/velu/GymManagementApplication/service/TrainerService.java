package com.velu.GymManagementApplication.service;
import com.velu.GymManagementApplication.dto.TrainerDto;
import com.velu.GymManagementApplication.entity.Trainer;
import com.velu.GymManagementApplication.repository.TrainerRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    public @Nullable Trainer create(TrainerDto trainerDto) {


        Optional<Trainer> trainer_box =  trainerRepository.findByPhoneNo(trainerDto.getPhoneNo());

        if(trainer_box.isPresent()){
            throw new RuntimeException("trainer id is exist");
        }

        Trainer trainer = new Trainer();

        trainer.setName(trainerDto.getName());
        trainer.setStatus(trainerDto.getStatus());
        trainer.setPhoneNo(trainerDto.getPhoneNo());
        trainer.setSalary(trainerDto.getSalary());

        return trainerRepository.save(trainer);
    }

    public @Nullable Trainer update(Long id, TrainerDto trainerDto) {

      Trainer existing_trainer =  trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer id is not exist" + id));

      if(trainerDto.getSalary() != null){
          existing_trainer.setSalary(trainerDto.getSalary());
      }

      if(trainerDto.getName() != null){
          existing_trainer.setName(trainerDto.getName());
      }

      if(trainerDto.getStatus() != null){
          existing_trainer.setStatus(trainerDto.getStatus());
      }

      if(trainerDto.getPhoneNo() != null){
          existing_trainer.setPhoneNo(trainerDto.getPhoneNo());
      }

      return trainerRepository.save(existing_trainer);
    }

    public void delete(Long id) {
        trainerRepository.deleteById(id);
    }

    public @Nullable Trainer getTrainer(Long id) {
       return trainerRepository.findById(id).orElseThrow(() -> new RuntimeException("Trainer id is not exist"));
    }

    public @Nullable List<Trainer> getTrainers() {
        return trainerRepository.findAll();
    }
}
