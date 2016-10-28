package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.font.ImageGraphicAttribute;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame{
	JComboBox<String> cboKhoaVien;
	JComboBox<String> cboMonHoc;
	JButton btnOK, btnExit;
	
	public MainWindow(String title)
	{
		super("Phần mềm tạo đề thi");
		addControls();
	}
	public void addControls()
	{
		Container con = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		con.add(pnMain);
		JPanel pnKhoaVien = new JPanel();
		pnKhoaVien.setLayout(new FlowLayout());
		JLabel lblKhoaVien = new JLabel("Khoa/Viện: ");
		cboKhoaVien = new JComboBox();
		//add items to cboKhoaVien
		cboKhoaVien.addItem("Viện Công nghệ thông tin và truyền thông");
		pnKhoaVien.add(lblKhoaVien);
		pnKhoaVien.add(cboKhoaVien);
		pnMain.add(pnKhoaVien);
		
		JPanel pnMonHoc = new JPanel();
		pnMonHoc.setLayout(new FlowLayout());
		JLabel lblMonHoc = new JLabel("Môn học: ");
		cboMonHoc = new JComboBox();
		//add items to cboMonHoc
		cboMonHoc.addItem("Cơ sở dữ liệu");
		cboMonHoc.addItem("Lập trình hướng đối tượng");
		pnMonHoc.add(lblMonHoc);
		pnMonHoc.add(cboMonHoc);
		pnMain.add(pnMonHoc);
		
		cboMonHoc.setPreferredSize(cboKhoaVien.getPreferredSize());
		lblMonHoc.setPreferredSize(lblKhoaVien.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnOK = new JButton("OK");
		btnExit = new JButton("Exit");
		pnButton.add(btnOK);
		ImageIcon iconOK = new ImageIcon("images/ok_icon.png");
		btnOK.setIcon(iconOK);
		pnButton.add(btnExit);
		ImageIcon iconExit = new ImageIcon("images/exit_icon.png");
		btnExit.setIcon(iconExit);
		pnMain.add(pnButton);
		
		Border borderThongTin = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitleThongTin = new TitledBorder(borderThongTin, "Thông tin");
		pnMain.setBorder(borderTitleThongTin);
		borderTitleThongTin.setTitleColor(Color.RED);
		borderTitleThongTin.setTitleJustification(TitledBorder.LEFT);
	}
	
	public void addEvents()
	{
		
	}
	
	public void showWindow()
	{
		this.setSize(400, 250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
