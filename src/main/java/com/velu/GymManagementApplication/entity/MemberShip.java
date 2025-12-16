package com.velu.GymManagementApplication.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.velu.GymManagementApplication.enums.BalanceStatus;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class MemberShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalAmount;
    private Double amountReceived;
    private Double balance;
    private LocalDate startDate;
    private LocalDate endDate;
    private BalanceStatus balanceStatus;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "member_id",nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "package_id",nullable = false)
    @JsonIgnore
    private PackageType packageType;
}
