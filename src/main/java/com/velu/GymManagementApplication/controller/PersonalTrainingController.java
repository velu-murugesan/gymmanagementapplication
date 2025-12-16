package com.velu.GymManagementApplication.controller;

import com.velu.GymManagementApplication.dto.PersonalTrainingDto;
import com.velu.GymManagementApplication.entity.PersonalTraining;
import com.velu.GymManagementApplication.service.PersonalTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personal-trainings")
public class PersonalTrainingController {

    @Autowired
    private PersonalTrainingService personalTrainingService;

    @PostMapping
    public ResponseEntity<PersonalTraining> create(@RequestBody PersonalTrainingDto personalTrainingDto){
        return ResponseEntity.ok(personalTrainingService.create(personalTrainingDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PersonalTraining> update(@PathVariable Long id, @RequestBody PersonalTrainingDto personalTrainingDto){
        return ResponseEntity.ok(personalTrainingService.update(id,personalTrainingDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       personalTrainingService.delete(id);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonalTraining> getPersonalTraining(@PathVariable Long id){
        return ResponseEntity.ok(personalTrainingService.getPersonalTraining(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonalTraining>> getPersonalTrainings(){
        return ResponseEntity.ok(personalTrainingService.getPersonalTrainings());
    }

}
