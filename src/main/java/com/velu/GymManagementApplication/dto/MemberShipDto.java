package com.velu.GymManagementApplication.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class MemberShipDto {
    @NotBlank(message = "amountReceived is required")
    private Double amountReceived;
    @PastOrPresent(message = "Date must not be in the future")
    @NotNull(message = "startDate is required")
    private LocalDate startDate;
    @NotNull(message = "member id is required")
    private Long member_id;
    @NotNull(message = "packageType id is required")
    private Long packageType_id;
}
