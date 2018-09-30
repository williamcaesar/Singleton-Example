/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package singleton;

import java.util.Random;

/**
 *
 * @author caesar
 */
class Key {

    private static Key instance;
    private int value;

    private Key() {
        this.setValue();
    }
    
    void showValue(){
        System.out.println("That is the value of the key: " + this.value);
    }

    private void setValue() {
        Random random = new Random();
        value = random.nextInt(100);
    }

    public static Key getInstance() {
        if (instance == null) {    
            instance = new Key();
        }
        return instance;
    }
}

class Door {

    public boolean isOpen = true;

    public void open(Key key) {
        this.isOpen = true;
        key.showValue();
    }

}

public class Singleton {

    public static void main(String[] args) {
        System.out.println("EXAMPLE OF SINGLETON\n\n");
        Door door1 = new Door();
        Door door2 = new Door();
        Door door3 = new Door();
        System.out.println("3 doors are instantiated\n");
        
        Key key1 = Key.getInstance();
        Key key2 = Key.getInstance();
        Key key3 = Key.getInstance(); 
        System.out.println("the getInstance method of a Singleton 'Key' class is called 3 times for 3 keys");
        
        door1.open(key1);
        door1.open(key2);
        door1.open(key3);
        System.out.println("The 3 keys are actually 1");
    }
}
