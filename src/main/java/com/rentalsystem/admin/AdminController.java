package com.rentalsystem.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/admin", "/staff"})
public class AdminController {

    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/admin-dashboard";
    }

    @GetMapping({"/employees", "/manage"})
    public String manageEmployees() {
        return "admin/manage-employees";
    }
}