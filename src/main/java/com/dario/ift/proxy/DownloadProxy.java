package com.dario.ift.proxy;

import com.dario.ift.core.exception.DownloadException;
import com.dario.ift.core.gateway.DownloadGateway;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import static java.lang.String.format;

@Service
public class DownloadProxy implements DownloadGateway {

    @Value("${page.url}")
    private String baseUrl;

    // TODO add cache
    public Document downloadUpToGeneration(Integer generations) {
        String familyTreeUrl = baseUrl + "&gens=" + generations;

        try {
            return Jsoup.connect(familyTreeUrl).get();
        } catch (Exception ex) {
            throw new DownloadException(format("Failed to download page %s", familyTreeUrl), ex);
        }
    }
}
