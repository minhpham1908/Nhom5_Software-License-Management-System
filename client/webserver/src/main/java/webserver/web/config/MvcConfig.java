package webserver.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import yuhnim.client.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@Configuration
public class MvcConfig  implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("index");
//        registry.addViewController("/licenceInfo").setViewName("/LicenceInfo");
//        registry.addViewController("/login").setViewName("login");
    }
    @Bean
    public Client getClient() throws RemoteException, NotBoundException {
        return new Client();
    }

}
