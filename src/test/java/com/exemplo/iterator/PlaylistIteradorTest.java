package com.exemplo.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

class PlaylistIteradorTest {

    private final Musica musica = new Musica("Faixa A", "Artista A");

    @Test
    void temProximoDeveRetornarVerdadeiroQuandoHaElementos() {
        PlaylistIterador iterador = new PlaylistIterador(List.of(musica));

        assertTrue(iterador.temProximo());
    }

    @Test
    void temProximoDeveRetornarFalsoQuandoNaoHaElementos() {
        PlaylistIterador iterador = new PlaylistIterador(List.of());

        assertFalse(iterador.temProximo());
    }

    @Test
    void proximoDeveRetornarElementoEAvancarPosicao() {
        PlaylistIterador iterador = new PlaylistIterador(List.of(musica));

        assertEquals(musica, iterador.proximo());
        assertFalse(iterador.temProximo());
    }

    @Test
    void proximoDeveLancarExcecaoQuandoNaoHaElementos() {
        PlaylistIterador iterador = new PlaylistIterador(List.of());

        assertThrows(NoSuchElementException.class, iterador::proximo);
    }
}
