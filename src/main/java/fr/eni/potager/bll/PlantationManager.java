package fr.eni.potager.bll;

import fr.eni.potager.bo.Plantation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationManager implements CrudManager<Plantation>{

    @Override
    public Plantation saveOrUpdate() {
        return null;
    }

    @Override
    public List<Plantation> getAll() {
        return null;
    }

    @Override
    public Plantation getById() {
        return null;
    }

    @Override
    public void delete() {

    }
}
