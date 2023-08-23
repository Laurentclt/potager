package fr.eni.potager;

import fr.eni.potager.bll.*;
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

@SpringBootApplication
public class PotagerApplication implements CommandLineRunner {
    @Autowired
   private MainManager mainManager;

    public static void main(String[] args) {
        SpringApplication.run(PotagerApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

//        Potager potager1 = new Potager("Chemin des Fleurs", "Jardin de Marie", "Rennes", 1500);
//        Potager potager2 = new Potager("Chemin des Fruits", "Jardin de Vincent", "Rennes", 200);
//
//        // Création de carrés
//        Carre carre1 = new Carre(potager1, TypeSol.ARGILEUX, TypeExpo.SOLEIL, 500);
//        Carre carre2 = new Carre(potager1, TypeSol.SABLEUX, TypeExpo.MI_OMBRE, 200);
//        Carre carre3 = new Carre(potager1, TypeSol.ROCAILLEUX, TypeExpo.OMBRE, 300);
//
//        // Création de plantes
//
//        Plante plante1 = new Plante("Carotte", "carottes des sables", 5, TypePlante.RACINE);
//        Plante plante2 = new Plante("Carotte", "carottes des pierres", 6, TypePlante.RACINE);
//        Plante plante3 = new Plante("Carotte", "carottes des terres", 9, TypePlante.RACINE);
//        Plante plante4 = new Plante("Carotte", "carottes des glaces", 10, TypePlante.RACINE);
//        Plante plante5 = new Plante("Carotte", "carottes orange", 15, TypePlante.RACINE);
//
//        // Création d'une plante dans un carré
//        Plantation plantation1 = new Plantation(15, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante1);
//        Plantation plantation2 = new Plantation(20, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante2);
//        Plantation plantation3 = new Plantation(25, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante3);
//        Plantation plantation4 = new Plantation(30, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante4);
//        Plantation plantation5 = new Plantation(10, LocalDate.now(),  LocalDate.now().plusDays(15), carre1, plante5);
//
//
//        System.out.println("add plante to database : " + mainManager.saveOrUpdatePlante(plante1));
//        System.out.println("add plante to database : " + mainManager.saveOrUpdatePlante(plante2));
//        System.out.println("add plante to database : " + mainManager.saveOrUpdatePlante(plante3));
//        System.out.println("add plante to database : " + mainManager.saveOrUpdatePlante(plante4));
//        System.out.println("add plante to database : " + mainManager.saveOrUpdatePlante(plante5));
//
//        System.out.println("create potager : " + mainManager.saveOrUpdatePotager(potager1));
////        System.out.println("create potager : " + mainManager.saveOrUpdatePotager(potager2)); // throw error
//
//        System.out.println("add carre to potager : " +mainManager.addCarreIntoPotager(carre1));
//        System.out.println("add carre to potager : " +mainManager.addCarreIntoPotager(carre2));
//        System.out.println("add carre to potager : " +mainManager.addCarreIntoPotager(carre3));
//
//        System.out.println("add plantation to carre : " +mainManager.addPlantationIntoCarre(plantation1));
//        System.out.println("add plantation to carre : " +mainManager.addPlantationIntoCarre(plantation2));
//        System.out.println("add plantation to carre : " +mainManager.addPlantationIntoCarre(plantation3));
//        System.out.println("add plantation to carre : " +mainManager.addPlantationIntoCarre(plantation4));
//        System.out.println("add plantation to carre : " +mainManager.addPlantationIntoCarre(plantation5));
//
//

    }
}
