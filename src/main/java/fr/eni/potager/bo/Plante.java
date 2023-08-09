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
    @Enumerated(EnumType.STRING)
    private TypePlante typePlante;

    public Plante(String nom, TypePlante typePlante) {
        this.nom = nom;
        this.typePlante = typePlante;
    }
}
