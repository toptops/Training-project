package com.network.pratice.secure_guide.provideToImmutable;

public class ValidCode extends Mutable{
	
	@Override
	public int[] getArray() {
		return super.getArray().clone();
	}
	
	@Override
	public void setArray(int[] i) {
		throw new UnsupportedOperationException();
	}	
	
	/**
	 * get() �Լ��� clone�� ���ؼ� ���� ���簡 �̷�����Ƿ� �Һ����� �����Ѵ�.
	 * set() �Լ� ���� ������ �Ϸ����ϸ� ���ܸ� �����Ѽ� ������ �����Ͽ����Ƿ� �Һ����� �����Ͽ���.
	 * Mutable.class�� get(), set()���θ� array�� ������ �����ϹǷ� �Һ����� �����Ͽ���.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ValidCode mutable = new ValidCode();
		
		// get�Լ��� clone�� ���� ���� ��������� ������� �ʴ´�. 
		mutable.getArray()[0] = 2;
		
		// set�Լ��� ���ܸ� ����Ų��. 
		mutable.setArray(new int[10]);
	}
}
