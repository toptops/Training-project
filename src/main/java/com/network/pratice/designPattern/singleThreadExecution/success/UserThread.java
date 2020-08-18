package com.network.pratice.designPattern.singleThreadExecution.success;

public class UserThread extends Thread{
	private final Gate gate;
	private final String myName;
	private final String myaddress;
	
	public UserThread(Gate gate, String myName, String myaddress) {
		this.gate = gate;
		this.myName = myName;
		this.myaddress = myaddress;
	}
	
	@Override
	public void run() {
		System.out.println(myName + " BEGIN");
		while(true) {
			gate.pass(myName, myaddress);
		}
	}
}
