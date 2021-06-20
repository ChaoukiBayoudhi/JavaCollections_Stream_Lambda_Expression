package List;

import CarPkg.Car;
import CarPkg.CarComparator;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOfCars {
    private List<Car> lstCars = new ArrayList<>();

    //Les collections viennent pour resoudre le problème des tableaux
    //et pour proposer une implementations des tructures des données
    //plusieurs catégories  qui heritent tous de l'interface Collection:
    //->List : equivalents des tableaux dynamiques : ArrayList, LinkedList,... (accèpte les doublants)
    //->Set : n'acceptent pas les doublants : HashSet, TreeSet,...
    //for(int i=0;i<10;i++)//parcours des indices
     //  System.out.println(tab[i]);
    //foreach en java
   // for( Car x:tab){
   //     System.out.println(x);
   // }
    //->Map : stocke l'information sous forme d'un couple clé/valeur
    //HashMap, TreeMap,...
    //******ArrayList
    //declaration : ArrayList<int> lst; ==>le contenu de l'array sont des entiers
    //declaration : ArrayList<CarPkg.Car> lstCar; ==>le contenu de l'array sont des objets CarPkg.Car
    //instanciation : ArrayList<CarPkg.Car> lstCar=new ArrayList<>();
    //instanciation : List<CarPkg.Car> lstCar=new ArrayList<>();//ok vu la notion de polymorphisme
    //Ajouter un element : CarPkg.Car c1=new CarPkg.Car();  lstCar.add(c1);
    //Supprimer un element lstCar.remove(c1); ou bien int index=0; lstCar.remove(index);
    //La recherche première occurrence : int index=lstCar.indexOf(c1);
    //La recherche dèrnière occurrence : int index=lstCar.lastIndexOf(c1);
    //existe ou n'existe pas boolean exist=lstCar.contains(c1);
    //trier une liste lstCar.sort(critère)
    //critère : decrit comment on va comparer les objets
    //le critère est basé sur la méthode :
    //int compare(Object o1, Object o2) ===>cette méthode est définie dans l'interface Comparator
    //les interfaces Comparator && Comparable
    //int compareTo(Object obj)// compare this et obj
    //les deux méthodes retourne 0 si les deux objets sont identiques, une valeur positive si obj ou this est puls grand
    //et une valeur négative si non
    //boolean isEmpty()==>retourne true si la liste est vide
    //int size()==>le nombre des elments de la liste
    //....
    //Ajouter une voiture à la fin de la liste
    public void addCar(Car c1) throws Exception{
        if(lstCars.contains(c1))
            throw  new Exception("This car already exist");
        lstCars.add(c1);
    }
    //Ajouter une voiture à un indice donné de la liste
    public void addCar(Car c1,int index) throws Exception{
        if(lstCars.contains(c1))
            throw  new Exception("This car already exist");
        if(index<0 || index>lstCars.size())
            throw  new Exception("Verify the given index");
        lstCars.add(index,c1);
    }
    public void showAllCars()
    {
        System.out.println("List of Cars :");
        for(int i=0;i<lstCars.size();i++)
            //lstCars.get(i) retourne la voiture à l'indice "i"
            System.out.println(lstCars.get(i));
    }
    public void showAllCars_v2()
    {
        System.out.println("List of Cars :");
        for(Car c:lstCars)
            //lstCars.get(i) retourne la voiture à l'indice "i"
            System.out.println(c);
    }
    public void showAllCars_v3()
    {
        System.out.println("List of Cars :");
        lstCars.forEach(x-> System.out.println(x));
    }

    public void removeCar(String code) throws Exception
    {
        int i=0;
        boolean trouve=false;
        while(i<lstCars.size()&&!trouve)
        {
            if(lstCars.get(i).getCode().equalsIgnoreCase(code))
                trouve=true;
            else
                i++;
        }
        if(!trouve)
            throw new Exception("Verify the given code !! The car does not exist");
        lstCars.remove(i);
    }
    //version using lambda Expression and stream
    public void removeCar_v2(String code) throws Exception {

    }
    public void showCarsPrices()
    {
        lstCars.stream()
                .map(c->"code= "+c.getCode()+", price ="+c.getPrice())//map retourne un stream contenant les élement après la ->
                .forEach(System.out::println);
    }
    public void sortCarsByCode(int ordre){
        //1: ordre croissant
        //2:ordre decroissnant
        int x;
//        if(x<10)
//            System.out.println("plus petit");
//        else
//            System.out.println("plus grand");
        //les 4 lignes precedentes sont equivalentes à
       // (x<10)?System.out.println("plus petit"):System.out.println("plus grand");
        if ((ordre == 1)) {
            lstCars.sort(new CarComparator());
        } else {
            lstCars.sort(new CarComparator().reversed());
        }
    }
    public void sortByPriceReversed()
    {
        lstCars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                if(o1.getPrice()==o2.getPrice())
                    return 0;
                else
                    if(o1.getPrice()>o2.getPrice())
                        return 1;
                    else
                        return -1;
                //return o1.getPrice()-o2.getPrice();
            }
        }.reversed());
    }
    //using streams
    //La méthode retourne une nouvelle list triée par Constructeur dans l'ordre ascendant
     public List<Car> sortCarsByConstructors()
     {
       return  lstCars.stream()
                 .sorted(Comparator.comparing(Car::getConstructor))//retourne un stream trié dans l'ordre croissant
                 .collect(Collectors.toList());
       //dans le sens descendant
//     return  lstCars.stream()
//                 .sorted(Comparator.comparing(Car::getConstructor).reversed())//retourne un stream trié dans l'ordre croissant
//                 .collect(Collectors.toList());
     }

    //Les streams en java
    //créer une liste formée par les entiers 1, 5, 12 , 7 et 8
    //Stream.of(1,5,12,7,8)
    //afficher uniquement les entiers pairs de la liste des entiers donnée precedament
    //avec les listes :
    //List<int> lst1=new ArrayList<>();
    //lst1.add(1);lst1.add(2);lst1.add(12);lst1.add(7);lst1.add(8);
    //for(int x:lst1)
    //     if(x%2==0)
            //  System.out.println(x);
    //avec les streams
    //Stream.of(1,5,12,7,8)
    //        .filter(x->x%2==0)//retourne un nouveau stream contenant uniquement les entiers pairs
    //        .forEach(x->Sytstem.out.println(x));
    //ou bien .forEach(Sytstem.out::println);

    //pour convertir de List à stream
    //lstCars.stream()
    //pour convertir de stream vers List
    //.collector(Collectors.ToList()) //ou bien Collectors.ToSet() ou bien Collectors.ToMap()
    public Car getCarByCode(String code)throws Exception
    {
        //Optional peut avoir soit zero ou une seule valeur
        //Optional opt;
        //opt.isEmpty() retourne true si opt ne contient aucune valeur et false si non
        //opt.isPresent() c'est l'inverse de isEmpty()
        Optional<Car> res=lstCars.stream()
                .filter(c->c.getCode().equalsIgnoreCase(code))
                .findFirst();
        if(res.isEmpty())
            throw new Exception("Verify the given code !! The car is not found");
        return res.get();
    }
}
