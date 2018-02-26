package guru.springframework.spring5webapp.services;

public class PrimarySpanishGreetingService implements  GreetingService {
    @Override
    public String sayGreeting() {
        return "Spanish Greetings !!!!";
    }
}
