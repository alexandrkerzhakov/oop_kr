package ru.gb.oop_kr.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.gb.oop_kr.dao.PetsDAO;
import ru.gb.oop_kr.models.Pets.Pet;

import javax.validation.Valid;


@Controller
@RequestMapping("/pets")
public class PetsController {
    private final PetsDAO petsDAO;

    public PetsController(PetsDAO petsDAO) {
        this.petsDAO = petsDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("pets", petsDAO.findAll());
        return "pets/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("pet", petsDAO.findById(id));
        return "pets/show";
    }

    @GetMapping("/new")
    public String newPets(@ModelAttribute("pet") Pet pet) {
        return "pets/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("pet") @Valid Pet pet,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/pets/new";
        }
        petsDAO.save(pet);
        return "redirect:/pets";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("pet", petsDAO.findById(id));
        return "pets/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("pet") @Valid Pet pet,
                         BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "/pets/edit";
        }
        petsDAO.update(id, pet);
        return "redirect:/pets";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        petsDAO.delete(id);
        return "redirect:/pets";
    }
    
    
}
