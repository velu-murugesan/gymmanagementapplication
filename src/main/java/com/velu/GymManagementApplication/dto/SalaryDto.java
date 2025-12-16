package com.velu.GymManagementApplication.dto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SalaryDto {
    private LocalDate month;
    private Double amount;
    private LocalDate paidOn;
    private Long trainer_id;
}
