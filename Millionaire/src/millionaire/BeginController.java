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
    private String answerOriginal;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readQA(1);
    }  
    
    @FXML
    public void onClickExit(){
        System.exit(0);
    }
    
    @FXML
    public void onClickInterName() throws IOException{
     Stage user = new Stage();
     openUser(user);
    }
    
    public void setLabelName(String name){
        namePlayer.setText(name);
    }
    
 
    private void openUser(Stage user) throws IOException{
        
        Parent root = FXMLLoader.load(getClass().getResource("User.fxml"));
        Scene scene = new Scene(root);
        user.setScene(scene);
        user.setTitle("Ввод имени");
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
            
            answerOriginal = rq.getAnswer();
            int numberQuestion = Random.random();
            rq.setNumberStage(i);
            rq.readQuestion(numberQuestion);
            question.setText(rq.getQuestion());
        
               
            ra.setNumberStage(i);
            ra.readAnswers(numberQuestion);
            answer1.setText(ReaderAnswers.getAnswer1());
            answer2.setText(ReaderAnswers.getAnswer2());
            answer3.setText(ReaderAnswers.getAnswer3());
            answer4.setText(ReaderAnswers.getAnswer4());
            
            if(corectAnswer1().equals(answerOriginal)){
                answer1.setText(answer1.getText()+666);
            }
//            else if(corectAnswer2().equals(answerOriginal)){
//                win += 100;
//                System.out.println(win);
//            }else if(corectAnswer3().equals(answerOriginal)){
//                win += 100;
//                System.out.println(win);
//            }else if(corectAnswer4().equals(answerOriginal)){
//                win += 100;
//                System.out.println(win);
//            }
            
            
        
    }
    
    @FXML
    public String corectAnswer1(){
        return answer1.getText();
    }
    
    @FXML
    public String corectAnswer2(){
        return answer2.getText();
    }
    
    @FXML
    public String corectAnswer3(){
        return answer3.getText();
    }
    
    @FXML
    public String corectAnswer4(){
        return answer4.getText();
    }
        
}
