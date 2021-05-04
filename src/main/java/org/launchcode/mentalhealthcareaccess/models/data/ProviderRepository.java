package org.launchcode.mentalhealthcareaccess.models.data;

import org.launchcode.mentalhealthcareaccess.models.Provider;
import org.springframework.data.repository.CrudRepository;

public interface ProviderRepository extends CrudRepository<Provider, Integer> {
        Provider findByEmail(String email);

    }
