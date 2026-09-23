package com.example.demo.controller;

import com.example.demo.model.PreferencesForm;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PreferencesController {

    @GetMapping("/")
    public String showForm(Model model) {
        if (!model.containsAttribute("preferencesForm")) {
            model.addAttribute("preferencesForm", new PreferencesForm());
        }
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@Valid @ModelAttribute("preferencesForm") PreferencesForm preferencesForm,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        model.addAttribute("preferencesForm", preferencesForm);
        return "result";
    }
}
