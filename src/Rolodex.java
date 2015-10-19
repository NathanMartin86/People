import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by macbookair on 10/19/15.
 */
public class Rolodex{
    public static void main(String[] args) throws IOException {
        HashMap<String, ArrayList<People>> rolo = new HashMap<>();
        File f = new File("people.csv");
        String content = readFile("people.csv");
        String[] lines = content.split("\n");
        Scanner scanner = new Scanner (System.in);
        try {
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] contents = new char[fileSize];
            fr.read(contents);

        } catch (Exception e) {
            System.out.println("There was an error reading the file");
        }


        for (int i =1; i<lines.length; i++) {
            String[] position = lines[i].split(",");
            String pos = position[0];
            String firstname = position[1];
            String lastname = position[2];
            String email = position[3];
            String country = position[4];
            String ip = position[5];

            People p = new People(Integer.valueOf(pos), firstname, lastname, email, country, ip);
            if (rolo.containsKey(country)){
                rolo.get(country).add(p);
            }else {
                ArrayList<People> persons = new ArrayList();
                persons.add(p);
                rolo.put(country,persons);
            }
        } for (Map.Entry<String,ArrayList<People>> list : rolo.entrySet()){
            Collections.sort(list.getValue());
            System.out.println(String.format("%s",list.getValue()));
        }
    }
    static String readFile(String fileName) {
        try {
            File f = new File(fileName);
            FileReader fr = new FileReader(f);
            int fileSize = (int) f.length();
            char[] fileContent = new char[fileSize];
            fr.read(fileContent);
            return new String(fileContent);
        } catch (Exception e) {
            return null;
        }
    }
}