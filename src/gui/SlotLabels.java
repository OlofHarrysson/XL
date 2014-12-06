package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import model.Sheet;
import control.CurrentCell;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private Sheet sheet;
    private int rows, cols;
    private CurrentCell currentCell;

    public SlotLabels(int rows, int cols, CurrentCell currentCell, Editor editor, Sheet sheet) {	
        super(rows + 1, cols);
        this.currentCell = currentCell;
    	this.rows = rows;
    	this.cols = cols;
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
            	String cellRef = ch + Integer.toString(row);
                SlotLabel label = new SlotLabel(cellRef, currentCell);
                add(label);
                labelList.add(label);
            }
        }
        editor.setSlotLabels(this);
        currentCell.setSlotLabels(this);
        currentCell.setCellRef("A1");
        
        sheet.addObserver(this);
        this.sheet = sheet;
        
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
    }
    
    public SlotLabel getSlotLabel(String cellRef) {
    	String col = cellRef.toString().substring(0, 1);
		String row = cellRef.toString().substring(1);
		
		String letters = "ABCDEFGH";
		int index = (Integer.parseInt(row) - 1) * 8 + letters.indexOf(col);
		return labelList.get(index);
    }

	@Override
	public void update(Observable o, Object arg) {
//		if(o.equals(sheet)){
		HashMap<String,String> contents = sheet.getSheetContents();
//		ArrayList<SlotLabel> tempSlots = new ArrayList<>();
		
		for(String key : contents.keySet()){
			
			String value = contents.get(key);
			
			SlotLabel slotLabel = getSlotLabel(key);
			
			System.out.println("text: " + value + "ref: " + key);
			
			slotLabel.setText(value);
			
			
//			String col = key.toString().substring(0, 1);
//			String row = key.toString().substring(1);
//			
//			String letters = "ABCDEFGH";
//			
//			int i = (Integer.parseInt(row) - 1) * 8 + letters.indexOf(col);
//			
//			currentCell.setCellRef(key);
//			
//			SlotLabel tempLabel = new SlotLabel(key, currentCell);
//			tempLabel.setText(contents.get(key));
//			tempSlots.set(i, tempLabel);			
			
//		}
//		labelList = tempSlots;
		}
	}
	
	
}
