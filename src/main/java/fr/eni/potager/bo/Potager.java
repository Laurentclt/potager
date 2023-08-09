package fr.eni.potager.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Potager{
    @Id
    @GeneratedValue
    private Integer id;
    private String localisation;
    private String nom;
    private String ville;

    private Integer surface;

    public Potager(String localisation, String nom, String ville, Integer surface) {
        this.surface =surface;
        this.localisation = localisation;
        this.nom = nom;
        this.ville = ville;
    }
}
