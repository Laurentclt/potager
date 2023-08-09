package fr.eni.potager.dal;

import fr.eni.potager.bo.Carre;
import org.springframework.data.repository.CrudRepository;

public interface CarreDAO extends CrudRepository<Carre, Integer> {
}
