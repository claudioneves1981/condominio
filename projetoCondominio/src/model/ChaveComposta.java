package model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChaveComposta {

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "ID_APTO")
    private Apartamento apto;

    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "ID_CONTATO")
    private Contato contato;

}
