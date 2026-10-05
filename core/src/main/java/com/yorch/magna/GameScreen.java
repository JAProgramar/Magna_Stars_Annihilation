package com.yorch.magna;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import static com.badlogic.gdx.utils.ScreenUtils.clear;

/**
 * Esta clase es la pantalla de juego, en donde ocurre la batalla entre naves y enemigos
 */

public class GameScreen implements Screen
{
    private SpriteBatch batch;
    private Texture image;
    private float x;
    private float velocidadX;

    /**
     * Este metodo se ejecuta una sola vez, justo cuando la pantalla se convierte en activa
     * ,es un metodo de reemplazo para el create(), pero especifico para cada pantalla;
     * aqui se ejecutarán los batch, texturas y otros recursos propios de la escena.
     * Funciona como un despertador para que esta escena despierte justo a tiempo.
     * */

    @Override
    public void show()
    {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        x = 140f;
        velocidadX = 100f;

    }

    /**
     * Un metodo que transforma los datos en bruto, en contexto visual (Imagenes, Textos, Texturas)
     * ,en la imagen que se visualizará ya sea 2D, Pixel Art, 3D, etc.
     * Este metodo se esta ejecutando continuamente.
     * @param delta Representa el tiempo en segundos desde el ultimo render
     */


    @Override
    public void render(float delta)
    {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);

        x = x + velocidadX * delta;

        if (x >= Gdx.graphics.getWidth() - image.getWidth()) {
            velocidadX = -velocidadX;
        }
        if (x <= 0) {
            velocidadX = -velocidadX;
        }

        batch.begin();
        batch.draw(image, x, 210);
        batch.end();

    }

    /**
     * Se ejecuta cada vez que cambia el tamaño de la ventana (en escritorio)
     * o la orientación de la pantalla (en Android, al rotar de vertical a
     * horizontal). Recibe el nuevo ancho y alto en píxeles como parámetros,
     * útil para reajustar la cámara o el HUD a las nuevas dimensiones.
     *
     * @param width  el nuevo ancho de la pantalla, en píxeles
     * @param height el nuevo alto de la pantalla, en píxeles
     */

    @Override
    public void resize(int width, int height) {

    }

    /**
     * Se ejecuta automáticamente cuando la aplicación pierde el foco o pasa a
     * segundo plano — no es una pausa activada por el jugador, sino una
     * notificación del sistema operativo (por ejemplo, el usuario cambia de
     * aplicación en Android, o recibe una llamada). libGDX no detiene el
     * render por sí solo al llamar este método: simplemente avisa, para que
     * aquí se decida qué hacer (como pausar la música o guardar el progreso
     * actual de la partida).
     */

    @Override
    public void pause() {

    }

    /**
     * Se ejecuta automáticamente cuando la aplicación recupera el foco,
     * justo lo opuesto a pause() — por ejemplo, cuando el usuario regresa
     * a la app en Android después de haber salido o recibido una llamada.
     * Aquí se podría reanudar la música que se pausó, o restaurar cualquier
     * estado que se haya guardado momentáneamente al perder el foco.
     */

    @Override
    public void resume() {

    }

    /**
     * Se ejecuta cuando esta pantalla deja de ser la activa, porque setScreen()
     * fue llamado con otra pantalla distinta — es el método opuesto a show().
     * Los elementos dejan de renderizarse o mostrarse en pantalla, pero no se
     * borran de memoria; siguen existiendo por si esta pantalla vuelve a
     * activarse más adelante.
     */

    @Override
    public void hide() {

    }

    /**
     * Libera manualmente recursos nativos (como texturas en la memoria de la
     * GPU, o datos de audio) que el Garbage Collector de Java no puede
     * gestionar por sí solo, ya que viven fuera del control de la JVM. Debe
     * llamarse explícitamente cuando esos recursos ya no se van a usar —
     * de lo contrario, permanecen ocupando memoria para siempre, sin que
     * Java tenga forma de limpiarlos automáticamente.
     */

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();

    }
}
