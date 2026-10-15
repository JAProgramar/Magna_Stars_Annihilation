package com.yorch.magna;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Nave del jugador (Magna). Guarda su posición y se encarga de moverse
 * y dibujarse. La lógica de armas y motores se agregará después.
 */

public class Spaceship {
    private float x;
    private float y;
    private final float speed = 300f;
    private final Texture texture;

    public Spaceship(Texture textura, float startX, float startY){
        this.texture = textura;
        this.x= startX;
        this.y= startY;
    }

    /**
     * Lee el teclado y mueve la nave. Se multiplica por delta para que
     * la velocidad sea igual en cualquier dispositivo.
     * @param delta tiempo en segundos desde el frame anterior
     */
    public void movement(float delta){
        if(Gdx.input.isKeyPressed(Input.Keys.A)) x = x - (speed * delta);
        if(Gdx.input.isKeyPressed(Input.Keys.D)) x = x + (speed * delta);
        if(Gdx.input.isKeyPressed(Input.Keys.W)) y = y + (speed * delta);
        if(Gdx.input.isKeyPressed(Input.Keys.S)) y = y - (speed * delta);

        // Límites: la nave no puede salirse de la pantalla
        x=Math.max(0, Math.min(x, Gdx.graphics.getWidth() - texture.getWidth()));
        y=Math.max(0, Math.min(y, Gdx.graphics.getHeight() - texture.getHeight()));
    }

    public void draw(SpriteBatch batch){
        batch.draw(texture, x, y);
    }
}
