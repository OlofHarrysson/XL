package model;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;
import util.XLException;

public class XCellFactoryImplementation implements XCellFactory {
	
	public XCell makeXCellComment(String content) {
		return new XCellComment(content);
	}

	
	public XCell makeXCellExpr(String cellRef, String content) throws IOException, XLException {
		ExprParser parser;
		Expr expr;
		try{
			parser = new ExprParser();
			expr = parser.build(content);
		} catch (IOException ioe) {
			throw new IOException(ioe.getMessage());
		} catch (XLException xle) {
			throw new XLException(xle.getMessage());
		}
		return new XCellExpr(expr, content);
	}
}
