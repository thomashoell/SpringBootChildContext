package de.tho.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by Hoell on 07.07.2016.
 */
@Service
public class DummyService {
    private final Logger logger = LoggerFactory.getLogger(DummyService.class);

    public String getMessage() {
        String s = String.format("Hello from DummyService, it is %s", LocalDateTime.now().toString());

        return s;
    }
}
