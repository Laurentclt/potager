package fr.eni.potager.bll;

import fr.eni.potager.bo.Plante;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanteManager implements CrudManager<Plante>{

    @Override
    public Plante saveOrUpdate() {
        return null;
    }

    @Override
    public List<Plante> getAll() {
        return null;
    }

    @Override
    public Plante getById() {
        return null;
    }

    @Override
    public void delete() {

    }
}
