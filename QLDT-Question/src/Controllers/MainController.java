/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Views.Login;
import Models.*;
import Object.Exams;
import Views.Question;
import java.awt.GridLayout;
import javax.swing.JPanel;
import Views.ExamViewing;
/**
 *
 * @author Duc Dung Dan
 */
public class MainController {
    public void startApplication() {
        // View the application's GUI
        Login login = new Login();
        login.setVisible(true);
    }
    
    public static void question(JPanel jpanel) {
        
//        Question question = new Question();
//        jpanel.removeAll();
//        GridLayout girdlayout = new GridLayout();
//        jpanel.setLayout(girdlayout);
//        jpanel.add(question.getJPanelQuestion());
//        jpanel.updateUI();
//        SubjectController.loadTableQuestion(question.tableQuestion);
        
        
        
        ExamViewing examViewing = new ExamViewing();
        jpanel.removeAll();
        GridLayout girdlayout = new GridLayout();
        jpanel.setLayout(girdlayout);
        jpanel.add(examViewing.getJPanelExam());
        jpanel.updateUI();
        ExamController.loadTableExam(examViewing.tableExam);
        
    }
}
