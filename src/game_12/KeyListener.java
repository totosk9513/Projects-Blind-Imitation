package game_12;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter
{
	@Override
	public void keyPressed(KeyEvent e) //KeyEvent�� Ű�� ���� ����, Ű�� �� ���� �߻���.
	{
		if(DynamicBeat.game == null)
		{
			return;
		}
		/*
		switch(e.getKeyCode())
		{
		
		}*/
		if(e.getKeyCode() == KeyEvent.VK_S) //���� ���� Ű�� "s"�ϰ��
		{
			//System.out.println("S pressed");
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) //���� ���� Ű�� "D"�ϰ��
		{
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) //���� ���� Ű�� "F"�ϰ��
		{
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) //���� ���� Ű�� "Space"�ϰ��
		{
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) //���� ���� Ű�� "J"�ϰ��
		{
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) //���� ���� Ű�� "K"�ϰ��
		{
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) //���� ���� Ű�� "L"�ϰ��
		{
			DynamicBeat.game.pressL();
		}
	}
	@Override
	public void keyReleased(KeyEvent e)//KeyEvent�� Ű�� ���� ����, Ű�� �� ���� �߻���.
	{
		if(DynamicBeat.game == null)
		{
			return;
		}
		/*
		switch(e.getKeyCode())
		{
		
		}*/
		if(e.getKeyCode() == KeyEvent.VK_S) //���� ���� Ű�� "s"�ϰ��
		{
			//System.out.println("S released");
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) //���� ���� Ű�� "s"�ϰ��
		{
			DynamicBeat.game.releaseL();
		}
	}
	
}
