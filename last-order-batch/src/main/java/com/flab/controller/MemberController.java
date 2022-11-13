package com.flab.controller;

import com.flab.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

    @GetMapping("/test")
    public String test() {
        Member member = new Member();
        member.setName("길동이");
        member.setAge(29);

        return  member.getName() + " / "+ member.getAge();
    }

}
