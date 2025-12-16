package com.velu.GymManagementApplication.repository;
import com.velu.GymManagementApplication.dto.PackageTypeDto;
import com.velu.GymManagementApplication.entity.PackageType;
import com.velu.GymManagementApplication.enums.Packages;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PackageTypeRepository extends JpaRepository<PackageType,Long> {


    Optional<PackageType> findByPackageName(@NotNull(message = "package name id is required") Packages packageName);
}
