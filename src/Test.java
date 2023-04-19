import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String test=":rfwewfwe tgwflwrle, star@gmail.com " +
                "reewf rwe e ertewfw tewfwe re@yandex.ru";
        Pattern email=Pattern.compile("(\\w+)@(gmail|yandex)\\.(com|ru)");
        Matcher matcher= email.matcher(test);

        while (matcher.find()){
            System.out.println(matcher.group(1));
        }
    }
}