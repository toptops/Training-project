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
	 * get() 함수는 clone을 통해서 깊은 복사가 이루어지므로 불변성을 유지한다.
	 * set() 함수 또한 수정을 하려고하면 예외를 일으켜서 수정을 방지하였으므로 불변성을 유지하였다.
	 * Mutable.class는 get(), set()으로만 array에 접근이 가능하므로 불변성을 유지하였다.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ValidCode mutable = new ValidCode();
		
		// get함수는 clone을 통해 깊은 복사됨으로 변경되지 않는다. 
		mutable.getArray()[0] = 2;
		
		// set함수는 예외를 일으킨다. 
		mutable.setArray(new int[10]);
	}
}
