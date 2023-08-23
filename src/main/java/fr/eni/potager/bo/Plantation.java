package fr.eni.potager.bo;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ScriptAssert;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ScriptAssert(lang = "javascript", script = "this._dateRecolte.after(_this.datePlantation)", message = "la date de récolte ne peut être avant la date de plantation")
public class Plantation {
    @Id
    @GeneratedValue
    private Integer id;
    @Min(value = 1, message = "la quantité ne peut être inférieur à 1")
    @Max(value = 100, message = "la quantité ne peut être supérieur à 100")
    @NotNull(message = "la quantité est obligatoire !")
    private Integer qte;
    @NotNull(message = "la date de plantation doit être déterminée")
    private LocalDate datePlantation;
    @NotNull(message = "la date de récolte doit être programmée")
    private LocalDate dateRecolte;
    @ManyToOne
    @NotNull(message = "une plantation doit forcément appartenir à un carré")
    private Carre carre;
    @OneToOne(fetch = FetchType.EAGER)
    @NotNull(message = "une plantation désigne forcément une plante")
    private Plante plante;


    public Plantation(Integer qte, LocalDate datePlantation, LocalDate dateRecolte, Carre carre, Plante plante) {
        this.qte = qte;
        this.datePlantation = datePlantation;
        this.dateRecolte = dateRecolte;
        this.carre = carre;
        this.plante = plante;
    }

    public Integer getSurface() {
        return this.qte * this.plante.getSurface();
    }
}
