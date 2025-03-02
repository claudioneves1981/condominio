package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Entity
public class Proprietario extends Pessoa {

    private ChaveComposta chaveComposta;

	public Proprietario(Long codigo, String pesquisa, Tipo tipo, String nome, String documento, LocalDate dataCadastro, Apartamento apto, Contato contato, Endereco endereco) {
		super(codigo, pesquisa, tipo, nome, documento, dataCadastro);
		chaveComposta.setApto(apto);
		chaveComposta.setContato(contato);
		this.endereco = endereco;
	}

	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "ID_ENDERECO")
	private Endereco endereco;

}


