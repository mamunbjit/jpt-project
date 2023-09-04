package jpt.mamun.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jpt.mamun.main.repository.MotorbikeRepository;
import jpt.mamun.main.model.Motorbike;
import jpt.mamun.main.exception.MotorbikeNotFoundException;




@Controller
@RequestMapping("/motorbikes")
public class MotorbikeController {

    private final MotorbikeRepository motorbikeRepository;

    public MotorbikeController(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("motorbikes", motorbikeRepository.findAll());
        return "motorbike-list";
    }
    @GetMapping("/motorbikes")
    public String listMotorbikes(Model model) {
        model.addAttribute("motorbikes", motorbikeRepository.findAll());
        return "motorbike-list";
    }


    @GetMapping("/motorbikes/{id}")
    public String viewMotorbikeDetails(@PathVariable Long id, Model model) {
        Motorbike motorbike = motorbikeRepository.findById(id)
                .orElseThrow(() -> new MotorbikeNotFoundException(id));

        model.addAttribute("motorbike", motorbike);
        return "motorbike-details";
    }

    // Create: Show the form to create a new motorbike
    @GetMapping("/motorbikes/new")
    public String showMotorbikeForm(Model model) {
        model.addAttribute("motorbike", new Motorbike());
        return "add-motorbike";
    }

    // Create: Process the form submission to create a new motorbike
    @PostMapping("/motorbikes")
    public String createMotorbike(
//            @Valid
            @ModelAttribute("motorbike") Motorbike motorbike,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "add-motorbike";
        }

        motorbikeRepository.save(motorbike);
        redirectAttributes.addFlashAttribute("successMessage", "Motorbike created successfully");
        return "redirect:/motorbike-list";
    }

    // Update: Show the form to edit an existing motorbike
    @GetMapping("/motorbikes/{id}/edit")
    public String showEditMotorbikeForm(@PathVariable Long id, Model model) {
        Motorbike motorbike = motorbikeRepository.findById(id)
                .orElseThrow(() -> new MotorbikeNotFoundException(id));
        model.addAttribute("motorbike", motorbike);
        return "edit-motorbike";
    }

    // Update: Process the form submission to edit an existing motorbike
    @PostMapping("/motorbikes/{id}/edit")
    public String updateMotorbike(
            @PathVariable Long id,
//            @Valid
            @ModelAttribute("motorbike") Motorbike motorbike,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        if (bindingResult.hasErrors()) {
            return "add-motorbike";
        }

        motorbike.setId(id); // Ensure the correct ID is set
        motorbikeRepository.save(motorbike);
        redirectAttributes.addFlashAttribute("successMessage", "Motorbike updated successfully");
        return "redirect:/motorbike-list";
    }

    // Delete: Process the deletion of a motorbike
    @PostMapping("/motorbikes/{id}/delete")
    public String deleteMotorbike(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        motorbikeRepository.deleteById(id);
        redirectAttributes.addFlashAttribute("successMessage", "Motorbike deleted successfully");
        return "redirect:/motorbike-list";
    }
}
