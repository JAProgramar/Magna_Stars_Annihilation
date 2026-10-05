package com.yorch.magna;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Clase Principal del Juego Magna
 * Actuá como el director del juego (un patrón de Game de libGDX)
 * controlando cuál pantalla (Screen) esta activa en cada momento
 */

public class MagnaGame extends Game
{
    /**
     * Se ejecuta una sola vez inicie la aplicación
     * Establece la pantalla principal del juego
     */
    @Override
    public void create()
    {
        //Mecanismo de navegación entre pantallas
        setScreen(new GameScreen());
    }
}
