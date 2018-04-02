package com.abhig.questions;

import java.util.Arrays;

final public class ImmutableString {

	private final char[] ch;
	private int start;
	private int end;
	
	ImmutableString(char ch[]) {
		this.ch = Arrays.copyOf(ch,ch.length);
		start = 0;
		end = ch.length;
	}
	
	private ImmutableString(char ch[], int start, int end) {
		this.ch = ch;
		this.start = start;
		this.end = end;
	}
	
	ImmutableString substring(int start, int end) {
		if(start<0 || end > this.end || end-start <0 ) {
			throw new RuntimeException("invalid arguments");
		}
		return new ImmutableString(this.ch, start, end);
		
	}
	public String toString() {
		String s = "";
		for(int i=start;i<end;i++) {
			s += this.ch[i];
		}
		return s;
		
	}
	
	public static void main(String st[]) {
		char ch[] = {'a','b','c','d'};
		ImmutableString s = new ImmutableString(ch);
		ImmutableString sub = s.substring(0, 1);
		ImmutableString ssub = sub.substring(0, 1);

		System.out.println(s+"  "+sub+" "+ssub);
		
		
	}
	
	
}
