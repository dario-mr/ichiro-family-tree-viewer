package com.dario.ift.core.service;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.gateway.DownloadGateway;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FamilyTreeService {

    private final DownloadGateway downloadGateway;
    private final ParseService parseService;

    public List<Dog> buildFamilyTree(Integer generations) {
        Document familyTreePage = downloadGateway.downloadUpToGeneration(generations);

        return parseService.parseFamilyTree(familyTreePage);
    }

}
