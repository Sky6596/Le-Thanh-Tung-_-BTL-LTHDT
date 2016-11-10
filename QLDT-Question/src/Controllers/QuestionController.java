/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import static Controllers.SubjectController.subjects;
import Models.SubjectsModel;
import Object.Answer;
import Object.Essay;
import Object.MultipleChoice;
import Views.InformationQuestion;
import Views.NewAnswer;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duc Dung Dan
 */
public class QuestionController {
    public static InformationQuestion newDialogQuestion = new InformationQuestion(null, true);
    public static Essay essay;
    public static MultipleChoice multipleChoice;
    public static String questionForm;
    
    public static void loadSubjects(JComboBox subjects) {
        subjects.removeAllItems();
        
        for(int i = 0; i < SubjectController.subjects.getSubjects().size(); ++i) {
            subjects.addItem(SubjectController.subjects.getSubjects().get(i).getNameSubject());
        }
    }
    
    public static void loadChapter(int index) {
        newDialogQuestion.chapters.removeAllItems();
        
        for(int i = 0; i < SubjectController.subjects.getSubjects().get(index).getChapters().size(); ++i) {
            newDialogQuestion.chapters.addItem(SubjectController.subjects.getSubjects().get(index).getChapters().get(i).getNameChapter());
        }
    }
    
    public static void viewNewQuestion() {
        String[] pizzas = {"Tự luận", "Trắc nghiệm"};
        JFrame frame = new JFrame("Question form");
        questionForm = (String) JOptionPane.showInputDialog(frame,
                "Hình thức câu hỏi bạn muốn tạo là gì?",
                "Hình thức câu hỏi",
                JOptionPane.QUESTION_MESSAGE,
                null,
                pizzas,
                pizzas[0]);
        
        newDialogQuestion = new InformationQuestion(null, true);

        if("Tự luận".equals(questionForm)) {
            essay = new Essay();
            newDialogQuestion.update.setVisible(false);
            newDialogQuestion.addAns.setVisible(false);

            JTextArea suggest = new JTextArea();
            suggest.setEnabled(true);
            JScrollPane JScr = new JScrollPane(suggest);
            JScr.setSize(newDialogQuestion.jPanel1.getPreferredSize().width + 25, newDialogQuestion.jPanel1.getPreferredSize().height);
            
            
            newDialogQuestion.jPanel1.removeAll();
            newDialogQuestion.jPanel1.setPreferredSize(JScr.getSize());
            newDialogQuestion.jPanel1.add(JScr);

            loadSubjects(newDialogQuestion.subjects);
            loadChapter(0);
            newDialogQuestion.setVisible(true);
        } else {
            if("Trắc nghiệm".equals(questionForm)) {
                multipleChoice = new MultipleChoice();
                newDialogQuestion.update.setVisible(false);
                newDialogQuestion.answer.removeAll();
                newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, 0));
                loadSubjects(newDialogQuestion.subjects);
                loadChapter(0);
                newDialogQuestion.setVisible(true);
            }
        }
    }
    
    public static void viewQuestion(JTable table, JPanel question) {
        question.removeAll();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectRow = table.getSelectedRow();
        int id = (int) model.getValueAt(selectRow, 0);
        String content = (String) model.getValueAt(selectRow, 1);
        question.setPreferredSize(new Dimension(question.getWidth(), content.length() * 7 * 14 / question.getWidth()));
        JLabel jlabelContent = new JLabel("<html>" + content + "</html>");
        jlabelContent.setPreferredSize(new Dimension(question.getWidth(), (Math.round(content.length() * 7 / question.getWidth()) + 1) * 14));
        question.setLayout(new FlowLayout());
        question.add(jlabelContent);
        question.updateUI();
        if (model.getValueAt(selectRow, 5) == "Tự luận") {
            String suggest = subjects.getSubject(id / 1000).getEssay(id % 1000).getSuggest();
            question.setPreferredSize(new Dimension(question.getWidth(), content.length() * 7 * 14 / question.getWidth()));
            JLabel jlabelSuggest = new JLabel("<html> Gợi ý: <br> " + suggest + "</html>");
            //jlabelSuggest.setHorizontalAlignment((int) JLabel.LEFT_ALIGNMENT);
            jlabelContent.setPreferredSize(new Dimension(question.getWidth(), (Math.round(content.length() * 7 / question.getWidth()) + 2) * 14));
            question.setLayout(new FlowLayout(FlowLayout.LEFT));
            question.add(jlabelSuggest);
            question.updateUI();
        } else {
            ArrayList<Answer> answers = subjects.getSubject(id / 1000).getMultipleChoice(id % 1000 - 500).getAnswers();
            int row = answers.size() / 2 + 1;
            JPanel ansQuestion = new JPanel();
            for (int i = 0; i < answers.size(); ++i) {
                Answer answer = answers.get(i);
                JLabel ans = new JLabel();
                if (answer.getAccuracy()) {
                    ans.setText("<html><font color='red'>" + (char) (65 + i) + ". " + answer.getContentAnswer() + "</font></html>");
                } else {
                    ans.setText("<html>" + (char) (65 + i) + ". " + answer.getContentAnswer() + "</html>");
                }
                ansQuestion.setLayout(new GridLayout(row, 2, 5, 5));
                ans.setHorizontalAlignment(JLabel.CENTER);
                ans.setPreferredSize(new Dimension(question.getWidth() / 2 - 10, ans.getPreferredSize().height));

                ansQuestion.add(ans);
                ansQuestion.updateUI();
            }

            question.setPreferredSize(new Dimension(question.getPreferredSize().width, question.getPreferredSize().height + ansQuestion.getPreferredSize().height + 50));
            question.add(ansQuestion);
            question.updateUI();
        }
    }
    
