/*
 * Element Class 
 */

public class Element implements Comparable<Element>{ 
	
	private int index;
	private double value;
	
	public Element(int i , double v){
		index = i;
		value = v;
		}
	
	public int compareTo(Element o){
	}
	
	public void setIndex(int i){
		index = i;
	}
	
	public int getIndex(){
		return index;
	}
	
	public void setValue(double v){
		value = v;
	}
	
	public double getValue(){
		return value;
	}
	
	
}