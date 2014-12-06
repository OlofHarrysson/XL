package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import util.XLException;
import model.Sheet;
import control.CurrentCell;

public class Editor extends JTextField implements Observer, ActionListener {
	
	private CurrentCell currentCell;
	private Sheet sheet;
	private SlotLabels slotLabels;
	private StatusLabel statusLabel;
	
    public Editor(CurrentCell currentCell, Sheet sheet, StatusLabel statusLabel) {
        setBackground(Color.WHITE);
        this.currentCell = currentCell;
        this.sheet = sheet;
        this.statusLabel = statusLabel;
        currentCell.addObserver(this);
        addActionListener(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		String cellRef = currentCell.getCellRef();
		String content = sheet.getCellContent(cellRef);
		setText(content);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cellRef = currentCell.getCellRef();
		SlotLabel slotLabel = slotLabels.getSlotLabel(cellRef);
		
		String editorText = getText();
		
		try {
			sheet.setCellContent(cellRef, editorText);
			String cellContent = sheet.getCellContent(cellRef);
			slotLabel.setText(cellContent);
		} catch (IOException exp) {
			statusLabel.setText(exp.getMessage());
		} catch (XLException xle) {
			statusLabel.setText(xle.getMessage());
		}
	}
	
	public void setSlotLabels(SlotLabels slotLabels) {
		this.slotLabels = slotLabels;
	}


}