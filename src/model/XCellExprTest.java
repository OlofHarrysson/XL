package model;

import expr.Environment;

public class XCellExprTest implements XCell {

	private String msg;
	
	public XCellExprTest(String msg){
		this.msg = msg;
	}
	
	public double value(Environment env) {
		return 34404;
	}

	public String displayString(Environment env) {
		return "";
	}

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String displayString(String cellRef) {
		// TODO Auto-generated method stub
		return null;
	}

}
