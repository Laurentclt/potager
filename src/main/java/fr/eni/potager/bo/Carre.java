package fr.eni.potager.bo;

import fr.eni.potager.bo.enums.TypeExpo;
import fr.eni.potager.bo.enums.TypeSol;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;


@Data
@NoArgsConstructor
@Entity
public class Carre  {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Potager potager;
    @Enumerated(EnumType.STRING)
    private TypeSol typeSol;

    @Enumerated(EnumType.STRING)
    private TypeExpo typeExpo;

    private Integer surface;



    public Carre(Potager potager, TypeSol typeSol, TypeExpo typeExpo, Integer surface) {
        this.surface = surface;
        this.potager = potager;
        this.typeSol = typeSol;
        this.typeExpo = typeExpo;
    }
}
