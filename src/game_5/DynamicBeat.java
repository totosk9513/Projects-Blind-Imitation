package game_5;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {
	private Image screenImage;
	private Graphics screenGraphic;

	private Image background = new ImageIcon(Main.class.getResource("../images/introBackground.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private ImageIcon exitButtonEnteredImage =  new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private int mouseX, mouseY;
	

	public DynamicBeat() 
	{
		setUndecorated(true); //기본적으로 windows에서 제공되는 menu bar가 사라짐
		setTitle("Dynamic Beat"); //windows에서 실행될때 title이름 
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //프로그램 창 크기 initialize
		setResizable(false); //프로그램 창 사이즈 조절 고정
		setLocationRelativeTo(null); //프로그램 창을 모니터 정 중앙(null)에 위치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //끄면 프로그램도 종료
		setVisible(true); //프로그램 창이 보임
		setBackground(new Color(0, 0, 0, 0)); //decoration으로 취급됨, paintcomponent를 했을때 배경을 회색이 아닌 흰색(?)으로 바꿔줌
		setLayout(null); //layout(null)을 해야 버튼, 매뉴 등등이 설정해놓은 제자리로 감.

		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				exitButton.setIcon(exitButtonEnteredImage); //이미지 변경
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try 
				{
					Thread.sleep(350);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0); //프로그램 종료
			}
		});
		add(exitButton);
		
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				startButton.setIcon(startButtonEnteredImage); //이미지 변경
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				quitButton.setIcon(quitButtonEnteredImage); //이미지 변경
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				try 
				{
					Thread.sleep(350);
				} catch (InterruptedException ex)
				{
					ex.printStackTrace();
				}
				System.exit(0); //프로그램 종료
			}
		});
		add(quitButton);
	
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e)   //마우스 커서를 대고 눌렀을때
			{
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() 
		{
			@Override
			public void mouseDragged(MouseEvent e) //마우스 커서를 대고 누르고/드래그 하면
			{
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation (x - mouseX, y - mouseY); //매뉴바를 잡고 움직이면 프로그램 창도 움직이게 해줌
			}
		}
				);
		add(menuBar);
		

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) // 이미 library에 의해 정해져있는 공식.
	{
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw(screenGraphic);
		// int i = 2;
		// System.out.println(i);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics g) // double buffering
	{
		g.drawImage(background, 0, 0, null);
		paintComponents(g);
		this.repaint();
		// int i = 1;
		// System.out.println(i);
	}
}
