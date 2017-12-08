package com.psl;
import java.lang.Character;
public class Client 
{
	public String convertToTitle(String string)
	{
	
		//Write the code here to Convert the String to title case
		boolean toggle = true;
		int i=0;
		char[] characters = string.toCharArray();
		int len = characters.length;
		for(i=0;i<len;i++)
		{
			if(characters[i] == ' ')
				toggle=true;
			else if(!toggle)
			{
				characters[i]=Character.toLowerCase(characters[i]);

			}
			else if(toggle)
			{
				characters[i]=Character.toUpperCase(characters[i]);
				toggle=false;
			}
		}
        return String.valueOf(characters);

     }
	
	public static void main(String[] args) 
	{
		Client demo = new Client();
		System.out.println(demo.convertToTitle("pErSIStEnt sYstem LTD"));
	}
}
