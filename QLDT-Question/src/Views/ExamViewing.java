/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.ExamController;
import Controllers.QuestionController;
import javax.swing.table.DefaultTableModel;
import Controllers.SubjectController;
import javax.swing.JPanel;

/**
 *
 * @author TungLe
 */
public class ExamViewing extends javax.swing.JPanel {

    /**
     * Creates new form Question
     */
    public ExamViewing() {
        initComponents();
    }
    
    public JPanel getJPanelExam() {
        return background;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        show = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        background = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableExam = new javax.swing.JTable();
        scrollPane1 = new java.awt.ScrollPane();
        exam = new javax.swing.JPanel();

        show.setText("Xem");
        show.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showActionPerformed(evt);
            }
        });
        jPopupMenu1.add(show);

        delete.setText("Xóa");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(delete);

        background.setBackground(new java.awt.Color(233, 235, 238));
        background.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                backgroundAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(233, 235, 238));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableExam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Tên đề thi", "Ngày tạo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableExam.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tableExam.setGridColor(new java.awt.Color(233, 235, 238));
        tableExam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableExamMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableExamMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tableExam);
        if (tableExam.getColumnModel().getColumnCount() > 0) {
            tableExam.getColumnModel().getColumn(0).setResizable(false);
            tableExam.getColumnModel().getColumn(0).setPreferredWidth(70);
            tableExam.getColumnModel().getColumn(1).setResizable(false);
            tableExam.getColumnModel().getColumn(1).setPreferredWidth(300);
            tableExam.getColumnModel().getColumn(2).setResizable(false);
            tableExam.getColumnModel().getColumn(2).setPreferredWidth(150);
        }

        scrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        exam.setBackground(new java.awt.Color(233, 235, 238));
        exam.setPreferredSize(new java.awt.Dimension(450, 446));

        javax.swing.GroupLayout examLayout = new javax.swing.GroupLayout(exam);
        exam.setLayout(examLayout);
        examLayout.setHorizontalGroup(
            examLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );
        examLayout.setVerticalGroup(
            examLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );

        scrollPane1.add(exam);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>                        

    private void backgroundAncestorAdded(javax.swing.event.AncestorEvent evt) {                                         
    }                                        

    private void tableExamMouseReleased(java.awt.event.MouseEvent evt) {                                            
        DefaultTableModel model = (DefaultTableModel) tableExam.getModel();
        int selectRow = tableExam.getSelectedRow();
        if (selectRow != -1 && evt.isPopupTrigger()) {
            delete.setVisible(true);
            jPopupMenu1.show(tableExam, evt.getX(), evt.getY());
        }
    }                                           

    private void tableExamMouseClicked(java.awt.event.MouseEvent evt) {                                           
        
    }                                          

    private void showActionPerformed(java.awt.event.ActionEvent evt) {                                       
        ExamController.showExam(tableExam, exam);
    }  
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {                                       
        ExamController.deleteExam(tableExam);
    }                                                                    
                          
    // Variables declaration - do not modify                     
    public javax.swing.JPanel background;
    public javax.swing.JMenuItem delete;
    public javax.swing.JMenuItem show;
    public javax.swing.JPopupMenu jPopupMenu1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JPanel exam;
    public java.awt.ScrollPane scrollPane1;
    public javax.swing.JTable tableExam;
    // End of variables declaration                   
}
