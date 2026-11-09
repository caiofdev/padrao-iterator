package com.exemplo.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements Colecao<Musica> {

    private final List<Musica> musicas = new ArrayList<>();

    public void adicionar(Musica musica) {
        if (musica == null) {
            throw new IllegalArgumentException("A música não pode ser nula");
        }
        musicas.add(musica);
    }

    @Override
    public Iterador<Musica> criarIterador() {
        return new PlaylistIterador(musicas);
    }
}
