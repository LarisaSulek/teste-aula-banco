/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.util.List;

/**
 *
 * @author Familia
 */
public class TestaLista {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();
        
        List<Contato> contatos = dao.getLista();
        
        for(Contato contato : contatos) {
            System.out.println("nome: " + contato.getNome());
            System.out.println("email: " + contato.getEmail());
            System.out.println("endereco: " + contato.getEndereco());
            System.out.println("data de nascimento: " + contato.getDataNascimento().getTime() + "\n");
            
        }
    }
}
