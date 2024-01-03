public class Toys {
    static int count;
    int id;
    String name;
    int chance;

    public Toys(String name, int chance){
        this.name = name;
        this.chance = chance;
        count += 1;
        this.id = count;
    }

}
