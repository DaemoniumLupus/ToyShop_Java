import java.io.IOException;

public class Program{
    public static void main(String[] args) throws IOException {   
        Construct construct = new Construct();
        construct.Add("robot", 20);
        construct.Add("girl", 30);
        construct.Add("car", 20);
        construct.Put();
        construct.Put();
        construct.Get();
        construct.Get();
    }
}