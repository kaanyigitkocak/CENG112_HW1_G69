import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileIO {

    private final String FILE_NAME = "garbage.txt";
    private IBag<Garbage> trashCan;

    public FileIO() {
        this.trashCan = new TrashCan<Garbage>();
    }

    public IBag<Garbage> readTrashCan() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line = reader.readLine();

            while (line != null) {
                String[] tokens = line.split(",");
                String garbageName = tokens[0].trim();
                String garbageType = tokens[1].trim();
                int amount = Integer.parseInt(tokens[2].trim());

                Garbage garbage = new Garbage(garbageName, garbageType,amount);
                this.trashCan.add(garbage);

                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.trashCan;
    }

    public boolean updateTrashCan() {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);

            for (int i = 0; i < this.trashCan.getItemCount(); i++) {
                Garbage garbage = this.trashCan.remove();
                writer.write(garbage.getGarbageName() + ", " + garbage.getGarbageType() + "\n");
            }

            writer.close();
            
            readTrashCan();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
