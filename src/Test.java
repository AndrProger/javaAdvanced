import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Scanner scanner =new Scanner(System.in);
        //название класса 1  название класса 2 Название метода
        Class<?> classObj1 = Class.forName(scanner.next());
        Class<?> classObj2 = Class.forName(scanner.next());

        String methodName = scanner.next();

        Method m =classObj1.getMethod(methodName,classObj2);

        Object o1 =classObj1.newInstance();
        Object o2 =classObj2.getConstructor(String.class).newInstance("String value");

        m.invoke(o1, o2);

        System.out.println(o1);


    }


}
