package webserver.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import yuhnim.client.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        SpringApplication.run(WebApplication.class, args);
    }
}
