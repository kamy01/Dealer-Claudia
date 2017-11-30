package com.fortech;

import java.io.Serializable;
import java.util.List;

public class SearchCarCriteria implements Serializable{
    private List<String> selectedMarks;
    private String selectedColor;
    private List<String> selectedConditions;

    public List<String> getSelectedMarks() {
        return selectedMarks;
    }

    public void setSelectedMarks(List<String> selectedMarks) {
        this.selectedMarks = selectedMarks;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public List<String> getSelectedConditions() {
        return selectedConditions;
    }

    public void setSelectedConditions(List<String> selectedConditions) {
        this.selectedConditions = selectedConditions;
    }
}
