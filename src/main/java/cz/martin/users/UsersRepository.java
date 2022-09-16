package cz.martin.users;

import cz.martin.nobel.Nobel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersRepository {

    public List<User> load() {
        ArrayList<User> list = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("passwd"));
            String line = br.readLine();
            while (line != null) {
                String[] splitLine = line.split(":");
                list.add(new User(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2]), Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5], splitLine[6]));
                line = br.readLine();
            }
            br.close();
        } catch (IOException ignored) {}
        return list;
    }

}
