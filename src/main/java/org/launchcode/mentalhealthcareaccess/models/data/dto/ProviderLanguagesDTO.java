package org.launchcode.mentalhealthcareaccess.models.data.dto;

import org.launchcode.mentalhealthcareaccess.models.Languages;
import org.launchcode.mentalhealthcareaccess.models.Provider;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class ProviderLanguagesDTO {

    @NotNull
    private Provider provider;

    @NotNull
    private Languages languages;

    public ProviderLanguagesDTO() {
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Languages getLanguages() {
        return languages;
    }

    public void setLanguages(Languages languages) {
        this.languages = languages;
    }
}

