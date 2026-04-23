package br.pucrs.daniellemadrid.demo;

public class Categoria {
    private int num;
    private String nome;
    private double valorMininmo;

    public Categoria(int num, String nome, double valorMininmo) {
        this.num = num;
        this.nome = nome;
        this.valorMininmo = valorMininmo;
    }

    public int getNum() {
        return this.num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorMininmo() {
        return this.valorMininmo;
    }

    public void setValorMininmo(double valorMininmo) {
        this.valorMininmo = valorMininmo;
    }

}
