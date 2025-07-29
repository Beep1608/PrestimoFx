package org.example.utils;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesFactory {

    
 /**
     * Copia un archivo de origen (que puede ser una URI de tipo "file:/") a un directorio de destino.
     *
     * @param sourceFilePath String de la ruta completa del archivo de origen (puede ser una URI "file:/").
     * @param destinationDirectoryPath String de la ruta del directorio donde se copiará el archivo.
     * @return El objeto File que representa el archivo copiado en el destino si la operación es exitosa,
     * o null si ocurre algún error.
     */
    public static File copyLocalFile(String sourceFilePath, String destinationDirectoryPath) {
        File sourceFile;
        try {
            // Convertir la URI string de vuelta a un objeto File
            // Parsear como URI si comienza con "file:"
            if (sourceFilePath.startsWith("file:")) {
                URI uri = URI.create(sourceFilePath);
                sourceFile = new File(uri);
            } else {
                sourceFile = new File(sourceFilePath);
            }
        } catch (Exception e) {
            System.err.println("Error de sintaxis URI para el archivo de origen: " + e.getMessage());
            e.printStackTrace();
            return null; // Retorna null en caso de error de sintaxis URI
        }

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.err.println("El archivo de origen no existe o no es un archivo válido: " + sourceFile.getAbsolutePath());
            System.err.println("SourcePath: " + sourceFilePath);
            return null; // Retorna null si el archivo de origen no es válido
        }

        Path destinationDirPath = Paths.get(destinationDirectoryPath);
        // Construye la ruta completa del nuevo archivo copiado
        Path destinationFilePath = destinationDirPath.resolve(sourceFile.getName());

        try {
            // Asegurarse de que el directorio de destino exista. Si no, créalo.
            Files.createDirectories(destinationDirPath);

            // Copiar el archivo
            Files.copy(sourceFile.toPath(), destinationFilePath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado exitosamente de '" + sourceFile.getAbsolutePath() + "' a '" + destinationFilePath.toAbsolutePath() + "'");

            // Retorna el objeto File del archivo recién copiado
            return destinationFilePath.toFile();

        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
            e.printStackTrace();
            return null; // Retorna null en caso de error de E/S
        }
    }

    
}
