/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.cliente.clienteedit;

import br.edu.unirg.vendafx.bean.Cliente;
import br.edu.unirg.vendafx.dao.ClienteDAO;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 *
 * @author rogerio
 */
public class ClienteeditPresenter implements 
        Initializable {

    @FXML
    private TextField textFieldNome;
    @FXML
    private TextField textFieldCpf;
    @FXML
    private TextField textFieldTelefone;
    
    private Integer cdCliente;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    private boolean valida() {
        if(textFieldNome.getText().trim().isEmpty()) {
            System.out.println("Nome nao pode ser vazio.");
            return false;
        }
        return true;
    }
    @FXML
    private void salvarCliente(ActionEvent event) {
        if(valida()) {
            Cliente cliente = new Cliente();
            cliente.setNome(textFieldNome.getText());
            cliente.setCpf(textFieldCpf.getText());
            cliente.setTelefone(textFieldTelefone.getText());
            //aqui que define se vai ser inserido novo Registro ou Atualizado
            //um com cdCliente existente
            if(cdCliente != null) {
                cliente.setIdCliente(cdCliente);
            }
            //Mandar pro banco na funcao que já faz os dois(insere ou atualiza)
            ClienteDAO dao = new ClienteDAO();
            dao.saveOrUpdate(cliente);
            textFieldNome.getScene().getWindow().hide();
        }
        
        
    }
    
    public void carregarClienteEdit(Cliente cliente) {
        cdCliente = cliente.getIdCliente();
        textFieldNome.setText(cliente.getNome());
        textFieldCpf.setText(cliente.getCpf());
        textFieldTelefone.setText(cliente.getTelefone());
    }
    
}
