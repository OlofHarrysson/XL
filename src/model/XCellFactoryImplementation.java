package model;

public class XCellFactoryImplementation implements XCellFactory {
	
	public XCell makeXCellComment(String cellRef, String content) {
		return new XCellComment("heasdasd");
	}

	
	public XCell makeXCellExpr(String cellRef, String content) {
		return null;
	}

}
