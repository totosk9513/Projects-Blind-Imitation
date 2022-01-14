package game_6;

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
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Start Image.png")).getImage();
	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Mighty Love Title Image.png")).getImage();
	
	
	
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
	
	
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private boolean isMainScreen = false;
	
	
	private int mouseX, mouseY;
	

	public DynamicBeat() 
	{
		setUndecorated(true); //�⺻������ windows���� �����Ǵ� menu bar�� �����
		setTitle("Dynamic Beat"); //windows���� ����ɶ� title�̸� 
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //���α׷� â ũ�� initialize
		setResizable(false); //���α׷� â ������ ���� ����
		setLocationRelativeTo(null); //���α׷� â�� ����� �� �߾�(null)�� ��ġ
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���� ���α׷��� ����
		setVisible(true); //���α׷� â�� ����
		setBackground(new Color(0, 0, 0, 0)); //decoration���� ��޵�, paintcomponent�� ������ ����� ȸ���� �ƴ� ���(?)���� �ٲ���
		setLayout(null); //layout(null)�� �ؾ� ��ư, �Ŵ� ����� �����س��� ���ڸ��� ��.

		exitButton.setBounds(1245, 0, 30, 30); //��ġ,��ġ,ũ��,ũ��
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //���콺 Ŀ���� �ö�����
			{
				exitButton.setIcon(exitButtonEnteredImage); //�̹��� ����
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ���� hand_cursor�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //���콺 Ŀ���� ������ ������ ��������
			{
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ���� default_cursor�� �ٽ� ����
			}
			@Override
			public void mousePressed(MouseEvent e) //���콺 Ŭ���� ������
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
				System.exit(0); //���α׷� ����
			}
		});
		add(exitButton);
		
		
		startButton.setBounds(40, 200, 400, 100); //x��ġ,y��ġ,xũ��,yũ��
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //���콺 Ŀ���� �ö�����
			{
				startButton.setIcon(startButtonEnteredImage); //�̹��� ����
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ���� hand_cursor�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //���콺 Ŀ���� ������ ������ ��������
			{
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ���� default_cursor�� �ٽ� ����
			}
			@Override
			public void mousePressed(MouseEvent e) //���콺 Ŭ���� ������
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 330, 400, 100); //x��ġ,y��ġ,xũ��,yũ��
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //���콺 Ŀ���� �ö�����
			{
				quitButton.setIcon(quitButtonEnteredImage); //�̹��� ����
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ���� hand_cursor�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //���콺 Ŀ���� ������ ������ ��������
			{
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ���� default_cursor�� �ٽ� ����
			}
			@Override
			public void mousePressed(MouseEvent e) //���콺 Ŭ���� ������
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
				System.exit(0); //���α׷� ����
			}
		});
		add(quitButton);
		
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60); //x��ġ,y��ġ,xũ��,yũ��
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //���콺 Ŀ���� �ö�����
			{
				leftButton.setIcon(leftButtonEnteredImage); //�̹��� ����
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ���� hand_cursor�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //���콺 Ŀ���� ������ ������ ��������
			{
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ���� default_cursor�� �ٽ� ����
			}
			@Override
			public void mousePressed(MouseEvent e) //���콺 Ŭ���� ������
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//���� ��ư �̺�Ʈ
			}
		});
		add(leftButton);
		
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60); //x��ġ,y��ġ,xũ��,yũ��
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent e) //���콺 Ŀ���� �ö�����
			{
				rightButton.setIcon(rightButtonEnteredImage); //�̹��� ����
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //���콺 Ŀ���� hand_cursor�� ����
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) //���콺 Ŀ���� ������ ������ ��������
			{
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); //���콺 Ŀ���� default_cursor�� �ٽ� ����
			}
			@Override
			public void mousePressed(MouseEvent e) //���콺 Ŭ���� ������
			{
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3", false);
				buttonPressedMusic.start();
				//������ ��ư �̺�Ʈ
			}
		});
		add(rightButton);
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e)   //���콺 Ŀ���� ��� ��������
			{
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() 
		{
			@Override
			public void mouseDragged(MouseEvent e) //���콺 Ŀ���� ��� ������/�巡�� �ϸ�
			{
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation (x - mouseX, y - mouseY); //�Ŵ��ٸ� ��� �����̸� ���α׷� â�� �����̰� ����
			}
		}
				);
		add(menuBar);
	
		

		Music introMusic = new Music("introMusic.mp3", true);
		introMusic.start();
	}

	public void paint(Graphics g) // �̹� library�� ���� �������ִ� ����.
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
		g.drawImage(background, 0, 0, null); //��׶��� ���� draw
		if (isMainScreen == true) //���� mainscreen = true, �׷��� ��׶��� ���� selected image draw
		{
			g.drawImage(selectedImage, 340, 100, null); //selectedImage�� 340,100ũ��, null = ���� �߾ӿ� draw.
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g); //main frame���� �߰��� ��ҵ��� (add(x)) paintComponents(g)�� ���ؼ� �׷���
		this.repaint();
		// int i = 1;
		// System.out.println(i);
	}
}
