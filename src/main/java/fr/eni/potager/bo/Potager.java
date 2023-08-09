package fr.eni.potager.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Potager extends Lieu{
    @Id
    @GeneratedValue
    private Integer id;
    private String localisation;
    private String nom;
    private String ville;

    public Potager(String localisation, String nom, String ville) {
        super();
        this.localisation = localisation;
        this.nom = nom;
        this.ville = ville;
    }
}
