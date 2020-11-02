package com.engoneassessment.game;

import com.badlogic.gdx.graphics.Texture;

public class TeleporterButton extends Button{
    private Teleporter teleporter;

    public TeleporterButton(Texture _texture, String button_text, Teleporter teleporter) {
        super(_texture, button_text);
        this.teleporter = teleporter;
    }

    public float getDestinationX(){
        return teleporter.getX();
    }

    public float getDestinationY(){
        return teleporter.getY();
    }
}
