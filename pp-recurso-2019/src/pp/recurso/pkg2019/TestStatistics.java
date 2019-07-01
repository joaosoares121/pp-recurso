/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import interfaces.models.IQuestion;

/**
 *
 * @author joaosoares
 */
public class TestStatistics implements interfaces.controller.ITestStatistics{

    
    private double meanTimePerAnswer;
    private double standardDerivationTimePerAnswear;
    private double correctAnswerPercentage;
    private double incorrectAnswerPercentage;
    private int correctAnswer;
    private int incorrectAnser;
    private Question[] incorrectAnswers;
    private Question[] correctAnswers;

    public TestStatistics(double meanTimePerAnswer, double standardDerivationTimePerAnswear, double correctAnswerPercentage, double incorrectAnswerPercentage, int correctAnswer, int incorrectAnser, Question[] incorrectAnswers, Question[] correctAnswers) {
        this.meanTimePerAnswer = meanTimePerAnswer;
        this.standardDerivationTimePerAnswear = standardDerivationTimePerAnswear;
        this.correctAnswerPercentage = correctAnswerPercentage;
        this.incorrectAnswerPercentage = incorrectAnswerPercentage;
        this.correctAnswer = correctAnswer;
        this.incorrectAnser = incorrectAnser;
        this.incorrectAnswers = incorrectAnswers;
        this.correctAnswers = correctAnswers;
    }

    public double getMeanTimePerAnswer() {
        return meanTimePerAnswer;
    }

    public void setMeanTimePerAnswer(double meanTimePerAnswer) {
        this.meanTimePerAnswer = meanTimePerAnswer;
    }

    public double getStandardDerivationTimePerAnswear() {
        return standardDerivationTimePerAnswear;
    }

    public void setStandardDerivationTimePerAnswear(double standardDerivationTimePerAnswear) {
        this.standardDerivationTimePerAnswear = standardDerivationTimePerAnswear;
    }

    public double getCorrectAnswerPercentage() {
        return correctAnswerPercentage;
    }

    public void setCorrectAnswerPercentage(double correctAnswerPercentage) {
        this.correctAnswerPercentage = correctAnswerPercentage;
    }

    public double getIncorrectAnswerPercentage() {
        return incorrectAnswerPercentage;
    }

    public void setIncorrectAnswerPercentage(double incorrectAnswerPercentage) {
        this.incorrectAnswerPercentage = incorrectAnswerPercentage;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getIncorrectAnser() {
        return incorrectAnser;
    }

    public void setIncorrectAnser(int incorrectAnser) {
        this.incorrectAnser = incorrectAnser;
    }

    public Question[] getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(Question[] incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    public Question[] getCorrectAnswers() {
        return correctAnswers;
    }

    public void setCorrectAnswers(Question[] correctAnswers) {
        this.correctAnswers = correctAnswers;
    }

    public QuestionMetadata getQmd() {
        return qmd;
    }

    public void setQmd(QuestionMetadata qmd) {
        this.qmd = qmd;
    }
    
    
    
    
    QuestionMetadata qmd = new QuestionMetadata();
    Test t = new Test();
    
    @Override
    public double meanTimePerAnswer() {
        double tf = qmd.getTimestamp_finish();
        double ts = qmd.getTimestamp_start();
        
        double qmd_temp = tf - ts;
        
        return qmd_temp;
    }

    @Override
    public double standardDeviationTimePerAnsewer() {
     //Formula ERRADA   
        double deviation = Math.sqrt(meanTimePerAnswer)/t.numberQuestions();
    // sqrt(((1)^2+(2)^2+(4)^2)/3)
    return deviation;
    }

    @Override
    public double correctAnswerPecentage() {
        //respostas corretas+respostas incorretas = temp_total
        //corretas*100 = temp_corretas
        //temp_corretas/temp_total = percentagem
        double temp_total = (this.correctAnswer+this.incorrectAnser);
        temp_total = getCorrectAnswer() * 100;
        double percentagem = getCorrectAnswer()/temp_total;
        return percentagem;
    }

    @Override
    public double incorrectAnswerPecentage() {
        double temp_total = (this.correctAnswer+this.incorrectAnser);
        temp_total = getIncorrectAnser() * 100;
        double percentagem = getIncorrectAnser()/temp_total;
        return percentagem;
        
    }

    @Override
    public int correctAnswer() {
        return getCorrectAnswer();
    }

    @Override
    public int incorrectAnswer() {
        return getIncorrectAnser();
    }

    @Override
    public IQuestion[] incorrectAnswers() {
        return incorrectAnswers;
    }

    @Override
    public IQuestion[] correctAnswers() {
        return correctAnswers;
    }
    
}
