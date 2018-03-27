package guru.springframework.spring5webapp.config;

import guru.springframework.spring5webapp.database.DatabaseSource;
import guru.springframework.spring5webapp.database.JMSSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
//@PropertySource({"classpath:datasource.properties","classpath:jms.properties"})
@PropertySources({
        @PropertySource("classpath:datasource.properties"),
        @PropertySource("classpath:jms.properties")
})
public class DatabaseSourceConfig {
    @Autowired
    Environment enviroment;

    @Value("${guru.username}")
    String userName;

    @Value("${guru.password}")
    String password;

    @Value("${jms.username}")
    String jmsUserName;

    @Value("${jms.password}")
    String jmsPassword;

    @Value("${guru.dbUrl}")
    String dbUrl;

    @Bean
    public DatabaseSource databaseSource() {
        DatabaseSource databaseSource = new DatabaseSource()   ;
        databaseSource.setUserName(userName);
        databaseSource.setPassword(password);
        databaseSource.setPassword(dbUrl);
        databaseSource.setUserName(enviroment.getProperty("USERNAME"));

        return databaseSource;
    }

    @Bean
    public JMSSource jmsSource() {
        JMSSource jmsSource = new JMSSource()   ;
        jmsSource.setUserName(jmsUserName);
        jmsSource.setPassword(jmsPassword);

        return jmsSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
