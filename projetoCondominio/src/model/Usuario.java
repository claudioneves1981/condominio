package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

	private int codigo;
	private String pesquisa;
	private String nome;
	private String documento;
	private String tipo;
	private String observacao;

}