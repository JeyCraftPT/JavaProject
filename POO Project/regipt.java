import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;


public class regipt {

    private ArrayList<pt> trainers = new ArrayList<>(); // List to store personal trainers

    // Other existing methods...

    public void addTrainer(pt trainer) {
        trainers.add(trainer);
        saveTrainers();
    }

    public void saveTrainers() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("trainers.ser"))) {
            oos.writeObject(trainers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadTrainers() {
        File file = new File("trainers.ser");
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                trainers = (ArrayList<pt>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File 'trainers.ser' does not exist. Creating an empty list of trainers.");
            trainers = new ArrayList<>();
            saveTrainers(); // Save the empty list to the file
        }
    }

    public void deleteTrainer(String nameToDelete) {
        ArrayList<pt> trainersToRemove = new ArrayList<>();
        for (pt trainer : trainers) {
            if (trainer != null && trainer.getNome() != null && trainer.getNome().equals(nameToDelete)) {
                trainersToRemove.add(trainer);
            }
        }
        trainers.removeAll(trainersToRemove);
        saveTrainers();
        System.out.println("Trainer deleted successfully.");
    }

    // Other methods related to managing personal trainers...

    public ArrayList<pt> getTrainers() {
        return trainers;
    }


    public pt findTrainer(String fName, String lName) {
        for (pt trainer : trainers) {
            if (trainer != null && trainer.getNome() != null && trainer.getApelido() != null &&
                    trainer.getNome().equalsIgnoreCase(fName) && trainer.getApelido().equalsIgnoreCase(lName)) {
                return trainer; // Return the trainer if found
            }
        }
        return null; // Return null if the trainer is not found
    }

}

