package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria) {
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void registrarLivro(Integer quantidade) {
        if (quantidade != null && ativa == true && quantidade > 0) {
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade){
        if (ativa == true && quantidade != null && quantidade > 0 && quantidade <= qtdLivros) {
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade) {
        if (ativa == true  && quantidade != null && quantidade > 0) {
            qtdLivros += quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer desativar() {
        if (ativa == false) {
            return null;
        } else {
            Integer livrosAnteriores = qtdLivros;
            ativa = false;
            qtdLivros = 0;
            return livrosAnteriores;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if (destino.ativa == true && this.ativa == true && this.qtdLivros != null && quantidade != null && quantidade <= this.qtdLivros) {
            this.qtdLivros -= quantidade;
            destino.qtdLivros += quantidade;
        }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual != null && percentual > 0) {
            multaDiaria += multaDiaria * percentual;
            return true;
        } else {
            return false;
        }
    }
    public String getNome(){
        return nome;
    }
    public Double getMultaDiaria(){
        return multaDiaria;
    }
    public Integer getQtdLivros(){
        return qtdLivros;
    }
    public Boolean getAtiva(){
        return ativa;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
