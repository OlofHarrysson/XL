package model;

import expr.Environment;

public class XCellComment implements XCell
{
	private String comment;
	
	public XCellComment(String comment) {
		this.comment = comment;
	}
	
	// Returns comment without #
	public String toString() {
		if(comment.length() > 1) {
			return comment.substring(1);
		} else {
			return "";
		}
	}

	@Override
	public String displayString(String cellRef) {
		return comment;
	}

	@Override
	public double value(String cellRef) {
		return 0;
	}
}