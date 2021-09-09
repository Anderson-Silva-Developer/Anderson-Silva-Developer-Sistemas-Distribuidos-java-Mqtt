package convert;

import org.json.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Base64;
import java.util.Random;

public class Convert {

    public Convert() {
    }
    public byte[] convertJsonToByte( JSONObject jsonmsg,String key){

        try {
            return Base64.getDecoder().decode(jsonmsg.get(key).toString().getBytes(StandardCharsets.UTF_8));
        }catch (Exception e){
            System.out.println("Error to convert");

        }

        return new byte[0];
    }
    public JSONObject convertByteToJson(byte[] payload){
        try {
            return  new JSONObject(new String(payload));
        }catch (Exception e){
            System.out.println("Error to convert "+e.getMessage());
        }
        return null;
    }
    public File convertPathNametoFile(String pathfile){
        try {
            return new File(pathfile);
        }catch (Exception e){
            System.out.println("Error create File");

        }
        return null;
    }
    public InputStream createInputStream(byte[] videoFilebytes){
        try {
            return new ByteArrayInputStream(videoFilebytes);
        }catch (Exception e){
            System.out.println("Error create InputStream");

        }

        return null;
    }
    public void createFilecopy(InputStream inputStream, File file){
        try {
            Files.copy(inputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception e){
            System.out.println("Error create InputStream");

        }
    }
    public byte[] convertPathNametoByte(String path) throws IOException {
        InputStream is = new FileInputStream(path);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return buffer;
    }

}
