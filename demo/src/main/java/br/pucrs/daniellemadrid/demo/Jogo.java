package br.pucrs.daniellemadrid.demo;

public class Jogo {
    private int codigo, ano;
    private String nome;
    private double valorMinuto;

    public Jogo(int codigo, int ano, String nome, double valorMinuto) {
        this.codigo = codigo;
        this.ano = ano;
        this.nome = nome;
        this.valorMinuto = valorMinuto;
    }


    public int getCodigo() {
        return this.codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMinuto() {
        return this.valorMinuto;
    }

    public void setValorMinuto(double valorMinuto) {
        this.valorMinuto = valorMinuto;
    }
}
