package fr.eni.potager.bo;

import fr.eni.potager.bo.enums.TypeExpo;
import fr.eni.potager.bo.enums.TypeSol;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
public class Carre extends Lieu {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Potager potager;
    @Enumerated(EnumType.STRING)
    private TypeSol typeSol;

    @Enumerated(EnumType.STRING)
    private TypeExpo typeExpo;


    public Carre(Potager potager, TypeSol typeSol, TypeExpo typeExpo) {
        super();
        this.potager = potager;
        this.typeSol = typeSol;
        this.typeExpo = typeExpo;
    }
}
