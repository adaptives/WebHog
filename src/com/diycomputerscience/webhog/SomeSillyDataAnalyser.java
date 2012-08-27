package com.diycomputerscience.webhog;

public class SomeSillyDataAnalyser {
	private CPUHogData cpuHogData;
	private boolean sysout;
	private int analysis1LoopCount;
	private int analysis2LoopCount;
	
	public SomeSillyDataAnalyser(int analysis1LoopCount, 
								 int analysis2LoopCount, 
								 boolean sysout) {
		this.analysis1LoopCount = analysis1LoopCount;
		this.analysis2LoopCount = analysis2LoopCount;
		this.sysout = sysout;
		this.cpuHogData = new CPUHogData();
	}
	
	public CPUHogData analyse() {
		long startTime = System.currentTimeMillis();
		analysis1();
		analysis2();
		long endTime = System.currentTimeMillis();
		this.cpuHogData.setTotalRunningTime(endTime - startTime);
		return cpuHogData;
	}
	
	private void analysis1() {
		long start = System.currentTimeMillis();
		
		if(this.sysout) {			
			String msg = "In analysis 1 - will loop " + this.analysis1LoopCount + " times ";
			System.out.println(msg);
		}
		
		for(int i=0 ;i<this.analysis1LoopCount; i++) {
			if(this.sysout) {
				System.out.println("analysis 1 " + i);
			}			
			try { Thread.sleep(4); } catch(Exception e) {}
		}
		long end = System.currentTimeMillis();
		this.cpuHogData.setAnalysis1RunningTime((end-start));
	}
	
	private void analysis2() {
		long start = System.currentTimeMillis();
		
		if(this.sysout) {			
			String msg = "In analysis 2 - will loop " + this.analysis2LoopCount + " times ";
			System.out.println(msg);
		}
		
		for(int i=0 ;i<this.analysis2LoopCount; i++) {
			if(this.sysout) {
				System.out.println("analysis 2 " + i);
			}
			
			try { Thread.sleep(4); } catch(Exception e) {}
		}
		long end = System.currentTimeMillis();
		this.cpuHogData.setAnalysis2RunningTime((end-start));
	}
}
