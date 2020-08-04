package com.network.pratice.secure_guide.provideToImmutable;

/**
 * array 배열은 불변성(immutable)을 가진다고 가정한 클래스
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
