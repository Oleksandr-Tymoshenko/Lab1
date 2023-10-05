package university;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import university.menu.Menu;
import university.menu.impl.MenuImpl;
import university.model.Workload;
import university.service.in.exceptionhandler.InputExceptionHandler;
import university.service.in.exceptionhandler.InputExceptionHandlerImpl;
import university.service.random.RandomFilledDisciplineHandler;
import university.service.random.impl.RandomFilledComputerDiscipline;
import university.service.random.impl.RandomFilledGeneralDiscipline;
import university.service.random.impl.RandomFilledMathDiscipline;
import university.strategy.DisciplineHandler;
import university.strategy.impl.ComputerDisciplineHandler;
import university.strategy.impl.GeneralDisciplineHandler;
import university.strategy.impl.MathDisciplineHandler;

public class Main {
    private static final List<DisciplineHandler> DISCIPLINE_HANDLER_LIST;
    private static final List<RandomFilledDisciplineHandler> RANDOM_DISCIPLINE_HANDLER_LIST;
    private static final InputExceptionHandler INPUT_EXCEPTION_HANDLER;

    static {
        DISCIPLINE_HANDLER_LIST = new ArrayList<>();
        DISCIPLINE_HANDLER_LIST.add(new GeneralDisciplineHandler());
        DISCIPLINE_HANDLER_LIST.add(new MathDisciplineHandler());
        DISCIPLINE_HANDLER_LIST.add(new ComputerDisciplineHandler());
        RANDOM_DISCIPLINE_HANDLER_LIST = new ArrayList<>();
        RANDOM_DISCIPLINE_HANDLER_LIST.add(new RandomFilledGeneralDiscipline());
        RANDOM_DISCIPLINE_HANDLER_LIST.add(new RandomFilledMathDiscipline());
        RANDOM_DISCIPLINE_HANDLER_LIST.add(new RandomFilledComputerDiscipline());
        INPUT_EXCEPTION_HANDLER = new InputExceptionHandlerImpl();
    }

    public static void main(String[] args) {
        Menu menu = new MenuImpl(DISCIPLINE_HANDLER_LIST);
        Scanner scanner = new Scanner(System.in);
        String menuNumber;
        do {
            menu.deserialize();
            menu.showMenu();
            System.out.print("Enter menu number -> ");
            menuNumber = scanner.nextLine();
            switch (menuNumber) {
                case "0" -> {
                }
                case "1" -> menu.print();
                case "2" -> {
                    System.out.print("Enter element index -> ");
                    int indexToPrint = INPUT_EXCEPTION_HANDLER.consoleReadInteger();
                    menu.printByNumber(indexToPrint);
                }
                case "3" -> {
                    System.out.print("Enter element index -> ");
                    int indexToDelete = INPUT_EXCEPTION_HANDLER.consoleReadInteger();
                    menu.deleteByNumber(indexToDelete);
                }
                case "4" -> menu.addElementFromConsole();
                case "4.1" -> menu.addRandomElement(RANDOM_DISCIPLINE_HANDLER_LIST);
                case "5" -> {
                    System.out.print("Enter file name -> ");
                    String textFilename = scanner.nextLine();
                    menu.addElementFromTextFile(textFilename);
                }
                case "6" -> {
                    System.out.print("Enter file name -> ");
                    String binaryFilename = scanner.nextLine();
                    menu.addElementFromBinaryFile(binaryFilename);
                }
                case "7" -> {
                    System.out.print("Enter element index -> ");
                    int indexToSaveToTextFile = INPUT_EXCEPTION_HANDLER.consoleReadInteger();
                    menu.saveToTextFileByNumber(indexToSaveToTextFile);
                }
                case "8" -> {
                    System.out.print("Enter element index -> ");
                    int indexToSaveToBinaryFile = INPUT_EXCEPTION_HANDLER.consoleReadInteger();
                    menu.saveToBinaryFileByNumber(indexToSaveToBinaryFile);
                }
                case "9" -> {
                    Comparator<Workload> comparatorByHours = Comparator
                            .comparingInt(w -> w.getDiscipline().getHours());
                    menu.sort(comparatorByHours);
                }
                case "10" -> {
                    Comparator<Workload> compareByTeacherName = Comparator
                            .comparing(o -> o.getTeacher().getRollNumber());
                    menu.sort(compareByTeacherName);
                }
                default -> System.out.println("Incorrect input value!");
            }
            menu.serialize();
        } while (!menuNumber.equals("0"));
        menu.serialize();
    }
}