//    public static void viewEditQuestion(JTable tableQuestion) {
//        
//        //load question edit
//        DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
//        int selectRow = tableQuestion.getSelectedRow();
//
//        
//        
//        if (selectRow != -1) {
//            int idQuestion = (int) model.getValueAt(selectRow, 0);
//            
//            
//            QuestionModels.question = new Question();
//
//            newDialogQuestion = new InformationQuestion(null, true);
//            newDialogQuestion.create.setVisible(false);
//            newDialogQuestion.answer.removeAll();
//            newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, 0));
//
//            
//            
//            if(QuestionModels.loadQuestion(idQuestion)) {
//                loadSubjects();
//                newDialogQuestion.subjects.setSelectedItem(QuestionModels.question.getNameSubject());
//                loadChapter(QuestionModels.question.getIdSubject());
//                newDialogQuestion.chapters.setSelectedItem(QuestionModels.question.getNameChapter());
//
//                newDialogQuestion.contentQuestion.setText(QuestionModels.question.getContentQuestion());
//                newDialogQuestion.level.setSelectedItem(QuestionModels.question.getLevelQuestion());
//
//                ArrayList<Answer> answers = QuestionModels.question.getAnswers();
//                for (int i = 0; i < answers.size(); ++i) {
//                    NewAnswer newAns = new NewAnswer();
//                    newDialogQuestion.answer.setLayout(new FlowLayout());
//                    Dimension size = newAns.background.getPreferredSize();
//                    newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, newDialogQuestion.answer.getPreferredSize().height + size.height));
//                    newAns.contentAnswer.setText(answers.get(i).getContentAnswer());
//                    newAns.TF.setState(answers.get(i).getTFAnswer());
//                    newDialogQuestion.answer.add(newAns.background);
//                    newDialogQuestion.answer.updateUI();
//                }
//                newDialogQuestion.setVisible(true);
//            }
//        }
//    }
    
    public static void viewNewAnswer() {
        multipleChoice.setAnswer(new Answer());
        NewAnswer newAns = new NewAnswer();
        newDialogQuestion.answer.setLayout(new FlowLayout());
        Dimension size = newAns.background.getPreferredSize();
        newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, newDialogQuestion.answer.getPreferredSize().height + size.height + 5));
        newDialogQuestion.answer.add(newAns.background);
        newDialogQuestion.answer.updateUI();
    }

    
    public static Boolean createQuestion() {
        if("Trắc nghiệm".equals(questionForm)) {
            if (newDialogQuestion.answer.getComponentCount() > 3) {
                multipleChoice = new MultipleChoice();
                multipleChoice.setChapter((String) newDialogQuestion.chapters.getSelectedItem());
                multipleChoice.setLevel(Integer.parseInt((String) newDialogQuestion.level.getSelectedItem()));
                multipleChoice.setContentQuestion(newDialogQuestion.contentQuestion.getText());
                
                for (int i = 0; i < newDialogQuestion.answer.getComponentCount(); ++i) {
                    Answer newAns = new Answer();
                    JPanel ans = new JPanel();
                    JTextField content = new JTextField();
                    Checkbox TF = new Checkbox();
                    ans = (JPanel) newDialogQuestion.answer.getComponent(i);
                    content = (JTextField) ans.getComponent(1);
                    TF = (Checkbox) ans.getComponent(0);
                    newAns.setContentAnswer(content.getText());
                    newAns.setAccuracy(TF.getState());
                    multipleChoice.setAnswer(newAns);
                }
                

                SubjectController.subjects.getSubject(newDialogQuestion.subjects.getSelectedIndex()).setMultipleChoice(multipleChoice);
                
                if (SubjectsModel.writeSubjects(SubjectController.subjects)) {
                    newDialogQuestion = new InformationQuestion(null, true);
                    JOptionPane.showMessageDialog(null, "Thêm câu hỏi thành công", "Thông báo", 3);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm câu hỏi thất bại", "Thông báo", 3);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Câu hỏi trắc nghiệm phải có ít nhất 4 đáp án trở lên", "Lỗi", 2);
                return false;
            }
        } else {
            JTextArea suggest = (JTextArea) (((JViewport) (((JScrollPane) newDialogQuestion.jPanel1.getComponent(0)).getViewport()))).getView();
            if (suggest.getText().length() > 0) {
                essay.setChapter((String) newDialogQuestion.chapters.getSelectedItem());
                essay.setLevel(Integer.parseInt((String) newDialogQuestion.level.getSelectedItem()));
                essay.setContentQuestion(newDialogQuestion.contentQuestion.getText());
                essay.setSuggest(suggest.getText());
               

                SubjectController.subjects.getSubject(newDialogQuestion.subjects.getSelectedIndex()).setEssay(essay);

                if (SubjectsModel.writeSubjects(SubjectController.subjects)) {
                    newDialogQuestion = new InformationQuestion(null, true);
                    JOptionPane.showMessageDialog(null, "Thêm câu hỏi thành công", "Thông báo", 3);
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm câu hỏi thất bại", "Thông báo", 3);
                    return false;
                }
            }
        }
        
        return false;
    }
    
    public static void deleteAnswer(Component answer) {
        String question = "Bạn muốn xóa câu trả lời này";
        if (JOptionPane.showConfirmDialog(null, question, "Thông báo", 2) == 0) {
            int i = newDialogQuestion.answer.getComponentZOrder(answer);
            multipleChoice.removeAns(i);
            newDialogQuestion.answer.remove(i);
            newDialogQuestion.answer.updateUI();
        }
    }
    
    public static void deleteQuestion(JTable tableQuestion) {
        DefaultTableModel model = (DefaultTableModel) tableQuestion.getModel();
        int selectRow = tableQuestion.getSelectedRow();
        
        if (selectRow != -1) {
            int idQuestion = (int) model.getValueAt(selectRow, 0);
            String question = "Bạn muốn xóa câu hỏi có id = " + idQuestion;
            if (JOptionPane.showConfirmDialog(null, question, "Thông báo", 2) == 0) {
                if(model.getValueAt(selectRow, 5) == "Trắc nghiệm") {
                    subjects.getSubject(idQuestion / 1000).removeMultipleChoice(idQuestion % 1000 - 500);
                    SubjectsModel.writeSubjects(subjects);
                    model.removeRow(selectRow);
                } else {
                    subjects.getSubject(idQuestion / 1000).removeEssay(idQuestion % 1000);
                    SubjectsModel.writeSubjects(subjects);
                    model.removeRow(selectRow);
                }
            }
        }
    }
    
}
