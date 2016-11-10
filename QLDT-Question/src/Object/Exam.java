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
public class Exam implements Serializable{
    private String nameExam;
    private String createday;
    private ArrayList<MultipleChoice> multipleChoices = new ArrayList<>();
    private ArrayList<Essay> essays = new ArrayList<>();

    public String getNameExam() {
        return nameExam;
    }

    public String getCreateday() {
        return createday;
    }

    public ArrayList<MultipleChoice> getMultipleChoices() {
        return multipleChoices;
    }
    
    public MultipleChoice getMultipleChoice(int i) {
        return multipleChoices.get(i);
    }

    public ArrayList<Essay> getEssays() {
        return essays;
    }
    
    public Essay getEssay(int i) {
        return this.essays.get(i);
    }

    public void setNameExam(String nameExam) {
        this.nameExam = nameExam;
    }

    public void setCreateday(String createday) {
        this.createday = createday;
    }

    public void setMultipleChoices(ArrayList<MultipleChoice> multipleChoices) {
        this.multipleChoices = multipleChoices;
    }
    
    public void setMultipleChoice(int i, MultipleChoice multipleChoice) {
        this.multipleChoices.set(i, multipleChoice);
    }
    
    public void setEssays(ArrayList<Essay> essays) {
        this.essays = essays;
    }
    
    public void setEssay(int i, Essay essay) {
        this.essays.set(i, essay);
    }

    public void removeMultipleChoice(int i) {
        this.multipleChoices.remove(i);
    }

    public void removeEssay(int i) {
        this.essays.remove(i);
    }
    
    
}
