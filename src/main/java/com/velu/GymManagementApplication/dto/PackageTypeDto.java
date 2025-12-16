package com.velu.GymManagementApplication.dto;
import com.velu.GymManagementApplication.entity.MemberShip;
import com.velu.GymManagementApplication.enums.Packages;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PackageTypeDto {
    @NotNull(message = "package name id is required")
    private Packages packageName;
    @NotNull(message = "price id is required")
    private Double price;
    @NotNull(message = "duration id is required")
    private Integer duration_months;
    private List<MemberShip> memberShips;
}
