package university.menu.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import university.db.Storage;
import university.menu.Menu;
import university.model.Workload;
import university.service.in.impl.WorkloadByteFileInput;
import university.service.in.impl.WorkloadConsoleInput;
import university.service.in.impl.WorkloadRandomInput;
import university.service.in.impl.WorkloadTextFileInput;
import university.service.out.impl.WorkLoadToByteFile;
import university.service.out.impl.WorkLoadToTextFile;
import university.service.random.RandomFilledDisciplineHandler;
import university.strategy.DisciplineHandler;

public class MenuImpl implements Menu {
    private final List<DisciplineHandler> disciplineHandlerList;

    public MenuImpl(List<DisciplineHandler> disciplineHandlerList) {
        this.disciplineHandlerList = disciplineHandlerList;
    }

    @Override
    public void showMenu() {
        System.out.println("""
                0 - вихід;
                1 - вивести список;
                2 - детально елемент за номером;
                3 - вилучити елемент за номером;
                4 - додати елемент з клавіатури;
                4.1 - додати рандомний елемент;
                5 - додати елемент з текстового файлу;
                6 - додати елемент з двійкового файлу;
                7 - записати елемент у текстовий файл;
                8 - записати елемент у двійковий файл;
                9 - сортування за годинами;
                10 - сортування за номером вчителя;
                    """);
    }

    @Override
    public void print() {
        int i = 0;
        for (Workload workload : Storage.getStorageList()) {
            System.out.println(i++ + ") " + workload.toStringFormat());
            System.out.println("------------");
        }
    }

    @Override
    public void printByNumber(int index) {
        if (!checkIndex(index)) {
            System.out.println("Incorrect index!");
            return;
        }
        System.out.println(Storage.getStorageList().get(index).toStringFormat());
    }

    @Override
    public void addElementFromConsole() {
        Storage.getStorageList().add(new WorkloadConsoleInput(disciplineHandlerList).load());
    }

    @Override
    public void addRandomElement(List<RandomFilledDisciplineHandler> randomWorkloadList) {
        Storage.getStorageList().add(new WorkloadRandomInput(randomWorkloadList).load());
    }

    @Override
    public void addElementFromTextFile(String fileName) {
        try {
            Storage.getStorageList().add(new WorkloadTextFileInput(fileName).load());
        } catch (Exception e) {
            System.out.println("Can't load data from file " + fileName);
        }
    }

    @Override
    public void addElementFromBinaryFile(String fileName) {
        try {
            Storage.getStorageList().add(new WorkloadByteFileInput(fileName).load());
        } catch (Exception e) {
            System.out.println("Can't load data from file " + fileName);
        }
    }

    @Override
    public void deleteByNumber(int index) {
        if (!checkIndex(index)) {
            System.out.println("Incorrect index!");
            return;
        }
        Storage.getStorageList().remove(index);
    }

    @Override
    public void saveToTextFileByNumber(int index) {
        if (!checkIndex(index)) {
            System.out.println("Incorrect index!");
            return;
        }
        new WorkLoadToTextFile().out(Storage.getStorageList().get(index));
    }

    @Override
    public void saveToBinaryFileByNumber(int index) {
        if (!checkIndex(index)) {
            System.out.println("Incorrect index!");
            return;
        }
        new WorkLoadToByteFile().out(Storage.getStorageList().get(index));
    }

    @Override
    public void sort(Comparator<Workload> comparator) {
        Storage.getStorageList().sort(comparator);
    }

    @Override
    public void serialize() {
        try (FileOutputStream fos = new FileOutputStream("workloadData.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(Storage.getStorageList());
        } catch (IOException e) {
            throw new RuntimeException("Can't save list to file!", e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void deserialize() {
        try (FileInputStream fis = new FileInputStream("workloadData.bin");
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            Storage.setStorageList((ArrayList<Workload>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Can't read list from file", e);
        }
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < Storage.getStorageList().size();
    }
}
