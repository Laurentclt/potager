package fr.eni.potager.bll;

import fr.eni.potager.bo.Plante;
import fr.eni.potager.dal.PlanteDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlanteManager implements CrudManager<Plante>{
    @Autowired
    private PlanteDAO dao;


    @Override
    @Transactional
    public Plante saveOrUpdate(Plante plante) {
        return dao.save(plante);
    }

    @Override
    @Transactional
    public List<Plante> getAll() {
        return (List<Plante>) dao.findAll();
    }

    @Override
    @Transactional
    public Plante getById(Integer id) throws BLLManagerException {
        return dao.findById(id).orElseThrow(() -> new BLLManagerException("couldn't find this plante"));
    }

    @Override
    @Transactional
    public void delete(Plante plante) {
        dao.delete(plante);
    }
}
