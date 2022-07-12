package com.dario.ift.core.service;

import com.dario.ift.core.gateway.DownloadGateway;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FamilyTreeService {

    private final DownloadGateway downloadGateway;
    private final ParseService parseService;

    public String buildFamilyTree(Integer generations) {
        Document familyTreePage = downloadGateway.downloadUpToGeneration(generations);

        return parseService.parseFamilyTree(familyTreePage);
    }

}
