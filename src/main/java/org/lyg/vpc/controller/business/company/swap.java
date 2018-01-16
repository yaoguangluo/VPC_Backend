package org.lyg.vpc.controller.business.company;

public class swap
{
	 public static String swap(String input)
	 {

		 char[] input_char=input.toCharArray();
		 char[] output= new char[input_char.length];
		 for(int i=0;i<input.length();i++)
		 {
			 output[i]=input_char[input.length()-1-i];
		 }
		
		 
		 
		 
		 
		 return String.valueOf(output);
	 }

 //    public static void main(String[] argv)
    		 {
    	            System.out.println(swap("tesst"));          
    		 }
}
