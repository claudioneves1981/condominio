package model;

import lombok.Getter;

@Getter
public enum Tipo {

    VISITANTE("Visitante"),
    MORADOR("Morador"),
    PROPRIETARIO("Proprietário"),
    PRESTADOR("Prestador");


    private String descricao;

    Tipo(String descricao) {

   this.descricao = descricao;
    }

    public void setDescricao(String descricao){

        this.descricao = descricao;
    }
}
