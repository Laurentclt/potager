package fr.eni.potager;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.bo.enums.TypeExpo;
import fr.eni.potager.bo.enums.TypeSol;
import fr.eni.potager.dal.CarreDAO;
import fr.eni.potager.dal.PlantationDAO;
import fr.eni.potager.dal.PlanteDAO;
import fr.eni.potager.dal.PotagerDAO;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.TransactionSystemException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TestEntities {

    @Autowired
    private PotagerDAO potagerDAO;
    @Autowired
    private CarreDAO carreDAO;
    @Autowired
    private PlantationDAO plantationDAO;
    @Autowired
    private PlanteDAO planteDAO;

    @Test
    @Transactional
    void testEntities() {
        Potager potagerValid = Potager.builder().surface(3000).ville("test").localisation("test").nom("test").build();
        Potager potagerInvalid = Potager.builder().surface(100000).ville("test").localisation("test").nom("test").build();

        Carre carreValid = Carre.builder().typeSol(TypeSol.SABLEUX).typeExpo(TypeExpo.MI_OMBRE).surface(300).potager(potagerValid).build();
        Carre carreInvalid = Carre.builder().typeSol(TypeSol.SABLEUX).typeExpo(TypeExpo.MI_OMBRE).surface(1000).potager(potagerValid).build();

        assertEquals(potagerValid ,potagerDAO.save(potagerValid));
        assertDoesNotThrow(() -> potagerDAO.save(potagerInvalid));
    }

}
