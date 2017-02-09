/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author george
 */
public class TaggedPicture {

    private JLabel label;
    
    private BufferedImage img;
    private String tag;
    private int index;

    private CallbackVoid onTagged;

    public TaggedPicture() {
        this.label = new JLabel("Loading ...");
        this.label.setTransferHandler(new ListTransferHandler(this::setTag));
    }

    public Component getComponent(int width, int height) {
        this.label.setPreferredSize(new Dimension(width, height));
        if(img != null){
            ImageIcon icon = new ImageIcon(img.getScaledInstance(width, height, 0));
            this.label.setIcon(icon);
        }
        return this.label;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
        if (onTagged != null) {
            onTagged.onCallback();
        }
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    void setOnTaggedCallback(CallbackVoid callback) {
        this.onTagged = callback;
    }

    void setImage(BufferedImage img) {
        this.img = img;
    }

    BufferedImage getImage() {
        return this.img;
    }

}
