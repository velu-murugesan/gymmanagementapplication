package com.velu.GymManagementApplication.controller;

import com.velu.GymManagementApplication.dto.SalaryDto;
import com.velu.GymManagementApplication.entity.Salary;
import com.velu.GymManagementApplication.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/salaries")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping
    public ResponseEntity<Salary> create(@RequestBody SalaryDto salaryDto){

        return ResponseEntity.ok(salaryService.create(salaryDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Salary> update(@PathVariable Long id,@RequestBody SalaryDto salaryDto){
        return ResponseEntity.ok(salaryService.update(id,salaryDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        salaryService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salary> getSalary(@PathVariable Long id){
        return ResponseEntity.ok(salaryService.getSalary(id));
    }

    @GetMapping
    public ResponseEntity<List<Salary>> getSalaries(){
        return ResponseEntity.ok(salaryService.getSalaries());
    }
}
