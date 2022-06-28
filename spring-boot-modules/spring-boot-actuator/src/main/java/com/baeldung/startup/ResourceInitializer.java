package com.baeldung.startup;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Component;

@Component
public class ResourceInitializer {

    ResourceInitializer() throws Exception {
        // simulate resource init with random delay of a few seconds
        int randomDelay = ThreadLocalRandom.current().nextInt(5, 9);
        TimeUnit.SECONDS.sleep(randomDelay);
    }

}
