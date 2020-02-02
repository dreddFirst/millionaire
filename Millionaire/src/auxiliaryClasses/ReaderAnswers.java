/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auxiliaryClasses;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author treba
 */
public class ReaderAnswers {
    private int numberStage;
    private static String question;
    private static String answer1;
    private static String answer2;
    private static String answer3;
    private static String answer4;
    
    public void readAnswers(int numberQuestion){
        readXMLAnswers(numberQuestion,getNumberStage());
    }
    
    private void readXMLAnswers(int qa, int nfq){
        try{
            File file = new File("src/answers/a"+nfq+".xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            
            document.getDocumentElement().normalize();
            
            NodeList nodeList = document.getElementsByTagName("questions");
            
            Node a = nodeList.item(0);
            
            if (Node.ELEMENT_NODE == a.getNodeType()){ 
                Element ea = (Element) a;
             
                setAnswer1(ea.getElementsByTagName("a"+qa+"_1").item(0).getTextContent());
                setAnswer2(ea.getElementsByTagName("a"+qa+"_2").item(0).getTextContent());
                setAnswer3(ea.getElementsByTagName("a"+qa+"_3").item(0).getTextContent());
                setAnswer4(ea.getElementsByTagName("a"+qa+"_4").item(0).getTextContent());
            }
            }catch(Exception e){
            
        }
    }

    public int getNumberStage() {
        return numberStage;
    }

    public void setNumberStage(int numberStage) {
        this.numberStage = numberStage;
    }

    public static String getAnswer1() {
        return answer1;
    }

    public static void setAnswer1(String answer1) {
        ReaderAnswers.answer1 = answer1;
    }

    public static String getAnswer2() {
        return answer2;
    }

    public static void setAnswer2(String answer2) {
        ReaderAnswers.answer2 = answer2;
    }

    public static String getAnswer3() {
        return answer3;
    }

    public static void setAnswer3(String answer3) {
        ReaderAnswers.answer3 = answer3;
    }

    public static String getAnswer4() {
        return answer4;
    }

    public static void setAnswer4(String answer4) {
        ReaderAnswers.answer4 = answer4;
    }
}
