package com.network.pratice.secure_guide.provideToImmutable;

/**
 * array �迭�� �Һ���(immutable)�� �����ٰ� ������ Ŭ����
 * 
 * @author seong
 *
 */
public class Mutable {
	private int[] array = new int[10];
	
	public int[] getArray() {
		return array;
	}
	
	public void setArray(int[] i) {
		array = i;
	}
}
