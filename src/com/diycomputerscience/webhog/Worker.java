package com.diycomputerscience.webhog;

public class Worker implements Runnable {
	
	long startTime;
	long duration;
	
	public Worker(long duration) {
		this.startTime = System.currentTimeMillis();
		this.duration = duration;
	}
	
	@Override
	public void run() {
		while(!endCondition()) {
			try { Thread.sleep(10); } catch(Exception e) {}
			System.out.print(".");
		}		
	}

	private boolean endCondition() {
		if(this.duration > -1) {
			long diff = System.currentTimeMillis() - this.startTime;
			if(diff > duration) {
				return true;
			}
		}
		return false;
	}

}
