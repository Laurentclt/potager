package fr.eni.potager.bll;

import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Plantation;
import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.dal.CarreDAO;
import fr.eni.potager.dal.PlantationDAO;
import fr.eni.potager.dal.PlanteDAO;
import fr.eni.potager.dal.PotagerDAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainManager {
    @Autowired
    private CarreDAO carreDAO;

    @Autowired
    private PlantationDAO plantationDAO;

    @Autowired
    private PlanteDAO planteDAO;

    @Autowired
    private PotagerDAO potagerDAO;


        @Transactional
        public Carre addCarreIntoPotager(Carre carre) throws BLLManagerException {
            Integer surfaceDispo = getSurfaceRestantePotager(carre.getPotager());
            if (surfaceDispo < carre.getSurface()) {
                throw new BLLManagerException("not enough space in potager");
            }
            return carreDAO.save(carre);
        }

        @Transactional
        public Carre getCarreById (Integer id) throws BLLManagerException {
            return carreDAO.findById(id).orElseThrow(() -> new BLLManagerException("couldn't find this carré"));
        }

        @Transactional
        public void deleteCarre (Carre carre){
            carreDAO.delete(carre);
        }

        @Transactional
        public List<Carre> getAllCarreFromPotager (Potager potager){
            List<Carre> carreList = carreDAO.findAllByPotager(potager);
            return carreList;
        }


        @Transactional
        public Plantation addPlantationIntoCarre (Plantation plantation) throws BLLManagerException {
            if (!checkNumberMaxPlantation(plantation, 3)) {
                throw new BLLManagerException("Too much of this plant in this carre");
            }
            Integer surfaceDispo = getSurfaceRestanteCarre(plantation.getCarre());
            if (surfaceDispo < plantation.getSurface()) {
                throw new BLLManagerException("not enough space in carre");
            }
            return plantationDAO.save(plantation);
        }

        private Integer getSurfaceRestanteCarre (Carre carre){
            Integer surfaceCarre = carre.getSurface();
            List<Plantation> plantationList = getAllPlantationFromCarre(carre);
            Integer surfacePlantationList = 0;
            for (Plantation plantation : plantationList) {
                surfacePlantationList += plantation.getSurface();
            }
            return surfaceCarre - surfacePlantationList;
        }

        private List<Plantation> getAllPlantationFromCarre (Carre carre){
            List<Plantation> plantationList = plantationDAO.findAllByCarre(carre);
            return plantationList;
        }

        private boolean checkNumberMaxPlantation (Plantation plantation, Integer count){
            List<Plantation> plantationList = getAllPlantationFromCarre(plantation.getCarre());
            for (Plantation value : plantationList) {
                if (plantation.getPlante().getNom().equals(value.getPlante().getNom())) {
                    count--;
                }
            }
            return count >= 0;
        }


        @Transactional
        public List<Plantation> getAllPlantation () {
            return (List<Plantation>) plantationDAO.findAll();
        }


        @Transactional
        public Plantation getPlantationById (Integer id) throws BLLManagerException {
            return plantationDAO.findById(id).orElseThrow(() -> new BLLManagerException("couldn't find this plantation"));
        }

        @Transactional
        public void deletePlantation (Plantation plantation){
            plantationDAO.delete(plantation);
        }

        @Transactional
        public Plante saveOrUpdatePlante (Plante plante) throws BLLManagerException {
            isPlantAlreadyRegistered(plante);
            return planteDAO.save(plante);
        }

        private void isPlantAlreadyRegistered (Plante plante) throws BLLManagerException {
            List<Plante> plantes = (List<Plante>) planteDAO.findAll();
            for (Plante value : plantes) {
                if (plante.getNom().equals(value.getNom()) && plante.getVariete().equals(value.getVariete())) {
                    throw new BLLManagerException("plant already exist in database");
                }
            }
        }

        @Transactional
        public List<Plante> getAllPlante () {
            return (List<Plante>) planteDAO.findAll();
        }

        @Transactional
        public Plante getPlanteById (Integer id) throws BLLManagerException {
            return planteDAO.findById(id).orElseThrow(() -> new BLLManagerException("couldn't find this plante"));
        }


        @Transactional
        public void deletePlante (Plante plante){
            planteDAO.delete(plante);
        }


        @Transactional
        public Potager saveOrUpdatePotager (Potager potager) throws BLLManagerException {
            if (potager.getSurface() < 300) {
                throw new BLLManagerException("Potager is too small");
            }
            return potagerDAO.save(potager);
        }


        @Transactional
        public List<Potager> getAllPotager () {
            return (List<Potager>) potagerDAO.findAll();
        }


        @Transactional
        public Potager getPotagerById (Integer id) throws BLLManagerException {
            return potagerDAO.findById(id).orElseThrow(() -> new BLLManagerException("couldn't find this potager"));
        }


        @Transactional
        public void deletePotager (Potager potager){
            potagerDAO.delete(potager);
        }

        public Integer getSurfaceRestantePotager (Potager potager){
            Integer surfacePotager = potager.getSurface();
            List<Carre> carreList = getAllCarreFromPotager(potager);
            Integer surfaceCarreList = 0;
            for (Carre carre : carreList) {
                surfaceCarreList += carre.getSurface();
            }
            return surfacePotager - surfaceCarreList;
        }
    }

