package fr.eni.potager.bll;

import fr.eni.potager.bo.Plantation;
import fr.eni.potager.dal.PlantationDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlantationManager implements CrudManager<Plantation>{
    @Autowired
    private PlantationDAO dao;


    @Override
    @Transactional
    public Plantation saveOrUpdate(Plantation plantation) {
        return dao.save(plantation);
    }

    @Override
    @Transactional
    public List<Plantation> getAll() {
        return (List<Plantation>) dao.findAll();
    }

    @Override
    @Transactional
    public Plantation getById(Integer id) throws BLLManagerException {
        return dao.findById(id).orElseThrow(()-> new BLLManagerException("couldn't find this plantation"));
    }

    @Override
    @Transactional
    public void delete(Plantation plantation) {
        dao.delete(plantation);
    }
}
