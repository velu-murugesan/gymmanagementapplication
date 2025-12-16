package com.velu.GymManagementApplication.dto;
import lombok.Data;
import java.time.LocalDate;


@Data
public class MemberDto {
    private String name;
    private LocalDate dob;
    private String phoneNo;
    private String address;
    private String emergencyContact;
    private String assignedTrainer;

    // membership summary
    private String packageType;
    private Double packagePrice;
    private Integer packageDuration;
    private LocalDate membershipStartDate;
    private LocalDate membershipEndDate;
    private Double totalAmount;
    private Double balance;
    private Double amountReceived;
    private String balanceStatus;

}
