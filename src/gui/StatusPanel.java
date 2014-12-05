package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import control.CurrentCell;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, CurrentCell currentCell) {
    	
        add(WEST, new CurrentLabel(currentCell));
        add(CENTER, statusLabel);
    }
}