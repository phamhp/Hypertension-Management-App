package gatech.scrubs26.hypertensionmanagement.controller;

import gatech.scrubs26.hypertensionmanagement.model.Exercise;
import gatech.scrubs26.hypertensionmanagement.service.SecurityService;
import gatech.scrubs26.hypertensionmanagement.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private SecurityService securityService;


    @GetMapping("/exercise_entry")
    public String exercise_entry(Model model) {
        //model.addAttribute("userForm", new User());

        return "exercise_entry";
    }

    @GetMapping("/exercise_hist")
    public String exercise_hist(Model model) {
        //model.addAttribute("userForm", new User());

        return "exercise_hist";
    }

}
