import java.io.*;

public class FileIO {

    private IBag<Garbage> trashCan;

    public FileIO() {
        this.trashCan = new TrashCan<Garbage>();
    }

    //The data retrieved from the garbage.txt file is used to create objects based on the number of garbage entries,
    // and these objects are then added to the list inside the TrashCan class.
    //                                  olive  packet,plastic,1
    //olive  packet,plastic,3    ===>   olive  packet,plastic,1
    //                                  olive  packet,plastic,1
    public IBag<Garbage> readTrashCan() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src//garbage.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] tokens = line.split(",");
                String garbageName = tokens[0].trim();
                String garbageType = tokens[1].trim();
                int amount = Integer.parseInt(tokens[2].trim());

                Garbage garbage = new Garbage(garbageName, garbageType,1);
                for( int i = 1; i<= amount;i++) {
                    this.trashCan.add(garbage);
                }
                line = reader.readLine();
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return this.trashCan;
    }

    // It takes the objects created based on the number of garbage items from the garbage.txt file
    // and adds them to the list inside the TrashCan class. Then, it takes the elements in the list
    // of the TrashCan class that have not been added to the bins and transfers them into the updated_garbage.txt file.
    // The updated_garbage.txt file will be created when you start the application.
    public boolean updateTrashCan(IBag<Garbage> trashCan) {

        boolean hasRemainingGarbage = false;
        File updatedFile = new File("src//updated_garbage.txt");
        try {
            FileWriter writer = new FileWriter(updatedFile);

            //If we call the display method directly with the items list returned by the add method in the FileIO class
            //it would print the same object three times since the add method adds each garbage object one by one
            //(for example olive  packet,plastic,3 creating three entries in the list for an object with a count of 3)
            // Therefore, we try to prevent this repetition when displaying by implementing a check in the code.
            //olive  packet,plastic,1
            //olive  packet,plastic,1    ===> olive  packet,plastic,3
            //olive  packet,plastic,1

            for (int a = 0; a < trashCan.getItemCount(); a++) {
                Garbage garbage = trashCan.getByIndex(a);
                int count = 1;
                if (a>0 && garbage.getGarbageName().equals(trashCan.getByIndex(a-1).getGarbageName())) {
                    continue;
                }
                for (int i = a + 1; i < trashCan.getItemCount(); i++) {
                    if (garbage.getGarbageName().equals(trashCan.getByIndex(i).getGarbageName())) {
                        count++;
                    }
                    else{break;}
                }
                garbage.setAmount(count);
                writer.write(garbage.toString() + "\n");
                hasRemainingGarbage = true;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return hasRemainingGarbage;
    }
}
