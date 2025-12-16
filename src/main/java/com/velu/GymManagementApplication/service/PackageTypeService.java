package com.velu.GymManagementApplication.service;
import com.velu.GymManagementApplication.dto.PackageTypeDto;
import com.velu.GymManagementApplication.entity.PackageType;
import com.velu.GymManagementApplication.repository.PackageTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PackageTypeService {

    @Autowired
    private PackageTypeRepository packageTypeRepository;

    public PackageType create(PackageTypeDto packageTypeDto) {

       Optional<PackageType> packageType_box =  packageTypeRepository.findByPackageName(packageTypeDto.getPackageName());

       if(packageType_box.isPresent()){
           throw new RuntimeException("Package is already exist");
       }

        PackageType packageType = new PackageType();

        packageType.setPackageName(packageTypeDto.getPackageName());

        if(packageTypeDto.getPrice() < 0){
              throw new RuntimeException("Price can't be negative");
        }
        packageType.setPrice(packageTypeDto.getPrice());
        if(packageTypeDto.getDuration_months() < 0){
            throw  new RuntimeException("duration can't be negative");
        }

        packageType.setDuration_months(packageTypeDto.getDuration_months());

        return packageTypeRepository.save(packageType);
    }

    public  PackageType update(Long id,PackageTypeDto packageTypeDto) {

      PackageType existing_package =  packageTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Package type id is not exist"));

      if(packageTypeDto.getPackageName() != null){
          existing_package.setPackageName(packageTypeDto.getPackageName());
      }

      if(packageTypeDto.getPrice() != null){
          existing_package.setPrice(packageTypeDto.getPrice());
      }

      if(packageTypeDto.getDuration_months() != null){
          existing_package.setDuration_months(packageTypeDto.getDuration_months());
      }

      return packageTypeRepository.save(existing_package);

    }

    public void delete(Long id) {
        packageTypeRepository.deleteById(id);
    }

    public  PackageType getPackage(Long id) {
        return packageTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Package type id is not exist" + id));
    }

    public  List<PackageType> getPackages() {
        return packageTypeRepository.findAll();
    }
}
