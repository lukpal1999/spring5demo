package guru.springframework.spring5webapp.config;

import guru.springframework.spring5webapp.database.DatabaseSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DatabaseSourceConfig {
    @Value("${guru.username}")
    String userName;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dbUrl}")
    String dbUrl;

    @Bean
    public DatabaseSource databaseSource() {
        DatabaseSource databaseSource = new DatabaseSource()   ;
        databaseSource.setUserName(userName);
        databaseSource.setPassword(password);
        databaseSource.setPassword(dbUrl);

        return databaseSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
