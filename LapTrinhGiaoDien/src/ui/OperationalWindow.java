package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

public class OperationalWindow extends JFrame{
	
	DefaultMutableTreeNode root = null;
	DefaultTableModel dtmCauHoi;
	JTable tblCauHoi;
	JTree tree;
	JTextField txtCauHoi, txtGoiY, txtMucDo;
	JButton btnThem, btnLuu, btnHuy, btnThoat;
	
	public OperationalWindow(String title)
	{
		super(title);
		addControls();
	}
	public void addControls()
	{
		Container con = getContentPane();
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BorderLayout());
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		con.add(sp);
		
		root = new DefaultMutableTreeNode("CƠ SỞ DỮ LIỆU");
		tree = new JTree(root);
		JScrollPane sc = new JScrollPane(tree, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);;
		pnLeft.add(sc, BorderLayout.CENTER);
		//add items for subject
		DefaultMutableTreeNode nodeChapter1 = new DefaultMutableTreeNode("Chương 1. Đại cương về các hệ CSDL");
		DefaultMutableTreeNode nodeTracNghiemChap1 = new DefaultMutableTreeNode("Trắc nghiệm");
		DefaultMutableTreeNode nodeTuLuanChap1 = new DefaultMutableTreeNode("Tự luận");
		nodeChapter1.add(nodeTracNghiemChap1);
		nodeChapter1.add(nodeTuLuanChap1);
		root.add(nodeChapter1);
		tree.expandRow(0);
		tree.expandRow(1);
		
		JPanel pnRight1 = new JPanel();
		JPanel pnRight2 = new JPanel();
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pnRight1, pnRight2);
		pnRight.add(spRight);
		pnRight1.setPreferredSize(new Dimension(0, 250));
		dtmCauHoi = new DefaultTableModel();
		dtmCauHoi.addColumn("STT");
		dtmCauHoi.addColumn("Câu hỏi");
		dtmCauHoi.addColumn("Đáp án/Gợi ý");
		dtmCauHoi.addColumn("Mức độ");
		tblCauHoi = new JTable(dtmCauHoi);
		tblCauHoi.getColumnModel().getColumn(0).setMaxWidth(50);
		tblCauHoi.getColumnModel().getColumn(1).setMaxWidth(600);
		tblCauHoi.getColumnModel().getColumn(2).setMaxWidth(500);
		tblCauHoi.getColumnModel().getColumn(3).setMaxWidth(50);
		
		//add items to table
		String q1[] = {"01", "Trình bày về thế chiến thứ hai ?", 
						"Viết khoảng 400 từ", "4"};
		dtmCauHoi.addRow(q1);
		
		JScrollPane scTable = new JScrollPane(tblCauHoi, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnRight1.setLayout(new BorderLayout());
		pnRight1.add(scTable, BorderLayout.CENTER);
		
		pnRight2.setLayout(new BoxLayout(pnRight2, BoxLayout.Y_AXIS));
		JPanel pnCauHoi = new JPanel();
		pnCauHoi.setLayout(new FlowLayout());
		JLabel lblCauHoi = new JLabel("Câu hỏi: ");
		txtCauHoi = new JTextField(50);
		pnCauHoi.add(lblCauHoi);
		pnCauHoi.add(txtCauHoi);
		pnRight2.add(pnCauHoi);
		
		JPanel pnGoiY = new JPanel();
		pnGoiY.setLayout(new FlowLayout());
		JLabel lblGoiY = new JLabel("Gợi ý: ");
		txtGoiY = new JTextField(50);
		pnGoiY.add(lblGoiY);
		pnGoiY.add(txtGoiY);
		pnRight2.add(pnGoiY);
		
		JPanel pnMucDo = new JPanel();
		pnGoiY.setLayout(new FlowLayout());
		JLabel lblMucDo = new JLabel("Mức độ: ");
		txtMucDo = new JTextField(50);
		pnMucDo.add(lblMucDo);
		pnMucDo.add(txtMucDo);
		pnRight2.add(pnMucDo);
		
		lblCauHoi.setPreferredSize(lblMucDo.getPreferredSize());
		lblGoiY.setPreferredSize(lblMucDo.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnLuu = new JButton("Lưu");
		btnHuy = new JButton("Hủy");
		btnThoat = new JButton("Thoát");
		pnButton.add(btnThem);
		pnButton.add(btnLuu);
		pnButton.add(btnHuy);
		pnButton.add(btnThoat);
		pnRight2.add(pnButton);
	}
	
	public void addEvents()
	{
		
	}
	
	public void showWindow()
	{
		this.setSize(1200, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
