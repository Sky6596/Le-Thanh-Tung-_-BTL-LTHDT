/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.io.Serializable;

/**
 *
 * @author Duc Dung Dan
 */
public class Question implements Serializable {
    private String contentQuestion;
    private Number level;
    private String chapter ;

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getChapter() {
        return chapter;
    }

    public String getContentQuestion() {
        return contentQuestion;
    }

    public Number getLevel() {
        return level;
    }

    public void setContentQuestion(String contentQuestion) {
        this.contentQuestion = contentQuestion;
    }

    public void setLevel(Number level) {
        this.level = level;
    }
}
