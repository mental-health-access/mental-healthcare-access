package org.launchcode.mentalhealthcareaccess.models;

public enum Languages {
    SPANISH("Spanish"),
    ENGLISH("English"),
    FRENCH("French");


    private final String displayValue;

    private Languages(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }


}
