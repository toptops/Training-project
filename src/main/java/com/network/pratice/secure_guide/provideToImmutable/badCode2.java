package com.network.pratice.secure_guide.provideToImmutable;

public class badCode2 extends Mutable{
	@Override
	public int[] getArray() {
		return super.getArray().clone();
	}
	
	/**
	 * getArray() �Լ��� clone�� ���ؼ� ���� ���簡 �̷�������� �ش� ��ü�� ���� �����ʹ� ������� �ʴ´�.
	 * �׷��� setArray()�� ���ؼ� �����͸� ������ �� �����Ƿ� �Һ����� �����Ѵ�.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		badCode1 mutable = new badCode1();
		
		// get�Լ��� clone�� ���� ���� ��������� ������� �ʴ´�. 
		mutable.getArray()[0] = 2;
		
		// set�Լ��� ���� ����2
		mutable.setArray(new int[10]);
	}
}
