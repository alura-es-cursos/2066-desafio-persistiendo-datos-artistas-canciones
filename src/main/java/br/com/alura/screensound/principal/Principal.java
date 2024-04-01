package br.com.alura.screensound.principal;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.Cancion;
import br.com.alura.screensound.model.TipoArtista;
import br.com.alura.screensound.repository.ArtistaRepository;
import br.com.alura.screensound.service.ConsultaChatGPT;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistaRepository repositorio;
    private Scanner teclado = new Scanner(System.in);

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void muestraElMenu() {
        var opcion = -1;

        while (opcion!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Registrar artistas
                    2- Registrar canciones
                    3- Listar canciones
                    4- Buscar canciones por artistas
                    5- Buscar los dados sobre un artista
                                    
                    9 - Salir
                    """;

            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarArtista();
                    break;
                case 2:
                    registrarCanciones();
                    break;
                case 3:
                    listarCanciones();
                    break;
                case 4:
                    buscarCancionesPorArtista();
                    break;
                case 5:
                    //buscarDatosDelArtista();
                    break;
                case 9:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

//    private void buscarDatosDelArtista() {
//        System.out.println("¿Desea buscar datos sobre qual artista? ");
//        var nombre = teclado.nextLine();
//        var respueta = ConsultaChatGPT.obtenerInformacion(nombre);
//        System.out.println(respueta.trim());
//    }

    private void buscarCancionesPorArtista() {
        System.out.println("¿Desea buscar canciones de que artista? ");
        var nombre = teclado.nextLine();
        List<Cancion> canciones = repositorio.buscaCancionesPorArtista(nombre);
        canciones.forEach(System.out::println);
    }

    private void listarCanciones() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(a -> a.getCanciones().forEach(System.out::println));
    }

    private void registrarCanciones() {
        System.out.println("¿Desea registrar la canción de que artista? ");
        var nombre = teclado.nextLine();
        Optional<Artista> artista = repositorio.findByNombreContainingIgnoreCase(nombre);
        if (artista.isPresent()) {
            System.out.println("Informa el título de la canción: ");
            var nombreCancion = teclado.nextLine();
            Cancion cancion = new Cancion(nombreCancion);
            cancion.setArtista(artista.get());
            artista.get().getCanciones().add(cancion);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista no encontrado");
        }
    }

    private void registrarArtista() {
        var registrarNuevo = "S";

        while (registrarNuevo.equalsIgnoreCase("s")) {
            System.out.println("Informa el nombre del artista: ");
            var nombre = teclado.nextLine();
            System.out.println("Informe el tipo de este artista: (solo, duo o banda)");
            var tipo = teclado.nextLine();
            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
            Artista artista = new Artista(nombre, tipoArtista);
            repositorio.save(artista);
            System.out.println("Registrar nuevo artista? (S/N)");
            registrarNuevo = teclado.nextLine();
        }
    }
}
