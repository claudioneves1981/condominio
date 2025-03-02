package model;

import lombok.*;

import jakarta.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Visitante extends Pessoa {

	private String observacao;

}