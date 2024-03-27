package lab7;

import utils.In;
import java.util.*;

public class Numbers{
    public static void main(String[] args){
        (new Numbers()).menu();
    }

    private List<Integer> numbers = new ArrayList<Integer>();

    public Numbers(){}

    private void populate(){
        Random r = new Random();
        
        if(numbers.isEmpty()){
            int size = readInt("Size = ");
            for(int i=0; i< size; i++)
                numbers.add(r.nextInt(101));
        }else{
            System.out.println("Please empty the list");
        }
    }

    private int readInt(String prompt){
        System.out.print(prompt);
        return In.nextInt();
    }

    private void clear(){
        if(!numbers.isEmpty())
            numbers.clear();
        else
            System.out.println("List is already empty");        
    }

    private void show(){
        // for(Integer e:numbers)
        // System.out.println(e);
        System.out.println(numbers);
    }

    //look up function
    private int number(int number){
        for(Integer e:numbers)
            if(e == number)
                return numbers.indexOf(e);
        return -1;
    }

    //updated look up function
    private List<Integer> numbers(int number){
        List<Integer> temp = new ArrayList<Integer>();
        for(Integer e:numbers)
            if(e == number)
                temp.add(numbers.indexOf(e));
        return temp;
    }

    private void find(){
        int target = readInt("Target = ");
        int pos = number(target);
        if(pos > -1)
            System.out.println(target+" is at position "+pos); 
        else
            System.out.println(target+" does not exist"); 
    }

    private void findAll(){
        int target = readInt("Target = ");
        List<Integer> temp = numbers(target);
        if(temp.size() > 0)
            System.out.println(target+" is at positions "+temp.toString());
        else
            System.out.println(target+" does not exist");
    }

    private void delete(){
        int target = readInt("Target = ");
        List<Integer> temp = numbers(target);
        numbers.removeAll(temp);
    }
    
    private void update(){
        int value = readInt("Value = ");
        int index = readInt("Index = ");
        if(index < numbers.size())
            numbers.add(index, value);
        else
            System.out.println(index+" is out of bounds");
    }
    
    private char readChoice(){
        System.out.print("Choice(p/c/f/F/d/u/v/x): ");
        return In.nextChar();
    }

    private void menu(){
        char c;

        while((c = readChoice()) != 'x'){
            switch(c){
                case 'p':populate();break;
                case 'c':clear();break;
                case 'f':find();break;
                case 'F':findAll();break;
                case 'd':delete();break;
                case 'u':update();break;
                case 'v':show();break;
                default: help();break;
            }
        }
    }

    private void help(){
        System.out.println("p - populate");
        System.out.println("c - clear");
        System.out.println("f - find one");
        System.out.println("F - find all");
        System.out.println("d - delete"); 
        System.out.println("i - insert");
        System.out.println("v - show");
        System.out.println("x - exit");
    }
}
