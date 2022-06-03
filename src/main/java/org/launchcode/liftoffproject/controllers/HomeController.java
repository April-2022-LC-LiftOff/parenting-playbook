package org.launchcode.liftoffproject.controllers;

import org.launchcode.liftoffproject.data.*;
import org.launchcode.liftoffproject.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private AuthenticationController authenticationController;

    @Autowired
    private UserRepository userRepository;



    public void createDomains() throws FileNotFoundException {
        String delimiter = ",";
        List repo = (List) domainRepository.findAll();

        if (repo.isEmpty()) {
            try {
                File file = new File("src/main/resources/assets/domains.csv");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = " ";
                String[] tempArr;
                while ((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter, 19);
                    Domain domain = new Domain(tempArr[0], tempArr[1]);
                    domainRepository.save(domain);
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    public void createTags() {
        String[] tags = {"Aggression", "Anger", "Mindfulness", "Resentment", "Kids", "Adults", "Openness", "Working"};
        List repo = (List) tagRepository.findAll();

        if (repo.isEmpty()) {
            for (int i = 0; i < tags.length; i++) {
                Tag tag = new Tag(tags[i]);
                tagRepository.save(tag);
            }
        }
    }

    public void saveInterventions() throws FileNotFoundException {
        String delimiter = ",";
        List repo = (List) interventionRepository.findAll();

        if (repo.isEmpty()) {
            try {
                File file = new File("src/main/resources/assets/ParentingPlaybookData - Book4.csv");
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String line = " ";
                String[] tempArr;
                User user = null;
                while ((line = br.readLine()) != null) {
                    tempArr = line.split(delimiter);
                    Intervention newIntervention = new Intervention(tempArr[0], tempArr[1], tempArr[2], tempArr[3], tempArr[4], user);
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
        User user = new User();
        model.addAttribute("username",user.getUsername());
        model.addAttribute(user);

        return "add";
    }

    @PostMapping("add")
    public String processAddInterventionForm(@ModelAttribute @Valid Intervention newIntervention, Errors errors, Model model, @RequestParam(required = false) List<Integer> domains, @RequestParam(required = false) List<Integer> tag, HttpServletRequest request) {
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
            model.addAttribute("tags", tagRepository.findAll());
            model.addAttribute("user", userRepository.findAll());
            return "add";
        }

        User user = authenticationController.getUserFromSession(request.getSession());

        if (user == null) {
            return "redirect:login";
        }

        List<Domain> domainObjs = (List<Domain>) domainRepository.findAllById(domains);
        List<Tag> tagObjs = (List<Tag>) tagRepository.findAllById(tag);

        newIntervention.setUser(user);
        newIntervention.setDomains(domainObjs);
        newIntervention.setTags(tagObjs);

        interventionRepository.save(newIntervention);

        return "redirect:/profile";
    }

    @GetMapping("view/{interventionId}")
    public String displayViewIntervention(Model model, @PathVariable int interventionId, HttpServletRequest request) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);

            User user = authenticationController.getUserFromSession(request.getSession());
            Comment comment = new Comment();

            if (user != null) {
                model.addAttribute("comments", commentRepository.findCommentByInterventionIdAndUserId(interventionId, user.getId()));
            }

           model.addAttribute("comment", comment);
           model.addAttribute("user",user);

            return "view";
        } else {
            return "redirect:../";
        }
    }

    @PostMapping("view/{interventionId}")
    public String processAddComment(@ModelAttribute @Valid Comment newComment, Errors errors, Model model,
                                    @PathVariable int interventionId, HttpServletRequest request) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        Intervention intervention = (Intervention) optIntervention.get();
        if (errors.hasErrors()) {
            model.addAttribute("intervention", intervention);
            return "view";
        }

        User user = authenticationController.getUserFromSession(request.getSession());

        newComment.setUser(user);
        newComment.setIntervention(intervention);
        commentRepository.save(newComment);
        return "redirect:{interventionId}";
    }

    @GetMapping("editView/{interventionId}")
    public String displayEditIntervention(Model model, @PathVariable int interventionId, HttpServletRequest request) {
        Optional optIntervention = interventionRepository.findById(interventionId);
        if (optIntervention.isPresent()) {
            Intervention intervention = (Intervention) optIntervention.get();
            model.addAttribute("intervention", intervention);

            User user = authenticationController.getUserFromSession(request.getSession());
            model.addAttribute("user",user);

            return "editView";
        } else {
            return "redirect:../";
        }
    }


    @GetMapping("about")
    public String displayAbout() {
        return "about";
    }

    @GetMapping("faq")
    public String displayFaq() {
        return "faq";
    }

    List<String> quizResults = new ArrayList<>();

    @GetMapping("quiz")
    public String displayAllQuestions(Model model) {
        List<String> questionnaire = new ArrayList<>();
        model.addAttribute("questionnaire", questionnaire);
        return "quiz";
    }

    @GetMapping("results")
    public String getResults(Model model, Quiz quiz) {
        model.addAttribute("Quiz", quiz);
        return "results";
    }

    @PostMapping("results")
    public String processFormMethodQuiz(@ModelAttribute("quiz") @Valid Quiz quiz, Model model, @RequestParam(required = false)
            List<String> impulseControl, @RequestParam(required = false) List<String> emotionalControl, @RequestParam(required = false)
                                                List<String> flexibleThinking, @RequestParam(required = false)
                                                List<String> workingMemory, @RequestParam(required = false)
                                                List<String> selfMonitoring, @RequestParam(required = false)
                                                List<String> planningAndPrioritizing, @RequestParam(required = false)
                                                List<String> taskInitiation, @RequestParam(required = false)
                                                List<String> organization, @RequestParam(required = false) List<String> none) {


        if (impulseControl == null) {
            model.addAttribute("title", quiz);
        } else if (impulseControl.size() >= 2) {
            model.addAttribute("impulseControl", domainRepository.findById(1));
        }

        if (emotionalControl == null) {
            model.addAttribute("title", quiz);
        } else if (emotionalControl.size() >= 2) {
            model.addAttribute("emotionalControl", domainRepository.findById(2));
        }

        if (flexibleThinking == null) {
            model.addAttribute("title", quiz);
        } else if (flexibleThinking.size() >= 2) {
            model.addAttribute("flexibleThinking", domainRepository.findById(3));
        }

        if (workingMemory == null) {
            model.addAttribute("title", quiz);
        } else if (workingMemory.size() >= 2) {
            model.addAttribute("workingMemory", domainRepository.findById(4));
        }

        if (selfMonitoring == null) {
            model.addAttribute("title", quiz);
        } else if (selfMonitoring.size() >= 2) {
            model.addAttribute("selfMonitoring", domainRepository.findById(5));
        }

        if (planningAndPrioritizing == null) {
            model.addAttribute("title", quiz);
        } else if (planningAndPrioritizing.size() >= 2) {
            model.addAttribute("planningAndPrioritizing", domainRepository.findById(6));
        }

        if (taskInitiation == null) {
            model.addAttribute("title", quiz);
        } else if (taskInitiation.size() >= 2) {
            model.addAttribute("taskInitiation", domainRepository.findById(7));
        }

        if (organization == null) {
            model.addAttribute("title", quiz);
        } else if (organization.size() >= 2) {
            model.addAttribute("organization", domainRepository.findById(8));
        }

        if (impulseControl == null && emotionalControl == null && flexibleThinking == null && workingMemory == null &&
        selfMonitoring == null && planningAndPrioritizing == null && taskInitiation == null && organization == null) {

            model.addAttribute("none", none);
        }
        return "results";

    }

}

