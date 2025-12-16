package com.velu.GymManagementApplication.controller;
import com.velu.GymManagementApplication.dto.PackageTypeDto;
import com.velu.GymManagementApplication.entity.PackageType;
import com.velu.GymManagementApplication.service.PackageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/packages")
public class PackageTypeController {

    @Autowired
    private PackageTypeService packageTypeService;

    @PostMapping
    public ResponseEntity<PackageType> create(@RequestBody PackageTypeDto packageTypeDto){
        return ResponseEntity.ok(packageTypeService.create(packageTypeDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PackageType> update(@PathVariable Long id, @RequestBody PackageTypeDto packageTypeDto){
        return ResponseEntity.ok(packageTypeService.update(id,packageTypeDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         packageTypeService.delete(id);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PackageType> getPackage(@PathVariable Long id){
        return ResponseEntity.ok(packageTypeService.getPackage(id));
    }

    @GetMapping
    public ResponseEntity<List<PackageType>> getPackages(){
        return ResponseEntity.ok(packageTypeService.getPackages());
    }
}
