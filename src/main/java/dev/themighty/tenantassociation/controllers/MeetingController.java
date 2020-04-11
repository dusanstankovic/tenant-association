package dev.themighty.tenantassociation.controllers;

import dev.themighty.tenantassociation.services.MeetingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meetings")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @RequestMapping({"", "/", "/index", "index.html"})
    public String listMeetings(Model model) {
        model.addAttribute("meetings", meetingService.findAll());

        return "meetings/index";
    }
}
