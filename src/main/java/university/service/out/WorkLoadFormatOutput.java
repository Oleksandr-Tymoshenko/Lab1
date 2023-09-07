package university.service.out;

import university.Workload;

public class WorkLoadFormatOutput implements WorkLoadOutput {
    @Override
    public void print(Workload workload) {
        System.out.println(workload.toStringFormat());
    }
}
