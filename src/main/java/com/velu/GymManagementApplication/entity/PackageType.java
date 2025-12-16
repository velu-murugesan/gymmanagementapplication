package com.velu.GymManagementApplication.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.velu.GymManagementApplication.enums.Packages;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "packages")
public class PackageType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Packages packageName;
    private Double price;
    private Integer duration_months;
    @OneToMany(mappedBy = "packageType", fetch = FetchType.LAZY , cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MemberShip> memberShips;
}
