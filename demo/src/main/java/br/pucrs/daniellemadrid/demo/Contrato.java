package br.pucrs.daniellemadrid.demo;

import java.util.Date;

public class Contrato {
    private int id, periodo;
    private Date data;

    public Contrato(int id, int periodo, Date data) {
        this.id = id;
        this.periodo = periodo;
        this.data = data;
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
}