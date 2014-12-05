package model;

import expr.Environment;
import expr.Expr;

public class XCellExpr implements XCell
{
	private Expr cellExpr;
	
	public XCellExpr(Expr expression) {
		cellExpr = expression;
	}
	
	public double value(Environment env) {
		return cellExpr.value(env);
	}

	@Override
	public String displayString(Environment env) {
		return String.valueOf(cellExpr.value(env));
	}
	
	public String toString() {
		return cellExpr.toString();
	}
	
	public Expr getExpr() {
		return cellExpr;
	}
}