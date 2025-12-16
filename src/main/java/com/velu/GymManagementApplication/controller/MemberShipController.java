package com.velu.GymManagementApplication.controller;
import com.velu.GymManagementApplication.dto.MemberShipDto;
import com.velu.GymManagementApplication.entity.MemberShip;
import com.velu.GymManagementApplication.service.MemberShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/memberships")
public class MemberShipController {

    @Autowired
    private MemberShipService memberShipService;


    @PostMapping
    public ResponseEntity<MemberShip> create(@RequestBody MemberShipDto memberShipDto){
        return ResponseEntity.ok(memberShipService.create(memberShipDto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MemberShip> update(@PathVariable Long id,@RequestBody MemberShipDto memberShipDto){
          return ResponseEntity.ok(memberShipService.update(id,memberShipDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         memberShipService.delete(id);
         return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MemberShip> getMemberShip(@PathVariable Long id){
        return ResponseEntity.ok(memberShipService.getMemberShip(id));
    }

    @GetMapping
    public ResponseEntity<List<MemberShip>> getMemberShips(){
         return ResponseEntity.ok(memberShipService.getMemberShips());
    }
}
