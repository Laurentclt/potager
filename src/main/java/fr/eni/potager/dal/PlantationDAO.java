package fr.eni.potager.dal;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Plantation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlantationDAO extends CrudRepository<Plantation, Integer> {
    List<Plantation> findAllByCarre(Carre carre);
}
