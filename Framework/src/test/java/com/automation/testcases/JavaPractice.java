package com.automation.testcases;

public class JavaPractice {
 public static void main(String[] args) {
	 
	String s1= "suhaib";
	String s2= "musaib";
	
	for(int i=0; i<s1.length(); i++) {
		char s3 = s1.charAt(i);
		int count=0;
		for(int j=0; j<s2.length(); j++) {
			 char s4 = s2.charAt(j);
			 
			 if(s3==s4) {
				 count=1;
				 j++;
			 }
			
			 else if(s3!=s4) {
				 count=2;
				 break;
				 }
			 
			 if(count==2) {
				 System.out.println(s3);
				 count=0;
			 }
		
		}
		}
		
	}
	
 }
 
