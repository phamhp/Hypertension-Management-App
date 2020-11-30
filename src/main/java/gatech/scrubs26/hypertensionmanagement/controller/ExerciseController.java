package gatech.scrubs26.hypertensionmanagement.controller;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import gatech.scrubs26.hypertensionmanagement.model.User;
import gatech.scrubs26.hypertensionmanagement.service.DietService;
import gatech.scrubs26.hypertensionmanagement.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
import java.util.List;
import java.util.Map;

@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercise_entry")
    public String exercise_entry(Model model) {
        model.addAttribute("exerciseForm", new Exercise());
        return "exercise_entry";
    }

    @PostMapping("/exercise_entry")
    public String exercise_entry(@ModelAttribute("exerciseForm") Exercise exerciseForm, BindingResult bindingResult) {
        exerciseService.save(exerciseForm);
        return "redirect:/home";
    }

    @GetMapping(value = "/exercise_hist", produces = MediaType.APPLICATION_JSON_VALUE)
    public String exercise_hist(HttpServletRequest request) {
        List<Exercise> currentExerciseEntries = (List<Exercise>) exerciseService.findAll();
        request.setAttribute("exerciseEntries", currentExerciseEntries);
        List<Exercise> AllExercises = exerciseService.findAll();
        return "exercise_hist";
    }
}