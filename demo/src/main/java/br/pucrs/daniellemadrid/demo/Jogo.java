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

    // A FINALIZAR (dani)
    // Todo jogo inicialmente é cadastrado no sistema como disponível. Torna-se
    // contratado se algum cliente realizar um contrato. 
    // Torna-se obsoleto se o último contrato expirado foi há mais de 2 anos ou se não teve nenhum contrato após 2 anos de seu ano de lançamento.
    // Um jogo é removido do sistema após 1 de se tornar obsoleto.
    public String getSituacao(){
        if(){
      return "disponivel";
       } else if(){
           return "contratado";
           } else if(){
            return "obsoleto";
            } else {
           return "removido";
        }
    }
}
