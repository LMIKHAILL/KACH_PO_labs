package duel_35;

public enum PlayerPart {
    STOMACH("Живот",5, 300), HEAD("Голова",8, 200), HEART("Сердце",15, 100);

    private final String name;
    private final int time;

    private final long difficulty;
    PlayerPart(String name, int time, long difficulty){
        this.name = name;
        this.time = time;
        this.difficulty = difficulty;
    }
    public String getName(){
        return name;
    }
    public int getTime() {
        return time;
    }
    public long getDifficulty() {
        return difficulty;
    }
}
