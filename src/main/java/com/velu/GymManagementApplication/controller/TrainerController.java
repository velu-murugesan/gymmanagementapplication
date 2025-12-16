package com.velu.GymManagementApplication.controller;

import com.velu.GymManagementApplication.dto.TrainerDto;
import com.velu.GymManagementApplication.entity.Trainer;
import com.velu.GymManagementApplication.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;


    @PostMapping
    public ResponseEntity<Trainer> create(@RequestBody TrainerDto trainerDto){
        return ResponseEntity.ok(trainerService.create(trainerDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Trainer> update(@PathVariable Long id,@RequestBody TrainerDto trainerDto){
        return ResponseEntity.ok(trainerService.update(id,trainerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
       trainerService.delete(id);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trainer> getTrainer(@PathVariable Long id){
        return ResponseEntity.ok(trainerService.getTrainer(id));
    }


    @GetMapping()
    public ResponseEntity<List<Trainer>> getTrainers(){
        return ResponseEntity.ok(trainerService.getTrainers());
    }
}
