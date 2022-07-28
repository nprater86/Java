import java.util.HashMap;
import java.util.Set;

public class HashmatiqueTest {
    public static void main(String[] args)
    {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Tubbies","I always loved me a tubby!");
        trackList.put("Manga Reading","I thought it was for nerds but it's pretty alright!");
        trackList.put("Butter","Add that butter, baby!");
        trackList.put("All Your Base","All your base are belong to us!");

        System.out.println(trackList.get("Butter"));

        Set<String> keys = trackList.keySet();
        for(String key : keys)
        {
            System.out.println("Song: " + key + " | Lyric: " + trackList.get(key));
        }
    }
}
