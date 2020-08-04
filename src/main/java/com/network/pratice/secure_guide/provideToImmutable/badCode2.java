package com.network.pratice.secure_guide.provideToImmutable;

public class badCode2 extends Mutable{
	@Override
	public int[] getArray() {
		return super.getArray().clone();
	}
	
	/**
	 * getArray() 함수는 clone을 통해서 깊은 복사가 이루어짐으로 해당 객체에 대한 데이터는 변경되지 않는다.
	 * 그러나 setArray()를 통해서 데이터를 변경할 수 있으므로 불변성을 위반한다.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		badCode1 mutable = new badCode1();
		
		// get함수는 clone을 통해 깊은 복사됨으로 변경되지 않는다. 
		mutable.getArray()[0] = 2;
		
		// set함수로 인한 변경2
		mutable.setArray(new int[10]);
	}
}
