/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.SubjectsModel;
import Views.InformationQuestion;
import java.util.ArrayList;
import Object.*;
import Views.NewChapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Duc Dung Dan
 */
public class SubjectController {
    public static InformationQuestion newDialogQuestion = new InformationQuestion(null, true);
    
    
    public static int start = 0;
    public static int page = 0;
    public static String search = "";
    public static String typeSearch = "id_question";
    public static ArrayList<Integer> removeAns = new ArrayList<>();
    public static Subjects subjects = new Subjects();

    public static void loadTableQuestion(JTable table) {
        subjects = SubjectsModel.readSubjects();
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int rowCount = model.getRowCount();
        //Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        
        for(int i = 0; i < subjects.getSubjects().size(); ++i) {
            Essay essay;
            for(int j = 0; j < subjects.getSubjects().get(i).getEssays().size(); ++j) {
                essay = subjects.getSubjects().get(i).getEssays().get(j);
                model.addRow(new Object[]{i*1000 + j, essay.getContentQuestion(), essay.getChapter(), subjects.getSubjects().get(i).getNameSubject(), essay.getLevel(), "Tự luận"});
                
            }
            
            MultipleChoice multipleChoice;
            for(int j = 0; j < subjects.getSubjects().get(i).getMultipleChoices().size(); ++j) {
                multipleChoice = subjects.getSubjects().get(i).getMultipleChoices().get(j);
                model.addRow(new Object[]{i*1000 + 500 + j, multipleChoice.getContentQuestion(), multipleChoice.getChapter(), subjects.getSubjects().get(i).getNameSubject(), multipleChoice.getLevel(), "Trắc nghiệm"});
            }
        }
    }
//
//
//    public static void searchTableQuestion(JTable table, JLabel pageQuestion, String inputSearch, String inputTypeSearch) {
//        switch (inputTypeSearch) {
//            case "id":
//                typeSearch = "id_question";
//                break;
//            case "Nội dung":
//                typeSearch = "content_question";
//                break;
//            case "Chương":
//                typeSearch = "chapter_name";
//                break;
//            case "Môn":
//                typeSearch = "subject_name";
//                break;
//            default:
//                typeSearch = "difficult_question";
//        }
//
//        search = inputSearch;
//        page = 0;
//        start = 0;
//        pageQuestion.setText(String.valueOf(page));
//        if (!loadTableQuestion(table)) {
//            JOptionPane.showMessageDialog(null, "Không tìm được kết quả nào thỏa mãn", "Thông báo", 2);
//        }
//    }
    
    
//
//    
//    
//    public static void viewNewQuestion() {
//        QuestionModels.question = new Question();
//        newDialogQuestion.update.setVisible(false);
//        newDialogQuestion.answer.removeAll();
//        newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, 0));
//        loadSubjects();
//        loadChapter(QuestionModels.subjects.get(newDialogQuestion.subjects.getSelectedIndex()).getIdSubject());
//        newDialogQuestion.setVisible(true);
//    }
//    
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
//    
//    public static void viewNewAnswer() {
//        QuestionModels.question.setAnswer(new Answer());
//        NewAnswer newAns = new NewAnswer();
//        newDialogQuestion.answer.setLayout(new FlowLayout());
//        Dimension size = newAns.background.getPreferredSize();
//        newDialogQuestion.answer.setPreferredSize(new Dimension(newDialogQuestion.answer.getPreferredSize().width, newDialogQuestion.answer.getPreferredSize().height + size.height));
//        newDialogQuestion.answer.add(newAns.background);
//        newDialogQuestion.answer.updateUI();
//    }
//    
//    
//    public static Boolean createQuestion() {
//        
//        if(newDialogQuestion.answer.getComponentCount() > 1 ) {
//            QuestionModels.question.setIdChapter(QuestionModels.chapters.get(newDialogQuestion.chapters.getSelectedIndex()).getIdChapter());
//            QuestionModels.question.setIdSubject(QuestionModels.subjects.get(newDialogQuestion.subjects.getSelectedIndex()).getIdSubject());
//            QuestionModels.question.setContentQuestion(newDialogQuestion.contentQuestion.getText());
//            QuestionModels.question.setLevelQuestion(Integer.parseInt((String) newDialogQuestion.level.getSelectedItem()));
//            for (int i = 0; i < newDialogQuestion.answer.getComponentCount(); ++i) {
//                JPanel ans = new JPanel();
//                JTextField content = new JTextField();
//                Checkbox TF = new Checkbox();
//                ans = (JPanel) newDialogQuestion.answer.getComponent(i);
//                content = (JTextField) ans.getComponent(1);
//                TF = (Checkbox) ans.getComponent(0);
//                QuestionModels.question.editAnswer(i, content.getText(), TF.getState());
//            }
//
//            if (QuestionModels.createQuestion()) {
//                newDialogQuestion = new InformationQuestion(null, true);
//                JOptionPane.showMessageDialog(null, "Create câu hỏi thành công", "Thông báo", 3);
//                return true;
//            } else {
//                JOptionPane.showMessageDialog(null, "Tạo câu hỏi thất bại", "Thông báo", 3);
//                return false;
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Câu hỏi phải có ít nhất 2 đáp án trở lên", "Lỗi", 2);
//            return false;
//        }
//        
//    }
//
//    public static Boolean updateQuestion() {
//
//        if (newDialogQuestion.answer.getComponentCount() > 1) {
//            QuestionModels.question.setIdChapter(QuestionModels.chapters.get(newDialogQuestion.chapters.getSelectedIndex()).getIdChapter());
//            QuestionModels.question.setIdSubject(QuestionModels.subjects.get(newDialogQuestion.subjects.getSelectedIndex()).getIdSubject());
//            QuestionModels.question.setContentQuestion(newDialogQuestion.contentQuestion.getText());
//            QuestionModels.question.setLevelQuestion(Integer.parseInt((String) newDialogQuestion.level.getSelectedItem()));
//            for (int i = 0; i < newDialogQuestion.answer.getComponentCount(); ++i) {
//                JPanel ans = new JPanel();
//                JTextField content = new JTextField();
//                Checkbox TF = new Checkbox();
//                ans = (JPanel) newDialogQuestion.answer.getComponent(i);
//                content = (JTextField) ans.getComponent(1);
//                TF = (Checkbox) ans.getComponent(0);
//                QuestionModels.question.editAnswer(i, content.getText(), TF.getState());
//            }
//
//            if (QuestionModels.updateQuestion()) {
//                newDialogQuestion = new InformationQuestion(null, true);
//                JOptionPane.showMessageDialog(null, "Update câu hỏi thành công", "Thông báo", 3);
//                return true;
//            } else {
//                JOptionPane.showMessageDialog(null, "Update câu hỏi thất bại công", "Lỗi", 2);
//                return false;
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Câu hỏi phải có ít nhất 2 đáp án trở lên", "Lỗi", 2);
//            return false;
//        }
//
//    }
//    
//    public static void importData(JPanel jpanel) {
//        JFileChooser chooser = new JFileChooser();
//        FileNameExtensionFilter loc = new FileNameExtensionFilter("File", "json");
//        chooser.setFileFilter(loc);
//        int i = chooser.showOpenDialog(jpanel);
//
//        if (i == JFileChooser.APPROVE_OPTION) {
//            String question = "Bạn muốn import file " + chooser.getSelectedFile().getPath();
//            if (JOptionPane.showConfirmDialog(null, question, "Thông báo", 2) == 0) {
//                try {
//                    InputStream inputStream = new FileInputStream(chooser.getSelectedFile().getPath());
//                    InputStreamReader fileI = new InputStreamReader(inputStream, "Unicode");
//                    try (BufferedReader br = new BufferedReader(fileI)) {
//                        StringBuilder str = new StringBuilder("");
//                        String line;
//                        while ((line = br.readLine()) != null) {
//                            str.append(line);
//                        }
//                        JSONArray fileJSONList = new JSONArray();
//                        try {
//                            fileJSONList = new JSONArray(str.toString());
//                        } catch (Exception e) {
//                            System.out.println(e.getMessage());
//                        }
//                        JSONObject object;
//                        String path;
//                        Image image;
//                        for (int k = 0; k < fileJSONList.length(); ++k) {
////                            Book bookNew = new Book();
////                            object = (JSONObject) fileJSONList.get(k);
////                            bookNew.setName((String) object.get("Name"));
////                            bookNew.setAuthor((String) object.get("Author"));
////                            bookNew.setContent((String) object.get("Content"));
////                            bookNew.setYear((Number) object.get("Year"));
////                            bookNew.setCompany((String) object.get("Company"));
////                            bookNew.setCountry((String) object.get("Country"));
////                            bookNew.setType((String) object.get("Type"));
////                            bookNew.setNumber((Number) object.get("Number"));
////                            bookNew.setValue((Number) object.get("Value"));
////                            path = (String) object.get("Image");
////                            if ("".equals(path.trim())) {
////                                bookNew.setImage(null);
////                            } else {
////                                image = MainController.readImageFromURL(path, 180, 130);
////                                if (image != null) {
////                                    BufferedImage bufferedImage = MainController.toBufferedImage(image);
////                                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
////                                    String[] nameFiles = path.split("\\.");
////                                    ImageIO.write(bufferedImage, nameFiles[nameFiles.length - 1], baos);
////                                    bookNew.setImage(baos.toByteArray());
////                                } else {
////                                    bookNew.setImage(null);
////                                }
////                            }
////                            BookModel.insert(bookNew);
//                        }
//                        br.close();
//                    }
//                } catch (FileNotFoundException ex) {
//                    System.out.println(ex.getMessage());
//                } catch (IOException ex) {
//                    System.out.println(ex.getMessage());
//                }
//            }
//
//        }
//    }

    public static void addSubject() {
        JFrame frame = new JFrame("Question form");
        String newNameSubject = (String) JOptionPane.showInputDialog(frame,
                "Nhập tên môn học",
                "New Subject",
                JOptionPane.INFORMATION_MESSAGE);
        Subject newSubject = new Subject();
        newSubject.setNameSubject(newNameSubject);
        subjects.setSubject(newSubject);
        SubjectsModel.writeSubjects(subjects);
    }
    
    public static void viewAddChapter() {
        NewChapter newChapter = new NewChapter(null, true);
        newChapter.setVisible(true);
    }

    public static Boolean addChapter(Number indexsubject, String newChapter) {
        Chapter chapter = new Chapter();
        chapter.setNameChapter(newChapter);
        subjects.getSubject((int) indexsubject).setChapter(chapter);
        SubjectsModel.writeSubjects(subjects);
        return true;
    }

}
