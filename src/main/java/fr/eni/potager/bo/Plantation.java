package fr.eni.potager.bo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.List;

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
    @OneToMany(fetch = FetchType.EAGER)
    private List<Plante> plantes;


    public Plantation(Integer qte, LocalDate datePlantation, LocalDate dateRecolte) {
        this.qte = qte;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
    }
}
