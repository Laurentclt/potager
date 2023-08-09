package fr.eni.potager.dal;

import fr.eni.potager.bo.Plantation;
import org.springframework.data.repository.CrudRepository;

public interface PlantationDAO extends CrudRepository<Plantation, Integer> {
}
