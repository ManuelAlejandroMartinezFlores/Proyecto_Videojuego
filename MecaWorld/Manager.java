import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manager - crea Button y controla el score y vidas del usuario
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 1
 */
public class Manager extends Actor
{
    private int score = 0;
    private int showscore = 0;
    private int lives = 3;
    /**
     * Act - do whatever the Manager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        scorer();
        checkLives(); 
        gameOver();
        addButtons();
    }
    /**
     * scorer - aumenta el score del usuario al pasar el tiempo
     */
    public void scorer(){
        if (lives != 0){
            score = score + 1;
        }
        showscore = score / 10;
        getWorld().showText(Integer.toString(showscore), 280, 550);
    }
    /**
     * checkLives - quita vidas cuando un Button llega al fondo
     */
    public void checkLives(){
        for (Button b: getWorld().getObjects(Button.class)){
            if (b.getY() > 550){
                lives = lives - 1;
                b.disappear();
            }
        }
        getWorld().showText("LIVES", 520, 20);
        getWorld().showText(Integer.toString(lives), 520, 40);
    }
    /**
     * gameOver - termina el juego si se terminan las vidas
     */
    public void gameOver(){
        if (lives == 0){
            for (Button b: getWorld().getObjects(Button.class)){
                b.disappear();
            }
            getWorld().showText("GAME OVER", 200, 200);
            getWorld().showText("GAME OVER", 400, 400);
            getWorld().showText("GAME OVER", 300, 300);
        }
    }
    /**
     * addButtons - añade Button hasta que hayan un maximo de 5
     */
    public void addButtons(){
        if (numberOfButtons() < 5 && Greenfoot.getRandomNumber(100) < 3 && lives != 0){
            Button b = new Button();
            getWorld().addObject(b, Greenfoot.getRandomNumber(560), 10);
        }
    }
    /**
     * numberOfButtons - cuenta la cantidad de Button en el World
     */
    public int numberOfButtons(){
        int count = 0;
        for (Button b: getWorld().getObjects(Button.class)){
            count = count + 1;
        }
        return count;
    }
}
