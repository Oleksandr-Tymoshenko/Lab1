package university.service.out.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import university.model.Workload;
import university.service.out.WorkLoadOutput;

public class WorkLoadToByteFile implements WorkLoadOutput {
    private static final String FILENAME = "workload.bin";

    @Override
    public void out(Workload workload) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(FILENAME);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(workload);
        } catch (IOException e) {
            throw new RuntimeException("Can't print out data to file " + FILENAME, e);
        }
    }
}
