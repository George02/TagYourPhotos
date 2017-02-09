/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tagyourphotos;

import com.tagyourphotos.tda.Iterator;
import com.tagyourphotos.tda.Lista;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.*;

/**
 *
 * @author george
 */
public class GUIController {

    private final GUIState guiState;
    private final GUIState initialState;

    private final JFrame frame;
    private final JPanel pnlPicturesHolder;
    private final JList tagsList;

    private JScrollPane scrollPane;
    private JPanel pnlPictures;

    public GUIController(JFrame frame, JPanel pnlPicturesHolder, JList jListTags) {
        this.frame = frame;
        this.pnlPicturesHolder = pnlPicturesHolder;
        this.tagsList = jListTags;

        this.guiState = new GUIState();
        this.initialState = new GUIState();
    }

    public void init() {
        pnlPictures = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));

        scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setViewportView(pnlPictures);

        scrollPane.setPreferredSize(new Dimension(pnlPicturesHolder.getWidth(), pnlPicturesHolder.getHeight()));
        pnlPictures.setPreferredSize(new Dimension(pnlPicturesHolder.getWidth(), 0));

        pnlPicturesHolder.add(scrollPane);
    }

    public void addTagToList(String tagName) {
        DefaultListModel listModel = (DefaultListModel) tagsList.getModel();
        listModel.add(listModel.getSize() + 1, tagName);
    }

    public void openAndShowFiles(String path) {
        try {
            List<File> filesInFolder = Files.walk(Paths.get(path))
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());

            for (int i = 0; i < filesInFolder.size(); i++) {
                TaggedPicture taggedPicture = new TaggedPicture();

                taggedPicture.setOnTaggedCallback(new CallbackVoid() {
                    @Override
                    public void onCallback() {
                        guiState.addTaggedPictureToDictionary(taggedPicture);
                    }
                });

                ImageLoader imageLoader = new ImageLoader(taggedPicture, filesInFolder.get(i));
                imageLoader.execute();
                imageLoader.onImageLoad(new Callback<TaggedPicture>() {
                    @Override
                    public void onCallback(TaggedPicture p) {
                        pnlPictures.add(p.getComponent(100, 100));
                        pnlPicturesHolder.revalidate();
                        pnlPicturesHolder.repaint();
                    }
                });

                guiState.addTaggedPicture(taggedPicture);
            }

            pnlPictures.setPreferredSize(new Dimension(pnlPictures.getWidth(), pnlPictures.getHeight() + (100 * (filesInFolder.size() / 5))));

            pnlPicturesHolder.revalidate();
            pnlPicturesHolder.repaint();
        } catch (IOException ex) {
            Logger.getLogger(GUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void viewPicturesWithTag(String tagName) {
        Lista<TaggedPicture> pictures = guiState.getPicturesByTag(tagName);
        showPictures(pictures);
    }

    public void resetPicturesView() {
        showPictures(guiState.getPictures());
    }

    public void showPictures(Lista<TaggedPicture> pictures) {
        pnlPictures.removeAll();
        pnlPicturesHolder.revalidate();
        pnlPicturesHolder.repaint();

        Iterator<TaggedPicture> picturesIterator = pictures.getIterator();
        while (picturesIterator.hasNext()) {
            TaggedPicture picture = picturesIterator.get().getInfo();
            pnlPictures.add(picture.getComponent(100, 100));
        }

        pnlPictures.setPreferredSize(new Dimension(pnlPictures.getWidth(), pnlPictures.getHeight() + (100 * (pictures.length() / 5))));

        pnlPicturesHolder.revalidate();
        pnlPicturesHolder.repaint();
    }

    public Lista<TaggedPicture> getCurrentPictures() {
        return guiState.getPictures();
    }

    public void setCurrentTag(String tagName) {
        this.guiState.setCurrentTag(tagName);
    }
    
    public String getCurrentTag(){
        return this.guiState.getCurrentTag();
    }

    public Lista<TaggedPicture> getPicturesByTag(String tag) {
        return guiState.getPicturesByTag(tag);
    }

}
