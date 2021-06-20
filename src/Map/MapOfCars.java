package Map;

import CarPkg.Car;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapOfCars {
    //l'information est stockée en couple (clé, valeur)
    //La recherche et l'accés se font en o(1)
    //si on a la clé, on peut alors recuperer directement la valeur
    Map<String,Car> mapCars=new HashMap<String,Car>();
    public void addCar(Car c1)
    {
        mapCars.put(c1.getCode(),c1);
    }
    public void removeCar(String code)
    {
        mapCars.remove(code);
    }
    public void removeAll()
    {
        mapCars.clear();
    }
    //afficher la liste des clés
    public void showAllKeys()
    {
        System.out.println("l'ensemble des clés");
        for(String code:mapCars.keySet())
            System.out.print(code+"\t");
    }
    //afficher la liste des valeurs
    public void showAllValues()
    {
        System.out.println("L'ensemble des valeurs");
        for(Car x: mapCars.values())
            System.out.println(x);
    }
    public static void mapExample()
    {
        //declation
        HashMap<String,Integer> personesAges=new HashMap<String, Integer>();
        //La clé est le nom de la personne
        //La valeur est son age
        //ajouter queleques valeurs
        personesAges.put("Mohamed",23);
        personesAges.put("Aziza",19);
        personesAges.put("Salah",42);
        personesAges.put("Bochra",9);
        //recuperer l'age de Salah
        System.out.println("L'age de salah est "+personesAges.get("Salah"));
        System.out.println("Les personnes avant suppression");
        System.out.println(personesAges);
        personesAges.remove("Aziza");
        System.out.println("Les personnes après suppression");
        System.out.println(personesAges);


    }
    public static void main(String[] args)
    {
        //MapOfCars.mapExample();
        //ou bien mapExmple();

        MapOfCars mapc=new MapOfCars();
        Scanner sc=new Scanner(System.in);
        int nbCars;
        do {
            System.out.println("Number of Cars to add ? ");
            nbCars=sc.nextInt();
        }while(nbCars<0);
        for(int i=1;i<=nbCars;i++)
        {
            //saisir la voiture
            Car c1=new Car();
            System.out.println("Code ? ");
            String code=sc.next();
            c1.setCode(code);
            System.out.println("Constructor ? ");
            c1.setConstructor(sc.next());
            System.out.println("Price ? ");
            c1.setPrice(sc.nextDouble());
            mapc.addCar(c1);
        }
        System.out.println(nbCars +" cars has been successufly added");
        mapc.showAllKeys();
        mapc.showAllValues();
        System.out.println("The code of  the car to remove");
        String code =sc.next();
        mapc.removeCar(code);
        mapc.showAllValues();
    }
}
