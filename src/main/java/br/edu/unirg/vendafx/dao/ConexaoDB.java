package br.edu.unirg.vendafx.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class ConexaoDB {
    //jdbc:mariadb://127.0.0.1:0/vendafxdb?useUnicode=true&characterEncoding=UTF-8&useServerPrepStmts=true&useCursorFetch=true&zeroDateTimeBehavior=convertToNull
    private final String URL = "jdbc:mariadb://127.0.0.1:3306/";
    private final String DATABASE = "vendafxdb";
    private final String DRIVER = "org.mariadb.jdbc.Driver";
    private final String USERNAME = "root";
    private final String PASSWORD = "";
    
    public Connection conexao;
    public Statement stm;
    
    public void open() {
        conexao = null;
        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL + DATABASE, USERNAME, PASSWORD);
            stm = conexao.createStatement();
        } catch(SQLException | ClassNotFoundException ex) {
            System.err.println("ERRO AO CONECTAR: " + ex);
        }
    }
    
    public void close() {
        if(conexao !=null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                System.out.println("Erro ao fechar a conexão com o banco de dados: " + ex);
            }
        }
    }
}
