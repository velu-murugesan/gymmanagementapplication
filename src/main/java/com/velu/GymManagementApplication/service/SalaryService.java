package com.velu.GymManagementApplication.service;
import com.velu.GymManagementApplication.dto.SalaryDto;
import com.velu.GymManagementApplication.entity.Salary;
import com.velu.GymManagementApplication.entity.Trainer;
import com.velu.GymManagementApplication.repository.SalaryRepository;
import com.velu.GymManagementApplication.repository.TrainerRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private TrainerRepository trainerRepository;

    public @Nullable Salary create(SalaryDto salaryDto) {

       Trainer trainer =  trainerRepository.findById(salaryDto.getTrainer_id()).orElseThrow(() -> new RuntimeException("Trainer id is not exist" + salaryDto.getTrainer_id()));

       Salary salary = new Salary();

       if(salaryDto.getAmount() > 0){
           salary.setAmount(salaryDto.getAmount());
       }else{
           throw new RuntimeException("amount should not be negative");
       }

       salary.setMonth(salaryDto.getMonth());
       salary.setTrainer(trainer);
       salary.setPaidOn(salaryDto.getPaidOn());

       return salaryRepository.save(salary);
    }

    public @Nullable Salary update(Long id, SalaryDto salaryDto) {

       Salary existing_salary = salaryRepository.findById(id).orElseThrow(() -> new RuntimeException("salary id is not exist"));
        Trainer trainer =  trainerRepository.findById(salaryDto.getTrainer_id()).orElseThrow(() -> new RuntimeException("Trainer id is not exist" + salaryDto.getTrainer_id()));
       if(salaryDto.getAmount() != null){
           existing_salary.setAmount(salaryDto.getAmount());
       }

       if(salaryDto.getMonth() != null){
           existing_salary.setMonth(salaryDto.getMonth());
       }

       if(salaryDto.getPaidOn() != null){
           existing_salary.setPaidOn(salaryDto.getPaidOn());
       }

       if(salaryDto.getTrainer_id() != null){
           existing_salary.setTrainer(trainer);
       }

       return salaryRepository.save(existing_salary);

    }

    public void delete(Long id) {

        salaryRepository.deleteById(id);

    }

    public @Nullable Salary getSalary(Long id) {


        return salaryRepository.findById(id).orElseThrow(() -> new RuntimeException("Salary id is not exist"));
    }

    public @Nullable List<Salary> getSalaries() {

        return salaryRepository.findAll();

    }
}
