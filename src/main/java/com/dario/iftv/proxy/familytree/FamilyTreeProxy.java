package com.dario.iftv.proxy.familytree;

import com.dario.iftv.core.domain.Dog;
import com.dario.iftv.core.gateway.FamilyTreeGateway;
import com.dario.iftv.proxy.familytree.dto.DogDto;
import com.dario.iftv.proxy.familytree.excpetion.FamilyTreeException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import static java.lang.String.format;
import static org.springframework.http.HttpMethod.GET;

@Service
@RequiredArgsConstructor
public class FamilyTreeProxy implements FamilyTreeGateway {

    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    @Value("${family-tree.api.url}/api/v1/family-tree?generations={generations}")
    private String url;

    @Value("${family-tree.api.key}")
    private String apiKey;

    public Dog getFamilyTree(int generations) {
        try {
            DogDto dog = restTemplate.exchange(url, GET, createRequest(), DogDto.class, generations).getBody();
            return mapper.convertValue(dog, Dog.class);
        } catch (HttpStatusCodeException ex) {
            String message = format("Failed to get family tree using endpoint %s with %s generations. Status code: %s (%s). Body: %s",
                    url, generations, ex.getStatusCode(), ex.getStatusText(), ex.getResponseBodyAsString());
            throw new FamilyTreeException(message, ex);
        } catch (RestClientException ex) {
            String message = format("Failed to get family tree using endpoint %s with %s generations.", url, generations);
            throw new FamilyTreeException(message, ex);
        }
    }

    private HttpEntity<?> createRequest() {
        HttpHeaders requestHeader = new HttpHeaders();
        requestHeader.set("api-key", apiKey);

        return new HttpEntity<>(requestHeader);
    }

}
