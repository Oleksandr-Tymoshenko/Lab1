package university.service.in.exceptionhandler;

public interface InputExceptionHandler {
    int consoleReadInteger();

    long consoleReadLong();

    double consoleReadDouble();

    Object consoleReadEnum(Class<?> enumClass);
}
