package com.engoneassessment.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.engoneassessment.utils.RectangleRenderObject;
import com.engoneassessment.utils.RenderObject;

public class EngOneAssessment extends ApplicationAdapter implements InputProcessor {
	Array<RectangleRenderObject> VisibleThings = new Array<>();
	Array<Teleporter> Teleporters = new Array<>();
	SpriteBatch batch;
	Character auber;
	Teleporter test_teleporter1;
	Teleporter test_teleporter2;
	TeleporterButton teleporter1_button;
	TeleporterButton teleporter2_button;
	TeleporterMenu teleport_menu;
	private OrthographicCamera camera;
	int i = 0;
	
	@Override
	public void create () {
		//Sets this file to be the input processor
		Gdx.input.setInputProcessor(this);

		//Sets up the camera and sets up its view
		camera = new OrthographicCamera();
		camera.setToOrtho(false,2560,1440);
		batch = new SpriteBatch();

		//All of this part creates objects in the world and moves them to their starting positions
		teleport_menu = new TeleporterMenu();
		auber = new Character(new Texture("badlogic.jpg"),10);

		//Create the teleporters
		test_teleporter1 = new Teleporter(new Texture("test_teleporter.png"),"Teleporter 1");
		test_teleporter2 = new Teleporter(new Texture("test_teleporter.png"),"Teleporter 2");

		//Create the Buttons
		teleporter1_button= new TeleporterButton(new Texture("teleporter1_button.png"),"Teleporter 1",test_teleporter1);
		teleporter2_button = new TeleporterButton(new Texture("teleporter2_button.png"),"Teleporter 2",test_teleporter2);

		//Add the buttons to the menu and make them invisible
		teleport_menu.addButton(teleporter1_button);
		teleport_menu.addButton(teleporter2_button);

		test_teleporter2.Move(1000,1000);

		Teleporters.add(test_teleporter1);
		Teleporters.add(test_teleporter2);

		VisibleThings.add(test_teleporter1);
		VisibleThings.add(test_teleporter2);
		VisibleThings.add(auber);
		VisibleThings.add(teleporter1_button);
		VisibleThings.add(teleporter2_button);

		auber.setX(0);
		auber.setY(0);
		auber.setWidth(250);
		auber.setHeight(250);
		teleport_menu.makeInvisible();
	}

	@Override
	public void render () {
		//Sets the cameras position to the centre of the player
		camera.position.set(auber.getX() , auber.getY(), 0);
		camera.update();
		// tell the SpriteBatch to render in the
		// coordinate system specified by the camera.
		batch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		for (RenderObject visiblething : VisibleThings) {
			if (visiblething.getRenderMode()) {
				visiblething.Render(batch);
			}
		}
		batch.end();
		i++;
	}

	@Override
	public void dispose () {
		batch.dispose();
		for(RenderObject thing:VisibleThings){
			thing.dispose();
		}
	}

	//Everything below here handles inputs
	@Override
	public boolean keyDown(int keycode) {
		if(keycode == Input.Keys.SPACE){
			for(Teleporter tele:Teleporters){
				if(Intersector.overlaps(auber.getRect(),tele.getRect())){
					teleport_menu.makeVisible(tele.getName(),tele.getX(),tele.getY()+tele.getHeight());
				}
			}
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Boolean interacted = false;
		if (button == Input.Buttons.LEFT){
			if(teleport_menu.menu_visible) {
				for (TeleporterButton menu_button:teleport_menu.buttons) {
					if (menu_button.getRenderMode() && menu_button.getShape().contains(camera.unproject(new Vector3(screenX, screenY, 0)).x, camera.unproject(new Vector3(screenX, screenY, 0)).y)) {
						auber.setX(menu_button.getDestinationX());
						auber.setY(menu_button.getDestinationX());
						interacted = true;
					}
				}
				if (interacted) {
					teleport_menu.makeInvisible();
				}
			}
		}
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
