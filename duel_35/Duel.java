package duel_35;
/*
        Игра на реакцию и точность.
        Два игрока. При старте - вводят свои имена.
        "Стреляют" по очереди. После вывода программой строки "к барьеру"
        игрок1 отсчитывает про себя X секунд и нажимает Ввод, являющийся сигналом к выстрелу.
        "Смертельный выстрел" должен попасть в окрестность точки t=X секунд.
        Количество X секунд определяется выбором части тела,
        в которую производится выстрел: сердце - 15, голова - 8, живот - 5.
        Размер окрестности определяется уровнем сложности и составляет на сложном уровне +\- 100 мс,
        на среднем +\- 200 мс, на легком +\- 300 мс. Промах игрока1 передает ход игроку2.
        Персистенция результатов игроков в файл + 10 баллов (сохранение количества "выбитых" баллов 15/8/5 для каждого игрока и загрузка этих результатов при старте - вывод таблицы результатов)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Duel {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cls();
        System.out.println("Игрок №1 введите свое имя:");
        Player player1 = new Player(reader.readLine());
        cls();
        System.out.println("Игрок №2 введите свое имя:");
        Player player2 = new Player(reader.readLine());

        Player shooter = player1;
        Player target = player2;

        while (true) {
            cls();
            PlayerPart targetPart = shooter.readPlayerPart(reader,target);
            cls();
            System.out.println(shooter.name + ". Вы готовы? (Нажмите Enter)");
            reader.readLine();
            System.out.println("Start (Нажмите Enter через " + targetPart.getTime() + " сек.)");
            long timeGoal = System.currentTimeMillis();
            reader.readLine();
            long timeResult = System.currentTimeMillis() - timeGoal;
            System.out.println("Цель: " + targetPart.getTime()*1000.0/1000.0 + " сек.\n" +
                    "Результат:" + timeResult/1000.0 + " сек.");
            if(shooter.shootPlayer(target, targetPart,timeResult)){
                System.out.println(target.name + " теряет " + targetPart.getName());
                if(!target.isAlive()) {
                    System.out.println(target.name + " погиб.");
                    break;
                }
            }
            else {
                Player temp = shooter;
                shooter = target;
                target = temp;
            }
        }

        System.out.println("\n" + shooter.getName() + " - победил!");
        reader.close();
    }



    public static void cls(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
