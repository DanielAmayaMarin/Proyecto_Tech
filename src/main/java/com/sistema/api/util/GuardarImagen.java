package com.sistema.api.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GuardarImagen {

    public static String guardarImagen(MultipartFile imagen) throws IOException, IOException {
        // Definir la carpeta donde se guardarán las imágenes
        String carpetaImagenes = "imagenes_perfil/";

        // Crear la carpeta si no existe
        Files.createDirectories(Paths.get(carpetaImagenes));

        // Generar un nombre único para la imagen
        String nombreArchivo = System.currentTimeMillis() + "_" + imagen.getOriginalFilename();

        // Ruta completa del archivo
        Path rutaCompleta = Paths.get(carpetaImagenes + nombreArchivo);

        // Guardar el archivo
        Files.write(rutaCompleta, imagen.getBytes());

        // Devolver la ruta relativa del archivo guardado
        return rutaCompleta.toString();
    }

}
