/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

/**
 *
 * @author george
 */
public class ImageLoader extends SwingWorker<BufferedImage, Void> {

    private final File fileToLoad;
    private final TaggedPicture taggedPicture;
    
    private Callback<TaggedPicture> onImageLoad;

    public ImageLoader(TaggedPicture taggedPicture, File fileToLoad) {
        this.fileToLoad = fileToLoad;
        this.taggedPicture = taggedPicture;
    }

    @Override
    protected BufferedImage doInBackground() throws Exception {
        BufferedImage img = ImageIO.read(fileToLoad);
        return img;
    }

    @Override
    protected void done() {
        try {
            BufferedImage img = get();
            taggedPicture.setImage(img);
            if(onImageLoad != null){
                onImageLoad.onCallback(taggedPicture);
            }
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(ImageLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void onImageLoad(Callback<TaggedPicture> callback) {
        onImageLoad = callback;
    }

}
