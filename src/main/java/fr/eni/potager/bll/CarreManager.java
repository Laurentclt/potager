package fr.eni.potager.bll;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Plantation;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.CarreDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarreManager implements CrudManager<Carre> {
    @Autowired
    private CarreDAO dao;

    @Autowired
    private PlantationManager plantationManager;






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

    public List<Carre> getAllFromPotager(Potager potager) {
        return dao.findAllByPotager(potager);
    }

    public Boolean addPlantation(Plantation plantation, Carre carre) throws Exception {
        if (this.getSurfaceRestante(carre) > plantationManager.getSurface(plantation)) {
            plantation.setCarre(carre);
            plantationManager.saveOrUpdate(plantation);
            return true;
        } else {
            return false;
        }
    }

    public Integer getSurfaceRestante(Carre carre) {
        List<Plantation> plantations = plantationManager.getAllByCarre(carre);

        Integer surface = 0;
        for (Plantation plantation : plantations) {
            surface += plantationManager.getSurface(plantation);
        }
        return surface;
    }
}
