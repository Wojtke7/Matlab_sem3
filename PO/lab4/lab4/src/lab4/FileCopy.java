package lab4;
import java.io.IOException;
import java.nio.file.*;

public class FileCopy {
	
	private static void copyFile(Path source, Path destination) throws IOException {
        if (Files.exists(destination) && Files.isDirectory(destination)) {
            // Jeśli ścieżka docelowa jest katalogiem, dodaj oryginalną nazwę pliku
            String fileName = source.getFileName().toString();
            destination = destination.resolve(fileName);
        }

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("Brak lub za mało argumentów programu");
            System.out.println("Użycie: java FileCopy.java source_file target");
            return;
        }

        String sourcePath = args[0];
        String destinationPath = args[1];
        

        try {
	            Path source = Paths.get(sourcePath);
	            Path destination = Paths.get(destinationPath);
	            
	            if (Files.isDirectory(source)) {
	        		System.out.println(args[0] + " jest katalogiem");
	        	}
	            
	            else {
	            copyFile(source, destination);
	            System.out.println("Plik skopiowany pomyślnie.");  
	            }
        	} 
        
        	catch (NoSuchFileException e) {
        		System.out.println("Plik " + args[0] + " nie istnieje");
            }
        	catch ( AccessDeniedException f) {
        		System.out.println("Brak dostępu do pliku " + args[0]);
        	}
        	catch ( SecurityException g) {
        		System.out.println("Brak uprawnień do katalogu");
        	}
        	catch ( FileSystemException h) {
        		System.out.println("Nie można nadpisać pliku" + args[1]);
        	}
    }		

}
