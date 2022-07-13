package com.dario.ift.proxy;

import com.dario.ift.core.exception.DownloadException;
import com.dario.ift.core.gateway.DownloadGateway;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.dario.ift.config.CacheConfig.DOWNLOAD_UP_TO_GENERATION;
import static java.lang.String.format;

@Service
public class DownloadProxy implements DownloadGateway {

    @Value("${page.url}")
    private String baseUrl;

    @Value("${page.ichiro-profile}")
    private String ichiroProfile;

    @Cacheable(DOWNLOAD_UP_TO_GENERATION)
    public Document downloadUpToGeneration(Integer generations) {
        String familyTreeUrl = baseUrl + ichiroProfile + "&gens=" + generations;

        try {
            return Jsoup.connect(familyTreeUrl).get();
        } catch (Exception ex) {
            throw new DownloadException(format("Failed to download page %s", familyTreeUrl), ex);
        }
    }
}
