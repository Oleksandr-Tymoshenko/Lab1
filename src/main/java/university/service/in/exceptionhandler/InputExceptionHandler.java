package university.service.in.exceptionhandler;

public interface InputExceptionHandler {
    int ConsoleReadInteger();

    long ConsoleReadLong();

    double ConsoleReadDouble();

    Object ConsoleReadEnum(Class<?> enumClass);
}
