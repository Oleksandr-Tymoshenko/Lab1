package university;

import university.service.ComputerDisciplineHandler;
import university.service.DisciplineHandler;
import university.service.GeneralDisciplineHandler;
import university.service.MathDisciplineHandler;
import university.service.in.WorkloadConsoleInput;
import university.service.out.WorkLoadFormatOutput;
import university.service.out.WorkLoadInlineOutput;
import university.service.out.WorkLoadOutput;
import java.util.ArrayList;
import java.util.List;

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
        WorkLoadOutput FORMAT_OUTPUT = new WorkLoadFormatOutput();
        FORMAT_OUTPUT.print(workload);
        FORMAT_OUTPUT = new WorkLoadInlineOutput();
        FORMAT_OUTPUT.print(workload);
    }
}
