package com.santiago.primeraentregadispositivosmviles.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Artista implements Serializable {
    private int recurso;
    private String nombre;
    private String genero;
    private int cancion;


}
