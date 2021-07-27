import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * BadButton - si los presiona, pierde una vida
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 2
 */
public class BadButton extends Button
{
    /**
     * Act - do whatever the BadButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        // Hereda fall y showLetter de clase Button
        fall();
        showLetter();
        evaluatePower();
    }
    /**
     * evaluatePower - si es presionada la letra, pierde una vida
     */
    public void evaluatePower(){
        if (Greenfoot.isKeyDown(letter)) {
            for (Manager m : getWorld().getObjects(Manager.class)){
                // le quita una vida al usuario
                m.changeLife(false);
            }
            Greenfoot.playSound("typewriter-key-1.wav");
            disappear();
        }
    }
}
