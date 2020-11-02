package com.engoneassessment.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.engoneassessment.utils.RectangleRenderObject;

public class Character extends RectangleRenderObject {
    Array<Texture> actionTextures;
    private Integer health;
    /*
    0:stand
    1:stand_left

     */

    public Character(Texture _texture, Integer character_health) {
        super(_texture);
        health = character_health;
    }

    public Integer getHealth(){
        return health;
    }

    public Integer setHealth(Integer new_health){
        health = new_health;
        return health;
    }

    public Integer changeHealth(Integer change){
        health += change;
        return health;
    }

    public void Movement(){
        movement_keyboard_event();
    }

    public void movement_keyboard_event(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.changeX(- 1200 * Gdx.graphics.getDeltaTime());
            //this.setTexture();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.changeX(1200 * Gdx.graphics.getDeltaTime());
            //this.setTexture();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.changeY(1200 * Gdx.graphics.getDeltaTime());
            //this.setTexture();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.changeY(-1200 * Gdx.graphics.getDeltaTime());
            //this.setTexture();
        }
    }

    @Override
    public void Render(SpriteBatch batch){
        super.Render(batch);
        Movement();
    }
}
