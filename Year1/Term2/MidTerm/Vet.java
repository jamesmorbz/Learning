public class Vet {
    private Dog[] dogs;
    private int numDogs=0;

    public Vet(){ 
        dogs = new Dog[5];
    }
    public void add(Dog a){
        dogs[numDogs] = a;

    }
    public Dog getPet(int index){
        return dogs[index];
    }
}
