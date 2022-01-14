package game_16;

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
	
	private Image flareImage1 = new ImageIcon(Main.class.getResource("../images/flare1.png")).getImage();
	private Image flareImage2 = new ImageIcon(Main.class.getResource("../images/flare2.png")).getImage();
	private Image blueFlareImage;
	
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	
	private Image judgeImage;
	
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	private int score = 0;
	
	boolean interrupted = false;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	public Game(String titleName, String difficulty, String musicTitle)
	{
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
		//gameMusic.start();
		//dropNotes(titleName);
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
			if (note.getY() > 620 )//필요 있나???
			{
				judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if(note.isProceeded() == false)
			{
				noteList.remove(i);
				i--;
			}
			else
			{
				note.screenDraw(g);
			}
			//System.out.print(i + " ");			
		}
		//System.out.println("gameloop");
		
		
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
		g.drawString(Integer.toString(score), 565, 702); //들어갈 String, x좌표, y좌표
		
		g.drawImage(blueFlareImage, -100, -100, null);
		g.drawImage(judgeImage, 460, 420, null);
		
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
		
		
	}
	//S
	public void pressS()
	{
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseS()
	{
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	//D
	public void pressD()
	{
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseD()
	{
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		
	}
	//F
	public void pressF()
	{
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseF()
	{
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	//Space
	public void pressSpace()
	{
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
		
	}
	public void releaseSpace()
	{
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	//J
	public void pressJ()
	{
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseJ()
	{
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	//K
	public void pressK()
	{
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseK()
	{
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	//L
	public void pressL()
	{
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}
	public void releaseL()
	{
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}
	
	
	@Override
	public void run() //이 메소드가 start할때 run부터 실행 시작... 그래서 dropnotes가
	{
		dropNotes(this.titleName);// 쓰레드란, 절차지향의 순서를 무조건 따르지 않고 자신만의 코드 절차를 실행시킬수 있는 것. 
								//쓰레드를 이용하면, 한번에 여러 프로세스를 실행 하게 할수 있음 
								//(절차지향은 무조건 코드 순서를 따라야하지만 쓰레드로 무시가 됨)
								//추측: dropNote에 while()문이 하나 있음. 
								//쓰레드를 사용하지 않으면이 while문이 끝날때 까지 다음 코드가 작동을 할 수가 없음
								//그러나 dropnote를 쓰레드로 보내주면 dropnote의 while문이 실행하면서도 그 다음 코드로 프로세스를 진행 함
	}
	
	public void close()
	{
		gameMusic.close();
		for (int i = 0; i < noteList.size(); i++)//노트떨어지는것도 모두다 interrupt.
		{
			Note note = noteList.get(i);
			note.interrupt();
		}
		this.interrupt(); //게임 쓰레드 종료 
	}
	
	public void dropNotes(String titleName)
	{
		System.out.println("Game start");
		Beat[] beats = null;
		if(titleName.equals("Joakim Kaurd - Mighty Love") && difficulty.equals("Easy"))
		{
			int startTime = 4460 - (Main.REACH_TIME * 1000);
			int gap = 125; //최소리듬/박자 단위
			beats = new Beat[]
					{
							new Beat(startTime, "S"),
							new Beat(startTime + (gap * 2), "D"),
							new Beat(startTime + (gap * 4), "S"),
							new Beat(startTime + (gap * 6), "D"),
							new Beat(startTime + (gap * 8), "S"),
							new Beat(startTime + (gap * 10), "D"),
							new Beat(startTime + (gap * 12), "S"),
							new Beat(startTime + (gap * 14), "D"),
							new Beat(startTime + (gap * 18), "J"),
							new Beat(startTime + (gap * 20), "K"),
							new Beat(startTime + (gap * 22), "J"),
							new Beat(startTime + (gap * 24), "K"),
							new Beat(startTime + (gap * 26), "J"),
							new Beat(startTime + (gap * 28), "K"),
							new Beat(startTime + (gap * 30), "J"),
							new Beat(startTime + (gap * 32), "K"),
							new Beat(startTime + (gap * 36), "S"),
							new Beat(startTime + (gap * 38), "D"),
							new Beat(startTime + (gap * 40), "S"),
							new Beat(startTime + (gap * 42), "D"),
							new Beat(startTime + (gap * 44), "S"),
							new Beat(startTime + (gap * 46), "D"),
							new Beat(startTime + (gap * 48), "J"),
							new Beat(startTime + (gap * 49), "K"),
							new Beat(startTime + (gap * 50), "L"),
							new Beat(startTime + (gap * 52), "F"),
							new Beat(startTime + (gap * 52), "Space"),
							new Beat(startTime + (gap * 52), "J"),
							
														
					};
		}
		else if (titleName.equals("Joakim Karud - Mighty Love") && difficulty.equals("Hard"))
		{
			int startTime = 1000;
			beats = new Beat[]
					{
							new Beat(startTime, "Space")
					};
		}
		else if (titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Easy"))
		{
			int startTime = 1000;
			beats = new Beat[]
					{
							new Beat(startTime, "Space")
					};
		}
		else if (titleName.equals("Joakim Karud - Wild Flower") && difficulty.equals("Hard"))
		{
			int startTime = 1000;
			beats = new Beat[]
					{
							new Beat(startTime, "Space")
					};
		}
		else if (titleName.equals("Bendsound - Energy") && difficulty.equals("Easy"))
		{
			int startTime = 1000;
			beats = new Beat[]
					{
							new Beat(startTime, "Space")
					};
		}
		else if (titleName.equals("Bendsound - Energy") && difficulty.equals("Hard"))
		{
			int startTime = 1000;
			beats = new Beat[]
					{
							new Beat(startTime, "Space")
					};
		}
		
		gameMusic.start();
		
		int i = 0; //for loop
		while(i < beats.length && !isInterrupted())
		{
			//System.out.println("Drop loop start");
			boolean dropped = false;
			if(beats[i].getTime() <= gameMusic.getTime()) //왜 <=??
			{
				Note note = new Note(beats[i].getNoteName());
				note.start(); //노트 쓰레드 작동 시작.
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(dropped == false)
			{
				try
				{
					Thread.sleep(5);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void judge(String input)
	{
		for (int i = 0; i < noteList.size(); i++)
		{
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType()))
			{
				//score = score + note.judge();
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent(String judge)
	{
		if(judge.equals("None") == false)
		{
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/blueFlare.png")).getImage();
		}
		if(judge.equals("Miss"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();//이게 필요하나?
			
		}
		else if(judge.equals("Late"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
		}
		else if(judge.equals("Good"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
		}
		else if(judge.equals("Great"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
		}
		else if(judge.equals("Perfect"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
		}
		else if(judge.equals("Early"))
		{
			judgeImage  = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
		}
		
	}
	
}