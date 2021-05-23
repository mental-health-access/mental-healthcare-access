package org.launchcode.mentalhealthcareaccess.models;

public enum Languages {
    SPANISH("Spanish", "ES"),
    ENGLISH("English", "EN"),
    FRENCH("French", "FR");


    private final String displayValue;
    private final String lang;

    private Languages(String displayValue, String lang) {
        this.displayValue = displayValue;
        this.lang = lang;
    }

    public String getDisplayValue() {
        return displayValue;
    }
    public String getLang() {
        return lang;
    }

}
