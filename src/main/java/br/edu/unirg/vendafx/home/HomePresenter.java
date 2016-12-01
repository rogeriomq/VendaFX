/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.unirg.vendafx.home;

import br.edu.unirg.vendafx.cliente.ClienteView;
import br.edu.unirg.vendafx.produto.ProdutoView;
import br.edu.unirg.vendafx.venda.VendaView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Rogério M. de Queiroz <rogerio.mq@gmail.com>
 */
public class HomePresenter implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void openViewProduto(ActionEvent event) {
        ProdutoView produtoView = new ProdutoView();
        Stage st = new Stage();
        st.setTitle("Produto");
        st.setScene(new Scene(produtoView.getView()));
        st.initModality(Modality.APPLICATION_MODAL);
        st.show();
    }

    @FXML
    private void openViewCliente(ActionEvent event) {
        ClienteView clienteView = new ClienteView();
        Stage st = new Stage();
        st.setTitle("Cliente");
        st.setScene(new Scene(clienteView.getView()));
        st.initModality(Modality.APPLICATION_MODAL);
        st.show();
    }

    @FXML
    private void openViewVenda(ActionEvent event) {
        VendaView vendaView = new VendaView();
        Stage st = new Stage();
        st.setTitle("Venda");
        st.setScene(new Scene(vendaView.getView()));
        st.initModality(Modality.APPLICATION_MODAL);
        st.show();
    }

    @FXML
    private void openViewRelatorio(ActionEvent event) {
    }

    @FXML
    private void openView(KeyEvent event) {
        if (null != event.getCode()) {
            switch (event.getCode()) {
                case F1:
                    System.out.println("Abrir Tela de Produto");
                    openViewProduto(null);
                    break;
                case F2:
                    System.out.println("Abrir Tela de Cliente");
                    openViewCliente(null);
                    break;
                case F3:
                    System.out.println("Abrir Tela de Venda");
                    openViewVenda(null);
                    break;
                case F4:
                    System.out.println("Abrir Tela de Relatorio");
                    break;
                default:
                    break;
            }
        }
    }

}
