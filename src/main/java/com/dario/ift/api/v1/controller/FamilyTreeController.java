package com.dario.ift.api.v1.controller;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.service.FamilyTreeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

import static com.dario.ift.api.v1.controller.FamilyTreeController.BASE_PATH;
import static com.dario.ift.api.v1.controller.FamilyTreeController.VERSION;

@RestController
@RequestMapping(value = BASE_PATH + VERSION)
@RequiredArgsConstructor
@Validated
@Tag(name = "ichiro-family-tree-" + VERSION, description = "Endpoint to retrieve Ichiro's family tree")
public class FamilyTreeController {

    static final String BASE_PATH = "/api/";
    static final String VERSION = "v1";
    static final String GET_FAMILY_TREE_ENDPOINT = "family-tree/generations/{generations}";

    private final FamilyTreeService familyTreeService;

    @GetMapping(path = GET_FAMILY_TREE_ENDPOINT)
    @Operation(summary = "Returns Ichiro's family tree up to the amount of generations specified")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Family tree successfully generated"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "406", description = "Something went wrong during the family tree generation"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public List<Dog> getFamilyTree(@PathVariable @Min(2) @Max(8) Integer generations) {
        return familyTreeService.buildFamilyTree(generations);
    }

}
