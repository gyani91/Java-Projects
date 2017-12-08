package com.psl;

public class Client {

	public String convertToTitle(String string){
		String result = "";
        for (int i = 0; i < string.length(); i++){
            String next = string.substring(i, i + 1);
            
            if (i == 0){
                result += next.toUpperCase();
            } else {
            	if(string.charAt(i-1)== ' '){
            		result += next.toUpperCase();
            	}else{
            		result += next.toLowerCase();
            	}
            }
        }
        return result;

        
	}
		public static void main(String[] args) {
			Client demo=new Client();
			System.out.println(demo.convertToTitle("wel come to Java"));
		}
}
