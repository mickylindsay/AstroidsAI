package com.demisardonic.astroids;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.demisardonic.astroids.entity.Enemy;
import com.demisardonic.astroids.entity.Entity;
import com.demisardonic.astroids.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class MainGame extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	
	@Override
	public void create () {
		AssetManager.instance().registerPath("default", "img/default.png");
		AssetManager.instance().registerPath("entity.player", "img/player.png");
		AssetManager.instance().registerPath("entity.enemy", "img/enemy.png");

		batch = new SpriteBatch();
		stage = new Stage();
	}

	@Override
	public void render () {
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
			Gdx.app.exit();
			System.exit(0);
		}

		float dt = Gdx.graphics.getDeltaTime();

		stage.update(dt);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		stage.render(batch, dt);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		AssetManager.instance().dispose();
	}
}
