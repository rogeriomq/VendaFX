/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.cliente;

import br.edu.unirg.vendafx.bean.Cliente;
import br.edu.unirg.vendafx.dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

/**
 *
 * @author rogerio
 */
public class ClientePresenter implements Initializable {

    @FXML
    private TableView<Cliente> tableViewCliente;
    @FXML
    private TableColumn<Cliente, String> tcNome;
    @FXML
    private TableColumn<Cliente, String> tcCpf;
    @FXML
    private TableColumn<Cliente, String> tcTelefone;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTable();
        loadClientes();
    }

    private void setupTable() {
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
//        tcTelefone.setCellFactory((TableColumn<Cliente, String> param) -> {
//            
//        });
        
    }
    private void loadClientes() {
        ClienteDAO dao = new ClienteDAO();
        tableViewCliente.getItems().clear();
        tableViewCliente.getItems().addAll(dao.listAll());
    }
    
}
