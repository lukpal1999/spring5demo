package guru.springframework.spring5webapp.services;

import org.springframework.stereotype.Service;

@Service
public class SetterGreetingService implements GreetingService {

    @Override
    public String sayGreeting() {
        return "I am in Setter Greeting Service !!!!";
    }
}
