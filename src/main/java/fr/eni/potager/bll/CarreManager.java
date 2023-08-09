package fr.eni.potager.bll;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.dal.CarreDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreManager implements CrudManager<Carre> {
    @Autowired
    private CarreDAO dao;


    @Override
    @Transactional
    public Carre saveOrUpdate(Carre carre) {
        return dao.save(carre);
    }

    @Override
    @Transactional
    public List<Carre> getAll() {
        return (List<Carre>) dao.findAll();
    }

    @Override
    @Transactional
    public Carre getById(Integer id) throws BLLManagerException {
        return dao.findById(id).orElseThrow(()-> new BLLManagerException("couldn't find this carré"));
    }

    @Override
    @Transactional
    public void delete(Carre carre) {
        dao.delete(carre);
    }
}
