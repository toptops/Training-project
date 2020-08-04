package com.network.pratice.secure_guide.provideToImmutable;

public class badCode1 extends Mutable{
	
	/**
	 * get,set 함수를 통해서 데이터를 변경할 수 있다.
	 * 그러므로 불변성을 위반한다.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		badCode1 mutable = new badCode1();
		
		// 얕은 복사로 인한 변경1
		mutable.getArray()[0] = 1;
		
		// set함수로 인한 변경2
		mutable.setArray(new int[10]);
		
	}
}
