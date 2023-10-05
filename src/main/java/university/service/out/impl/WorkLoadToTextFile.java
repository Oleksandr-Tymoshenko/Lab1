package university.service.out.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import university.model.Workload;
import university.service.out.WorkLoadOutput;

public class WorkLoadToTextFile implements WorkLoadOutput {
    private static final String FILENAME = "workloadData.txt";

    @Override
    public void out(Workload workload) {
        try {
            Files.writeString(Path.of(FILENAME), workload.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + FILENAME, e);
        }
    }
}
