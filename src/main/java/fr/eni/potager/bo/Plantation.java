package fr.eni.potager.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    public Plantation(Integer qte, Integer datePlantation, Integer dateRecolte) {
        this.qte = qte;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
    }
}
