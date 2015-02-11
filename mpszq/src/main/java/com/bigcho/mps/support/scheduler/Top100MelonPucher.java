package com.bigcho.mps.support.scheduler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

import com.bigcho.mps.application.album.service.AlbumService;
import com.bigcho.mps.util.CommonUtility;

@Component("top100MelonPucher")
public class Top100MelonPucher {
	@Resource(name = "albumService")
	private AlbumService albumService;
	
	public void printAnotherMessage() {
        System.out.println("Go Cho's schduler!");
        
        try {
			//schedulingInsert("http://apis.skplanetx.com/melon/charts/todaytopsongs?version=1&page=1&count=100&format=json&appKey=c4728efb-e0dd-3d31-8445-7624ac0307ce");
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
	
	/*public void schedulingInsert(String _url) throws IOException, JSONException{
        URL url = new URL(_url);
        InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
        JSONTokener tokenizer = new JSONTokener(reader);
        JSONObject jsonObject = new JSONObject(tokenizer);
        
        JSONObject melon = (JSONObject)(jsonObject.get("melon"));
        JSONObject asongs = (JSONObject)(melon.get("songs"));
        JSONArray songs = (JSONArray)asongs.get("song");
        
        Album album = new Album();
        album.setTitle(CommonUtility.getCurrentServerByFormat("yyyy년 MM월 dd일")+" 멜론 BEST 100곡");
        album.setYoutubes(saveYoutubeOne(songs));
        albumService.saveAlbum(album);
    }
    
    public List<Youtube> saveYoutubeOne(JSONArray songs) throws UnsupportedEncodingException, IOException, JSONException{
    	List<Youtube> youtubes = new ArrayList<Youtube>();
    	
    	for(int i = 0 ; i < songs.length(); i++) {
    		Youtube youtube = new Youtube();
        	JSONObject obj1 = (JSONObject) songs.get(i);
        	String searchTitle = obj1.get("songName").toString();
        	
        	URL url = new URL("http://gdata.youtube.com/feeds/videos?start-index=1&max-results=1&alt=json&format=5&vq="+URLEncoder.encode(searchTitle, "UTF-8"));
            InputStreamReader reader = new InputStreamReader(url.openConnection().getInputStream(), "UTF-8");
            JSONTokener tokenizer = new JSONTokener(reader);
            JSONObject jsonObject = new JSONObject(tokenizer);
            
            JSONObject feed = (JSONObject)(jsonObject.get("feed"));
            JSONArray entrise = (JSONArray)feed.get("entry");
            
            for(int j = 0 ; j < entrise.length(); j++) {
                JSONObject entry = (JSONObject) entrise.get(j);
                JSONObject titler = (JSONObject) entry.get("title");
                String title = (String) titler.get("$t");
                JSONObject idr = (JSONObject) entry.get("id");
                String oid = (String) idr.get("$t");
                String id = oid.substring(oid.lastIndexOf("/")+1);
                System.out.println(title.replace("%", ""));
                youtube.setPlayId(id);
                youtube.setTitle(title.replace("%", ""));
            }
            
            youtubes.add(youtube);
        }

    	
        
        return youtubes;
    }
    */
}
