package com.diycomputerscience.webhog;

import java.util.ArrayList;
import java.util.List;

public class SimpleWidgetFactory extends WidgetFactory {
	private int count;
	private int times;	
	
	private long startTime;
	private long endTime;
	
	public SimpleWidgetFactory(int times, int count) {
		this.count = count;
		this.times = times; 
	}
	
	public void startFactory() {		
		this.startTime = System.currentTimeMillis();
		try { Thread.sleep(5000); } catch(Exception e) {}
		for(int i=0; i<this.times; i++) {
			makeWidgets(count);
		}
		
		this.endTime = System.currentTimeMillis();
	}
	
	public long timeTaken() {
		return this.endTime - this.startTime;
	}
	
	private void makeWidgets(int count) {
		List<Widget> widgets = new ArrayList<Widget>();
		for(int j=0; j<count; j++) {
			try { Thread.sleep(10); } catch(Exception e) {}
			widgets.add(new Widget());
		}
	}
}
