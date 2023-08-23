package fr.eni.potager;

import fr.eni.potager.bll.BLLManagerException;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.ws.PotagerWS;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestController {

    @Autowired
    private PotagerWS controller;

    @Test
    void createPotager() throws BLLManagerException {
        Potager potager = Potager.builder().surface(1000).localisation("test").ville("test").nom("test").build();
        controller.createPotager(potager);
    }
}
