package com.demisardonic.astroids;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.GdxRuntimeException;

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
            // TODO logging for missing textures
            if (paths.containsKey(key))
                path = paths.get(key);
            else
                // Default texture when texture key is not registered
                return texture("default");
            try {
                textures.put(key, new Texture(path));
            } catch (GdxRuntimeException e) {
                // Default texture when png is missing.
                return texture("default");
            }

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
