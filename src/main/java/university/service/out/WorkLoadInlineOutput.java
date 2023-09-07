package university.service.out;

import university.Workload;

public class WorkLoadInlineOutput implements WorkLoadOutput {
    @Override
    public void print(Workload workload) {
        System.out.println(workload);
    }
}
