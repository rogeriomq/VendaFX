/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.cliente;

import br.edu.unirg.vendafx.bean.Cliente;
import br.edu.unirg.vendafx.cliente.clienteedit.ClienteeditView;
import br.edu.unirg.vendafx.dao.ClienteDAO;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

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
    @FXML
    private TextField textFieldFiltro;
    @FXML
    private Button btAdd;
    @FXML
    private Button btEdit;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setupTable();
        loadClientes("");
    }

    private void setupTable() {
        tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tcCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tcCpf.setCellFactory(call -> {
            return new TableCell<Cliente, String>() {
                @Override
                protected void updateItem(String cpf, boolean empty) {
                    super.updateItem(cpf, empty);
                    if (cpf == null || cpf.isEmpty()) {
                        setText("-");
                    } else {
                        setText("CPF: " + cpf);
                    }
                    setAlignment(Pos.CENTER);
                }
            };
        });
        tcTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
//        tcTelefone.setCellFactory((TableColumn<Cliente, String> param) -> {
//            
//        });

    }

    private void loadClientes(String filter) {
        ClienteDAO dao = new ClienteDAO();
        tableViewCliente.getItems().clear();
        tableViewCliente.getItems().addAll(dao.listAll(filter));
    }

    @FXML
    private void filtrarCliente(ActionEvent event) {
        String filtro = textFieldFiltro.getText();
        loadClientes(filtro);
    }

    @FXML
    private void abrirClienteEdit(ActionEvent event) {
        ClienteeditView viewClienteEdit = new ClienteeditView();
        Stage st = new Stage();
        st.setScene(new Scene(viewClienteEdit.getView()));
        //Quando for novo, só dar o show no stage pois
        // a tela está limpa. Nova instancia.
        if (event.getSource() == btAdd) {
            System.out.println("NOVO CLIENTE");
            st.setTitle("Novo Cliente");
            st.showAndWait();
            filtrarCliente(null);
        } else //No caso de ser edicao, verificar obj selecionado
        // e carregar os dados do cliente na tela de novo/edit cliente.
        {
            if (event.getSource() == btEdit) {
                Cliente clienteEdit = tableViewCliente.getSelectionModel().getSelectedItem();
                if (clienteEdit != null) {
                    st.setTitle("Editar Cliente");
                    System.out.println("EDIT CLIENTE");
                    viewClienteEdit.getRealPresenter().carregarClienteEdit(clienteEdit);
                    st.showAndWait();
                    filtrarCliente(null);
                }
            }
        }
    }

    @FXML
    private void deleteCliente(ActionEvent event) {
        Cliente clienteRemove = tableViewCliente.getSelectionModel().getSelectedItem();
        if (clienteRemove != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Remover Cliente");
            alert.setHeaderText("Deseja realmente deletar o cliente?");
            alert.setContentText("Todos os registros vinculados a esse cliente \n"
                    + "serão apagados automaticamente.");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get() == ButtonType.OK) {
                ClienteDAO clienteDao = new ClienteDAO();
                clienteDao.delete(clienteRemove.getIdCliente());
                filtrarCliente(null);
            }
        }
    }
}
