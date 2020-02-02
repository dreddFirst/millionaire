/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliaryClasses;


import java.io.File;
import org.w3c.dom.*;
import javax.xml.parsers.*;




/**
 *
 * @author treba
 */
public class ReaderQuestions {
    
    private static int numberStage;
    private static String question;
    private static String answer;

    public String getQuestion() {
        return this.question;
    }

    public  void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    

    public void setNumberStage(int numberStage) {
        this.numberStage = numberStage;
    }

    public int getNumberStage() {
        return this.numberStage;
    }
    
    public void readQuestion(int numberQuestion){
        readXMLQuestions(numberQuestion,getNumberStage());
    }
    
    private void readXMLQuestions(int qa, int nfq){
        try{
            File file = new File("src/questions/q"+nfq+".xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            document.getDocumentElement().normalize();
            
            NodeList nodeList = document.getElementsByTagName("questions");
            
            Node q = nodeList.item(0); 
            Node a = nodeList.item(0);
            
            if (Node.ELEMENT_NODE == q.getNodeType()) { 
                Element eq = (Element) q;
             
                setQuestion(eq.getElementsByTagName("q"+qa).item(0).getTextContent());
            }
            
            if (Node.ELEMENT_NODE == a.getNodeType()) { 
                Element ea = (Element) a;
             
                setAnswer(ea.getElementsByTagName("a"+qa).item(0).getTextContent());
            }
            }catch(Exception e){
            
        }
    }
    
    
}
