package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class HumanFileManager {

    List<Human> humans = new ArrayList<>();

    public List<Human> getHumans() {
        return new ArrayList<>(humans);
    }

    public void readHumansFromFile(Path path) {
        try {
            for (String s : Files.readAllLines(path)) {
                String[] split = s.split(";");
                humans.add(new Human(split[0], split[1]));
            }
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
    }

    public void writeMaleHumansToFile(Path path) {
        List<String> results = new ArrayList<>();

        for (Human human : humans) {
            if (!"2".equals(human.getIdentityNumber().substring(0, 1))) {
                results.add(human.getName().concat(";").concat(human.getIdentityNumber()));
            }
        }

        try {
            Files.write(path, results);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't write file!", ioe);
        }
    }
}
