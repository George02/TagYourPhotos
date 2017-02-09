/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import com.tagyourphotos.tda.Dictionar;
import com.tagyourphotos.tda.Lista;

/**
 *
 * @author george
 */
public class GUIState {

    private final Lista<String> taguri;
    private final Lista<TaggedPicture> pictures;
    private final Dictionar<String, Lista<TaggedPicture>> dictionarTaguri;
    
    private String currentTag;

    public GUIState() {
        this.taguri = new Lista<>();
        this.pictures = new Lista<>();
        this.dictionarTaguri = new Dictionar<>();
    }

    public Lista<TaggedPicture> getPictures() {
        return pictures;
    }

    public Lista<String> getTaguri() {
        return taguri;
    }

    void addTaggedPicture(TaggedPicture taggedPicture) {
        this.pictures.append(taggedPicture);
    }

    void addTaggedPictureToDictionary(TaggedPicture taggedPicture) {
        final String tag = taggedPicture.getTag();

        if (!dictionarTaguri.containsKey(tag)) {
            dictionarTaguri.add(tag, new Lista<>());
        }

        dictionarTaguri.getValue(tag).append(taggedPicture);
    }

    void addTagToList(String tagName) {
        this.taguri.append(tagName);
    }

    public Lista<TaggedPicture> getPicturesByTag(String tagName) {
        if (!dictionarTaguri.containsKey(tagName)) {
            return null;
        }

        return dictionarTaguri.getValue(tagName);
    }

    void setCurrentTag(String tagName) {
        this.currentTag = tagName;
    }

    String getCurrentTag() {
        return this.currentTag;
    }

}
