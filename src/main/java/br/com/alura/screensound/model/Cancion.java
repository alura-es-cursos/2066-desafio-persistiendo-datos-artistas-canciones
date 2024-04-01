package br.com.alura.screensound.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @ManyToOne
    private Artista artista;

    public Cancion() {}
    public Cancion(String nomeMusica) {
        this.titulo = nomeMusica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return
                "Música='" + titulo + '\'' +
                ", artista=" + artista.getNombre();
    }
}
