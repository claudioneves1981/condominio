package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Morador extends Pessoa {

    private ChaveComposta chaveComposta;

    public Morador(Long codigo, String pesquisa, Tipo tipo, String nome, String documento, LocalDate dataCadastro, Apartamento apto, Contato contato) {
        super(codigo, pesquisa, tipo, nome, documento, dataCadastro);
        chaveComposta.setContato(contato);
        chaveComposta.setApto(apto);

    }

}
