/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.ExamModel;
import Object.Answer;
import Object.Essay;
import Object.Exam;
import Object.Exams;
import Object.MultipleChoice;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TungLe
 */
public class ExamController {
    
    public static Exams exams = new Exams();
    private static DefaultTableModel model;
    
    public static void loadTableExam(JTable table) {
        exams = ExamModel.readExam();
        
        model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        for(int i = 0; i < exams.getExams().size(); ++i) {
            Exam exam = exams.getExam(i);
            model.addRow(new Object[]{i + 1, exam.getNameExam(), exam.getCreateday()});      
        }
    }
    
    public static void showExam(JTable tableExam, JPanel exam) 
    {
        exam.removeAll();
        model = (DefaultTableModel) tableExam.getModel();
        int selectRow = tableExam.getSelectedRow();
        
        if (selectRow != -1) {
            int idExam = (int)model.getValueAt(selectRow, 0) - 1;
            exams = ExamModel.readExam();
            Exam ex = exams.getExam(idExam);
            exam.setLayout(new BorderLayout());
            JPanel pnExam = new JPanel();
            pnExam.setLayout(new GridLayout(ex.getEssays().size() + ex.getMultipleChoices().size() + 5, 1, 0, 0));
            JScrollPane sc = new JScrollPane(pnExam, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            JPanel pnName = new JPanel();
            pnName.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel lblName = new JLabel(ex.getNameExam());
            Font fontName = new Font("arial", Font.BOLD, 20);
            lblName.setFont(fontName);
            pnName.add(lblName);
            pnExam.add(pnName);
            
            
            Font fontPart = new Font("arial", Font.BOLD, 15);
            if(ex.getEssays().size() != 0)
            {
                JLabel lblEs = new JLabel("Tự luận");
                lblEs.setFont(fontPart);
                pnExam.add(lblEs);
            }
            
            int count = 0;
            for (Essay es : ex.getEssays())
            {
                count++;
                JPanel pnEssay = new JPanel();
                pnEssay.setLayout(new BoxLayout(pnEssay, BoxLayout.Y_AXIS));
                JPanel pnQuestion = generateSentence("Câu " + count + ": ", es.getContentQuestion());
                JPanel pnSuggest = generateItalicSentence("Gợi ý: ", es.getSuggest());
                pnEssay.add(pnQuestion);
                pnEssay.add(pnSuggest);
                pnExam.add(pnEssay);
            }
            
            if(ex.getMultipleChoices().size() != 0)
            {
                JLabel lblMC = new JLabel("Trắc nghiệm");
                lblMC.setFont(fontPart);
                pnExam.add(lblMC);
            }
           
            count = 0;
            for (MultipleChoice mc : ex.getMultipleChoices())
            {
                count++;
                JPanel pnMultipleChoice = new JPanel();
                pnMultipleChoice.setLayout(new BoxLayout(pnMultipleChoice, BoxLayout.Y_AXIS));
                JPanel pnQuestion = generateSentence("Câu " + count + ": ", mc.getContentQuestion());
                JPanel pnAnswer = new JPanel();
                ArrayList<Answer> answers = mc.getAnswers();
                int row = answers.size() / 2 + 1;
                JPanel ansQuestion = new JPanel();
                for (int i = 0; i < answers.size(); ++i) {
                    Answer answer = answers.get(i);
                    JLabel ans = new JLabel();
                    ans.setText("<html>" + (char) (65 + i) + ". " + answer.getContentAnswer() + "</html>");
                    ansQuestion.setLayout(new GridLayout(row, 2, 5, 5));
                    ans.setHorizontalAlignment(JLabel.LEFT);
                    ans.setPreferredSize(new Dimension(exam.getWidth() / 2 - 10, ans.getPreferredSize().height));
                    ansQuestion.add(ans);
                }
                pnMultipleChoice.add(pnQuestion);
                pnMultipleChoice.add(ansQuestion);
                pnExam.add(pnMultipleChoice);
            }
            
            exam.add(sc, BorderLayout.CENTER);
            exam.updateUI();
        }
    }
    
    public static void deleteExam(JTable tableExam) {
        model = (DefaultTableModel) tableExam.getModel();
        int selectRow = tableExam.getSelectedRow();
        
        if (selectRow != -1) {
            int idExam = (int)model.getValueAt(selectRow, 0) - 1;
            String exam = "Bạn muốn xóa đề thi thứ : " + idExam;
            if (JOptionPane.showConfirmDialog(null, exam, "Thông báo", 2) == 0) {
                exams = ExamModel.readExam();
                exams.removeExam(idExam-1);
                ExamModel.writeExam(exams);
                model.removeRow(selectRow);
                loadTableExam(tableExam);
            }
            
        }
    }
    
    private static JPanel generateSentence(String content1, String content2) 
    {
        JPanel pn = new JPanel();
        Font font = new Font("arial", Font.BOLD, 12);
        JLabel lblContent1 = new JLabel(content1);
        JLabel lblContent2 = new JLabel(content2);
        lblContent1.setFont(font);
        JPanel pnQuestion = new JPanel();
        pn.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn.add(lblContent1);
        pn.add(lblContent2);
        return pn;
    }
    
    private static JPanel generateItalicSentence(String content1, String content2) 
    {
        JPanel pn = new JPanel();
        Font font = new Font("arial", Font.BOLD|Font.ITALIC, 12);
        JLabel lblContent1 = new JLabel(content1);
        JLabel lblContent2 = new JLabel(content2);
        lblContent1.setFont(font);
        JPanel pnQuestion = new JPanel();
        pn.setLayout(new FlowLayout(FlowLayout.LEFT));
        pn.add(lblContent1);
        pn.add(lblContent2);
        return pn;
    }
}
