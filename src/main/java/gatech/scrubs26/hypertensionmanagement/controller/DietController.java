package gatech.scrubs26.hypertensionmanagement.controller;

import gatech.scrubs26.hypertensionmanagement.model.Diet;
import gatech.scrubs26.hypertensionmanagement.model.User;
import gatech.scrubs26.hypertensionmanagement.service.DietService;
import gatech.scrubs26.hypertensionmanagement.service.SecurityService;
import gatech.scrubs26.hypertensionmanagement.utils.DietValidator;
import gatech.scrubs26.hypertensionmanagement.utils.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class DietController {
    @Autowired
    private DietService dietService;

    @Autowired
    private DietValidator dietValidator;

    private String getCurrentLoggedUser(){
        org.springframework.security.core.userdetails.User sUser = (org.springframework.security.core.userdetails.User) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        return sUser.getUsername();
    }

    @GetMapping("/diet_entry")
    public String diet_entry(Model model) {
        model.addAttribute("dietForm", new Diet());
        return "diet_entry";
    }

    @PostMapping("/diet_entry")
    public String diet_entry(@ModelAttribute("dietForm") Diet dietForm, BindingResult bindingResult) {
        dietValidator.validate(dietForm, bindingResult);
        if (bindingResult.hasErrors()) {
            return "diet_entry";
        }
        dietForm.setCreatedDate(new Date());
        dietForm.setUsername(getCurrentLoggedUser());
        dietService.save(dietForm);
        return "redirect:/home";
    }

    // Return all history of diet entries with evaluation
    @GetMapping(value = "/diet_history", produces = MediaType.APPLICATION_JSON_VALUE)
    public String dietEntryHistory(HttpServletRequest request) {

        //List<Diet> currentDietEntries = dietService.findAll();
        // Need to implement business logic to evaluate Diet entries
        List<Diet> allDiets = dietService.findByUsername(getCurrentLoggedUser());
        request.setAttribute("dietEntries", allDiets);

        //Carb
        HashMap<Date,Integer> totalHashCarb = getTotalCarb(allDiets);
        Object[] keys = totalHashCarb.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("totalCarbHash", totalHashCarb);
        request.setAttribute("totalDateList", keys);

        //Protein
        HashMap<Date,Integer> totalHashProtein = getTotalProtein(allDiets);
        keys = totalHashProtein.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("totalProteinHash", totalHashProtein);
        request.setAttribute("totalDateList", keys);

        //Fat
        HashMap<Date,Integer> totalHashFat = getTotalFat(allDiets);
        keys = totalHashFat.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("totalFatHash", totalHashFat);
        request.setAttribute("totalDateList", keys);

        //Decision for carb
        HashMap<Date,String> DecisionCarbHash = getDecisionForCarb(totalHashCarb);
        keys = DecisionCarbHash.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("decisionCarbHash", DecisionCarbHash);

        //Decision for protein
        HashMap<Date,String> DecisionproteinHash = getDecisionForProtein(totalHashProtein);
        keys = DecisionproteinHash.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("decisionProteinHash", DecisionproteinHash);

        //Decision for carb
        HashMap<Date,String> DecisionFatHash = getDecisionForFat(totalHashFat);
        keys = DecisionFatHash.keySet().toArray();
        Arrays.sort(keys);
        request.setAttribute("decisionFatHash", DecisionFatHash);

        return "diet_history";
    }
    /*
    Return a hash:
    - key: date
    - Value: total percentage of carb for that date
     */
    private HashMap<Date, Integer> getTotalCarb(List<Diet> dietLst){
        HashMap<Date, Integer> _hash = new HashMap<Date, Integer>();
        for(Diet _diet : dietLst ){
            if(_diet.getCreatedDate() != null){
                if(_hash.isEmpty() || _hash.get(_diet.getCreatedDate()) == null){
                    _hash.put(_diet.getCreatedDate(), _diet.getCarb());
                }else{
                    int total = _hash.get(_diet.getCreatedDate());
                    _hash.replace(_diet.getCreatedDate(), total + _diet.getCarb());
                }

            }
        }
        return _hash;
    }

    /*
    Return a hash:
    - key: date
    - Value: total percentage of Protein for that date
     */
    private HashMap<Date, Integer> getTotalProtein(List<Diet> dietLst){
        HashMap<Date, Integer> _hash = new HashMap<Date, Integer>();
        for(Diet _diet : dietLst ){
            if(_diet.getCreatedDate() != null){
                if(_hash.isEmpty() || _hash.get(_diet.getCreatedDate()) == null){
                    _hash.put(_diet.getCreatedDate(), _diet.getProtein());
                }else{
                    int total = _hash.get(_diet.getCreatedDate());
                    _hash.replace(_diet.getCreatedDate(), total + _diet.getProtein());
                }

            }
        }
        return _hash;
    }

    /*
    Return a hash:
    - key: date
    - Value: total percentage of Fat for that date
     */
    private HashMap<Date, Integer> getTotalFat(List<Diet> dietLst){
        HashMap<Date, Integer> _hash = new HashMap<Date, Integer>();
        for(Diet _diet : dietLst ){
            if(_diet.getCreatedDate() != null){
                if(_hash.isEmpty() || _hash.get(_diet.getCreatedDate()) == null){
                    _hash.put(_diet.getCreatedDate(), _diet.getFat());
                }else{
                    int total = _hash.get(_diet.getCreatedDate());
                    _hash.replace(_diet.getCreatedDate(), total + _diet.getFat());
                }

            }
        }
        return _hash;
    }
    /*
     * Decision for carb
     * Key: date
     * Value: Evaluation string
     * */
    private HashMap<Date,String> getDecisionForCarb(HashMap<Date,Integer> totalHash){
        HashMap<Date, String> _hash = new HashMap<Date, String>();
        for (HashMap.Entry<Date,Integer> entry : totalHash.entrySet()) {
            Date key = entry.getKey();
            Integer value = entry.getValue();
            if(value >= 45 && value <= 65){
                _hash.put(key, "You carb intake is good");
            }else if (value > 65){
                _hash.put(key, "Ooops! Too much carb!");
            }else{
                _hash.put(key, "Please take some more carb!");
            }
        }
        return _hash;
    }
    /*
     * Decision for carb
     * Key: date
     * Value: Evaluation string
     * */
    private HashMap<Date,String> getDecisionForProtein(HashMap<Date,Integer> totalHash){
        HashMap<Date, String> _hash = new HashMap<Date, String>();
        for (HashMap.Entry<Date,Integer> entry : totalHash.entrySet()) {
            Date key = entry.getKey();
            Integer value = entry.getValue();
            if(value >= 10 && value <= 30){
                _hash.put(key, "You protein intake is good");
            }else if (value >30){
                _hash.put(key, "Ooops! Too much protein!");
            }else{
                _hash.put(key, "Please take some more protein!");
            }
        }
        return _hash;
    }
    /*
     * Decision for carb
     * Key: date
     * Value: Evaluation string
     * */
    private HashMap<Date,String> getDecisionForFat(HashMap<Date,Integer> totalHash){
        HashMap<Date, String> _hash = new HashMap<Date, String>();
        for (HashMap.Entry<Date,Integer> entry : totalHash.entrySet()) {
            Date key = entry.getKey();
            Integer value = entry.getValue();
            if(value >=20 && value <= 35){
                _hash.put(key, "You fat intake is good");
            }else if (value > 35){
                _hash.put(key, "Ooops! Need more fat!");
            }else{
                _hash.put(key, "Please take some more fat!");
            }
        }
        return _hash;
    }
}
