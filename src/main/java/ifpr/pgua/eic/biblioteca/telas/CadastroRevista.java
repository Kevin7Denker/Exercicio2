package ifpr.pgua.eic.biblioteca.telas;

import ifpr.pgua.eic.biblioteca.repositorios.Biblioteca;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroRevista{
    
    private Biblioteca biblioteca;

    public CadastroRevista(Biblioteca biblioteca){
        this.biblioteca = biblioteca;
    }

    @FXML
    private TextField tfTitulo;

    @FXML
    private TextField tfEditora;
    
    @FXML
    private TextField tfAnoPublicacao;

    @FXML
    private TextField tfNumeroPaginas;

    @FXML
    private TextField tfNumero;
    
    

    @FXML
    private void cadastrar(){
      String titulo = tfTitulo.getText();
      String editora = tfEditora.getText();
      int anoPublicacao= Integer.valueOf(tfAnoPublicacao.getText()); 
      int numeroPaginas = Integer.valueOf(tfNumeroPaginas.getText());
      int numero = Integer.valueOf(tfNumero.getText());
      String msg = "";
       
      boolean ret = biblioteca.cadastraRevista(titulo,numero,anoPublicacao,numeroPaginas, editora);
      
      if(ret){
           msg = "Revista cadastrada!!!!!";
           limpar();
        } else {
           msg = "Erro no cadastro!!!!!!";
      }
    
      Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
      alert.showAndWait();
    
     
    }

    
    @FXML
    private void limpar(){
        tfTitulo.setText("");
        tfEditora.setText("");
        tfAnoPublicacao.setText(""); 
        tfNumeroPaginas.setText("");
        tfNumero.setText(""); 
       
    }

}