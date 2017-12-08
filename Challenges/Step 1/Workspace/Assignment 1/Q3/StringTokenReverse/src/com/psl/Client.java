package com.psl;
import java.util.StringTokenizer;

public class Client {

	public String[] getTokens(String data) 
	{
		//Write a code here to tokenize the words in the given String and return an array of words
		StringTokenizer str = new StringTokenizer(data);
		String[] tokens = new String[str.countTokens()];
		int i =0;
		while(str.hasMoreElements())
		{
			tokens[i]=str.nextToken();
			i++;
		}
		return tokens;
	}

	public String reverseAndAppend(String[] data) 
	{
		//Write a code here to reverse and append the words in the passed array
		StringBuilder appended = new StringBuilder();
		int len=data.length;
		for(int i=0;i<len;i++)
		{
			data[i] = new StringBuilder(data[i]).reverse().toString();
		}
		
		for(String s : data)
		{
			appended.append(s + " ");
		}
		return appended.toString();
	}

	public static void main(String[] args) 
	{
		//Check your code by calling methods from here
		Client client=new Client();
		String[] tokens=client.getTokens("Hello World");
		System.out.println(client.reverseAndAppend(tokens));		
		
	}

}
