package university.service;

import java.util.List;

public class DisciplineStrategyImpl implements DisciplineStrategy {
    private final List<DisciplineHandler> disciplineHandlerList;

    public DisciplineStrategyImpl(List<DisciplineHandler> disciplineHandlerList) {
        this.disciplineHandlerList = disciplineHandlerList;
    }

    @Override
    public DisciplineHandler getDiscipline(Integer index) {
        return disciplineHandlerList.get(index);
    }
}
