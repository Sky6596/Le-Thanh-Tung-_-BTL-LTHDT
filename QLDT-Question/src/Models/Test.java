/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Object.Exam;
import Object.Exams;
import Object.Subjects;
import java.util.ArrayList;

/**
 *
 * @author SinhVienBK
 */
public class Test {
    public static void main(String[] args) {
        Subjects sj = new Subjects();
        sj = SubjectsModel.readSubjects();
        Exam exam1 = new Exam();
        Exam exam2 = new Exam();
        Exam exam3 = new Exam();
        exam1.setNameExam("Đề thi Toán");
        exam2.setNameExam("Đề thi Lý");
        exam3.setNameExam("Đề thi Hóa");
        exam1.setCreateday("2012-08-12");
        exam2.setCreateday("2014-11-24");
        exam3.setCreateday("2013-07-14");
        
        exam1.setEssays(sj.getSubject(0).getEssays()); 
        //exam2.setEssays(sj.getSubject(0).getEssays());
        exam3.setEssays(sj.getSubject(0).getEssays());
        exam1.setMultipleChoices(sj.getSubject(0).getMultipleChoices());
        exam2.setMultipleChoices(sj.getSubject(0).getMultipleChoices());
        //exam3.setMultipleChoices(sj.getSubject(0).getMultipleChoices());
        Exams exams = new Exams();
        ArrayList<Exam> examlist = new ArrayList<Exam>();
        examlist.add(exam1);
        examlist.add(exam2);
        examlist.add(exam3);
        exams.setExams(examlist);
        ExamModel.writeExam(exams);
    }
}
