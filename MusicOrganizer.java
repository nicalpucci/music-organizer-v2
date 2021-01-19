import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael KÃ¶lling
 * @version 2011.07.31
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;

    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<String>();
        player = new MusicPlayer();
    }

    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }

    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }

    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }

    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * List all items of files
     */
    public void listAllFiles() {
        int position = 0;
        while (position < files.size()) {
            String filename = files.get(position);            
            position++;
            System.out.println(position + ". " + filename);
        }
    }

    /**
     * Encuentra determinados archivos
     */
    public void listMatching(String searchString){ 
        boolean existe = false;
        for (String filename : files ){
            if(filename.contains(searchString)){
                System.out.println(filename);
                existe = true;
            }
        }
        if(!existe){
            System.out.println("¡Error! No existe");
        }        
    }

    /**
     * reproduce los primeros segundo de cada canción
     */
    public void playSamplesArtist(String artista) {
        for(String file : files) {
            if(file.contains(artista)) {
                player.playSample(file); 
            }
        }
    }

    /**
     * Borra todas las canciones que contengan el texto que vayamos a escribir
     */
    public void deleteSongsWithText(String textoPurgante){
        for(String file : files) {
            if(file.contains(textoPurgante)) {
                files.remove(file);
            }
        }
    }

    /**
     * Localiza el índice del primer archivo que se corresponde con
     * la cadena de búsqueda indicada .
     * @param searchString La cadena que hay que buscar.
     * @return El índice de la primera aparición o -1 si
     * no se encuentra ninguna correspondencia
     */
    public int findFirst(String searchString){
        int resultado = -1;
        int encontrado = 0;
        boolean found = true;
        while(encontrado < files.size() && found){
            String filename = files.get(encontrado);
            if(filename.contains(searchString)){
                resultado = encontrado;
                found = false;
            }
            encontrado++;
        }
        return resultado;
    }
}

