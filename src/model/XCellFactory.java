package model;

import java.io.IOException;

public interface XCellFactory {
	
	public XCell makeXCellComment(String content);
	public XCell makeXCellExpr(String cellRef, String content) throws IOException;
}
