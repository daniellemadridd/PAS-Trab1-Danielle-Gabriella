package br.pucrs.daniellemadrid.demo;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/acmespiele")
public class Controller{
     private List<Cliente> clientes;

    public Controller(){
   clientes = new ArrayList<>(List.of(
                new Cliente("838737473", "Maria", "maria@gmail.com", "usermaria", "password", java.sql.Date.valueOf("2000-09-11")),
                new Cliente("234456778", "Geovana", "geo@gmail.com", "usergeo", "password", java.sql.Date.valueOf("1992-12-23")),
                new Cliente("09837626", "Alice", "Alice@gmail.com", "userAli", "password", java.sql.Date.valueOf("2010-04-02"))));
            }

 @GetMapping("/listaclientes")
    public List<Cliente> getListaClientes() {
        return clientes;
    }
}