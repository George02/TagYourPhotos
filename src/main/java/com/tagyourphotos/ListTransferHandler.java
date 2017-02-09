/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import java.awt.Color;
import javax.swing.TransferHandler;

/**
 *
 * @author george
 */
import javax.swing.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListTransferHandler extends TransferHandler {

    private final Callback<String> onTagged;
    
    public ListTransferHandler(Callback<String> onTagged) {
        this.onTagged = onTagged;
    }
    
    @Override
    public boolean canImport(TransferHandler.TransferSupport info) {
        // Check for String flavor
        if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            return false;
        }
        return true;
   }

    @Override
    protected Transferable createTransferable(JComponent c) {
        JList list = (JList)c;
        return new StringSelection((String)list.getSelectedValue());
    }
    
    @Override
    public int getSourceActions(JComponent c) {
        return TransferHandler.COPY;
    }
    
    @Override
    public boolean importData(TransferHandler.TransferSupport info) {
        if (!info.isDrop()) {
            return false;
        }

        JLabel image = (JLabel)info.getComponent();
        image.setBorder(BorderFactory.createLineBorder(Color.yellow));
        
        if(onTagged != null){
            try {
                onTagged.onCallback((String) info.getTransferable().getTransferData(DataFlavor.stringFlavor));
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(ListTransferHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return true;
    }
}
