/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import com.tagyourphotos.tda.Coada;
import com.tagyourphotos.tda.Iterator;
import com.tagyourphotos.tda.Lista;

/**
 *
 * @author george
 */
class PicturesViewer {
    
    private final Lista<TaggedPicture> pictures;
    
    private Coada<TaggedPicture> picturesToShow;
    
    public PicturesViewer(Lista<TaggedPicture> pictures){
        this.pictures = pictures;
        this.picturesToShow = new Coada<>();
    }
    
    public void init(){
        Iterator<TaggedPicture> iterator = pictures.getIterator();
        while(iterator.hasNext()){
            TaggedPicture p = iterator.get().getInfo();
            picturesToShow.push(p);
        }
    }
    
    public Coada<TaggedPicture> getCoada(){
        return picturesToShow;
    }
    
    public void inverseaza(){
        picturesToShow.inverseaza();
    }
    
    public TaggedPicture getNextPicture(){
        return picturesToShow.pop().getInfo();
    }
    
}
