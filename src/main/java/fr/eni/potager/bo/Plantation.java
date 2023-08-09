package fr.eni.potager.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Plantation {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer qte;
    private LocalDate datePlantation;
    private LocalDate dateRecolte;
    @ManyToOne
    private Carre carre;
    @OneToOne(fetch = FetchType.EAGER)
    private Plante plante;


    public Plantation(Integer qte, LocalDate datePlantation, LocalDate dateRecolte, Carre carre, Plante plante) {
        this.qte = qte;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
        this.carre = carre;
        this.plante = plante;
    }
}
