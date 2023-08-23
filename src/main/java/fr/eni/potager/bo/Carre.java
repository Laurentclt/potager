package fr.eni.potager.bo;

import fr.eni.potager.bo.enums.TypeExpo;
import fr.eni.potager.bo.enums.TypeSol;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class Carre  {
    @Id
    @GeneratedValue
    private Integer id;
    @NotNull(message = "un carré appartient forcément à un potager")
    @ManyToOne
    private Potager potager;
    @NotBlank(message = "le type de sol est obligatoire !")
    @Enumerated(EnumType.STRING)
    private TypeSol typeSol;

    @NotBlank(message = "le type d'exposition est obligatoire !")
    @Enumerated(EnumType.STRING)
    private TypeExpo typeExpo;

    @NotNull(message = "la surface est obligatoire !")
    @Min(value = 30, message = "le carré ne peut avoir une surface inférieure a 30cm2")
    @Max(value = 500, message = "le carré ne peut avoir une surface supérieure à 5m2")
    private Integer surface;



    public Carre(Potager potager, TypeSol typeSol, TypeExpo typeExpo, Integer surface) {
        this.surface = surface;
        this.potager = potager;
        this.typeSol = typeSol;
        this.typeExpo = typeExpo;
    }
}
