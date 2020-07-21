package com.silence.app.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/manager/api/v1/students")
public class UserManagerController {

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public String get() {
        return "manager  get  method ";
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('STUDENT:WRITE')")
    public String insert() {
        return "manager Post method";
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('STUDENT:WRITE')")
    public String update() {
        return "manager Update method";
    }

    @DeleteMapping
    @PreAuthorize("hasAnyAuthority('STUDENT:WRITE')")
    public String delete() {
        return "manager Delete method";
    }

}
