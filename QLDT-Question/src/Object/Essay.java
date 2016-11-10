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
public class Essay extends Question implements Serializable{
    private String suggest;

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }
}
