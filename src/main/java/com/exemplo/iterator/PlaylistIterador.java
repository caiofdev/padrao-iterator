package com.exemplo.iterator;

import java.util.List;
import java.util.NoSuchElementException;

public class PlaylistIterador implements Iterador<Musica> {

    private final List<Musica> musicas;
    private int posicao = 0;

    public PlaylistIterador(List<Musica> musicas) {
        this.musicas = musicas;
    }

    @Override
    public boolean temProximo() {
        return posicao < musicas.size();
    }

    @Override
    public Musica proximo() {
        if (!temProximo()) {
            throw new NoSuchElementException("Não há mais músicas na playlist");
        }
        return musicas.get(posicao++);
    }
}
