package guru.springframework.spring5webapp.config;

import guru.springframework.spring5webapp.database.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:datasource.properties")
public class DataSourceConfig {

    @Value("${guru.username}")
    String userName;

    @Value("${guru.password}")
    String password;

    @Value("${guru.dbUrl}")
    String dbUrl;

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setUserName(userName);
        dataSource.setPassword(password);
        dataSource.setDburl(dbUrl);

        return dataSource;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
         return new PropertySourcesPlaceholderConfigurer();
    }
}
