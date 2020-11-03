package com.engoneassessment.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Character extends CustomActor {
    Array<Texture> actionTextures;

    public Character(TextureRegion textureRegion) {
        super(textureRegion);
    }



    /*
    0:stand
    1:stand_left
     */

    public void movement_keyboard_event(){
        //if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
        //    this.changeX(- 1200 * Gdx.graphics.getDeltaTime());
        //    //this.setTexture();
        //}
        //if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
        //    this.changeX(1200 * Gdx.graphics.getDeltaTime());
        //    //this.setTexture();
        //}
        //if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
        //    this.changeY(1200 * Gdx.graphics.getDeltaTime());
        //    //this.setTexture();
        //}
        //if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
        //    this.changeY(-1200 * Gdx.graphics.getDeltaTime());
        //    //this.setTexture();
        //}
    }
}
