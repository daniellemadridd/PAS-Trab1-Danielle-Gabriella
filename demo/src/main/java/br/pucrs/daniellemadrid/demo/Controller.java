package br.pucrs.daniellemadrid.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/acmespiele")
public class Controller{
     private List<Cliente> clientes;
     private List<Jogo> jogos;
     private List<Contrato> contratos;

    public Controller(){
   clientes = new ArrayList<>(List.of(
                new Cliente("838737473", "Maria", "maria@gmail.com", "usermaria", "password", java.sql.Date.valueOf("2000-09-11")),
                new Cliente("234456778", "Geovana", "geo@gmail.com", "usergeo", "password", java.sql.Date.valueOf("1992-12-23")),
                new Cliente("09837626", "Alice", "Alice@gmail.com", "userAli", "password", java.sql.Date.valueOf("2010-04-02"))));
            
    jogos = new ArrayList<>(List.of(
                new Jogo(1, 2019, "The Last of Us Part II", 0.50),
                new Jogo(2, 2020, "Cyberpunk 2077", 0.75),
                new Jogo(3, 2026, "Resident Evil 9", 0.60)));  

    contratos = new ArrayList<>(List.of(
                new Contrato(1, 1, java.sql.Date.valueOf("2024-06-01")),
                new Contrato(2, 2, java.sql.Date.valueOf("2024-07-01")),
                new Contrato(3, 3, java.sql.Date.valueOf("2024-08-01"))));

    }

 @GetMapping("/listaclientes")
    public List<Cliente> getListaClientes() {
        return clientes;
    }

  @GetMapping("/listajogos")
  public List<Jogo> getListaJogos(){
    return jogos;
  }

  @GetMapping("/listacontratos")
  public List<Contrato> getListContratos(){
    return contratos;
  }

 
  @GetMapping("/consultarjogossituacao/{situacao}")
  public List<Jogo> getJogoPorSituacao(@PathVariable String situacao){
    List<Jogo> jogoSituacao = new ArrayList<>();
    for(Jogo jogo : jogos){
      if(jogo.getSituacao().equals(situacao)){
        jogoSituacao.add(jogo);
      }
    
    return jogoSituacao;
 }

// A FINALIZAR (dani
//Corpo da requisição {id, data, período, cpf, codigo}
//resposta Retorna se o cadastro teve sucesso Booleano: true ou false )

  @PostMapping("/cadastro/cadcontrato")
    public Contrato cadastrarContrato(@RequestBody Contrato contrato){
        contratos.add(contrato);
        return contrato;
    }
}