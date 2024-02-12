package org.axel.nonblockingapi.config;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * Utility Class
 */
@Service
public class Utils {

    @Value("${axel.nonblockingapi.url}")
    public String url;

    public String getUrl(){
        return url;
    }
}
