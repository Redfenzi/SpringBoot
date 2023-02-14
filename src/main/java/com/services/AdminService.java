package com.services;

import com.dtos.AdminDto;

import java.util.List;

public interface AdminService {

    AdminDto saveAdmin(AdminDto adminDto);
    AdminDto getAdminById(Long adminId);
    boolean deleteAdmin(Long adminId);
    List<AdminDto> getAllAdmins();

}
