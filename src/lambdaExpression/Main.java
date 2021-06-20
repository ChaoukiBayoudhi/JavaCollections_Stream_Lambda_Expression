package lambdaExpression;

public class Main {
    public static void main(String[] args)
    {

        AddInterface obj1=(int x,int y)->x+y;
        System.out.println(obj1.add(20,50));
    }
}
