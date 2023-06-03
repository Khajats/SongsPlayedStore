package songsplayedstore;

import java.util.*;

public class RecentlyPlayedSongsStore {
    private final int capacity;
    private final Map<String, Queue<String>> recentlyPlayedSongs;

    public RecentlyPlayedSongsStore(int capacity) {
        this.capacity = capacity;
        this.recentlyPlayedSongs = new LinkedHashMap<>();
    }

    public void addSong(String user, String song) {
    	   Queue<String> songsQueue = recentlyPlayedSongs.get(user);
    	    if (songsQueue == null) {
    	        songsQueue = new LinkedList<>();
    	        recentlyPlayedSongs.put(user, songsQueue);
    	    }
    	    songsQueue.offer(song);
    	    if (songsQueue.size() > capacity) {
    	        songsQueue.poll();
    	    }
    }

    public List<String> getRecentlyPlayedSongs(String user) {
    	Queue<String> songsQueue = recentlyPlayedSongs.get(user);
        if (songsQueue != null) {
            return new LinkedList<>(songsQueue);
        } else {
            return new LinkedList<>();
        }
    }

}

