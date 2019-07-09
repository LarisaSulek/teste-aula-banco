/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.SQLException;

/**
 *
 * @author Familia
 */
public class TesteRemove {
    public static void main(String[] args) throws SQLException {
        Contato contato = new Contato();
        ContatoDAO dao = new ContatoDAO();
        
        System.out.println("GRAVADO!");
    }
}
