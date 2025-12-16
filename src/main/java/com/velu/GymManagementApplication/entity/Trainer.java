package com.velu.GymManagementApplication.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.velu.GymManagementApplication.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainer_id;
    private String name;
    private String phoneNo;
    private MemberStatus status;
    private Double salary;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PersonalTraining> personalTraining;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Salary> trainerSalary;
}
