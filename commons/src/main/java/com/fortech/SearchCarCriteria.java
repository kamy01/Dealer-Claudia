package com.fortech;

import java.io.Serializable;
import java.util.List;

public class SearchCarCriteria implements Serializable{
    private List<String> selectedMarks;
    private List<String> selectedColors;
    private List<String> selectedConditions;

    public List<String> getSelectedMarks() {
        return selectedMarks;
    }

    public void setSelectedMarks(List<String> selectedMarks) {
        this.selectedMarks = selectedMarks;
    }

    public List<String> getSelectedColors() {
        return selectedColors;
    }

    public void setSelectedColors(List<String> selectedColors) {
        this.selectedColors = selectedColors;
    }

    public List<String> getSelectedConditions() {
        return selectedConditions;
    }

    public void setSelectedConditions(List<String> selectedConditions) {
        this.selectedConditions = selectedConditions;
    }
}
