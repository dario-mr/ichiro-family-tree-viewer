package com.dario.ift.core.service;

import com.dario.ift.core.domain.Dog;
import com.dario.ift.core.exception.ParseException;
import com.dario.ift.util.Colors;
import org.apache.commons.text.WordUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ParseService {

    private final static List<String> INVALID_NAMES = Arrays.asList(
            "Добавить", ""
    );

    @Value("${page.selector}")
    private String selector;

    @Value("${page.url}")
    private String baseUrl;

    public List<Dog> parseFamilyTree(Document familyTreePage) {
        Elements familyTreeTable = familyTreePage.select(selector);
        if (familyTreeTable.isEmpty()) {
            throw new ParseException("The family tree has no elements");
        }

        Elements dogRows = familyTreeTable.get(0).children();

        // remove table header and footer
        dogRows.remove(0);
        dogRows.remove(dogRows.size() - 1);

        // TODO as a POC I extracted a flat list of dogs - hierarchy must be implemented, somehow...
        List<Dog> dogs = dogRows.stream()
                .map(Node::childNodes)
                .flatMap(List::stream)
                .filter(node -> {
                    String nodeHtml = node.outerHtml();
                    Optional<Element> link = Optional.ofNullable((Jsoup.parse(nodeHtml).select("a").first()));

                    String name = link.map(l -> WordUtils.capitalizeFully(l.text()))
                            .orElse("");
                    return isValidName(name);
                })
                .map(node -> {
                    String nodeHtml = node.outerHtml();
                    Optional<Element> link = Optional.ofNullable((Jsoup.parse(nodeHtml).select("a").first()));
                    Optional<Element> span = Optional.ofNullable((Jsoup.parse(nodeHtml).select("span").first()));
                    Optional<Element> label = Optional.ofNullable((Jsoup.parse(nodeHtml).select("label").last()));

                    String name = link.map(l -> WordUtils.capitalizeFully(l.text()))
                            .orElse("");
                    String profileUrl = link.map(l -> baseUrl + l.attr("href"))
                            .orElse("");
                    String imageUrl = link.map(l -> baseUrl + "/" + Jsoup.parse(l.outerHtml()).select("img").attr("src"))
                            .orElse("");
                    String country = span.map(Element::text)
                            .orElse("");
                    String color = label.map(c -> c.text().split(" ")[0])
                            .orElse("");
                    if (!Colors.contains(color)) {
                        color = "";
                    }

                    return buildDog(name, profileUrl, imageUrl, country, color);
                })
                .collect(Collectors.toList());

        return dogs;
    }

    private boolean isValidName(String name) {
        return !INVALID_NAMES.contains(name);
    }

    private Dog buildDog(String name, String profileUrl, String imageUrl, String country, String color) {
        return Dog.builder()
                .name(name)
                .profileUrl(profileUrl)
                .imageUrl(imageUrl)
                .country(country)
                .color(color)
                .build();
    }

}
