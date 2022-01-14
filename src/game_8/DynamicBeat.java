package game_8;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

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

	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));

	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	
	private Music selectedMusic;
	private Image selectedImage; 
	private Image titleImage; 
	private int nowSelected = 0; //index of a music.
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	
	private boolean isMainScreen = false;
	
	
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
		

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
		
		//index 0
		trackList.add(new Track(
								"Mighty Love Title Image.png",
								"Mighty Love Start Image.png",
								"Mighty Love Game Image.jpg",
								"Mighty Love Selected.mp3",
								"Joakim Karud - Mighty Love.mp3"
								)
					);
		
		//index 1
		trackList.add(new Track(
								"Wild Flower Title Image.png",
								"Wild Flower Start Image.png",
								"Wild Flower Game Image.jpg",
								"Wild Flower Selected.mp3",
								"Joakim Karud - Wild Flower.mp3"
								)
					);
		
		//index 2
		trackList.add(new Track(
								"Energy Title Image.png",
								"Energy Start Image.png",
								"Energy Game Image.png",
								"Energy Selected.mp3",
								"Bensound - Energy.mp3"
								)
					);



		exitButton.setBounds(1245, 0, 30, 30); //위치,위치,크기,크기
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
		
		
		startButton.setBounds(40, 200, 400, 100); //x위치,y위치,x크기,y크기
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
				introMusic.close();
				selectTrack(0);

				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				easyButton.setVisible(true);
				hardButton.setVisible(true);

				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 330, 400, 100); //x위치,y위치,x크기,y크기
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
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); //x위치,y위치,x크기,y크기
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				leftButton.setIcon(leftButtonEnteredImage); //이미지 변경
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectLeft();
			}
		});
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); //x위치,y위치,x크기,y크기
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				rightButton.setIcon(rightButtonEnteredImage); //이미지 변경
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67); //x위치,y위치,x크기,y크기
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				easyButton.setIcon(easyButtonEnteredImage); //이미지 변경
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "easy");
				
			}
		});
		add(easyButton);
		
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67); //x위치,y위치,x크기,y크기
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //마우스 커서가 올라갔을때
			{
				hardButton.setIcon(hardButtonEnteredImage); //이미지 변경
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //마우스 커서가 hand_cursor로 변경
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //마우스 커서가 아이콘 밖으로 나갔을때
			{
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //마우스 커서가 default_cursor로 다시 변경
			}
			@Override
			public void mousePressed(MouseEvent e) //마우스 클릭을 했을때
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				gameStart(nowSelected, "hard");
				
			}
		});
		add(hardButton);
		
		
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
		
	} //end of dynamic beat
	
	

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
		g.drawImage(background, 0, 0, null); //백그라운드 먼저 draw
		if (isMainScreen == true) //만약 mainscreen = true, 그러면 백그라운드 위에 selected image draw
		{
			g.drawImage(selectedImage, 340, 100, null); //selectedImage를 340,100크기, null = 제일 중앙에 draw.
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); //main frame에서 추가된 요소들을 (add(x)) paintComponents(g)를 통해서 그려짐
		this.repaint();
		// int i = 1;
		// System.out.println(i);
	}
	
	public void selectTrack(int nowSelected)
	{
		if (selectedMusic != null) //selectedMusic이 이미 한 music object를 담고 있고 실행되고 있다면,
		{
			selectedMusic.close();
		}
		
		titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}
	
	public void selectLeft()
	{
		if (nowSelected == 0)
		{
			nowSelected = trackList.size() - 1;
		}
		else
		{
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	public void selectRight()
	{
		if (nowSelected == trackList.size() - 1)
		{
			nowSelected = 0;
		}
		else
		{
			nowSelected++;
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty)
	{
		if (selectedMusic != null) //selectedMusic이 이미 한 music object를 담고 있고 실행되고 있다면,
		{
			selectedMusic.close();
		}
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage())).getImage();
	}
}
