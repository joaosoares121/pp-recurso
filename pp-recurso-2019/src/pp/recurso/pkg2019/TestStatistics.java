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
    
    //NOVO
    
    
    @Override
    public double meanTimePerAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double standardDeviationTimePerAnsewer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double correctAnswerPecentage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double incorrectAnswerPecentage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int correctAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int incorrectAnswer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IQuestion[] incorrectAnswers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IQuestion[] correctAnswers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
