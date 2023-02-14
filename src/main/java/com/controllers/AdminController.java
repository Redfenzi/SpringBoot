package com.controllers;

import com.dtos.AdminDto;
import com.services.impl.AdminServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    private final AdminServiceImpl adminService;

    public AdminController(AdminServiceImpl adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<AdminDto> getAdmin(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminDto getAdmin(@PathVariable Long id){
        return adminService.getAdminById(id);
    }

    @PostMapping
    public AdminDto saveAdmin(final @RequestBody AdminDto adminDto){
        return adminService.saveAdmin(adminDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteAdmin(@PathVariable Long id){
        return adminService.deleteAdmin(id);
    }
}
