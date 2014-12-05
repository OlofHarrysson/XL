package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import control.CurrentCell;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentCell currentCell) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, currentCell));
    }
}