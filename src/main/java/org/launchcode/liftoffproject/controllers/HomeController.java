package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.TagRepository;
import org.launchcode.liftoffproject.models.Domain;
import org.launchcode.liftoffproject.models.Intervention;
import org.launchcode.liftoffproject.models.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    public void createDomains() {
        String[] domains = {"Impulse Control", "Emotional Control", "Flexible Thinking", "Working Memory", "Self-Monitoring", "Planning and Prioritizing", "Task Initiation", "Organization"};
        String[] descriptions = {"Think before acting", "Keep feelings in check", "Adjust behavior to unexpected changes", "Keep key information in mind while using it", "Self-awareness to how one id doing in the moment", "To set and meet goals", "Take action to get started on tasks", "Keep track of things physically and mentally"};

        for (int i = 0; i < domains.length; i++) {
            Optional<Domain> result = domainRepository.findById(i + 1);
            if (result.isEmpty()) {
                Domain domain = new Domain(domains[i], descriptions[i]);
                domainRepository.save(domain);
            }
        }
    }

    public void createTags() {
        String[] tags = {"Aggression", "Anger", "Mindfulness", "Resentment", "Kids", "Adults", "Openness", "Working"};

        for (int i = 0; i < tags.length; i++) {
            Optional<Tag> result = tagRepository.findById(i + 9);
            if (result.isEmpty()) {
                Tag tag = new Tag(tags[i]);
                tagRepository.save(tag);
            }
        }
    }

    public void saveInterventions() throws FileNotFoundException {
        String delimiter = ",";
        if (!interventionRepository.findById(17).isPresent()) {
            try {
                File file = new File("src/main/resources/assets/CSVMAY5.csv");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = " ";
                String[] tempArr;
                while ((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    Intervention newIntervention = new Intervention(tempArr[0], tempArr[1], tempArr[2], tempArr[3], tempArr[4]);
                    List<Integer> domains = new ArrayList<Integer>();
                    List<Integer> tags = new ArrayList<Integer>();
                    for (int i = 0; i < tempArr[5].length(); i++) {
                        domains.add(Integer.parseInt(String.valueOf(tempArr[5].charAt(i))));
                        tags.add(Integer.parseInt(String.valueOf(tempArr[5].charAt(i))) + 8);
                    }
                    List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
                    List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tags);
                    newIntervention.setDomains(domainObjs);
                    newIntervention.setTags(tagObjs);
                    interventionRepository.save(newIntervention);
                }
                br.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    @RequestMapping("")
    public String index(Model model) throws FileNotFoundException {
        createDomains();
        createTags();
        saveInterventions();

        model.addAttribute("title", "All Domains");
        model.addAttribute("domains", domainRepository.findAll());

        return "index";
    }

    @GetMapping("add")
    public String displayAddInterventionForm(Model model) {
        model.addAttribute("title", "Add Intervention");
        model.addAttribute(new Intervention());
        model.addAttribute("domains", domainRepository.findAll());
        model.addAttribute("tags", tagRepository.findAll());

        return "add";
    }

    @PostMapping("add")
    public String processAddInterventionForm(@ModelAttribute @Valid Intervention newIntervention, Errors errors, Model model, @RequestParam(required = false) List<Integer> domains, @RequestParam(required = false) List<Integer> tag) {
        if (domains == null || domains.size() == 0 || domains.isEmpty()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "A Domain must be selected.";
            model.addAttribute("checkBoxError", str);
            return "add";
        }

        if (tag == null || tag.size() == 0 || tag.isEmpty()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            model.addAttribute("tags", tagRepository.findAll());
            String str = "A Tag must be selected.";
            model.addAttribute("checkBoxErrorTag", str);
            return "add";
        }

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Intervention");
            model.addAttribute("domains", domainRepository.findAll());
            return "add";
        }

        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
        List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tag);

        newIntervention.setDomains(domainObjs);
        newIntervention.setTags(tagObjs);

        interventionRepository.save(newIntervention);

        return "redirect:";
    }

    @GetMapping("view/{interventionId}")
    public String displayViewIntervention(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping("about")
    public String displayAbout() {
        return "about";
    }
}
