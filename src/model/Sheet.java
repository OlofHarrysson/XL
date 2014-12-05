package model;

import java.util.HashMap;

public class Sheet {
	
	private HashMap<String, XCell> contents;
	private XCellFactoryImplementation factory;
	
	public Sheet () {
		contents = new HashMap<String, XCell>();
		factory = new XCellFactoryImplementation();
	}
	
	public String setCellContent(String cellRef, String content) {
		if(content.equals("")) {
			return "";
		// If content is a comment
		}else if (content.substring(0, 1).equals("#")) {
			XCell xCell = factory.makeXCellComment(cellRef, content);
		}
		return "hej";
	}

}
