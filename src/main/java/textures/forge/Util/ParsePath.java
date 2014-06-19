package textures.forge.Util;

import java.util.*;

public class ParsePath {
  
  public ArrayList ParseBlockPath(String path, String tiles){
    
    //Standardize input to forward slashes, expand mcpatcher
    path = path.replaceAll("\\", "/").replace("{mcpatcher}", "assets/minecraft/mcpatcher/ctm/");
    tiles = tiles.replaceAll("\\", "/").replace("{mcpatcher}", "assets/minecraft/mcpatcher/ctm/");
    
    //Expand domain
    String domain = path.split(":")[0];
    path.replaceAll("^.*(?=(\\:))", ("assets/" + domain + "/textures/blocks/"));

    //Declare and construct a string arrayList from: tile split by commas
    ArrayList<String> pathList = new ArrayList<String>(Arrays.asList(tiles.split("\\s*,\\s*")));
    
    
    for (String subTile : pathList){
      
      //Prepend path to relative tiles
      if (subTile.startsWith("/")){
        subTile = (path + subTile);
      }
    }
    return pathList;
  }
}