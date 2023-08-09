package fr.eni.potager.bo;

import fr.eni.potager.bo.enums.TypePlante;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Plante {
    @Id
    @GeneratedValue
    private Integer id;
    private String nom;

    private String variete;

    private Integer surface;

    @Enumerated(EnumType.STRING)
    private TypePlante typePlante;

    public Plante(String nom, String variete, Integer surface, TypePlante typePlante) {
        this.nom = nom;
        this.variete = variete;
        this.surface = surface;
        this.typePlante = typePlante;
    }
}
