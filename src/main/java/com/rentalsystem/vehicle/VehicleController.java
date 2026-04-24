package com.rentalsystem.vehicle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/vehicle", "/vehicles"})
public class VehicleController {

    @GetMapping("/list")
    public String listVehicles() {
        return "vehicle/list-vehicles";
    }

    @GetMapping("/add")
    public String addVehicle() {
        return "vehicle/add-vehicle";
    }

    @GetMapping("/edit")
    public String editVehicle() {
        return "vehicle/edit-vehicle";
    }

    @GetMapping("/search")
    public String searchVehicle() {
        return "vehicle/search-vehicle";
    }
}