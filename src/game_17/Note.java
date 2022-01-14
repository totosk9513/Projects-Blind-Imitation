package game_17;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread
{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; 
	// Thread.sleep은 0.001초 기준. 1000이면 1초, 설정해둔 SLEEP_TIME 은 10, 그러면 쓰레드 frequency for 1 sec = 100
	// 고로 1초전 노트의 위치는 100 X 7 = 700, 580 - 700 = -120.
	private String noteType;
	private boolean proceeded = true;
	
	public String getNoteType()
	{
		return noteType;
	}
	
	public boolean isProceeded() //getter함수
	{
		return proceeded;
	}
	
	public void close() //만약 노트 hit시, 그 노트는 사라져야 하니깐, proceeded를 false로 하고 그래픽에서 삭제(?)
	{
		proceeded = false;
	}
	
	
	
	public Note(String noteType)
	{
		if (noteType.equals("S"))
		{
			x = 228;
		}
		else if (noteType.equals("D"))
		{
			x = 332;
		}
		else if (noteType.equals("F"))
		{
			x = 436;
		}
		else if (noteType.equals("Space"))
		{
			x = 540;
		}
		else if (noteType.equals("J"))
		{
			x = 744;
		}
		else if (noteType.equals("K"))
		{
			x = 848;
		}
		else if (noteType.equals("L"))
		{
			x = 952;
		}
		this.noteType = noteType;
		
	}
	
	public void screenDraw(Graphics2D g)
	{
		if(noteType.equals("Space") == false) //일반 타입 일 경우
		{
			g.drawImage(noteBasicImage, x, y, null); //short타입 노트를 그림
		}
		else // note for space
		{
			g.drawImage(noteBasicImage, x, y, null); //space를 위한 긴 노트 구현: 왼쪽부분
			g.drawImage(noteBasicImage, x + 100, y, null);//오른쪽 부분
		}
	}
	
	public void drop()
	{
		y += Main.NOTE_SPEED; //노트의 y좌표가 NOTE_SPEED 만큼 내려감.
		if (y > 620)
		{
			System.out.println("Miss");
			close(); //proceeded가 false로 바뀌면서 쓰레드도 도중 종료
		}
	}
	
	@Override
	public void run() //쓰레드 작동
	{
		//System.out.println(y);
		try
		{
			while (true && !isInterrupted())
			{
				drop();
				if (proceeded == true)
				{
					Thread.sleep(Main.SLEEP_TIME); //쓰레드가 한번 노트를 움직이고 SLEEP_TIME 만큼 쉼
												//Thread.sleep은 0.001초 기준, SLEEP_TIME이 10이기 때문에, 
												// 0.01초만큼 쓰레드가 노트의 Y위치를 NOTE_SPEED(7) 바꿈.(떨어뜨리는 모션)
												// 즉, 1초에 700 pixel만큼 노트가 떨어지는 모션을 가지게됨.
				}
				else
				{
					interrupt(); //그 노트의 쓰레드 도중 종료. (그러면서 그래픽draw도 멈추게됨)
					break; //run도 반복문이 끝나면서 작동 중단
				}
				
				//System.out.println(y);
			}
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public String judge()
	{
		if (y >= 613)
		{
			System.out.println("Late");
			close();
			return "Late";
		}
		else if (y >= 600)
		{
			System.out.println("Good");
			close();
			return "Good";
		}
		else if (y >= 587)
		{
			System.out.println("Great");
			close();
			return "Great";
		}
		else if (y >= 573)
		{
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if (y >= 565)
		{
			System.out.println("Great");
			close();
			return "Great";
		}
		else if (y >= 550)
		{
			System.out.println("Good");
			close();
			return "Good";
		}
		else if (y >= 535)
		{
			System.out.println("Early");
			close();
			return "Early";
		}
		else
		{
			return "None";
		}
	}
	
	public int getY()
	{
		return y;
	}
}
