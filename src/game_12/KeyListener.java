package game_12;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter
{
	@Override
	public void keyPressed(KeyEvent e) //KeyEvent는 키를 누를 때도, 키를 뗄 때도 발생함.
	{
		if(DynamicBeat.game == null)
		{
			return;
		}
		/*
		switch(e.getKeyCode())
		{
		
		}*/
		if(e.getKeyCode() == KeyEvent.VK_S) //현재 누른 키가 "s"일경우
		{
			//System.out.println("S pressed");
			DynamicBeat.game.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) //현재 누른 키가 "D"일경우
		{
			DynamicBeat.game.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) //현재 누른 키가 "F"일경우
		{
			DynamicBeat.game.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) //현재 누른 키가 "Space"일경우
		{
			DynamicBeat.game.pressSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) //현재 누른 키가 "J"일경우
		{
			DynamicBeat.game.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) //현재 누른 키가 "K"일경우
		{
			DynamicBeat.game.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) //현재 누른 키가 "L"일경우
		{
			DynamicBeat.game.pressL();
		}
	}
	@Override
	public void keyReleased(KeyEvent e)//KeyEvent는 키를 누를 때도, 키를 뗄 때도 발생함.
	{
		if(DynamicBeat.game == null)
		{
			return;
		}
		/*
		switch(e.getKeyCode())
		{
		
		}*/
		if(e.getKeyCode() == KeyEvent.VK_S) //현재 누른 키가 "s"일경우
		{
			//System.out.println("S released");
			DynamicBeat.game.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_SPACE) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseSpace();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) //현재 누른 키가 "s"일경우
		{
			DynamicBeat.game.releaseL();
		}
	}
	
}
