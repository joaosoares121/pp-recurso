/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pp.recurso.pkg2019;

import interfaces.exceptions.QuestionException;
import interfaces.models.IQuestionMetadata;

/**
 *
 * @author joaosoares
 */
public class Question implements interfaces.models.IQuestion{

    private String title;
    private String description;
    private QuestionMetadata metadata;
    private boolean done;
    private String answer;
    private boolean evaluationAnswer;
    private float mark;

    public Question(String title, String description, QuestionMetadata metadata, boolean done, String answer, boolean evaluationAnswer, float mark) {
        this.title = title;
        this.description = description;
        this.metadata = metadata;
        this.done = done;
        this.answer = answer;
        this.evaluationAnswer = evaluationAnswer;
        this.mark = mark;
    }
    
    
    
    
    
    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String string) throws QuestionException {
        this.title = string;
    }

    @Override
    public String getQuestion_description() {
        return description;
    }

    @Override
    public void setQuestion_description(String string) throws QuestionException {
        this.description = string;
    }

    @Override
    public IQuestionMetadata getQuestion_metadata() {
        return metadata;
    }

    @Override
    public void setQuestion_metadata(IQuestionMetadata iqm) {
        this.metadata = (QuestionMetadata) iqm;
        }

    @Override
    public boolean isDone() {
        return done;
    }

    @Override
    public void setDone(boolean bln) {
        
        this.done = bln;
    }
    

    @Override
    public void answer(String string) {
    this.answer = string;
        
        }

    @Override
    public boolean evaluateAnswer() {
        return evaluationAnswer;
        
    }

    @Override
    public void setMark(float f) {
        this.mark = f;
    }

    @Override
    public float getMark() {
        return mark;
    }
    
    
}
