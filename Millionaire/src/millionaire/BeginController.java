/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millionaire;


import auxiliaryClasses.ReaderQuestions;
import java.awt.MenuItem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import auxiliaryClasses.Random;
import auxiliaryClasses.ReaderAnswers;
import javafx.scene.control.Alert;
import javafx.scene.layout.Background;

/**
 * FXML Controller class
 *
 * @author treba
 */
public class BeginController implements Initializable {
    
    @FXML
    private Button helpPhone;
    @FXML
    private Button helpFF;    
    @FXML
    private Button helpHall;
    @FXML
    private Button answer1b;
    @FXML
    private Button answer2b;
    @FXML
    private Button answer3b;
    @FXML
    private Button answer4b;
    
    @FXML
    private Label question;
    @FXML
    private Label answer1;
    @FXML
    private Label answer2;
    @FXML
    private Label answer3;
    @FXML
    private Label answer4;
    
    @FXML
    private Label namePlayer;
    @FXML
    private MenuBar menuBar;
    
    @FXML
    private MenuItem nameUs;
    
    private static int win = 0;
    private static int count = 1;
    private static String answerOriginal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readQA(count);
    }  
    
    @FXML
    public void onClickExit(){
        System.exit(0);
    }
    
    @FXML
    public void onClickInterName(){
        try{
            Stage user = new Stage();
            openUser(user);
        }
        catch(Exception e){
            
        }
    }
    
    public void setLabelName(String name){
        namePlayer.setText(name);
    }
    
 
    private void openUser(Stage user) throws IOException{
        win = 0;
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        Scene scene = new Scene(root);
        user.setScene(scene);
        user.setTitle("Новая игра");
        user.show();
            
        closeBegin();
        
    }
    
    private void closeBegin(){
        Stage stage = (Stage) menuBar.getScene().getWindow();
        stage.close();
    }    
    
    private void readQA(int i){
        
        
            ReaderQuestions rq = new ReaderQuestions();
            ReaderAnswers ra = new ReaderAnswers();
            
            
            int numberQuestion = Random.random();
            rq.setNumberStage(i);
            rq.readQuestion(numberQuestion);
            answerOriginal = rq.getAnswer();
            question.setText(rq.getQuestion());
        
               
            ra.setNumberStage(i);
            ra.readAnswers(numberQuestion);
            answer1.setText(ReaderAnswers.getAnswer1());
            answer2.setText(ReaderAnswers.getAnswer2());
            answer3.setText(ReaderAnswers.getAnswer3());
            answer4.setText(ReaderAnswers.getAnswer4());
    }
    
    private void getAlert(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Внимание!!!");
            alert.setHeaderText(null);
            alert.setContentText("Ваш выигрыш равен "+win+" леям");
            alert.showAndWait();
    }
    
    @FXML
    public void corectAnswer1(){
        
        if(answer1.getText().equals(answerOriginal)){
            win += 100;
            System.out.println(answer1.getText()+" "+ answerOriginal);
            getAlert();
            count++;
            readQA(count);
        }
        else{
            onClickInterName();
        }
        
    }
    
    @FXML
    public void corectAnswer2(){
        
        if(answer2.getText().equals(answerOriginal)){
            win += 100;
            System.out.println(answer1.getText()+" "+ answerOriginal);
            getAlert();
            count++;
            readQA(count);
        }
        else{
            onClickInterName();
        }
    }
    
    @FXML
    public void corectAnswer3(){
        if(answer3.getText().equals(answerOriginal)){
            win += 100;
            System.out.println(answer1.getText()+" "+ answerOriginal);
            getAlert();
            count++;
            readQA(count);
        }
        else{
            onClickInterName();
        }
    }
    
    @FXML
    public void corectAnswer4(){
        if(answer4.getText().equals(answerOriginal)){
            win += 100;
            System.out.println(answer1.getText()+" "+ answerOriginal);
            getAlert();
            count++;
            readQA(count);
        }
        else{
            onClickInterName();
        }
    }
        
}
