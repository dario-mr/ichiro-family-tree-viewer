package com.dario.ift.core.service;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.repository.FamilyTreeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyTreeService {

    private final FamilyTreeRepository familyTreeRepository;

    public Dog getFamilyTree(int generations) {
        Dog ichiro = familyTreeRepository.getFamilyTree();
        limitFamilyTreeDepth(ichiro, generations);

        return ichiro;
    }

    private void limitFamilyTreeDepth(Dog dog, int generations) {
        if (dog.getGeneration() < generations && dog.getFather() != null && dog.getMother() != null) {
            limitFamilyTreeDepth(dog.getFather(), generations);
            limitFamilyTreeDepth(dog.getMother(), generations);
        } else {
            dog.setFather(null);
            dog.setMother(null);
        }
    }

}
