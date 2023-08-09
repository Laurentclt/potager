package fr.eni.potager;

import fr.eni.potager.bll.CarreManager;
import fr.eni.potager.bll.PlantationManager;
import fr.eni.potager.bll.PlanteManager;
import fr.eni.potager.bll.PotagerManager;
import fr.eni.potager.bo.Carre;
import fr.eni.potager.bo.Plantation;
import fr.eni.potager.bo.Plante;
import fr.eni.potager.bo.Potager;
import fr.eni.potager.bo.enums.TypeExpo;
import fr.eni.potager.bo.enums.TypePlante;
import fr.eni.potager.bo.enums.TypeSol;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner {

    @Autowired
    private PotagerManager potagerManager;

    @Autowired
    private CarreManager carreManager;

    @Autowired
    private PlanteManager planteManager;

    @Autowired
    private PlantationManager plantationManager;

    public static void main(String[] args) {
        SpringApplication.run(PotagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Potager potager1 = new Potager("Chemin des Fleurs", "Jardin de Marie", "Rennes", 500);

        // Création de carrés
        Carre carre1 = new Carre(potager1, TypeSol.ARGILEUX, TypeExpo.SOLEIL, 100);
        Carre carre2 = new Carre(potager1, TypeSol.SABLEUX, TypeExpo.MI_OMBRE, 200);
        Carre carre3 = new Carre(potager1, TypeSol.ROCAILLEUX, TypeExpo.OMBRE, 300);

        // Création de plantes
        Plante plante1 = new Plante("Carotte", "carottes des sables", 5, TypePlante.RACINE);

        // Création d'une plante dans un carré
        Plantation plantation1 = new Plantation(15, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante1);


        System.out.println("Potager: " + potager1.getNom() + " à " + potager1.getLocalisation() + " (" + potager1.getVille() + ")");
        System.out.println("Carré: " + carre1.getSurface() + " cm2, sol: " + carre1.getTypeSol() + ", exposition: " + carre1.getTypeExpo());
        System.out.println("Plante: " + plante1.getNom() + " (" + plante1.getTypePlante() + ")");
        System.out.println("Plante dans carré: " + plantation1.getQte() + " plants, mise en place: " + plantation1.getDatePlantation() + ". Plants, à récolter le : " + plantation1.getDateRecolte() );

        potager1 = potagerManager.saveOrUpdate(potager1);
        carre1 = carreManager.saveOrUpdate(carre1);
        plante1 = planteManager.saveOrUpdate(plante1);
        plantation1 = plantationManager.saveOrUpdate(plantation1);


        System.out.println("get potager : " + potagerManager.getById(potager1.getId()));
        System.out.println("get carre : " + carreManager.getById(carre1.getId()));
        System.out.println("get plante : " + planteManager.getById(plante1.getId()));
        System.out.println("get plantation : " + plantationManager.getById(plantation1.getId()));


        System.out.println(potagerManager.getById(potager1.getId()));

        System.out.println("succes ?" + potagerManager.addCarre(carre1, potager1));
        System.out.println("succes ?" + potagerManager.addCarre(carre2, potager1));
        System.out.println("succes ?" + potagerManager.addCarre(carre3, potager1));

        System.out.println("surface restante potager 1 :" + potagerManager.getSurfaceRestante(potager1));
    }
}
