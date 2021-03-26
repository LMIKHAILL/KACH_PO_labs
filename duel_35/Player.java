package duel_35;

import java.io.BufferedReader;

class Player {
    String name;

    private boolean stomach;
    private boolean head;
    private boolean heart;

    Player(String name) {
        this.name = name;
        stomach = true;
        head = true;
        heart = true;
    }

    public boolean isAlive(){
        return stomach || head || heart;
    }

    public boolean shootPlayer(Player player, PlayerPart playerPart, long resultTime) {
        //if(Math.abs((playerPart.getTime() * 1000L) - resultTime) < playerPart.getDifficulty() * 100L) {
        if(Math.abs((playerPart.getTime() * 1000L) - resultTime) < playerPart.getDifficulty()) {
            switch (playerPart) {
                case STOMACH:
                    player.setStomach(false);
                    break;
                case HEAD:
                    player.setHead(false);
                    break;
                case HEART:
                    player.setHeart(false);
                    break;
            }
            return true;
        }
        return false;
    }



    public PlayerPart readPlayerPart(BufferedReader reader, Player target) {
        if(!target.isAlive()) return null;
        System.out.println(this.name + " выберите свою цель.(Введите число)");
        if (target.isStomach()) System.out.println("1 - " + PlayerPart.STOMACH.getName() + "(" + PlayerPart.STOMACH.getTime() + " сек.)");
        if (target.isHead()) System.out.println("2 - " + PlayerPart.HEAD.getName() + "(" + PlayerPart.HEAD.getTime() + " сек.)");
        if (target.isHeart()) System.out.println("3 - " + PlayerPart.HEART.getName() + "(" + PlayerPart.HEART.getTime() + " сек.)");
        while (true) {
            try {
                int var = Integer.parseInt(reader.readLine());
                if (var > 3 || var < 1) continue;
                System.out.print("Выбранная цель:");
                switch (var){
                    case 1:
                        if(!target.isStomach()){
                            System.out.println(PlayerPart.STOMACH.getName() + " отсутствует, выбрерите другую часть тела");
                            continue;
                        }
                        System.out.println(PlayerPart.STOMACH.getName() + "(" + PlayerPart.STOMACH.getTime() + " сек.)");
                        return PlayerPart.STOMACH;
                    case 2:
                        if(!target.isHead()){
                            System.out.println(PlayerPart.HEAD.getName() + " отсутствует, выбрерите другую часть тела");
                            continue;
                        }
                        System.out.println(PlayerPart.HEAD.getName() + "(" + PlayerPart.HEAD.getTime() + " сек.)");
                        return PlayerPart.HEAD;
                    default:
                        if(!target.isHeart()){
                            System.out.println(PlayerPart.HEART.getName() + " отсутствует, выбрерите другую часть тела");
                            continue;
                        }
                        System.out.println(PlayerPart.HEART.getName() + "(" + PlayerPart.HEART.getTime() + " сек.)");
                        return PlayerPart.HEART;
                }
            }
            catch (Exception e){
                System.out.println("Неверный ввод, укажите число от 1 до 3");
            }
        }
    }

    public String getName() {
        return name;
    }

    public boolean isStomach() {
        return stomach;
    }

    public boolean isHead() {
        return head;
    }

    public boolean isHeart() {
        return heart;
    }
    public void setStomach(boolean stomach) {
        this.stomach = stomach;
    }

    public void setHead(boolean head) {
        this.head = head;
    }

    public void setHeart(boolean heart) {
        this.heart = heart;
    }

    /*
    public static void readDifficulty(BufferedReader reader) {
        System.out.println("Выберите сложность. Введите число от 1 до 3");
        System.out.println("1 - сложно");
        System.out.println("2 - нормально");
        System.out.println("3 - легко");
        while (true) {
            try {
                difficulty = Integer.parseInt(reader.readLine());
                if (difficulty > 3) difficulty = 3;
                if (difficulty < 1) difficulty = 1;
                System.out.print("Выбранная сложность:");
                switch (difficulty){
                    case 1:
                        System.out.println("Сложно");
                        break;
                    case 2:
                        System.out.println("Нормально");
                        break;
                    case 3:
                        System.out.println("Легко");
                        break;
                }
                break;
            }
            catch (Exception e){
                System.out.println("Неверный ввод, укажите число от 1 до 3");
            }
        }
    }
*/
}
