package lab8.exercise2;

public class Dog extends Animal {

    public Dog() {
        super(0,"Dog");
    }
    
    @Override
    public void walk() {
        this.position += 4;
    }
}
