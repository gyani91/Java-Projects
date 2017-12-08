package com.psl;

public class Client {

	
	public String[] getTokens(String data){
		String arr[]=data.split(" ");
		return arr;
		
	}
	
	public String reverseAndAppend(String [] data){
		String str="";
		for(String s:data){
			StringBuffer  string= new StringBuffer(s);
			str=str+string.reverse()+" ";
		}
		return str.trim();
	}
	
	public static void main(String[] args) {
		String myString ="This is the MyPassion Challenge Test";
		Client demo=new Client();
		System.out.println(demo.reverseAndAppend(demo.getTokens(myString)));
		

	}

}
