import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Button - objetos que caen y deben ser eliminados
 * 
 * @author Manuel Alejandro Martinez Flores
 * @version 1
 */
public class Button extends Actor
{
    private int oldX = 0;
    private int oldY = 0;
    private int newX = 0;
    private int newY = 0;
    private List<String> abc = generateABC();
    private String letter = generateLetter();
    
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        // Add your action code here.
        turnTowards(getX(), 560);
        //String letter = generateLetter();
        showLetter();
        
        move(1);
        
        evaluate();
    }
    /**
     * showLetter - muestra la letra que el usuario debe presionar
     */
    public void showLetter(){
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
        int idx = Greenfoot.getRandomNumber(24);
        return abc.get(idx);
    }
    /**
     * generateABC - genera una lista con el abecedario
     */
    public List<String> generateABC(){
        List<String> abc = new ArrayList<String>();
        String[] array = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
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
            disappear();
        }
    }
    /**
     * getLetter - muestra la variable letter
     */
    public String getLetter(){
        return letter;
    }
    /**
     * disappear - elimina el botón y la letra
     */
    public void disappear(){
        getWorld().showText(" ", newX, newY);
        for (Button b : getWorld().getObjectsAt(getX(), getY(), Button.class)){
            if (b.getLetter() == letter) {
                getWorld().removeObject(b);
            }
        }
    }
}
