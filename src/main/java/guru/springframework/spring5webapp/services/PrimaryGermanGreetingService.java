package guru.springframework.spring5webapp.services;

public class PrimaryGermanGreetingService implements GreetingService {
    @Override
    public String sayGreeting() {
        return "German Greetings !!!!";
    }
}

