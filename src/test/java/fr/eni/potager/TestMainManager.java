package fr.eni.potager;

import fr.eni.potager.bll.BLLManagerException;
import fr.eni.potager.bll.MainManager;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.PotagerDAO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestMainManager {

    @Autowired
    MainManager manager;

    @Autowired
    PotagerDAO potagerDAO;

    @Test
    @Transactional
    void saveOrUpdatePotager() throws BLLManagerException {
        Long nb = potagerDAO.count();


        // test si l'exception est levé en cas de mauvais input
        assertThrows(BLLManagerException.class, () ->
                // insertion d'ub potager invalide
                manager.saveOrUpdatePotager(Potager.builder()
                        .nom("test").ville("test").localisation("test").surface(200).build()));

        // insertion d'un potager valide
        manager.saveOrUpdatePotager(Potager.builder()
                .nom("test").ville("test").localisation("test").surface(2000).build());
        // test si le potager est bien insérer
        assertEquals(nb + 1, manager.getAllPotager().size());
    }

    @Test
    @Transactional
    void getAllPotager() throws BLLManagerException {
        // nb de potagers dans la bdd
        Long nb = potagerDAO.count();

        // ajout d'un potager
        manager.saveOrUpdatePotager(Potager.builder()
                .nom("test").ville("test").localisation("test").surface(2000).build());

        assertEquals(nb + 1, manager.getAllPotager().size());
    }

    @Test
    @Transactional
    void updatePotager() throws BLLManagerException {
        // ajout d'un potager
        Potager potager = manager.saveOrUpdatePotager(Potager.builder()
                .nom("test").ville("test").localisation("test").surface(2000).build());

        // modifie les valeurs nom et surface
        potager.setNom("modifié");
        potager.setSurface(1000);

        Potager potagerUpdated = manager.saveOrUpdatePotager(potager);

        assertEquals(1000, potagerUpdated.getSurface());
        assertEquals("modifié", potagerUpdated.getNom());
    }

    @Test
    @Transactional
    void deletePotager() throws BLLManagerException {
        Long nb = potagerDAO.count();
        Potager potager = Potager.builder()
                .nom("test").ville("test").localisation("test").surface(2000).build();

        manager.saveOrUpdatePotager(potager);
        assertEquals(nb + 1, potagerDAO.count());

        manager.deletePotager(potager);
        assertEquals(nb, potagerDAO.count());
    }

    @Test
    @Transactional
    void getPotagerById() throws BLLManagerException {
        Potager potager = Potager.builder()
                .nom("test").ville("test").localisation("test").surface(2000).build();

        manager.saveOrUpdatePotager(potager);

        assertEquals(potager, manager.getPotagerById(potager.getId()));
        assertThrows(BLLManagerException.class, ()-> manager.getPotagerById(1000000000));
    }
}
