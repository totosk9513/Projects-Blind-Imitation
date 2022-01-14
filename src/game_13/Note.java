package game_13;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread
{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y;// = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED); 
	// Thread.sleep은 0.001초 기준. 1000이면 1초, 설정해둔 SLEEP_TIME 은 10, 그러면 쓰레드 frequency for 1 sec = 100
	// 고로 1초전 노트의 위치는 100 X 7 = 700, 580 - 700 = -120.
	private String noteType;
	
	public Note(int x, String noteType)
	{
		this.x = x; //x, x좌표
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g)
	{
		if(noteType.equals("short"))
		{
			g.drawImage(noteBasicImage, x, y, null); //short타입 노트를 그림
		}
		else if (noteType.equals("long")) // note for space
		{
			g.drawImage(noteBasicImage, x, y, null); //space를 위한 긴 노트 구현: 왼쪽부분
			g.drawImage(noteBasicImage, x + 100, y, null);//오른쪽 부분
		}
	}
	
	public void drop()
	{
		y += Main.NOTE_SPEED; //노트의 y좌표가 NOTE_SPEED 만큼 내려감.
	}
	
	@Override
	public void run() //쓰레드 작동
	{
		System.out.println(y);
		try
		{
			while (true)
			{
				drop();
				Thread.sleep(Main.SLEEP_TIME); //쓰레드가 한번 노트를 움직이고 SLEEP_TIME 만큼 쉼
												//Thread.sleep은 0.001초 기준, SLEEP_TIME이 10이기 때문에, 
												// 0.01초만큼 쓰레드가 노트의 Y위치를 NOTE_SPEED(7) 바꿈.(떨어뜨리는 모션)
												// 즉, 1초에 700 pixel만큼 노트가 떨어지는 모션을 가지게됨.
				//System.out.println(y);
			}
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
