package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import util.XLException;

public class Sheet {
	
	private HashMap<String, XCell> contents;
	private XCellFactoryImplementation factory;
	
	public Sheet () {
		contents = new HashMap<String, XCell>();
		factory = new XCellFactoryImplementation();
	}
	
	public void setCellContent(String cellRef, String rawContent) throws IOException, XLException{
		if(rawContent.equals("")) {
			return;
		}else if (rawContent.substring(0, 1).equals("#")) { // If content is a comment
			XCell xCell = factory.makeXCellComment(rawContent);
			contents.put(cellRef, xCell);
			
		}else{ // If content is an expr
			try {
				String validContent = parseExprContent(rawContent);
				System.out.println("sheet -> setCellCont: rawContent = " + rawContent);
				System.out.println("sheet -> setCellCont: validContent = " + validContent);
				
				XCell xCell = factory.makeXCellExpr(cellRef, validContent);
				
				contents.put(cellRef, xCell);
			} catch (IOException e) {
				throw new IOException(e.getMessage());
			} catch (XLException xle) {
				throw new XLException(xle.getMessage());
			}
		}
	}
	
	
	public boolean validCellRef(String cellRef) {
		boolean valid = false;
		String numbers = "0123456789";
		String letters = "ABCDEFGH";
		
		if(cellRef.length() == 2)
		{
			if(letters.indexOf(cellRef.substring(0, 1)) >= 0)
			{
				if(numbers.indexOf(cellRef.substring(1, 2)) >= 0)
				{
					valid = true;
				}
			}
		}
		else if(cellRef.length() == 3 && cellRef.substring(1).equals("10")) 
		{
			if(letters.indexOf(cellRef.substring(0, 1)) >= 0)
			{
				valid = true;
			}
		}
		return valid;
	}
	
	public String getCellContent(String cellRef) {
		if (contents.containsKey(cellRef)){
			XCell xCell = contents.get(cellRef);
			return xCell.displayString(cellRef);
		}else{
			return "";
		}
	}
	
	//OBOBSOBOSB CANT HANDLE asdasdasdas
	public String parseExprContent(String rawContent) {
		StringBuilder sb = new StringBuilder();
		
		String s = "";
		for (int i = 0; i < rawContent.length(); i++) {
			char c = rawContent.charAt(i);
			if(Character.isLetter(c)){ // When we find a letter, do a while till you cant find more digits
				s += c;
				i++;
				c = rawContent.charAt(i);
				while(Character.isDigit(c)){
					s += c;
					i++;
					if(!(i < rawContent.length())){ // Avoids index out of bounds
						break;
					}
					c = rawContent.charAt(i);
					
				}
				i--; // So the next forloop doesnt skip an index
				s = s.toUpperCase();
				if(validCellRef(s)){
					String cellContent = getCellContent(s); // Tries to get expr from hashMap
					if (!cellContent.equals("")) {
						sb.append(cellContent);
						s = "";
					}else{
						System.out.println("Sheet -> parseExpr() cant find cellRef in hashMap");
					}
				}
				
			}else{
				sb.append(c);
			}

		}
		return sb.toString();
	}
		
//TODO deleteKey from contents
}
