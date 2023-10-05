package university.menu;

import java.util.Comparator;
import java.util.List;
import university.model.Workload;
import university.service.random.RandomFilledDisciplineHandler;

public interface Menu {
    void showMenu();

    void print();

    void printByNumber(int index);

    void addElementFromConsole();

    void addRandomElement(List<RandomFilledDisciplineHandler> randomWorkloadList);

    void addElementFromTextFile(String fileName);

    void addElementFromBinaryFile(String fileName);

    void deleteByNumber(int index);

    void saveToTextFileByNumber(int index);

    void saveToBinaryFileByNumber(int index);

    void sort(Comparator<Workload> comparator);

    void serialize();

    void deserialize();
}
