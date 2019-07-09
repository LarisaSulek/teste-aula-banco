/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Familia
 */
public class ContatoDAO {
    private Connection connection;
    
    public ContatoDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }
    // metodo adicao
    public void adiciona (Contato contato) {
        String sql = "insert into contatos" + 
                "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getEndereco());
            stmt.setDate(4, new Date (contato.getDataNascimento().getTimeInMillis()));
            
            stmt.execute();
            stmt.close();
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
           
    }
    // metodo listagem
    public List<Contato> getLista() {
     try{   
        List<Contato> contatos = new ArrayList<Contato>();
        PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            //criando o objeto
            Contato contato = new Contato();
            contato.setId(rs.getLong("id"));
            contato.setNome(rs.getString("nome"));
            contato.setEmail(rs.getString("email"));
            contato.setEndereco(rs.getString("endereco"));
            
            //montando a data atraves do Calendar
            Calendar data = Calendar.getInstance();
            data.setTime(rs.getDate("dataNascimento"));
            contato.setDataNascimento(data);
            
            //adiciona objeto a lista
            contatos.add(contato);
        }
        rs.close();
        stmt.close();
        return contatos;
     } catch (SQLException e) {
         throw new RuntimeException(e);
     } 
    }
    
    //metodo alterar
    public void altera(Contato contato) throws SQLException {
        String sql = "update contatos set nome=?, email=?,"
                + " endereco=?,dataNascimento=? where id=?";
        try {
        PreparedStatement  stmt = connection.prepareStatement(sql);
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getEndereco());
        stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
        stmt.setLong(5, contato.getId());
        } catch (SQLException e) {
                throw new RuntimeException(e);
                }
    }
    
    //metodo para remover
    public void remove(Contato contato) {
    try {
     PreparedStatement stmt = connection.prepareStatement("delete from contato where id=?");
        
     stmt.setLong(1, contato.getId());
     stmt.execute();
     stmt.close();
     } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    
   
}
}
