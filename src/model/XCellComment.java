package model;

import util.XLException;
import expr.Environment;

public class XCellComment implements XCell
{
	private String comment;
	
	public XCellComment(String comment) {
		this.comment = comment;
	}
	
	public double value(Environment env) throws XLException {
		return 0;
	}
	
	public String toString() {
		return comment;
	}

	@Override
	public String displayString(Environment env) {
		if(comment.length() > 1) {
			return comment.substring(1);
		} else {
			return "";
		}
	}
}