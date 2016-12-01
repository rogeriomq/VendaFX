package br.edu.unirg.vendafx;

import br.edu.unirg.vendafx.bean.Cliente;
import br.edu.unirg.vendafx.dao.ClienteDAO;
import br.edu.unirg.vendafx.dao.ConexaoDB;
import br.edu.unirg.vendafx.home.HomeView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
//        ConexaoDB conexao = new ConexaoDB();
//        conexao.open();
//        conexao.close();
//        Cliente c = new Cliente();
//        c.setNome("ZEBEDEU");
//        c.setCpf("00591266222");
//        c.setTelefone("63992272369");
//        
        HomeView view = new HomeView();
        stage.setTitle("|..VendaFX..|");
        stage.setScene(new Scene(view.getView()));
        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
