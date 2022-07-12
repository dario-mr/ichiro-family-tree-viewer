package com.dario.ift.core.service;

import com.dario.ift.core.exception.ParseException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ParseService {

    @Value("${page.selector}")
    private String selector;

    public String parseFamilyTree(Document familyTreePage) {
        Elements elements = familyTreePage.select(selector);

        if (elements.isEmpty()) {
            throw new ParseException("The family tree has no elements");
        }

        return "";
    }
}
