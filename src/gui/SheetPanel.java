package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import model.Sheet;
import control.CurrentCell;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, CurrentCell currentCell, Editor editor, Sheet sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, currentCell, editor, sheet));
    }
}