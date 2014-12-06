package model;

import java.io.IOException;
import java.util.HashMap;

import util.XLException;

public class Sheet {
	
	private HashMap<String, XCell> contents;
	private XCellFactoryImplementation factory;
	
	public Sheet () {
		contents = new HashMap<String, XCell>();
		factory = new XCellFactoryImplementation();
	}
	
	public String setCellContent(String cellRef, String content) throws IOException, XLException{
		
		if(content.equals("")) {
			return "";
		// If content is a comment
		}else if (content.substring(0, 1).equals("#")) {
			XCell xCell = factory.makeXCellComment(cellRef, content);
			contents.put(cellRef, xCell);
			return xCell.toString();
		}else if(!contents.containsKey(cellRef)){
			throw new XLException("Invalid cell ref");
		}else{
			try {
				XCell xCell = factory.makeXCellExpr(cellRef, content);
				contents.put(cellRef, xCell);
				return xCell.toString();
			} catch (IOException e) {
				throw new IOException(e.getMessage());
			} catch (XLException xle) {
				throw new XLException(xle.getMessage());
			}
		}
	}
	
	private void setErrorMessage(String errorMessage){
		System.out.println(errorMessage);
	}
	
	public String getCellContent(String cellRef) {
		if (contents.containsKey(cellRef)){
			XCell xCell = contents.get(cellRef);
			double value = xCell.value(cellRef);
			return String.valueOf(value);
		}else{
			return "";
		}
	}
		

}
