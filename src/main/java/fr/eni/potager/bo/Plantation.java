package fr.eni.potager.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Plantation {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer qte;
    private Integer datePlantation;
    private Integer dateRecolte;
    @ManyToOne
    private Carre carre;
    @OneToMany
    private List<Plante> plantes;


    public Plantation(Integer qte, Integer datePlantation, Integer dateRecolte) {
        this.qte = qte;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
    }
}
