package control;

import gui.SlotLabel;
import gui.SlotLabels;

import java.util.Observable;

public class CurrentCell extends Observable {
	
	private String cellRef;
	private SlotLabels slotLabels;
	
	public CurrentCell() {
		cellRef = "A1";
	}
	
	public void setCellRef(String cellRef) {
		SlotLabel slotLabel = slotLabels.getSlotLabel(this.cellRef);
		slotLabel.setNormalColor();
		
		this.cellRef = cellRef;
		setChanged();
		notifyObservers();
	}
	
	public String getCellRef() {
		return cellRef;
	}
	
	public void setSlotLabels(SlotLabels slotLabels) {
		this.slotLabels = slotLabels;
	}

}
