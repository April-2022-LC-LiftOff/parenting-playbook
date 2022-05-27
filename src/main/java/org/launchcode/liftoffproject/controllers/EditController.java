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
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("edit")
public class EditController {

    @Autowired
    private DomainRepository domainRepository;

    @Autowired
    private InterventionRepository interventionRepository;

    @Autowired
    private TagRepository tagRepository;

    @GetMapping("/name/{interventionId}")
    public String displayNameEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/name";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/name/{interventionId}")
    public String processNameEdit(Model model, @PathVariable int interventionId, @RequestParam String name) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (name.length() < 5 || name.length() > 255) {
            model.addAttribute("intervention", intervention);
            String str = "Name must be longer than 5 characters and not exceed 255 characters.";
            model.addAttribute("nameError", str);
            return "edit/name";
        }

        intervention.setName(name);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/action/{interventionId}")
    public String displayActionEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/action";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/action/{interventionId}")
    public String processActionEdit(Model model, @PathVariable int interventionId, @RequestParam String action) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (action.length() < 20 || action.length() > 2000) {
            model.addAttribute("intervention", intervention);
            String str = "Action must be longer than 20 characters and not exceed 2000 characters.";
            model.addAttribute("actionError", str);
            return "edit/action";
        }

        intervention.setAction(action);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/expectedResponse/{interventionId}")
    public String displayExpectedResponseEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/expectedResponse";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/expectedResponse/{interventionId}")
    public String processExpectedResponseEdit(Model model, @PathVariable int interventionId, @RequestParam(required = false) String expectedResponse) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (expectedResponse.length() < 20 || expectedResponse.length() > 2000) {
            model.addAttribute("intervention", intervention);
            String str = "Expected Response must be longer than 20 characters and not exceed 2000 characters.";
            model.addAttribute("expectedResponseError", str);
            return "edit/expectedResponse";
        }

        intervention.setAction(expectedResponse);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/reference/{interventionId}")
    public String displayReferenceEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/reference";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/reference/{interventionId}")
    public String processReferenceEdit(Model model, @PathVariable int interventionId, @RequestParam String reference) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
//        if (reference == "") {
//            model.addAttribute("intervention", intervention);
//            return "edit/reference";
//        }

        intervention.setAction(reference);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/ifItFails/{interventionId}")
    public String displayIfItFailsEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/ifItFails";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/ifItFails/{interventionId}")
    public String processIfItFailsEdit(Model model, @PathVariable int interventionId, @RequestParam String ifItFails) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
//        if (ifItFails == "") {
//            model.addAttribute("intervention", intervention);
//            return "edit/ifItFails";
//        }

        intervention.setAction(ifItFails);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/domains/{interventionId}")
    public String displayDomainsEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            model.addAttribute("domains", domainRepository.findAll());
            return "edit/domains";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/domains/{interventionId}")
    public String processDomainsEdit(Model model, @PathVariable int interventionId, @RequestParam(required = false) List<Integer> domains) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (domains == null) {
            model.addAttribute("intervention", intervention);
            model.addAttribute("domains", domainRepository.findAll());
            String str = "A Domain must be selected.";
            model.addAttribute("checkBoxError", str);
            return "edit/domains";
        }

        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
        intervention.setDomains(domainObjs);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("/tags/{interventionId}")
    public String displayTagsEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            model.addAttribute("tags", tagRepository.findAll());
            return "edit/tags";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/tags/{interventionId}")
    public String processTagsEdit(Model model, @PathVariable int interventionId, @RequestParam(required = false) List<Integer> tag) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (tag == null) {
            model.addAttribute("intervention", intervention);
            model.addAttribute("tags", tagRepository.findAll());
            String str = "A Tag must be selected.";
            model.addAttribute("checkBoxErrorTag", str);
            return "edit/tags";
        }

        List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tag);
        intervention.setTags(tagObjs);
        interventionRepository.save(intervention);

        return "redirect:/view/{interventionId}";
    }

    @GetMapping("delete/{interventionId}")
    public String displayDeleteEdit(Model model, @PathVariable int interventionId) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);
            return "edit/delete";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("/delete/{interventionId}")
    public String processDeleteEdit(Model model, @PathVariable int interventionId, @RequestParam int delete) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (delete == 0) {
            model.addAttribute("intervention", intervention);
            return "redirect:";
        }

        if (delete == 1) {
            interventionRepository.deleteById(interventionId);
        }

        return "redirect:/view/{interventionId}";
    }
}
