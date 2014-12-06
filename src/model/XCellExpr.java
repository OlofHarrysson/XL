package model;

import expr.Expr;

public class XCellExpr implements XCell
{
	private Expr cellExpr;
	
	public XCellExpr(Expr expression) {
		cellExpr = expression;
	}

	@Override
	public String displayString(String cellRef) {
		return String.valueOf(value(cellRef));
	}
	
	public String toString() {
		return cellExpr.toString();
	}
	
	public Expr getExpr() {
		return cellExpr;
	}

	@Override
	public double value(String cellRef) {
		return cellExpr.value(this);
	}
	
}