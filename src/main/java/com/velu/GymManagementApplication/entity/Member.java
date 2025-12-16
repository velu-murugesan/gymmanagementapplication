package com.velu.GymManagementApplication.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.velu.GymManagementApplication.enums.MemberStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "members")
public class Member {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dob;
    private String phoneNo;
    private String address;
    private LocalDate joinDate;
    private MemberStatus status;
    private String assignedTrainer;
    private String emergencyContact;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MemberShip> memberShips;
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PersonalTraining> personalTrainings;
}
