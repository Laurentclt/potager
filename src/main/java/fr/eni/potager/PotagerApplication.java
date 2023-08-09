package fr.eni.potager;

import fr.eni.potager.bll.PotagerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner {

    @Autowired
    private PotagerManager potagerManager;
    public static void main(String[] args) {
        SpringApplication.run(PotagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
