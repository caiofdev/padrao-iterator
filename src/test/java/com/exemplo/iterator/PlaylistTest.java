package com.exemplo.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class PlaylistTest {

    private final Playlist playlist = new Playlist();

    @Test
    void adicionarDeveGuardarMusicaValida() {
        Musica musica = new Musica("Faixa A", "Artista A");

        playlist.adicionar(musica);

        Iterador<Musica> iterador = playlist.criarIterador();
        assertEquals(musica, iterador.proximo());
        assertFalse(iterador.temProximo());
    }

    @Test
    void adicionarDeveLancarExcecaoQuandoMusicaForNula() {
        assertThrows(IllegalArgumentException.class, () -> playlist.adicionar(null));

        assertFalse(playlist.criarIterador().temProximo());
    }

    @Test
    void criarIteradorDeveRetornarIteradorQuePercorreNaOrdemDeInsercao() {
        Musica primeira = new Musica("Faixa A", "Artista A");
        Musica segunda = new Musica("Faixa B", "Artista B");
        playlist.adicionar(primeira);
        playlist.adicionar(segunda);

        Iterador<Musica> iterador = playlist.criarIterador();

        assertEquals(primeira, iterador.proximo());
        assertEquals(segunda, iterador.proximo());
        assertFalse(iterador.temProximo());
    }
}
