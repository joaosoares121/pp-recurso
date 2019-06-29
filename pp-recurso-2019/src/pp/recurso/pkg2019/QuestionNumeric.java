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
public class QuestionNumeric extends Question implements interfaces.models.IQuestionNumeric{

    private double correctAnswer;
    private double userAnswer;

    public QuestionNumeric(double correctAnswer, double userAnswer, String title, String description, QuestionMetadata metadata, boolean done, String answer, boolean evaluationAnswer, float mark) {
        super(title, description, metadata, done, answer, evaluationAnswer, mark);
        this.correctAnswer = correctAnswer;
        this.userAnswer = userAnswer;
    }
    
    
    @Override
    public double getCorrect_anwser() {
        return correctAnswer;
    }

    @Override
    public void setCorrect_anwser(double d) {
        this.correctAnswer = d;
    }

    @Override
    public double getUser_answer() {
        return userAnswer;
    }

    @Override
    public void setUser_answer(double d) {
        this.userAnswer = d;
    }
    
}
