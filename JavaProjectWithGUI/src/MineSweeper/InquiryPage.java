package MineSweeper;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InquiryPage {
	Client session;
	JFrame frm;
	Thread dbThread = new Thread(){
		@Override
		public void run() {
			while(true) {
				try {Thread.sleep(10000); //1000분의 1초니까 10초단위로 DB데이터 갱신
					session = new ClientManagement().cList.dao.accessAllDataSQL().get(session.getId());}catch (InterruptedException e) {}
			}
		}
	};
	InquiryPage(Client client){
		if(!dbThread.isAlive()) dbThread.start();
		session=client;
		frm=new JFrame("★★★회원 정보!★★★");
		ImageIcon img = new ImageIcon("src/image/mine.png");
		frm.setIconImage(img.getImage());
		frm.setSize(700, 700);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.getContentPane().setLayout(null);
		JLabel l1= new JLabel(String.format("★★★%s님의 정보★★★",session.getName()));
		l1.setBounds(200,30,400,50);
		l1.setFont(new Font("Serif", Font.BOLD,30));
		frm.getContentPane().add(l1);
		JLabel l2 = new JLabel(String.format("등급: %s",session.getGrade()));
		l2.setBounds(300,100,300,50);
		l2.setFont(new Font("Serif", Font.BOLD,20));
		frm.add(l2);
		JLabel l3 = new JLabel(String.format("게임 ID: %s",session.getId()));
		l3.setBounds(100,360,300,50);
		l3.setFont(new Font("Serif", Font.BOLD,20));
		frm.add(l3);
		JLabel l4 = new JLabel(String.format("승리 판 수: %s, 총 판 수: %s",(int)(session.getvRounds()),(int)(session.gettRounds())));
		l4.setBounds(100,420,300,50);
		l4.setFont(new Font("Serif", Font.BOLD,20));
		frm.add(l4);
		JLabel l5 = new JLabel(String.format("승률: %s %s",session.getvRate()*100,(char)37));
		l5.setBounds(100,480,300,50);
		l5.setFont(new Font("Serif", Font.BOLD,20));
		frm.add(l5);
		JButton back = new RoundedButton("<-");
		back.setBounds(0, 0, 50, 50);
		back.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				frm.setVisible(false);
				dbThread.stop();
				new ClientPage(session).frm.setVisible(true);
			}
		});
		JButton withdrawal = new RoundedButton("탈퇴");
		withdrawal.setBounds(500, 500, 50, 50);
		withdrawal.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				if(JOptionPane.showConfirmDialog(withdrawal, "정말 탈퇴하시겠습니까?","확인 창",JOptionPane.YES_NO_CANCEL_OPTION)==0){
				frm.setVisible(false);
				dbThread.stop();
				new ClientManagement().Withdrawal(session);//탈퇴 메소드
				 new LoginPage().frm.setVisible(true);
				}
			}
		});
		
		frm.add(back);
		frm.add(withdrawal);
	}
}

