package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import model.Sheet;
import control.CurrentCell;

class ClearMenuItem extends JMenuItem implements ActionListener {
	
	private Sheet sheet;
	private CurrentCell currentCell;
	
    public ClearMenuItem(Sheet sheet, CurrentCell currentCell) {
        super("Clear");
        this.sheet = sheet;
        this.currentCell = currentCell;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
    	sheet.clearCell(currentCell.getCellRef());
    }
}