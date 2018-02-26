package guru.springframework.spring5webapp.services;

import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImpl implements GreetingService {
    public static String HELLO_GURUS = "Hello World !!! GreetingServiceImpl";

    @Override
    public String sayGreeting() {
        return HELLO_GURUS;
    }

}
