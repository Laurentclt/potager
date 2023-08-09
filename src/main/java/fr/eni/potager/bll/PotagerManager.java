package fr.eni.potager.bll;

import fr.eni.potager.bo.Potager;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotagerManager implements CrudManager<Potager>{


    @Override
    public Potager saveOrUpdate() {
        return null;
    }

    @Override
    public List<Potager> getAll() {
        return null;
    }

    @Override
    public Potager getById() {
        return null;
    }

    @Override
    public void delete() {

    }
}
