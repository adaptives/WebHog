package com.diycomputerscience.webhog;

public class CPUHogData {
	private long totalRunningTime;
	private long analysis1RunningTime;
	private long analysis2RunningTime;
	
	public CPUHogData() {
		
	}

	public long getTotalRunningTime() {
		return totalRunningTime;
	}

	public void setTotalRunningTime(long totalRunningTime) {
		this.totalRunningTime = totalRunningTime;
	}

	public long getAnalysis1RunningTime() {
		return analysis1RunningTime;
	}

	public void setAnalysis1RunningTime(long analysis1RunningTime) {
		this.analysis1RunningTime = analysis1RunningTime;
	}

	public long getAnalysis2RunningTime() {
		return analysis2RunningTime;
	}

	public void setAnalysis2RunningTime(long analysis2RunningTime) {
		this.analysis2RunningTime = analysis2RunningTime;
	}

	@Override
	public String toString() {
		return "CPUHog Data : " + this.analysis1RunningTime + " + "  + this.analysis2RunningTime + " = " + this.totalRunningTime;
	}
}
