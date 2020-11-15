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

@Controller
public class DietController {
    @Autowired
    private DietService dietService;

    @GetMapping("/diet_entry")
    public String diet_entry(Model model) {
        model.addAttribute("dietForm", new Diet());
        return "diet_entry";
    }

    @PostMapping("/diet_entry")
    public String diet_entry(@ModelAttribute("dietForm") Diet dietForm, BindingResult bindingResult) {
        dietService.save(dietForm);
        return "redirect:/home";
    }

    // Return all history of diet entries with evaluation
    @GetMapping(value = "/diet_history", produces = MediaType.APPLICATION_JSON_VALUE)
    public String dietEntryHistory(HttpServletRequest request) {

        List<Diet> currentDietEntries = dietService.findAll();
        // Need to implement business logic to evaluate Diet entries
        request.setAttribute("dietEntries", currentDietEntries);

        return "diet_history";
    }
}
