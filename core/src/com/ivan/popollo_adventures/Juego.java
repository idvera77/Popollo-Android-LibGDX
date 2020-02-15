package com.ivan.popollo_adventures;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import actores.Popollo;
import pantallas.BaseScreen;
import pantallas.*;

public class Juego extends Game {
    private BaseScreen pantallaActual;

    @Override
    public void create() {
        //Creamos al personaje principal para pasarlo por el constructor de cada pantalla,
        // asi siempre es el mismo objeto y mantiene las estadisticas.
        Popollo popollo = new Popollo();
        //Se indica la pantalla en la cual comenzara el juego
        this.setPantallaActual(new Pantalla1(this, popollo));
    }

    /**
     * Setter de pantallaActual
     *
     * @param pantalla pantalla a cargar
     */
    public void setPantallaActual(BaseScreen pantalla) {
        pantallaActual = pantalla;
        setScreen(pantallaActual);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        pantallaActual.render(Gdx.graphics.getDeltaTime());
    }

    @Override
    public void dispose() {
        pantallaActual.dispose();
    }
}
