package com.dario.ift.core.gateway;

import org.jsoup.nodes.Document;

public interface DownloadGateway {

    Document downloadUpToGeneration(Integer generations);
}
