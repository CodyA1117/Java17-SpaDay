package org.launchcode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SpaDayController {

    public static List<String> checkSkinType(String skinType) {
        List<String> facials = new ArrayList<>();
        if (skinType.equals("oily")) {
            facials.add("Oil Control Facial");
            facials.add("Deep Cleansing Facial");
        } else if (skinType.equals("dry")) {
            facials.add("Hydrating Facial");
            facials.add("Calming Facial");
        } else if (skinType.equals("combination")) {
            facials.add("Combination Skin Balancing Facial");
            facials.add("Revitalizing Facial");
        }
        return facials;
    }

    @GetMapping("/")
    public String customerForm() {
        return "form";
    }

    @PostMapping("/menu")
    public String spaMenu(@RequestParam String name, @RequestParam String skintype, @RequestParam String manipedi, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("skintype", skintype);
        model.addAttribute("manipedi", manipedi);
        List<String> appropriateFacials = checkSkinType(skintype);
        model.addAttribute("appropriateFacials", appropriateFacials);
        return "menu";
    }
}
