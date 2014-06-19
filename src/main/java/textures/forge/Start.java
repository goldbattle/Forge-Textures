package textures.forge;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Start {

  /*
   * To be authenticated when launching the game from eclipse, create a new Launch Configuration with this class as the Main class.
   * 
   * In the arguments tab add "[YOUR_USERNAME(or email)] [YOUR_PASSWORD]" for the program arguments.
   * Add "-Xincgc -Xmx1024M -Xms1024M -Dfml.ignoreInvalidMinecraftCertificates=true" as a VM argument.
   */
  public static void main(String[] args) {

    // Parameters
    String USERNAME = args[0];
    String PASSWORD = args[1];

    // Post string
    String json = String.format("{\"agent\": {\"name\": \"Minecraft\", \"version\": 1}, \"username\": \"%s\", \"password\": \"%s\"}", USERNAME, PASSWORD);

    HttpURLConnection connection = null;
    URL url;
    try {
      url = new URL("https://authserver.mojang.com/authenticate");
      // Create request
      connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("POST");
      connection.setRequestProperty("Content-Type", "application/json");
      connection.setUseCaches(false);
      connection.setDoInput(true);
      connection.setDoOutput(true);
      DataOutputStream e = new DataOutputStream(connection.getOutputStream());
      e.writeBytes(json);
      e.flush();
      e.close();
      InputStream is = connection.getInputStream();
      BufferedReader rd = new BufferedReader(new InputStreamReader(is));
      StringBuffer response = new StringBuffer();
      // Read in request
      String line;
      while ((line = rd.readLine()) != null) {
        response.append(line);
        response.append('\r');
      }
      rd.close();
      String r = response.toString();
      // Fine info from post json
      String uuid = r.substring(r.indexOf("\"id\":\"") + 6, r.indexOf("\",\"name\""));
      String user = r.substring(r.indexOf("\"name\":\"") + 8, r.indexOf("\"},\""));
      String accessToken = r.substring(16, r.indexOf("\",\"clientToken\""));
      // Create runtime command
      String newArg = "--version 1.6 --tweakClass cpw.mods.fml.common.launcher.FMLTweaker --accessToken " + accessToken + " --username " + user + " --uuid " + uuid;
      // Debug
      System.out.println(newArg);
      // Launch from main launcher
      net.minecraft.launchwrapper.Launch.main(newArg.split(" "));
    } catch (MalformedURLException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

}
