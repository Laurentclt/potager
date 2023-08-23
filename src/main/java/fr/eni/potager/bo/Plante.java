package fr.eni.potager.bo;

import fr.eni.potager.bo.enums.TypePlante;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Plante {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Le nom est obligatoire !")
    private String nom;

    @NotBlank(message = "La variété est obligatoire !")
    private String variete;

    @Min(value = 1, message = "une plante ne peut avoir une surface inférieure à 1")
    @Max(value = 100, message = "une plante ne peut avoir une surface supérieure à 100")
    @NotNull(message = "la surface d'une plante est obligatoire !")
    private Integer surface;

    @NotBlank(message = "le type de plante est obligatoire !")
    @Enumerated(EnumType.STRING)
    private TypePlante typePlante;

    public Plante(String nom, String variete, Integer surface, TypePlante typePlante) {
        this.nom = nom;
        this.variete = variete;
        this.surface = surface;
        this.typePlante = typePlante;
    }
}
