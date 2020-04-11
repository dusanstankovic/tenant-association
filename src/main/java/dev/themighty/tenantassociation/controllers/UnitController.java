package dev.themighty.tenantassociation.controllers;

import dev.themighty.tenantassociation.services.UnitService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/units")
public class UnitController {

    private final UnitService unitService;

    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listUnits(Model model) {
        model.addAttribute("units", unitService.findAll());

        return "units/index";
    }
}
