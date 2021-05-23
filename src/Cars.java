public class Cars {
    private Car[] tab = new Car[10];
    //Les collections viennent pour resoudre le problème des tableaux
    //et pour proposer une implementations des tructures des données
    //plusieurs catégories  qui heritent tous de l'interface Collection:
    //->List : equivalents des tableaux dynamiques : ArrayList, LinkedList,... (accèpte les doublants)
    //->Set : n'acceptent pas les doublants : HashSet, TreeSet,...
    //->Map : stocke l'information sous forme d'un couple clé/valeur
    //HashMap, TreeMap,...
    //******ArrayList
    //declaration : ArrayList<int> lst; ==>le contenu de l'array sont des entiers
    //declaration : ArrayList<Car> lstCar; ==>le contenu de l'array sont des objets Car
    //instanciation : ArrayList<Car> lstCar=new ArrayList<>();
    //instanciation : List<Car> lstCar=new ArrayList<>();//ok vu la notion de polymorphisme
    //Ajouter un element : Car c1=new Car();  lstCar.add(c1);
    //Supprimer un element lstCar.remove(c1); ou bien int index=0; lstCar.remove(index);
    //La recherche première occurrence : int index=lstCar.indexOf(c1);
    //La recherche dèrnière occurrence : int index=lstCar.lastIndexOf(c1);
    //existe ou n'existe pas boolean exist=lstCar.contains(c1);
    //....
}
