package model;

import util.XLException;
import expr.Environment;

public class XCellExprTest implements XCell {

	private String msg;
	
	public XCellExprTest(String msg){
		this.msg = msg;
	}
	
	public double value(Environment env) throws XLException {
		throw new XLException(msg);
	}

	public String displayString(Environment env) {
		return "";
	}

	@Override
	public double value(String name) throws XLException {
		throw new XLException(msg);
	}

	@Override
	public String displayString(String cellRef) {
		return "";
	}
}
