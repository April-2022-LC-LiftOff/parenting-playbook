package org.launchcode.liftoffproject.models;

import org.launchcode.liftoffproject.data.DomainRepository;
import org.launchcode.liftoffproject.data.InterventionRepository;
import org.launchcode.liftoffproject.data.TagRepository;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class HelperMethods {

    public static void createDomains(DomainRepository domainRepository) throws FileNotFoundException {
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

    public static void createTags(TagRepository tagRepository) {
        String[] tags = {"Aggression", "Anger", "Mindfulness", "Resentment", "Kids", "Adults", "Openness", "Working"};
        List repo = (List) tagRepository.findAll();

        if (repo.isEmpty()) {
            for (int i = 0; i < tags.length; i++) {
                Tag tag = new Tag(tags[i], null);
                tagRepository.save(tag);
            }
        }
    }

    public static void saveInterventions(InterventionRepository interventionRepository, DomainRepository domainRepository, TagRepository tagRepository) throws FileNotFoundException {
        String delimiter = ";";
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

    public static String clickableURL(String reference) {
        String[] parts = reference.split("\\s+");
        String start = "<p>";
        String end = "</p>";

        for (int i = 0; i < parts.length; i++) try {
            URL url = new URL(parts[i]);
            parts[i] = "<a target=\"_blank\" href=\"" + url + "\">"+ url + "</a>";
        } catch (MalformedURLException e) {
            System.out.print( parts[i] + " " );
            if (parts[i].contains(".com")) {
                parts[i] = "<a target=\"_blank\" href=\"https://" + parts[i] + "\">"+ parts[i] + "</a>";
            }
        }

        String joined = "";

        for (String part : parts) {
            joined += part + " ";
        }

        String output = start + joined + end;

        return output;
    }

    public static Boolean detectURL(String reference) {
        String[] parts = reference.split("\\s+");
        Boolean output = false;

        for (String part : parts) try {
            URL url = new URL(part);
            if (url != null) {
                output = true;
                break;
            }
        } catch (MalformedURLException e) {
            System.out.print( part + " " );
            if (part.contains(".com")) {
                output = true;
                break;
            }
        }

        return output;
    }

    public static Boolean wordFilter(String str) throws IOException {
        Boolean output = true;
        String[] parts = str.split("\\s+");
        ArrayList<String> badWords = new ArrayList<>();

        File file = new File("src/main/resources/assets/ParentingPlaybookData - Book4.csv");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = " ";
        String[] tempArr;
        while ((line = br.readLine()) != null) {
            badWords.add(line);
        }

        for (String part : parts) {
            for (String bad : badWords) {
                if (part.toLowerCase(Locale.ROOT).equals(bad.toLowerCase(Locale.ROOT))) {
                    output = false;
                    break;
                }
            }
        }

        return output;
    }
}
