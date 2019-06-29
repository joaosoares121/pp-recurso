/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import interfaces.controller.IScoreStrategy;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author joaosoares
 */
public class Test implements interfaces.controller.ITest {

    private QuestionMultipleChoice[] questionMultipleChoice;
    private QuestionNumeric[] questionNumeric;
    private QuestionYesNo[] questionYesNo;
    private Question q;
    
    private QuestionMetadata questionMetadata;
    
    QuestionYesNo yesnos[] = new QuestionYesNo[5];
    
    
   // Test t = new Test();
    
    
    @Override
    public boolean addQuestion(IQuestion iq) throws TestException {
    return true;
    }

    @Override
    public IQuestion getQuestion(int i) throws TestException {
        return q;
    }

    @Override
    public boolean removeQuestion(int i) {
        return true;
    }

    @Override
    public boolean removeQuestion(IQuestion iq) {

        return true;
    }

    @Override
    public int numberQuestions() {
         return 3;
    }

    @Override
    public boolean isComplete() {
        return true;
    }

    @Override
    public ITestStatistics getTestStatistics() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadFromJSONFile(String string) throws TestException {

        //Pessoa pessoas[] = new Pessoa[2];
        QuestionMultipleChoice questions[] = new QuestionMultipleChoice[2];

        //String path = "C:\\Users\\Tiago Pinto\\Documents\\NetBeansProjects\\Trabalho_PP_RECURSO_2019\\pp-recurso\\pp-recurso-2019\\src\\data\\teste_A.json";
        String path = "/Users/joaosoares/NetBeansProjects/pp-recurso/pp-recurso-2019/src/data/teste_A.json";

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(path));

            JsonStreamParser p = new JsonStreamParser(reader);

            JsonArray arr = (JsonArray) p.next();
            int arr_size = arr.size();

            for (int i = 0; i < arr_size; i++) {
                JsonElement arrayElement = arr.get(i);
                JsonObject obj = arrayElement.getAsJsonObject();

                if (obj.has("type") && obj.has("question")) {

                    String temp_type = obj.get("type").getAsString();

                    JsonObject temp_question = obj.get("question").getAsJsonObject();

                    System.out.println("type: " + temp_type);

                    if ("MultipleChoice".equals(temp_type)) {

                        if (temp_question.has("title") && temp_question.has("score") && temp_question.has("mark") && temp_question.has("question_description")) {

                            String temp_title = temp_question.get("title").getAsString();

                            
                            
                            System.out.println("title: " + temp_title);

                            String temp_score = temp_question.get("score").getAsString();

                            System.out.println("score: " + temp_score);

                            String temp_mark = temp_question.get("mark").getAsString();

                            System.out.println("mark: " + temp_mark);

                            String temp_question_description = temp_question.get("question_description").getAsString();

                            System.out.println("question_description: " + temp_question_description);

                            
                            
                            
                            
                            
                            //Le array options
                            JsonArray arrOptions = temp_question.getAsJsonArray("options"); 
                                
                            for (int j = 0; j < arrOptions.size(); j++) {
                                
                                System.out.println(arrOptions.get(j).getAsString());
                                
                            
                            }
                            
                           
                             

                            String temp_correct_answer = temp_question.get("correct_answer").getAsString();

                            System.out.println("correct_answer: " + temp_correct_answer);
                            
                            System.out.println("--------------//////////-----------");

                        }
                    }
                    
                    
                 

                    if ("YesNo".equals(temp_type)) {

                        if (temp_question.has("title") && temp_question.has("score") && temp_question.has("mark") && temp_question.has("question_description")) {

                            String temp_title = temp_question.get("title").getAsString();

                            System.out.println("title: " + temp_title);

                            String temp_score = temp_question.get("score").getAsString();

                            System.out.println("score: " + temp_score);

                            String temp_mark = temp_question.get("mark").getAsString();

                            System.out.println("mark: " + temp_mark);

                            String temp_question_description = temp_question.get("question_description").getAsString();

                            System.out.println("question_description: " + temp_question_description);

                            

                            String temp_correct_answer = temp_question.get("correct_answer").getAsString();

                            System.out.println("correct_answer: " + temp_correct_answer);
                            
                           //t.addQuestion();
                            
                            yesnos[i] = new QuestionYesNo(temp_correct_answer,  temp_title, temp_question_description, questionMetadata, true, temp_correct_answer, true, i);
                            
                            System.out.println("ToString: " +yesnos[i].toString());
                            
                             System.out.println("--------------//////////-----------");
                        }
                    }
                    
                    if ("Numeric".equals(temp_type)) {

                        if (temp_question.has("title") && temp_question.has("score") && temp_question.has("mark") && temp_question.has("question_description")) {

                            String temp_title = temp_question.get("title").getAsString();

                            System.out.println("title: " + temp_title);

                            String temp_score = temp_question.get("score").getAsString();

                            System.out.println("score: " + temp_score);

                            String temp_mark = temp_question.get("mark").getAsString();

                            System.out.println("mark: " + temp_mark);

                            String temp_question_description = temp_question.get("question_description").getAsString();

                            System.out.println("question_description: " + temp_question_description);

                            

                            String temp_correct_answer = temp_question.get("correct_answer").getAsString();

                            System.out.println("correct_answer: " + temp_correct_answer);
                            
                            System.out.println("--------------//////////-----------");

                        }
                    }
                
            
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    

                }

            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return true;
    }

    @Override
    public void setScoreStrategy(IScoreStrategy iss) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IScoreStrategy getScoreStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String calculateScore() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveTestResults() throws TestException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
