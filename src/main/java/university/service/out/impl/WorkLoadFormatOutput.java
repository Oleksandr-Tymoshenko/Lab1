package university.service.out.impl;

import university.model.Workload;
import university.service.out.WorkLoadOutput;

public class WorkLoadFormatOutput implements WorkLoadOutput {
    @Override
    public void out(Workload workload) {
        System.out.println(workload.toStringFormat());
    }
}
