/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.dao;

import br.edu.unirg.vendafx.bean.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class ClienteDAO extends ConexaoDB {

    public void saveOrUpdate(Cliente obj) {
        String sql = "insert into clientes set idcliente=?, nome=?, cpf=?, telefone=? "
                + "ON DUPLICATE KEY UPDATE nome=?, cpf=?, telefone=?";
        open();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setObject(1, obj.getIdCliente());
            stm.setString(2, obj.getNome());
            stm.setString(3, obj.getCpf());
            stm.setString(4, obj.getTelefone());
            stm.setString(5, obj.getNome());
            stm.setString(6, obj.getCpf());
            stm.setString(7, obj.getTelefone());
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERRO SaveOrUpdate ClienteDAO: " + ex.getMessage());
        } finally {
            close();
        }
    }

    public void delete(int id) {
        String sql = "delete from clientes where idcliente = ?";
        open();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ERRO SaveOrUpdate ClienteDAO: " + ex.getMessage());
        } finally {
            close();
        }
    }
    public List<Cliente> listAll() {
        List<Cliente> listagem = new ArrayList<>();
        String sql = "select * from clientes";
        open();
        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                Cliente obj = new Cliente();
                obj.setIdCliente(rs.getInt("idcliente"));
                obj.setNome(rs.getString("nome"));
                obj.setCpf(rs.getString("cpf"));
                obj.setTelefone(rs.getString("telefone"));
                
                listagem.add(obj);
            }
        } catch (SQLException ex) {
            System.out.println("ERRO SaveOrUpdate ClienteDAO: " + ex.getMessage());
        } finally {
            close();
        }
        
        return listagem;
    }
}
