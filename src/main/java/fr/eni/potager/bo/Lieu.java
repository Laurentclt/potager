package fr.eni.potager.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public abstract class Lieu {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer surface;

    public Lieu(Integer surface) {
        this.surface = surface;
    }
}
