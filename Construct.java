import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class Construct {

    private Queue<Toys> liToys;

    ListToys head = null;

    public Construct(){
        liToys = new ArrayBlockingQueue<Toys>(10);
    }

    public void Add(String name, int chance){
        if(head == null){
            head = new ListToys(new Toys(name, chance));
        }else {
            ListToys buf = head;
            head = new ListToys(new Toys(name, chance));
            head.next = buf;
        }
    }

    public void Put() throws IOException{
        ListToys work = head;
        int chances = 0;
        while (true){
            chances += work.toy.chance;
            work = work.next;
            if(work == null){
                break;
            }
        }
        Random random = new Random();
        chances = random.nextInt(chances);
        work = head;
        while (true){
            chances -= work.toy.chance;
            if (chances <= 0){
                break;
            }
            work = work.next;
            if(work == null){
                break;
            }
        }

        liToys.add(work.toy);
        
        Remove(work.toy);
    }

    private void Remove(Toys toy) throws IOException{
        ListToys work = head;
        if (work.toy.id == toy.id){
            head = work.next;
            
        }
        while (true){
            
            if (work.next != null && work.next.toy.id == toy.id ){
                work.next = work.next.next;
                break;
            }
            work = work.next;
            if(work == null){
                break;
            }
        }
    }

    public void Get() throws IOException{
        FileWriter writer = new FileWriter("toys.txt", true);
        writer.write(ToysInFile(liToys.poll()));
        writer.close();
        
    }

    private String ToysInFile(Toys toy){
        return toy.id + " " + toy.name + " " + toy.chance + "\n";
    }
}

