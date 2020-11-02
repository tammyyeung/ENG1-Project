package com.engoneassessment.game;

import com.engoneassessment.utils.RectangleRenderObject;
import com.badlogic.gdx.graphics.Texture;

public class Teleporter extends RectangleRenderObject {
    private String name;


    public Teleporter(Texture _texture,String teleporter_name){
        super(_texture);
        name = teleporter_name;
        this.setHeight(500);
        this.setWidth(500);

    }

    public String getName(){
        return name;
    }
}
