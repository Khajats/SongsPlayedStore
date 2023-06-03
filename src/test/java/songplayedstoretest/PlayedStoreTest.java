package songplayedstoretest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import songsplayedstore.RecentlyPlayedSongsStore;

public class PlayedStoreTest {
	
	@Test
	public void testAddSongWithCapacityExceeded() {
		 RecentlyPlayedSongsStore store = new RecentlyPlayedSongsStore(3);

	        store.addSong("user1", "S1");
	        store.addSong("user1", "S2");
	        store.addSong("user1", "S3");
	        
	        store.addSong("user1","S4");
	        List<String> recentlyPlayedSongs = store.getRecentlyPlayedSongs("user1");
	        Assert.assertEquals(recentlyPlayedSongs.size(), 3);
	        Assert.assertEquals(recentlyPlayedSongs.get(0), "S2");
	        Assert.assertEquals(recentlyPlayedSongs.get(1), "S3");
	        Assert.assertEquals(recentlyPlayedSongs.get(2), "S4");
	        
	        store.addSong("user1", "S2");
	        List<String> recentlyPlayedSongs1 = store.getRecentlyPlayedSongs("user1");
	        Assert.assertEquals(recentlyPlayedSongs1.size(), 3);
	        Assert.assertEquals(recentlyPlayedSongs1.get(0), "S3");
	        Assert.assertEquals(recentlyPlayedSongs1.get(1), "S4");
	        Assert.assertEquals(recentlyPlayedSongs1.get(2), "S2");
	        
	        store.addSong("user1", "S1");
	        List<String> recentlyPlayedSongs2 = store.getRecentlyPlayedSongs("user1");
	        Assert.assertEquals(recentlyPlayedSongs2.size(), 3);
	        Assert.assertEquals(recentlyPlayedSongs2.get(0), "S4");
	        Assert.assertEquals(recentlyPlayedSongs2.get(1), "S2");
	        Assert.assertEquals(recentlyPlayedSongs2.get(2), "S1");
	        
	}

}
