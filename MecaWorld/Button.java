import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Button - objetos que caen y deben ser eliminados
 * 
 * @author Manuel Alejandro Martinez Flores
 * @version 2
 */
public class Button extends Actor
{
    private int oldX = 0;
    private int oldY = 0;
    private int newX = 0;
    private int newY = 0;
    // Abecedario
    private List<String> abc = generateABC();
    protected String letter = generateLetter();
    protected int id = 0;
    private int speed = 1;
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        showLetter();
        fall();
        evaluate();
    }
    /**
     * showLetter - muestra la letra que el usuario debe presionar
     */
    public void showLetter(){
        // Borra la impresión anterior
        getWorld().showText(" ", oldX, oldY);
        newX = getX();
        newY = getY();

        getWorld().showText(letter, newX, newY);
        oldX = newX;
        oldY = newY;
    }
    /**
     * generateLetter - genera letra aleatoria
     */
    public String generateLetter(){
        int idx = Greenfoot.getRandomNumber(26);
        return abc.get(idx);
    }
    /**
     * generateABC - genera una lista con el abecedario
     */
    public List<String> generateABC(){
        List<String> abc = new ArrayList<String>();
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        for (String letter : array){
            abc.add(letter);
        }
        return abc;
    }
    /**
     * evaluate - desaparece si el usuario presion la letra
     */
    public void evaluate(){
        if (Greenfoot.isKeyDown(letter)) {
            for (Manager m: getWorld().getObjects(Manager.class)){
                // Gana puntos
                m.clickScorer();
            }
            Greenfoot.playSound("typewriter-key-1.wav");
            disappear();
        }
    }
    /**
     * disappear - elimina el botón y la letra
     */
    public void disappear(){
        getWorld().showText(" ", newX, newY);
        for (Button b : getWorld().getObjectsAt(getX(), getY(), Button.class)){
            // Evita que se eliminen Button cercanos
            if (b.getId() == id) {
                getWorld().removeObject(b);
            }
        }
    }
    /**
     * fall - movimiento de caida
     */
    public void fall(){
        turnTowards(getX(), 560);
        for (Manager m: getWorld().getObjects(Manager.class)){
            // va tan rápido como el nivel
            speed = m.getLevel();
        }
        move(speed);
    }
    /**
     * setId - le proporciona Id unico al Button
     * @parameter (int) i: ID
     */
    public void setId(int i){
        id = i;
    }
    /**
     * getId - regresa el id del Button
     */
    public int getId(){
        return id;
    }
    /**
     * getLetter - regresa la letra del Button
     */
    public String getLetter(){
        return letter;
    }
}
