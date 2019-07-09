/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.util.Calendar;

/**
 *
 * @author Familia
 */
public class TesteInsere {
    public static void main(String[] args) {
        Contato contato = new Contato();
        
        contato.setNome("juju");
        contato.setEmail("juju@gmail.com");
        contato.setEndereco("rua 1 casa 10 jujulandia");
        contato.setDataNascimento(Calendar.getInstance());
        
        ContatoDAO dao = new ContatoDAO();
        
        dao.adiciona(contato);
        System.out.println("GRAVADO!");
    }
}
