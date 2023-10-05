package university.strategy.impl;

import java.util.List;
import university.strategy.DisciplineHandler;
import university.strategy.DisciplineStrategy;

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
