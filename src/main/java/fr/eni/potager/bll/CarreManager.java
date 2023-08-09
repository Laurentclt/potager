package fr.eni.potager.bll;

import fr.eni.potager.bo.Carre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreManager implements CrudManager<Carre> {

    @Override
    public Carre saveOrUpdate() {
        return null;
    }

    @Override
    public List<Carre> getAll() {
        return null;
    }

    @Override
    public Carre getById() {
        return null;
    }

    @Override
    public void delete() {

    }
}
