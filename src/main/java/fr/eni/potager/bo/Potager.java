package fr.eni.potager.bo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Potager{
    @Id
    @GeneratedValue
    private Integer id;
    @NotBlank
    @Size(min = 2, max = 100, message = "la localisation doit être compris entre 2 et 100 caractères")
    private String localisation;
    @NotBlank()
    @Size(min = 2, max = 100, message = "le nom doit être compris entre 2 et 100 caractères")
    private String nom;
    @NotBlank
    @Size(min = 2, max = 100, message = "la ville doit être compris entre 2 et 100 caractères")
    private String ville;
    @NotNull
    @Min(value = 300, message = "Le potager que voues essayez de créer est trop petit")
    @Max(value = 5000, message = "Le potager que voues essayez de créer est trop grand")
    private Integer surface;

    public Potager(String localisation, String nom, String ville, Integer surface) {
        this.surface =surface;
        this.localisation = localisation;
        this.nom = nom;
        this.ville = ville;
    }
}
