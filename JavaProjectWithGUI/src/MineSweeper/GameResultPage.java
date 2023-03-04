package MineSweeper;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GameResultPage {
	JFrame frm;
	Client session;
	List<List<Integer>> list;
	List<List<JButton>> Buttonlist;
	Thread dbThread = new Thread(){
		@Override
		public void run() {
			while(true) {
				try {Thread.sleep(10000); //1000분의 1초니까 10초단위로 DB데이터 갱신
					session = new ClientManagement().cList.dao.accessAllDataSQL().get(session.getId());}catch (InterruptedException e) {}
			}
		}
	};
	GameResultPage(Client client,List<List<Integer>> list,boolean vic){
		session=client;
		this.list = list;
		ResultList();
		frm = new JFrame("★★★Result★★★");
		ImageIcon img = new ImageIcon("src/image/mine.png");
		frm.setIconImage(img.getImage());
		frm.setSize(700, 700);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setLocationRelativeTo(null);
		frm.getContentPane().setLayout(null);
		JLabel jl =new JLabel("★★★게임 결과★★★");
		jl.setFont(new Font("Serif", Font.BOLD,30));
		jl.setBounds(200,30,400,50);
		jl.setForeground(Color.BLUE);
		frm.add(jl);
		JLabel jl2 =new JLabel(String.format("%s님 %s !!", session.getName(), vic ? "승리":"패배"));
		jl2.setFont(new Font("Serif", Font.BOLD,30));
		jl2.setBounds(200,100,400,50);
		jl2.setForeground(Color.BLUE);
		frm.add(jl2);
		JLabel jl3 =new JLabel(String.format("승률: %s",session.getGrade()));
		jl2.setFont(new Font("Serif", Font.BOLD,30));
		jl2.setBounds(200,170,400,50);
		jl2.setForeground(Color.BLACK);
		frm.add(jl3);
		addButton();
		JButton back = new RoundedButton("돌아가기");
		back.setBounds(0, 600, 150, 70);
		back.addActionListener(new ActionListener(){
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e){
				frm.setVisible(false);
				dbThread.stop();
				new ClientPage(session).frm.setVisible(true);
			}
		});
		frm.add(back);
		frm.setVisible(true);
	}
	void ResultList() {
		Buttonlist= IntStream.rangeClosed(0, list.size()-1)
		.boxed()
		.map(s-> IntStream.rangeClosed(0, list.get(s)
				.size()-1).mapToObj(p-> {
					JButton but;
					if(list.get(s).get(p).equals(1)) {
						but=new RoundedButton(" ");
						but.setBackground(Color.WHITE);
					}
					else if(list.get(s).get(p).equals(2)){
						 ImageIcon icon = new ImageIcon("src\\image\\mine.png");
					        Image img = icon.getImage();
					        Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
						but=new JButton(new ImageIcon(scaledImg));
						but.setBackground(Color.WHITE);
					}else {
						but=new RoundedButton("error");//잘못된 값이 들어가면 error 표시
					}
					return but;
				}).collect(Collectors.toList())).collect(Collectors.toList());
	}
	void addButton() {
		int col=0 ,row = 0;
		for(int i=0;i<Buttonlist.size();i++) {
			row = 0;
			col+=70;
			for(int j=0;j<Buttonlist.size();j++) {
				JButton bu = Buttonlist.get(i).get(j);
				bu.setBounds(200+row, 300+col, 60, 60);
				frm.getContentPane().add(bu);
				row+=70;
			}
		}
	}
	
}
