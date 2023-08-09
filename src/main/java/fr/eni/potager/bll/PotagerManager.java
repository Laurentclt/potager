package fr.eni.potager.bll;

import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.PotagerDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PotagerManager implements CrudManager<Potager>{

    @Autowired
    private PotagerDAO dao;


    @Override
    @Transactional
    public Potager saveOrUpdate(Potager potager) {
        return dao.save(potager);
    }

    @Override
    @Transactional
    public List<Potager> getAll() {
        return (List<Potager>) dao.findAll();
    }

    @Override
    @Transactional
    public Potager getById(Integer id) throws BLLManagerException {
        return dao.findById(id).orElseThrow(()-> new BLLManagerException("couldn't find this potager"));
    }

    @Override
    @Transactional
    public void delete(Potager potager) {
        dao.delete(potager);
    }
}
