package university;

import java.util.ArrayList;
import java.util.List;
import university.service.ComputerDisciplineHandler;
import university.service.DisciplineHandler;
import university.service.GeneralDisciplineHandler;
import university.service.MathDisciplineHandler;
import university.service.in.WorkloadConsoleInput;
import university.service.out.WorkLoadFormatOutput;
import university.service.out.WorkLoadInlineOutput;
import university.service.out.WorkLoadOutput;

public class Main {
    private static final List<DisciplineHandler> DISCIPLINE_HANDLER_LIST;

    static {
        DISCIPLINE_HANDLER_LIST = new ArrayList<>();
        DISCIPLINE_HANDLER_LIST.add(new GeneralDisciplineHandler());
        DISCIPLINE_HANDLER_LIST.add(new MathDisciplineHandler());
        DISCIPLINE_HANDLER_LIST.add(new ComputerDisciplineHandler());
    }

    public static void main(String[] args) {
        Workload workload = new WorkloadConsoleInput(DISCIPLINE_HANDLER_LIST).input();
        WorkLoadOutput formatOutput = new WorkLoadFormatOutput();
        formatOutput.print(workload);
        formatOutput = new WorkLoadInlineOutput();
        formatOutput.print(workload);
    }
}
