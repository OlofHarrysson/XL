package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import model.Sheet;
import control.CurrentCell;

public class Editor extends JTextField implements Observer, ActionListener {
	
	private CurrentCell currentCell;
	private Sheet sheet;
	private SlotLabels slotLabels;
	
    public Editor(CurrentCell currentCell, Sheet sheet) {
        setBackground(Color.WHITE);
        this.currentCell = currentCell;
        this.sheet = sheet;
        currentCell.addObserver(this);
        addActionListener(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		String cellRef = currentCell.getCellRef();
		//TODO
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cellRef = currentCell.getCellRef();
		SlotLabel slotLabel = slotLabels.getSlotLabel(cellRef);
		
		String editorText = getText();
		String cellContent = sheet.setCellContent(cellRef, editorText);
		
		slotLabel.setText(cellContent);
	}
	
	public void setSlotLabels(SlotLabels slotLabels) {
		this.slotLabels = slotLabels;
	}


}