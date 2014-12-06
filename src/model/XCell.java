package model;

import expr.Environment;

public interface XCell extends Environment
{
	
	
	public String displayString(String cellRef);

	public String getRawContent();
}