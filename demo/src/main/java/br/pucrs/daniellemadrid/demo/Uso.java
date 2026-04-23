package br.pucrs.daniellemadrid.demo;

import java.util.Date;

public class Uso {
    private int numero, horarioInicio, horarioFim;
    private Date dataInicio, dataFim;

    public Uso(int numero, int horarioInicio, int horarioFim, Date dataInicio, Date dataFim) {
        this.numero = numero;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }


    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getHorarioInicio() {
        return this.horarioInicio;
    }

    public void setHorarioInicio(int horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getHorarioFim() {
        return this.horarioFim;
    }

    public void setHorarioFim(int horarioFim) {
        this.horarioFim = horarioFim;
    }

    public Date getDataInicio() {
        return this.dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return this.dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
    
}
