package lab4;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.file.*;

public class FileAndURLCopy {

    private static void copyFile(Path source, Path destination) throws IOException {
        if (Files.exists(destination) && Files.isDirectory(destination)) {
            // Jeśli ścieżka docelowa jest katalogiem, dodaj oryginalną nazwę pliku
            String fileName = source.getFileName().toString();
            destination = destination.resolve(fileName);
        }

        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }

    @SuppressWarnings("deprecation")
	private static void copyUrlToFile(String urlString, Path destination) throws IOException {
    	try (InputStream in = new URL(urlString).openStream()) {
    		String fileName = getFileName(urlString);
    		try {
            Path destinationPath = destination.resolve(fileName);
            // dodać warunek sprawdzający czy drugi argument to plik czy katalog elo
            Files.copy(in, destinationPath, StandardCopyOption.REPLACE_EXISTING);
    		}
            catch (NoSuchFileException e) {
            	Files.copy(in, destination, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    private static String getFileName(String urlString) {
        // Pobierz nazwę pliku z URL
        String[] parts = urlString.split("/");
        return parts[parts.length - 1];
    }

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Brak lub za mało argumentów programu");
            System.out.println("Użycie: java FileCopy.java source_file target");
            System.out.println("Lub: java FileCopy.java url target");
            return;
        }

        String sourcePath = args[0];
        String destinationPath = args.length > 1 ? args[1] : "."; // Domyślnie bieżący katalog

        try {
            Path source;
            if (sourcePath.startsWith("http://") || sourcePath.startsWith("https://")) {
                // Jeśli pierwszy argument to URL
            	copyUrlToFile(sourcePath, Paths.get(destinationPath));                               
                System.out.println("URL skopiowany pomyślnie.");
            } else {
            	if (args.length < 2) {
            		System.out.println("Brak lub za mało argumentów programu do skopiowania pliku");
                    System.out.println("Użycie: java FileCopy.java source_file target");
                    return;
            	}
                source = Paths.get(sourcePath);
                Path destination = Paths.get(destinationPath);

                if (Files.isDirectory(source)) {
                    System.out.println(args[0] + " jest katalogiem");
                } else {
                    copyFile(source, destination);
                    System.out.println("Plik skopiowany pomyślnie.");
                }
            }
        }catch (NoSuchFileException e) {
            System.out.println("Plik " + args[0] + " nie istnieje");
        } 
        catch (AccessDeniedException f) {
            System.out.println("Brak dostępu do pliku " + args[0]);
        } catch (SecurityException g) {
            System.out.println("Brak uprawnień do katalogu");
        } 
        catch (FileSystemException h) {
            System.out.println("Nie można nadpisać pliku " + args[1]);
        } 
        catch (MalformedURLException i) {
            System.out.println("Podany URL ma złą formę");
        } catch (UnknownHostException k) {
        	System.out.println("Brak połączenia sieciowego bądz niepoprawny adres.");
        }catch (IOException j) {
          System.out.println("Błąd podczas kopiowania pliku");
        }
    }
}
