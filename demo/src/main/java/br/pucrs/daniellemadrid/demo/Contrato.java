package br.pucrs.daniellemadrid.demo;

import java.util.Date;

public class Contrato {
    private int id, periodo;
    private Jogo jogo;
    private Cliente cliente;
    private Date data;
    
    public Contrato(int id, int periodo, Date data, Jogo jogo, Cliente cliente) {
        this.id = id;
        this.periodo = periodo;
        this.data = data;
        this.jogo = jogo;
        this.cliente = cliente;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public Date getData() {
        return this.data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Jogo getJogo() {
        return this.jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double calcularTotal(Uso uso) {
        int minutosJogados = uso.getHorarioFim() - uso.getHorarioInicio();
        Categoria categoriaDoJogo = this.jogo.getCategoria();

        return categoriaDoJogo.getValorMininmo() + (minutosJogados * this.jogo.getValorMinuto());
    }
}