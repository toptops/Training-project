package com.network.pratice.secure_guide.provideToImmutable;

public class badCode1 extends Mutable{
	
	/**
	 * get,set �Լ��� ���ؼ� �����͸� ������ �� �ִ�.
	 * �׷��Ƿ� �Һ����� �����Ѵ�.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		badCode1 mutable = new badCode1();
		
		// ���� ����� ���� ����1
		mutable.getArray()[0] = 1;
		
		// set�Լ��� ���� ����2
		mutable.setArray(new int[10]);
		
	}
}
