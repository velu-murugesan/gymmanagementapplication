package com.velu.GymManagementApplication.dto;
import com.velu.GymManagementApplication.enums.Pt;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalTrainingDto {

    private Pt pt;
    private LocalDate purchasedOn;
    private Long member_id;
    private Long trainer_id;
}
