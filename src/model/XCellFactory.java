package model;

public interface XCellFactory {
	
	public XCell makeXCellComment(String cellRef, String content);
	public XCell makeXCellExpr(String cellRef, String content);
}
