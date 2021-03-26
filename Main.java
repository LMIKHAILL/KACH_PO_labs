import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Main implements Calculator {

    public static void main(String[] args) {
        System.out.println("#1");
        {
            int[] array = {1, 2, 3, 4, 5, 6};
            int i = 1;
            int j = 5;
            System.out.println(Arrays.toString(array));
            swap(i, j, array);
            System.out.println("swap(" + i + ", " + j + ")");
            System.out.println(Arrays.toString(array));
        }

        System.out.println("\n#2");
        {
            int a = 34, b = 36546, c =4;
            System.out.println("min("+ a + ", " + b + ", " + c + ")");
            System.out.println(min(a,b,c));
        }

        System.out.println("\n#3");
        {
            Spaceship[] spaceships = {new Spaceship(500), new Spaceship(3000),new Spaceship(30000)};
            System.out.println("AvgSpeeed: " + spaceshipsAvgSpeed(spaceships));
            System.out.println("MinSpeed: " + spaceshipsMinSpeed(spaceships));
        }

        System.out.println("\n#4");
        {
            ArrayList<String> arrayList = new ArrayList<>();
            int i = 0, j = 4;
            arrayList.add("str1");
            arrayList.add("str2");
            arrayList.add("str3");
            arrayList.add("str4");
            arrayList.add("str5");
            System.out.println(arrayList.toString());
            System.out.println("swap(" + i +", " + j + ")");
            swap(i,j,arrayList);
            System.out.println(arrayList.toString());
        }

        System.out.println("\n#5");
        {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(-6);
            arrayList.add(2);
            arrayList.add(3);
            arrayList.add(-55);
            System.out.println(minInArea(0,3,arrayList));
        }

        System.out.println("\n#6");
        {
            Main calc = new Main();
            int a = Integer.MAX_VALUE;
            int b = 435;
            System.out.println("summ("+ a + ", " + b + ")");
            System.out.println(calc.summ(a,b));
        }

        //Найдите среднее арифметическое чисел 9_000_000_000_000_000_000 8_444_444_444_444_444_444
        System.out.println("\n#18");
        {
            BigInteger bigInteger = new BigInteger("9000000000000000000");
            bigInteger = bigInteger.add(new BigInteger("8444444444444444444"));
            bigInteger = bigInteger.divide(new BigInteger("2"));
            System.out.println(bigInteger);
        }
    }

/*  1. реализуйте метод boolean swap(int i, int j, int[] anArray),
        меняющий местами элементы по индексам i и j в массиве anArray
        и возвращающий false, если индексы выходят за пределы массива*/
    static boolean swap(int i, int j, int[] anArray){
        if(i >= anArray.length || j >= anArray.length) return false;

        int temp = anArray[i];
        anArray[i] = anArray[j];
        anArray[j] = temp;
        return true;
    }

/*  2. реализуйте метод int min(int a, int b, int c),
        находящий минимальный из трех аргументов без
        использования утилитарных функций стандартной библиотеки Java.*/
    static int min(int a, int b, int c){
        return a < b? (a < c? a : c) : ( b < c? b : c);
    }

/*  3. Имеется класс Spaceship. Создайте 3 экземпляра. Напишите методы, которые находят:
    a) среднюю скорость кораблей
    б) минимальную скорость кораблей*/
    static double spaceshipsAvgSpeed(Spaceship[] spaceships){
        double avgSpeed = 0;
        for (Spaceship spaceship: spaceships){
            avgSpeed += 1.0 * spaceship.getSpeed()/spaceships.length;
        }
        return avgSpeed;
    }
    static int spaceshipsMinSpeed(Spaceship[] spaceships){
        int min = Integer.MAX_VALUE;
        for(Spaceship spaceship: spaceships){
            if(spaceship.getSpeed() < min){
                min = spaceship.getSpeed();
            }
        }
        return min;
    }

/*  4. Напишите обобщенный метод для перестановки двух элементов в списке по индексам.
    Напишите junit-тесты.*/
    static <T> boolean swap(int i, int j, List<T> list){
        if(i >= list.size() || j>= list.size()) return false;
        T temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
        return true;
    }

/*  5. Напишите обобщенный метод для поиска минимального элемента списка
    в диапазоне [begin, end). Где [ – включительно, ) – исключительно.
    Напишите junit-тесты.*/
    static <T> T minInArea(int from, int to, List<T> list){
        if(list.size() == 0) return null;
        if(from < 0 || from >= to || to > list.size()) return null;

        double min;
        T minT;

        try {
            min = Double.parseDouble(String.valueOf(list.get(from)));
            minT = list.get(from);
        }
        catch (Exception e){
            return null;
        }

        for(int i = from; i < to; i++){
            double current = Double.parseDouble(String.valueOf(list.get(i)));
            if(min >  current){
                min = current;
                minT = list.get(i);
            }
        }
        return minT;
    }

/*  6. Дан интерфейс. Имплементируйте. Напишите junit-тесты.
    Один из тестов должен проверять сумму Integer.MAX_VALUE + 1*/
    @Override
    public int summ(int x, int y) {
        if(x > 0 && Integer.MAX_VALUE - x < y || y > 0 && Integer.MAX_VALUE - y < x) return Integer.MAX_VALUE;
        if(x < 0 && Integer.MIN_VALUE - x > y || y < 0 && Integer.MIN_VALUE - y > x) return Integer.MIN_VALUE;
        return x + y;
    }
}
