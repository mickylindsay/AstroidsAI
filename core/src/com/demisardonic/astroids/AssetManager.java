package com.demisardonic.astroids;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class AssetManager {
    private static AssetManager manager = null;

    public static AssetManager instance() {
        if (manager == null)
            manager = new AssetManager();
        return manager;
    }

    private Map<String, String> paths;
    private Map<String, Texture> textures;

    private AssetManager() {
        paths = new HashMap<String, String>();
        textures = new HashMap<String, Texture>();
    }

    public Texture texture(String key) {
        if (!textures.containsKey(key)) {
            String path = key;
            if (paths.containsKey(key))
                path = paths.get(key);
            // TODO: Error handling for missing asset
            textures.put(key, new Texture(path));
        }
        return textures.get(key);
    }

    public void registerPath(String key, String path){
        // TODO: Error handling for invalid path
        paths.put(key, path);
    }

    public void dispose(){
        for(Texture t: textures.values()){
            t.dispose();
        }
        textures.clear();
    }
}
