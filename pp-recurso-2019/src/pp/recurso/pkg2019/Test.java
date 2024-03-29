/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import collections.ClassificationManager;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonStreamParser;
import interfaces.controller.IScoreStrategy;
import interfaces.controller.ITestStatistics;
import interfaces.exceptions.TestException;
import interfaces.models.IQuestion;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import jdk.nashorn.internal.runtime.options.Options;

/**
 *
 * @author joaosoares
 */
public class Test implements interfaces.controller.ITest {

    private QuestionMultipleChoice[] questionMultipleChoice;
    private QuestionNumeric[] questionNumeric;
    private QuestionYesNo[] questionYesNo;
    private Question q;

    private ClassificationManager cm;

    private QuestionMetadata questionMetadata;

    QuestionYesNo yesnos[] = new QuestionYesNo[5];
    QuestionMultipleChoice qmc[] = new QuestionMultipleChoice[5];
    QuestionNumeric qn[] = new QuestionNumeric[5];
    private String optionsMultiple[];

    
    
    // Test t = new Test();
    @Override
    public boolean addQuestion(IQuestion iq) throws TestException {
        
        
            
        this.cm.addObject(iq);
        
        return true;
    }

    @Override
    public IQuestion getQuestion(int i) throws TestException {
        return q;
    }

    @Override
    public boolean removeQuestion(int i) {
        
        this.cm.removeObject(i);
        
        return true;
    }

    @Override
    public boolean removeQuestion(IQuestion iq) {

        //remove o objeto na posição x
        this.cm.removeObject(0);
        
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
        
        //Falta acabar este Método
        
        return (ITestStatistics) this.cm;
    }

    @Override
    public boolean loadFromJSONFile(String string) throws TestException {

        //Pessoa pessoas[] = new Pessoa[2];
        //QuestionMultipleChoice questions[] = new QuestionMultipleChoice[2];

        String path = "C:\\Users\\Tiago Pinto\\Documents\\NetBeansProjects\\Trabalho_PP_RECURSO_2019\\pp-recurso\\pp-recurso-2019\\src\\data\\teste_A.json";
        //String path = "/Users/joaosoares/NetBeansProjects/pp-recurso/pp-recurso-2019/src/data/teste_A.json";

        BufferedReader reader = null;

        try {
            
            ClassificationManager cmTemp = new ClassificationManager();
            
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
                            this.optionsMultiple = new String[arrOptions.size()];

                            for (int j = 0; j < arrOptions.size(); j++) {

                                System.out.println(arrOptions.get(j).getAsString());
                                this.optionsMultiple[j] = arrOptions.get(j).toString();
                                
                                
                               //String arrOpt[] = arrOptions.get(j).getAsString();
                            }

                            String temp_correct_answer = temp_question.get("correct_answer").getAsString();

                            System.out.println("correct_answer: " + temp_correct_answer);
                            int j = 0;
                            
                            qmc[j] = new QuestionMultipleChoice(optionsMultiple,temp_correct_answer, string, path, string, questionMetadata, true, path, true, i);
                            //cm.addObject(j);
                            
                            System.out.println("--------------//////////-----------");
                            
                            

                        }
                    }

                    //www.guj.com.br/t/o-que-e-instanceof/31561
                    
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

                            
                            //yesnos[i] = new QuestionYesNo(temp_correct_answer, temp_title, temp_question_description, questionMetadata, true, temp_correct_answer, true, i);

                            //System.out.println("ToString: " + yesnos[i].toString());
                            QuestionMetadata qmd = new QuestionMetadata();
                            //System.out.println("" + qmd.getTimestamp_finish());
                            QuestionYesNo qyn = new QuestionYesNo(temp_correct_answer, path, string, questionMetadata, true, path, true, i);
                            
                            System.out.println("Add Question YesNo" + cmTemp.addObject(qyn));
                            System.out.println("Objeto Criado:" + qyn.toString());
                            
                            
                            
                            System.out.println("--------------//////////-----------");
                        }
                    } //não estou a ouvir e diz que o teu tlm está desligado
                    
                    //tenta ligar agr
                    //continua a dar desligado

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
        
        QuestionMetadata qmd = new QuestionMetadata();
        TestStatistics ts = new TestStatistics(1, 2, 1, 1, 3, 4, yesnos, yesnos);
        
        qmd.getTimestamp_start();
        qmd.getTimestamp_finish();
        ts.correctAnswer();
        ts.correctAnswerPecentage();
        ts.correctAnswers();
        ts.getIncorrectAnswerPercentage();
        ts.getIncorrectAnswers();
        ts.getMeanTimePerAnswer();
        ts.getStandardDerivationTimePerAnswear();
        
        
        
        return true;
    }

}
