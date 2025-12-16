package com.velu.GymManagementApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate month;
    private Double amount;
    private LocalDate paidOn;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "trainer_id",nullable = false)
    @JsonIgnore
    private Trainer trainer;
}
