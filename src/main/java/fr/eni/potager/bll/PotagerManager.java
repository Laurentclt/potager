package fr.eni.potager.bll;

import fr.eni.potager.bo.Carre;
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

    @Autowired
    private CarreManager carreManager;



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

    public boolean addCarre(Carre carre, Potager potager) throws BLLManagerException {
        try {
            // check si la surface restante du potager est suffisante pour intégrer le nouveau carré
            if (this.getSurfaceRestante(potager) > carre.getSurface() ) {
                // ajouter le carre dans le potager
                carre.setPotager(potager);
                // persiste le carré en bdd
                carreManager.saveOrUpdate(carre);
                return true;
            }
            else {
                return false;
            }
        } catch (Exception e) {
            throw new BLLManagerException("error in method addCarre() in PotagerManager");
        }
    }

    public Integer getSurfaceRestante(Potager potager) {
        // récupère surface du potager cible
        Integer surfacePotager = potager.getSurface();
        // initialise la surface des carrés du potager déja présent sur le potager
        Integer surfaceAllCarres = 0;
        // récupère les carrés du potager
        List<Carre> carres = carreManager.getAllFromPotager(potager);
        for (Carre value : carres) {
            surfaceAllCarres += value.getSurface();
        }
        return surfacePotager - surfaceAllCarres;
    }

}