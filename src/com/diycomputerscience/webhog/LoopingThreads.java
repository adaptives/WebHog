package com.diycomputerscience.webhog;

import java.util.ArrayList;
import java.util.List;

public class LoopingThreads {
	
	private List<Worker> workers = new ArrayList<Worker>();
	
	public LoopingThreads() {
		
	}
	
	public void loopEm() {
		Worker w1 = new Worker(1000);
		this.workers.add(w1);
		Worker w2 = new Worker(10);
		this.workers.add(w2);
		Worker w3 = new Worker(100);
		this.workers.add(w3);
		Worker w4 = new Worker(-1);
		this.workers.add(w4);
		Worker w5 = new Worker(-1);
		this.workers.add(w5);
		for(int i=0; i<this.workers.size(); i++) {
			//do not start threads without a name
			Thread t = new Thread(workers.get(i));

			//try and use this instead
			//Thread t = new Thread(workers.get(i), "worker " + i);			
			
			t.start();
		}
	}
}
