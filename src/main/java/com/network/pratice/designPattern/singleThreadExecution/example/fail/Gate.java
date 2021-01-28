package com.network.pratice.designPattern.singleThreadExecution.example.fail;

public class Gate {
	private long index = 0;
	private String name ="Nobody";
	private String address = "Nowhere";
	
	public void pass(String name, String address) {
		this.index++;
		this.name = name;
		this.address = address;
		check();
	}

	public void check() {
		if(name.charAt(0) != address.charAt(0)) {
			System.out.println("******BROKEN****** : " + toString());
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return sb.append("No.")
				 .append(this.index)
				 .append(" name : ")
				 .append(this.name)
				 .append(", address : ")
				 .append(this.address).toString();
	}
}
