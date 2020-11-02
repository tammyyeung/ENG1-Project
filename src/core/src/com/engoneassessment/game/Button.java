package com.engoneassessment.game;

import com.badlogic.gdx.graphics.Texture;
import com.engoneassessment.utils.RectangleRenderObject;

public class Button extends RectangleRenderObject {
    private String text;

    public Button(Texture _texture,String button_text) {
        super(_texture);
        text = button_text;
        this.setHeight(100);
        this.setWidth(300);
    }

    public String getText(){
        return text;
    }

}
