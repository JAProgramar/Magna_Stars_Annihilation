package com.yorch.magna;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MagnaGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    float x = 140f;
    private float velocidadX = -1f;

    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        x=x+velocidadX;
        if(x<= 0){
            velocidadX = -velocidadX;
        }
        if (x>= Gdx.graphics.getWidth() - image.getWidth()){
            velocidadX= -velocidadX;
        }
        batch.draw(image, x, 210);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
    }
}
