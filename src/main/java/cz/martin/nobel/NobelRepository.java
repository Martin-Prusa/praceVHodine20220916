package cz.martin.nobel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NobelRepository {

    public List<Nobel> load() {
        ArrayList<Nobel> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("nobel.txt"));
            br.readLine();
            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split("\\|");
                list.add(new Nobel(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2]));
                line = br.readLine();
            }
            br.close();
        } catch (IOException ignored) {}
        return list;
    }
}
