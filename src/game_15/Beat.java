package game_15;

public class Beat 
{
	private int time; //���� ��Ʈ�� ����?
	private String noteName; //��Ʈ Ÿ�� ( sdf space jkl...)
	
	
	public Beat(int time, String noteName)  
	{
		super();
		this.time = time;
		this.noteName = noteName;
	}

	public int getTime() 
	{
		return time;
	}
	
	public void setTime(int time) 
	{
		this.time = time;
	}
	
	public String getNoteName() 
	{
		return noteName;
	}
	
	public void setNoteName(String noteName) 
	{
		this.noteName = noteName;
	}
	
	
	
}
