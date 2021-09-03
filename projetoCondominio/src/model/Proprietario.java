package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Proprietario {

	private int codigo;
	private String pesquisa;
	private String nome;
	private String apto;
	private String bloco;
	private String cpf;
	private String telefone;
	private String email;
	private String dataCadastro;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String tipo;

}


