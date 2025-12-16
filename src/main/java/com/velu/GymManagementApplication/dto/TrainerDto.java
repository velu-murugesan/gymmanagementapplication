package com.velu.GymManagementApplication.dto;

import com.velu.GymManagementApplication.entity.PersonalTraining;
import com.velu.GymManagementApplication.entity.Salary;
import com.velu.GymManagementApplication.enums.MemberStatus;
import lombok.Data;

import java.util.List;

@Data
public class TrainerDto {

    private String name;
    private String phoneNo;
    private MemberStatus status;
    private Double salary;
    private List<PersonalTraining> personalTraining;
    private List<Salary> trainerSalary;

}
