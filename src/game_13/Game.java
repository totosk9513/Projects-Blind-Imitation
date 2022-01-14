package game_13;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread
{
	//private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	public Game(String titleName, String difficulty, String musicTitle)
	{
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		gameMusic.start();
		dropNotes(titleName);
	}

	public void screenDraw(Graphics2D g)
	{
		//line routes
		g.drawImage(noteRouteSImage, 228, 30, null);//left 3 lines
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		
		g.drawImage(noteRouteSpace1Image, 540, 30, null);//space
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		
		g.drawImage(noteRouteJImage, 744, 30, null);//right 3 lines
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		
		//line borders
		g.drawImage(noteRouteLineImage, 224, 30, null);//left 3 lines
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		
		g.drawImage(noteRouteLineImage, 536, 30, null); //space
		g.drawImage(noteRouteLineImage, 740, 30, null);
		
		g.drawImage(noteRouteLineImage, 844, 30, null);//right 3 lines
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		//others
		g.drawImage(gameInfoImage, 0 , 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		
		//notes drawing
		for (int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			note.screenDraw(g);
		}
		System.out.println("gameloop");
		
		//notes(test)
		//g.drawImage(noteBasicImage, 228, 120, null);
		//
		
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30)); //글꼴체, 글꼴스타일, 폰트크기
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		
		g.setFont(new Font("Arial", Font.PLAIN, 26)); //폰트세팅 변경.
		g.setColor(Color.DARK_GRAY); //폰트 색상도 변경(정확히는 그려주는 object인 g의 색상변수 변경)
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30)); //폰트세팅 변경.
		g.drawString("000000", 565, 702); //들어갈 String, x좌표, y좌표

		
	}
	//S
	public void pressS()
	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseS()
	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	//D
	public void pressD()
	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseD()
	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	//F
	public void pressF()
	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseF()
	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	//Space
	public void pressSpace()
	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
		
	}
	public void releaseSpace()
	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	//J
	public void pressJ()
	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseJ()
	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	//K
	public void pressK()
	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseK()
	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	//L
	public void pressL()
	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseL()
	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}
	
	
	@Override
	public void run()
	{
		
	}
	
	public void close()
	{
		gameMusic.close();
		this.interrupt(); //게임 쓰레드 종료 
	}
	
	public void dropNotes(String titleName)
	{
		Note note = new Note(228, "short");
		note.start();
		noteList.add(note);
		/*
		noteList.add(new Note(228, 120, "short"));
		noteList.add(new Note(332, 580, "short"));
		noteList.add(new Note(436, 500, "short"));
		
		noteList.add(new Note(540, 340, "long"));
		
		noteList.add(new Note(744, 325, "short"));
		noteList.add(new Note(848, 305, "short"));
		noteList.add(new Note(952, 305, "short"));
		*/
	}
	
}