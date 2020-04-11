package dev.themighty.tenantassociation.controllers;

import dev.themighty.tenantassociation.services.TenantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listTenants(Model model) {
        model.addAttribute("tenants", tenantService.findAll());

        return "tenants/index";
    }
}
