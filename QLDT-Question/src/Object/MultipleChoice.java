/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Duc Dung Dan
 */
public class MultipleChoice extends Question implements Serializable{
    private ArrayList<Answer> answers = new ArrayList<>();

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
    
    public Answer getAnswer(int i) {
        return answers.get(i);
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    
    public void setAnswer(Answer answer) {
        this.answers.add(answer);
    }
    
    public void removeAns(int i) {
        this.answers.remove(i);
    }
    
    public void updateAnswer(int i, Answer answer) {
        this.answers.set(i, answer);
    }
}
