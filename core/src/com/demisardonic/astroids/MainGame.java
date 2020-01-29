package com.demisardonic.astroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;

public class MainGame extends ApplicationAdapter {
	public static Stage stage;
	private Renderer renderer;

	public static boolean renderCollision = false;
	public static boolean renderQuadTree = false;
	public static boolean renderAcceleration = false;
	
	@Override
	public void create () {
		System.out.println(new Vector(1,0).rotate(Math.PI/4f));

		AssetManager.instance().registerPath("default", "img/default.png");
		AssetManager.instance().registerPath("entity.player", "img/player.png");
		AssetManager.instance().registerPath("entity.enemy", "img/enemy.png");
		AssetManager.instance().registerPath("entity.shot", "img/shot.png");
		renderer = new Renderer();
		stage = new Stage();
	}

	@Override
	public void render () {
		Gdx.graphics.setTitle("" + Gdx.graphics.getFramesPerSecond());
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
			System.exit(0);
		}

		if (Gdx.input.isKeyJustPressed(Input.Keys.F1)) renderCollision = !renderCollision;
		if (Gdx.input.isKeyJustPressed(Input.Keys.F2)) renderQuadTree = !renderQuadTree;
		if (Gdx.input.isKeyJustPressed(Input.Keys.F3)) renderAcceleration = !renderAcceleration;

		float dt = Gdx.graphics.getDeltaTime();

		stage.update(dt);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.render(renderer, dt);
		renderer.close();
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
		AssetManager.instance().dispose();
	}
}
