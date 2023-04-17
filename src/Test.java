import java.lang.annotation.Target;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test {

    public static void main(String[] args) {
        /*
         * \\d -одна цифра
         * \\w -одна буква
         *
         * + - один или более
         * * - ноль или болеее
         * ? - ноль или один символ до
         *
         * (x|y|z) -  или
         * [a-zA-Z] - все английские буквы
         *[^abc]- исключение симвоов a b c
         *
         * . -любой символ
         * {2} - точное количество символов не больше не меньше
         *  {2,} -от 2 символов
         * {2,4} - от 2 до 4
         * */
        String a = "-234";
        String b = "234";
        String c = "+234";
        System.out.println(a.matches("(-|\\+)?\\d*"));
        System.out.println(b.matches("(-|\\+)?\\d*"));
        System.out.println(c.matches("(-|\\+)?\\d*"));

        String d="1213";
        System.out.println(d.matches("[a-zA-Z]*\\d+"));

        String e="helloa";
        System.out.println(e.matches("[^abc]*"));

        String url="http://www.google.com";
        String url2="http://www.yandex.ru";
        String url3="hello there";
        System.out.println(url.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));
        System.out.println(url2.matches("http://www\\..+\\.(com|ru)"));

        String f="123";
        System.out.println(f.matches("\\d{2}"));

        String g="d";
        System.out.println(g.matches("\\w"));
    }
}