package com.velu.GymManagementApplication.controller;
import com.velu.GymManagementApplication.dto.MemberDto;
import com.velu.GymManagementApplication.entity.Member;
import com.velu.GymManagementApplication.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    private ResponseEntity<MemberDto> createMember(@RequestBody MemberDto memberDto){
        return ResponseEntity.ok(memberService.createMember(memberDto));
    }

    @PatchMapping("/{id}")
    private ResponseEntity<MemberDto> updateMember(@PathVariable  Long id, @RequestBody MemberDto memberDto){
         return ResponseEntity.ok(memberService.updateMember(id,memberDto));
    }

    @DeleteMapping("/{id}")
    private  ResponseEntity<Void> deleteMember(@PathVariable  Long id){
           memberService.deleteMember(id);
          return ResponseEntity.ok().build();
    }

    @GetMapping
    private ResponseEntity<List<MemberDto>> getMembers(){
          return ResponseEntity.ok(memberService.getMembers());
    }

    @GetMapping("/{id}")
    private ResponseEntity<MemberDto> getMember(@PathVariable Long id){
        return ResponseEntity.ok(memberService.getMember(id));
    }

}
