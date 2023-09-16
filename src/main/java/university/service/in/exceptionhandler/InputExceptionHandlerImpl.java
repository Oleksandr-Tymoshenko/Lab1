package university.service.in.exceptionhandler;
import java.lang.reflect.Method;
import java.util.Scanner;

public class InputExceptionHandlerImpl implements InputExceptionHandler {
    private final Scanner in;

    public InputExceptionHandlerImpl() {
        in = new Scanner(System.in);
    }

    @Override
    public int ConsoleReadInteger() {
        while (true) {
            String input = in.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException  e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }
    }

    @Override
    public long ConsoleReadLong() {
        while (true) {
            String input = in.nextLine();
            try {
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }
    }

    @Override
    public double ConsoleReadDouble() {
        while (true) {
            String input = in.nextLine();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }
    }

    @Override
    public Object ConsoleReadEnum(Class<?> enumClass) {
        while (true) {
            String enumInput = in.nextLine().toUpperCase();
            try {
                Method valueOf = enumClass.getMethod("valueOf", String.class);
                return valueOf.invoke(enumClass, enumInput);
            } catch (Exception e) {
                System.out.println("Incorrect input value! Try again");
                System.out.print("--> ");
            }
        }
    }
}
