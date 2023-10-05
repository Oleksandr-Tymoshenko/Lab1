package university.db;

import java.util.ArrayList;
import java.util.List;
import university.model.Workload;

public class Storage {
    private static List<Workload> storageList = new ArrayList<>();

    public static List<Workload> getStorageList() {
        return storageList;
    }

    public static void setStorageList(ArrayList<Workload> workloads) {
        Storage.storageList = workloads;
    }
}
