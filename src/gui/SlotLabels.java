package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingConstants;

import control.CurrentCell;

public class SlotLabels extends GridPanel {
    private List<SlotLabel> labelList;

    public SlotLabels(int rows, int cols, CurrentCell currentCell) {
        super(rows + 1, cols);
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
        currentCell.setSlotLabels(this);
        currentCell.setCellRef("A1"); 
        
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
}
