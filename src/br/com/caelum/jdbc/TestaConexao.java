/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Familia
 */
public class TestaConexao {
    public static void main(String[] args) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        System.out.println("conexao aberta");
        connection.close();
    }
}
