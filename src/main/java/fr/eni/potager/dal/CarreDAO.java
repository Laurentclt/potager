package fr.eni.potager.dal;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Potager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarreDAO extends CrudRepository<Carre, Integer> {
    List<Carre> findAllByPotager(Potager potager);
}
