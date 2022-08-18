package com.epam.mjc.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException {

        FileInputStream fileInputStream = null;
        StringBuilder sb = null;
        try {
            fileInputStream = new FileInputStream(file);
            sb = new StringBuilder();
            int ch;
            while ((ch = fileInputStream.read()) != -1){
                sb.append((char) ch);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            fileInputStream.close();
        }

        String[] arr = sb.toString().split("\n");
        Profile profile = new Profile();

        profile.setName(arr[0].split("\\s+")[1]);
        profile.setAge(Integer.parseInt(arr[1].split("\\s+")[1]));
        profile.setEmail(arr[2].split("\\s+")[1]);
        profile.setPhone(Long.parseLong(arr[3].split("\\s+")[1]));

        return profile;
    }
}
