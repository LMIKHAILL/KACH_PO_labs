package robot_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Robot{
    public static void main(String[] args) throws IOException, InterruptedException {
        Robot robot = new Robot();
        robot.startRobot();

    }

    private void startRobot() throws IOException, InterruptedException {
        Thread leftLeg = new Thread(new LeftLeg());
        Thread rightLeg = new Thread(new RightLeg());
        System.out.println("Робот пошел! (Нажмите Enter чтобы остановить)");
        leftLeg.start();
        rightLeg.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        leftLeg.interrupt();
        rightLeg.interrupt();
        while (leftLeg.isAlive() || rightLeg.isAlive()){
            Thread.sleep(100);
        }
        System.out.println("Робот остановился.");
    }


    boolean left = true;
    class LeftLeg implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    if (left) {
                        Thread.sleep(1000);
                        System.out.println("Левая нога");
                        left = false;
                    }
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Левая нога опущена.");
            }
        }
    }
    class RightLeg implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    if (!left) {
                        Thread.sleep(1000);
                        System.out.println("Правая нога");
                        left = true;
                    }
                    Thread.sleep(100);
                }
            }
            catch (InterruptedException e) {
                System.out.println("Правая нога опущена.");
            }
        }
    }
}
