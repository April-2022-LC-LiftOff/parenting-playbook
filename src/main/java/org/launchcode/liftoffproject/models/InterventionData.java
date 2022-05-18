package org.launchcode.liftoffproject.models;

import java.util.ArrayList;
import java.util.Locale;

public class InterventionData {

    public static ArrayList<Intervention> findByColumnAndValue(String column, String value, Iterable<Intervention> allInterventions) {
        ArrayList<Intervention> results = new ArrayList<>();

        if (value.toLowerCase(Locale.ROOT).equals("all")) {
            return (ArrayList<Intervention>) allInterventions;
        }

        if (column.equals("all")) {
            results = findByValue(value, allInterventions);
            return results;
        }

        for (Intervention intervention : allInterventions) {
            String aValue = getFieldValue(intervention, column);

            if (aValue != null && aValue.toLowerCase(Locale.ROOT).contains(value.toLowerCase(Locale.ROOT))) {
                results.add(intervention);
            }
        }

        return results;
    }

    public static String getFieldValue(Intervention intervention, String fieldName) {
        String theValue;
        if (fieldName.equals("name")) {
            theValue = intervention.getName();
        } else {
            theValue = intervention.getDomains().toString();
        }

        return theValue;
    }

    public static ArrayList<Intervention> findByValue(String value, Iterable<Intervention> allInterventions) {
        String lowerVal = value.toLowerCase(Locale.ROOT);

        ArrayList<Intervention> results = new ArrayList<>();

        for (Intervention intervention : allInterventions) {
            if (intervention.getName().toLowerCase(Locale.ROOT).contains(lowerVal)) {
                results.add(intervention);
            } else if (intervention.getDomains().contains(lowerVal)) { // May need to switch how search is done as Domains are a list in interventions, might not be needed
                results.add(intervention);
            } else if (intervention.getAction().toLowerCase(Locale.ROOT).contains(lowerVal)) {
                results.add(intervention);
            } else if (intervention.getExpectedResponse().toLowerCase(Locale.ROOT).contains(lowerVal)) {
                results.add(intervention);
            }
        }

        return results;
    }
}
