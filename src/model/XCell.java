package model;

import expr.Environment;

public interface XCell 
{
	public double value(Environment env);
	
	public String displayString(Environment env);
}