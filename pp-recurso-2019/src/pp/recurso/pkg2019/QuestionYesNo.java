/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

/**
 *
 * @author joaosoares
 */
public class QuestionYesNo extends Question implements interfaces.models.IQuestionYesNo{

    
    private String correctAnswer;
    private String userAnswer;
    
    @Override
    public String getCorrect_answer() {
        return correctAnswer;
    }

    @Override
    public void setCorrect_answer(String string) {
        
        this.correctAnswer = string;
        
    }

    @Override
    public String getUser_answer() {
        return userAnswer;
        
    }

    @Override
    public void setUser_answer(String string) {
        this.userAnswer = string;
    }
    
}
