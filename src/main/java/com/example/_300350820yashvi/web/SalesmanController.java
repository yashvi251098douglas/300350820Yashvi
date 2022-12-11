package com.example._300350820yashvi.web;

import com.example._300350820yashvi.entities.Salesman;
import com.example._300350820yashvi.repositories.SalesmanRepo;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;
@Controller
@AllArgsConstructor
@SessionAttributes({"err"})
public class SalesmanController {

    @Autowired
    private SalesmanRepo repo;
    static String error = "";

    @GetMapping(path = "/index")
    public String getSalesmanList(Model model, ModelMap mm, HttpSession session) {
        List<Salesman> list;
        list = repo.findAll();
        model.addAttribute("list", list);
        model.addAttribute("err", "");
        return "salesTable";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        repo.deleteById(id);
        return "redirect:/index";
    }

    @PostMapping(path = "/save")
    public String addLoan(Model model, Salesman salesman, BindingResult
            bindingResult, ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "redirect:/index";
        } else {
            List<Salesman> salesmans = repo.findSalesmanById(salesman.getId());
            System.out.println("done");
            if (salesmans != null && salesmans.size() > 0) {
                List<Salesman> list;
                list = repo.findAll();
                model.addAttribute("list", list);
                model.addAttribute("err", "The record you are trying to add is already " +
                        "existing. Choose a different id.");
                return "editSalesman";
            }
            repo.save(salesman);
            return "salesTable";
        }
    }
    @PostMapping(path = "/update")
    public String update(Model model, Salesman salesman, BindingResult
            bindingResult, ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "redirect:/index";
        } else {
            repo.save(salesman);
            return "salesTable";
        }
    }

}

