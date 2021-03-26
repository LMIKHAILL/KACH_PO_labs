import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class MainTest {
    //#4
    @Test
    public void swap () {
    ArrayList<Integer> actualArrayList = new ArrayList<>();
    int n1 = 53, n2 = 101;
    actualArrayList.add(n1);
    actualArrayList.add(n2);
    Main.swap(0, 1, actualArrayList);
    ArrayList<Integer> expectedArrayList = new ArrayList<>();
    expectedArrayList.add(n2);
    expectedArrayList.add(n1);
    assertEquals(expectedArrayList, actualArrayList);
    }


    //#5
    @Test
    public void minInArea1() {
        ArrayList<Float> arrayList = new ArrayList<>();
        Float expected = -2f;
        arrayList.add(expected);
        arrayList.add(20f);
        arrayList.add(3f);
        arrayList.add(-100f);
        Float actual = Main.minInArea(0,2,arrayList);
        assertEquals(expected, actual);
    }
    @Test
    public void minInArea2() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");
        arrayList.add("d");
        String actual = Main.minInArea(0,2,arrayList);
        assertNull(actual);
    }
    @Test
    public void minInArea3() {
        ArrayList<Float> arrayList = new ArrayList<>();
        arrayList.add(-2f);
        arrayList.add(20f);
        arrayList.add(3f);
        arrayList.add(-100f);
        Float actual = Main.minInArea(10,2,arrayList);
        assertNull(actual);
    }


    //#6
    @Test
    public void summ1(){
        Main calc = new Main();
        assertEquals(Integer.MAX_VALUE, calc.summ(Integer.MAX_VALUE,1));
    }
    @Test
    public void summ2(){
        Main calc = new Main();
        assertEquals(Integer.MIN_VALUE, calc.summ(Integer.MIN_VALUE,-100));
    }
    @Test
    public void summ3(){
        Main calc = new Main();
        int a = -5435;
        int b = 23565;
        assertEquals(a + b, calc.summ(a,b));
    }


}