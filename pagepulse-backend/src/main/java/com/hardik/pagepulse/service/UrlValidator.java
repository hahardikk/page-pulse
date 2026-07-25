package com.hardik.pagepulse.service;

import com.hardik.pagepulse.exception.InvalidUrlException;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class UrlValidator {
    public void validateUrl(String url) {
        try {
            URI uri = URI.create(url);
            if(uri.getHost() == null){
                if (url.contains(".")) {
                    throw new InvalidUrlException(
                            "URL must start with http:// or https://"
                    );
                }
                // Doesn't even look like a URL
                throw new InvalidUrlException(
                        "Please provide a valid URL."
                );
            }
            String scheme = uri.getScheme();
            if (!scheme.equalsIgnoreCase("https")
                            && !scheme.equalsIgnoreCase("http")) {
                throw new InvalidUrlException("URL must start with http:// or https://");
            }
        } catch (IllegalArgumentException e) {
            throw new InvalidUrlException("Please provide a valid URL.");
        }
    }
}
