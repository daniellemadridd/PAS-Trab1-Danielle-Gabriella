package br.pucrs.daniellemadrid.demo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Jogo {
    private int codigo, ano;
    private String nome;
    private double valorMinuto;
    private Categoria categoria;
    private String situacao;

    public Jogo(int codigo, int ano, String nome, double valorMinuto, Categoria categoria) {
        this.codigo = codigo;
        this.ano = ano;
        this.nome = nome;
        this.valorMinuto = valorMinuto;
        this.categoria = categoria;
        this.situacao = "disponivel";
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

    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getSituacao() {
    return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public String getSituacao(List<Contrato> todosContratos) {
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        Date dataUltimoContrato = null;
        boolean temContratoVigente = false;

            for (Contrato c : todosContratos) {
                if (c.getJogo() != null && c.getJogo().getCodigo() == this.codigo) {
                if (dataUltimoContrato == null || c.getData().after(dataUltimoContrato)) {
                    dataUltimoContrato = c.getData();
                }
                
                Calendar dataFimContrato = Calendar.getInstance();
                dataFimContrato.setTime(c.getData());
                dataFimContrato.add(Calendar.MONTH, c.getPeriodo());
                
                if (dataFimContrato.after(Calendar.getInstance())) {
                    temContratoVigente = true;
                }
            }
        }
        if (temContratoVigente) {
            return "contratado";
        }
        int anosInativo;
        if (dataUltimoContrato == null) {
            anosInativo = anoAtual - this.ano;
        } else {
            Calendar cal = Calendar.getInstance();
            cal.setTime(dataUltimoContrato);
            anosInativo = anoAtual - cal.get(Calendar.YEAR);
        }
        if (anosInativo > 3) {
            return "removido";   
        } else if (anosInativo > 2) {
            return "obsoleto";  
        } else {
            return "disponivel"; 
        }
    }
}
