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
public class QuestionMetadata implements interfaces.models.IQuestionMetadata{

    private long start,finish;
    
    
    @Override
    public long getTimestamp_start() {
        
        return start;
        
    }

    @Override
    public void setTimestamp_start(long l) {
        this.start = l;
    }

    @Override
    public long getTimestamp_finish() {
        return finish;
    }

    @Override
    public void setTimestamp_finish(long l) {
        this.finish = l;
    }
    
}
