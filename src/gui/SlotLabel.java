package gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import control.CurrentCell;

public class SlotLabel extends ColoredLabel implements MouseListener {
	
	private String cellRef;
	private CurrentCell currentCell;
	
    public SlotLabel(String cellRef, CurrentCell currentCell) {
        super("                    ", Color.WHITE, RIGHT);
        this.cellRef = cellRef;
        this.currentCell = currentCell;
        addMouseListener(this);
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		currentCell.setCellRef(cellRef);
	}
	
	public void setFocusColor() {
    	setBackground(Color.YELLOW);
    }
	
	public void setNormalColor() {
		setBackground(Color.WHITE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	
}