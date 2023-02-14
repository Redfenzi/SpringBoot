package com.services.impl;

import com.dtos.AdminDto;
import com.entities.Admin;
import com.repositories.AdminRepository;
import com.services.AdminService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("AdminService")
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminDto saveAdmin(AdminDto adminDto) {
        Admin admin = adminDtoToEntity(adminDto);
        admin = adminRepository.save(admin);
        return adminEntityToDto(admin);
    }

    @Override
    public AdminDto getAdminById(Long adminId) {
        Admin admin = adminRepository.getById(adminId);
        return adminEntityToDto(admin);
    }

    @Override
    public boolean deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
        return true;
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<AdminDto> adminDtos = new ArrayList<>();
        List<Admin> admins = adminRepository.findAll();
        admins.forEach(admin -> {
            adminDtos.add(adminEntityToDto(admin));
        });
        return adminDtos;
    }

    public Admin adminDtoToEntity(AdminDto adminDto){
        Admin admin = new Admin();
        admin.setPassword(adminDto.getPassword());
        return admin;

    }

    public AdminDto adminEntityToDto(Admin admin){
        AdminDto adminDto = new AdminDto();
        adminDto.setPassword(admin.getPassword());
        return adminDto;
    }
}
