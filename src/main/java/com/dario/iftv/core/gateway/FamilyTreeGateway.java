package com.dario.iftv.core.gateway;

import com.dario.iftv.core.domain.Dog;

public interface FamilyTreeGateway {

    Dog getFamilyTree(int generations);
}
