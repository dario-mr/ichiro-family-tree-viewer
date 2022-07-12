package com.dario.ift.api.v1.controller;

import com.dario.ift.core.service.FamilyTreeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.dario.ift.api.v1.controller.FamilyTreeController.BASE_PATH;
import static com.dario.ift.api.v1.controller.FamilyTreeController.VERSION;

@RestController
@RequestMapping(value = BASE_PATH + VERSION)
@Tag(name = "ichiro-family-tree-" + VERSION, description = "Endpoint to retrieve Ichiro's family tree")
@RequiredArgsConstructor
public class FamilyTreeController {

    static final String BASE_PATH = "/api/";
    static final String VERSION = "v1";
    static final String GET_FAMILY_TREE_ENDPOINT = "family-tree/generations/{generations}";

    private final FamilyTreeService familyTreeService;

    @GetMapping(path = GET_FAMILY_TREE_ENDPOINT)
    @Operation(summary = "Returns Ichiro's family tree up to the amount of generations specified")
    public String getFamilyTree(@PathVariable Integer generations) { // TODO add @ApiResponses
        return familyTreeService.buildFamilyTree(generations);
    }
}
