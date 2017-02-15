package com.pipe.iccraw.app;

import java.util.Date;
import java.util.Timer;

public class App {
	static{
		Timer timer ;
		timer = new Timer();
		timer.schedule(new TaskThreadHelp(), new Date(), 1*1000*15);
	}
	public static void main(String[] args) {
		System.out.println("begin...........");
	}
}
