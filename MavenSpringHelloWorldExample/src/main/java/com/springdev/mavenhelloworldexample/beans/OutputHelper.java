package com.springdev.mavenhelloworldexample.beans;

public class OutputHelper {

	private IOutputGenerator outputGenerator;
	
	public void setOutputGenerator(IOutputGenerator outputGenerator) {
		this.outputGenerator = outputGenerator;
	}
	
	public void generateOutput() {
		outputGenerator.generateOutput();
	}
	
}
