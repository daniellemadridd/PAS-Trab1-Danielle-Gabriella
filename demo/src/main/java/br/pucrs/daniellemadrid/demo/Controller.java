package br.pucrs.daniellemadrid.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acmespiele")
public class Controller{
     private List<Cliente> clientes;
     private List<Jogo> jogos;
     private List<Contrato> contratos;
     private List<Uso> usos;
     private List<Categoria> categorias;

    public Controller(){
   clientes = new ArrayList<>(List.of(
                new Cliente("838737473", "Maria", "maria@gmail.com", "usermaria", "password", java.sql.Date.valueOf("2000-09-11")),
                new Cliente("234456778", "Geovana", "geo@gmail.com", "usergeo", "password", java.sql.Date.valueOf("1992-12-23")),
                new Cliente("09837626", "Alice", "Alice@gmail.com", "userAli", "password", java.sql.Date.valueOf("2010-04-02"))));
            
    categorias = new ArrayList<>(List.of(
                new Categoria(1, "Bronze", 50.0),
                new Categoria(2, "Prata", 75.0),
                new Categoria(3, "Ouro", 100.0),
                new Categoria(4, "Platina", 120.0),
                new Categoria(5, "Diamante", 150.0)));

    jogos = new ArrayList<>(List.of(
                new Jogo(1, 2019, "The Last of Us Part II", 0.50, categorias.get(0)),
                new Jogo(2, 2020, "Cyberpunk 2077", 0.75, categorias.get(1)),
                new Jogo(3, 2026, "Resident Evil 9", 0.60, categorias.get(2)),
                new Jogo(4, 2023, "Elden Ring", 0.80, categorias.get(3)),
                new Jogo(5, 2022, "God of War Ragnarök", 0.90, categorias.get(4))));  

    contratos = new ArrayList<>(List.of(
                new Contrato(1, 1, java.sql.Date.valueOf("2024-06-01"), jogos.get(0), clientes.get(0)),
                new Contrato(2, 2, java.sql.Date.valueOf("2024-07-01"), jogos.get(1), clientes.get(0)),
                new Contrato(3, 3, java.sql.Date.valueOf("2024-08-01"), jogos.get(2), clientes.get(1)),
                new Contrato(4, 1, java.sql.Date.valueOf("2024-06-15"), jogos.get(3), clientes.get(1))));
    
    usos = new ArrayList<>(List.of(
                new Uso(1, 8, 18, java.sql.Date.valueOf("2024-06-01"), java.sql.Date.valueOf("2024-06-10")),
                new Uso(2, 9, 17, java.sql.Date.valueOf("2024-07-01"), java.sql.Date.valueOf("2024-07-15")),
                new Uso(3, 13, 22, java.sql.Date.valueOf("2024-08-01"),java.sql.Date.valueOf("2024-08-20"))));
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
      if(jogo.getSituacao(contratos).equals(situacao)){
        jogoSituacao.add(jogo);
      }
    }
    return jogoSituacao;

  
 }

  @PostMapping("/cadastro/cadcontrato")
    public boolean cadastrarContrato(@RequestBody java.util.Map<String, Object> dados) {
        int id = ((Number) dados.get("id")).intValue();
        String dataStr = (String) dados.get("data");
        int periodo = ((Number) dados.get("periodo")).intValue();
        String cpf = (String) dados.get("cpf");
        int codigo = ((Number) dados.get("codigo")).intValue();

        Cliente cliente = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                cliente = c;
                break;
            }
        }

        Jogo jogo = null;
        for (Jogo j : jogos) {
            if (j.getCodigo() == codigo) {
                jogo = j;
                break;
            }
        }

        java.util.Date data = java.sql.Date.valueOf(dataStr);
        Contrato novoContrato = new Contrato(id, periodo, data, jogo, cliente);
        contratos.add(novoContrato);
        return true;
    }

    @PostMapping("/cadastro/caduso")
    public boolean cadastrarUso(@RequestBody Uso uso) {

        for (Uso u : usos) {
            if (u.getNumero() == uso.getNumero()) {
                return false;
            }
        }
        usos.add(uso);

        return true;
    }

    @GetMapping("/consultatotalcontrato/{id}")
public double consultarTotalContrato(@PathVariable int id) {

    Contrato contrato = null;
    Uso uso = null;
    Jogo jogo = null;
    Categoria categoria = null;
    int minutosJogados;
    double total;

    for (Contrato c : contratos) {
        if (c.getId() == id) {
            contrato = c;
            break;
        }
    }

    if (contrato == null) {
        return -1;
    }

    for (Uso u : usos) {
        if (u.getNumero() == id) {
            uso = u;
            break;
        }
    }
    if (contrato.getJogo() == null) {
        return -1;
    }

    jogo = contrato.getJogo();
    categoria = jogo.getCategoria();

    if (uso == null || jogo == null || categoria == null) {
        return -1;
    }

    minutosJogados = uso.getHorarioFim() - uso.getHorarioInicio();

    total = categoria.getValorMininmo() + (minutosJogados * jogo.getValorMinuto());

    return total;
}

@GetMapping("/consultatotalcliente/{cpf}")
public double consultarTotalCliente(
        @PathVariable String cpf) {

    Cliente cliente = null;

    for (Cliente c : clientes) {
        if (c.getCpf().equals(cpf)) {
            cliente = c;
            break;
        }
    }

    if (cliente == null) {
        return -1;
    }

    return cliente.calcularTotalCobranca(contratos, usos, jogos, categorias);
}
}