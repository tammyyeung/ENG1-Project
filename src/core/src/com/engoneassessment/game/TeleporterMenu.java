package com.engoneassessment.game;

import com.badlogic.gdx.utils.Array;

public class TeleporterMenu{
    Array<TeleporterButton> buttons = new Array<>();
    Boolean menu_visible;

    public TeleporterMenu() {
        menu_visible = false;
    }

    public void Interact(){
        System.out.println("Click");
    }

    public void addButton(TeleporterButton button){
        buttons.add(button);
    }

    public void makeVisible(){
        for (Button button:buttons){
            button.setRenderMode(true);
        }
        menu_visible = true;
    }

    public void makeVisible(String exclusion,float menuStartX, float menuStartY){
        for (Button button:buttons){
            if(button.getText() != exclusion) {
                menuStartY-=button.getHeight();
                button.setX(menuStartX);
                button.setY(menuStartY);
                button.setRenderMode(true);
            }
        }
        menu_visible = true;
    }

    public void makeInvisible(){
        for (Button button:buttons){
            button.setRenderMode(false);
        }
        menu_visible = false;
    }
}
