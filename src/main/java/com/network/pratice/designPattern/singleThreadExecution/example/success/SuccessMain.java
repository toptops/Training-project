package com.network.pratice.designPattern.singleThreadExecution.example.success;

import com.network.pratice.designPattern.singleThreadExecution.example.success.Gate;
import com.network.pratice.designPattern.singleThreadExecution.example.success.UserThread;

public class SuccessMain {
	public static void main(String[] args) {
		System.out.println("Testing Gate, hit CTRL+C to exit");
		Gate gate = new Gate();
		new UserThread(gate, "Alice", "Alaska").start();
		new UserThread(gate, "Bobby", "Brazil").start();
		new UserThread(gate, "Chris", "Canada").start();
	}
}
