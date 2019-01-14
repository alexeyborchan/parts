package ru.javarush.parts.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.javarush.parts.model.Part;
import ru.javarush.parts.service.PartService;

import java.util.List;

@Controller
public class PartsController {

    private final PartService partService;

    public PartsController(PartService partService) {
        this.partService = partService;
    }

    @GetMapping("/{page}")
    public String findAll(@PathVariable Integer page, Model model) {
        List<Part> parts = partService.findAllPage(page);
        model.addAttribute("pageCount", partService.findAll());
        model.addAttribute("parts", parts);
        model.addAttribute("page", page);
        String list = "";
        model.addAttribute("list", list);
        String question = "";
        model.addAttribute("question", question);
        int computers = partService.findCountComputers();
        model.addAttribute("computers", computers);
        return "index";
    }

    @GetMapping("/")
    public String findAll(Model model) {
        return "redirect:/1";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        partService.delete(id);
        return "redirect:/1";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Part part = partService.findById(id);
        model.addAttribute("part", part);
        return "operations/edit";
    }

    @PostMapping("/update")
    public String savePart(@RequestParam Integer id, @RequestParam String partName,
                           @RequestParam String isNecessary, @RequestParam int amount) {
        boolean necessary = false;
        if (isNecessary.toLowerCase().equals("да")) {
            necessary = true;
        }
        Part part = partService.findById(id);
        part.setPartName(partName);
        part.setNecessary(necessary);
        part.setAmount(amount);
        partService.save(part);
        return "redirect:/1";
    }

    @GetMapping("/new")
    public String newPart() {
        return "operations/new";
    }

    @PostMapping("/save")
    public String savePart(@RequestParam String partName, @RequestParam String isNecessary, @RequestParam int amount) {
        boolean necessary = false;
        if (isNecessary.toLowerCase().equals("да")) {
            necessary = true;
        }
        Part part = new Part();
        part.setPartName(partName);
        part.setNecessary(necessary);
        part.setAmount(amount);
        partService.save(part);
        return "redirect:/1";
    }

    @GetMapping("/search/{page}")
    public String search(@RequestParam String name,@PathVariable Integer page, Model model) {
        if (name.equals("")) {
            return "redirect:/1";
        }
        List<Part> parts = partService.search(page, name);
        model.addAttribute("pageCount", (int) Math.ceil((double) parts.size()/10));
        model.addAttribute("parts", parts);
        model.addAttribute("page", page);
        int computers = partService.findCountComputers();
        model.addAttribute("computers", computers);
        String list = "/search";
        model.addAttribute("list", list);
        String question = "name=" + name;
        model.addAttribute("question", question);
        return "index";
    }

    @GetMapping("/filter/{page}")
    public String filter(@RequestParam String filter,@PathVariable Integer page, Model model) {
        String list = "/filter";
        model.addAttribute("list", list);
        String question = "filter=" + filter;
        model.addAttribute("question", question);
        int computers = partService.findCountComputers();
        model.addAttribute("computers", computers);
        switch (filter) {
            case "true":
                List<Part> parts = partService.filter(page, 1);
                model.addAttribute("pageCount", (int) Math.ceil((double) parts.size() / 10));
                model.addAttribute("parts", parts);
                model.addAttribute("page", page);
                return "index";
            case "false":
                List<Part> parts2 = partService.filter(page, 0);
                model.addAttribute("pageCount", (int) Math.ceil((double) parts2.size() / 10));
                model.addAttribute("parts", parts2);
                model.addAttribute("page", page);
                return "index";
        }
        return "redirect:/1";
    }


//
}
