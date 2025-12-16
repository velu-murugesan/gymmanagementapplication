package com.velu.GymManagementApplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.velu.GymManagementApplication.enums.Pt;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class PersonalTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Pt pt;
    private Double amount;
    private LocalDate purchasedOn;
    private LocalDate expiryDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id",nullable = false)
    @JsonIgnore
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainer_id",nullable = false)
    @JsonIgnore
    private Trainer trainer;
}
