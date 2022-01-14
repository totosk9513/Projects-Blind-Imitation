package game_14;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread
{
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME; 
	// Thread.sleep�� 0.001�� ����. 1000�̸� 1��, �����ص� SLEEP_TIME �� 10, �׷��� ������ frequency for 1 sec = 100
	// ��� 1���� ��Ʈ�� ��ġ�� 100 X 7 = 700, 580 - 700 = -120.
	private String noteType;
	
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
		if(noteType.equals("Space") == false) //�Ϲ� Ÿ�� �� ���
		{
			g.drawImage(noteBasicImage, x, y, null); //shortŸ�� ��Ʈ�� �׸�
		}
		else // note for space
		{
			g.drawImage(noteBasicImage, x, y, null); //space�� ���� �� ��Ʈ ����: ���ʺκ�
			g.drawImage(noteBasicImage, x + 100, y, null);//������ �κ�
		}
	}
	
	public void drop()
	{
		y += Main.NOTE_SPEED; //��Ʈ�� y��ǥ�� NOTE_SPEED ��ŭ ������.
	}
	
	@Override
	public void run() //������ �۵�
	{
		System.out.println(y);
		try
		{
			while (true)
			{
				drop();
				Thread.sleep(Main.SLEEP_TIME); //�����尡 �ѹ� ��Ʈ�� �����̰� SLEEP_TIME ��ŭ ��
												//Thread.sleep�� 0.001�� ����, SLEEP_TIME�� 10�̱� ������, 
												// 0.01�ʸ�ŭ �����尡 ��Ʈ�� Y��ġ�� NOTE_SPEED(7) �ٲ�.(����߸��� ���)
												// ��, 1�ʿ� 700 pixel��ŭ ��Ʈ�� �������� ����� �����Ե�.
				//System.out.println(y);
			}
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
		}
	}
}
