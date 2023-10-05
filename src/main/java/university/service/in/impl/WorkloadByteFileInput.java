package university.service.in.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import university.model.Workload;
import university.service.in.WorkloadInput;

public class WorkloadByteFileInput implements WorkloadInput {
    private String fileName = "workload.bin";

    public WorkloadByteFileInput() {
    }

    public WorkloadByteFileInput(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Workload load() {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (Workload) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Can't load data from file " + fileName, e);
        }
    }
}
