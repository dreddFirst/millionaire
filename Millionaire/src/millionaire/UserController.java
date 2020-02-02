/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millionaire;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author treba
 */
public class UserController extends BeginController implements Initializable {

    @FXML
    private TextField NameUser;
    
    @FXML
    private Button RegUser;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    } 
    
    @FXML
    public void onClickUserReg() throws IOException{
        if(NameUser.getText().equals("")){
            getAlert();
        }else{
            getNamePlayer();
        }
            
    }
    
    private void getAlert(){
        Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Внимание!!!");
            alert.setHeaderText(null);
            alert.setContentText("Вы не ввели имя игрока!!!");
            alert.showAndWait();
    }
    
    private void getNamePlayer(){
        try{
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Millionaire.fxml"));
            
            Parent root = (Parent)loader.load();
            BeginController bc = loader.getController();
            bc.setLabelName(NameUser.getText());
            Stage st = new Stage();
            st.setScene(new Scene(root));
            st.setTitle("Кто хочет стать миллионером?");
            st.show();
            
            Stage stage = (Stage) RegUser.getScene().getWindow();
            stage.close();
            
            }
            catch(Exception e){
                
            }
    }
    
}
