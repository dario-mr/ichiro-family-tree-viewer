package com.dario.iftv.core.service;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.repository.DogRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class FamilyTreeService {

    private final DogRepository dogRepository;

    public Dog getDog(String dogName, int generations) {
        Dog ichiro = dogRepository.findByName(dogName)
                .orElseThrow(() -> new EntityNotFoundException(format("Dog [%s] not found", dogName)));

        Dog limitedIchiro = SerializationUtils.clone(ichiro);
        limitFamilyTreeDepth(limitedIchiro, generations);

        return limitedIchiro;
    }

    public void limitFamilyTreeDepth(Dog dog, int generations) {
        if (dog.getGeneration() < generations && dog.getFather() != null && dog.getMother() != null) {
            limitFamilyTreeDepth(dog.getFather(), generations);
            limitFamilyTreeDepth(dog.getMother(), generations);
        } else {
            dog.setFather(null);
            dog.setMother(null);
        }
    }
}
