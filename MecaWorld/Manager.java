import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Manager - crea Button y controla el score y vidas del usuario
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 2
 */
public class Manager extends Actor
{
    private int score = 0;
    private int showscore = 0;
    private int vidas = 3;
    private int level = 0;
    private int idCnt = 0;
    private int timer = 0;
    /**
     * Act - do whatever the Manager wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        timeScorer();
        cntVidas(); 
        gameOver();
        addButtons();
        checkLevel();
    }
    /**
     * scorer - aumenta el score del usuario al pasar el tiempo
     */
    public void timeScorer(){
        if (vidas != 0){
            score = score + 1;
        }
        showscore = score / 15;
        // Muestra en la pantalla el puntaje
        getWorld().showText("SCORE", 280, 530);
        getWorld().showText(Integer.toString(showscore), 280, 550);
    }
    /**
     * clickScorer - aumenta el score del usuario al disappear Button
     */
    public void clickScorer(){
        // se llama cada vez que se elimina un RegButton
        score = score + 100;
    }
    /**
     * cntVidas - quita vidas cuando un Button llega al fondo
     */
    public void cntVidas(){
        for (RegButton b: getWorld().getObjects(RegButton.class)){
            if (b.getY() > 550){
                // si un RegButton llega al fondo, pierde una vida
                vidas = vidas - 1;
                b.disappear();
            }
        }
        for (Button b : getWorld().getObjects(Button.class)) {
            if (b.getY() > 550){
                // elimina Buttons en el fondo
                b.disappear();
            }
        }
        getWorld().showText("VIDAS", 520, 20);
        getWorld().showText(Integer.toString(vidas), 520, 40);
    }
    /**
     * gameOver - termina el juego si se terminan las vidas
     */
    public void gameOver(){
        if (vidas < 1){
            for (Button b: getWorld().getObjects(Button.class)){
                b.disappear();
            }
            getWorld().showText("GAME OVER", 200, 200);
            getWorld().showText("GAME OVER", 400, 400);
            getWorld().showText("GAME OVER", 300, 300);
            Greenfoot.stop();
        }
    }
    /**
     * addButtons - añade Button hasta que hayan un maximo de 5
     */
    public void addButtons(){
        if (numberOfButtons() < 5 && vidas != 0){
            // probabilidad de añadir RegButton: 93%
            // probabilidad de añadir LifeUp: 4%
            // probabilidad de añadir BadButton: 3%
            int prob = Greenfoot.getRandomNumber(100);
            if (prob > 3 && prob < 97){
                RegButton b = new RegButton();
                b.setId(idCnt);
                idCnt = idCnt + 1;
                getWorld().addObject(b, Greenfoot.getRandomNumber(33) * 16 + 8, 10);
            }
            if (prob < 3) {
                LifeUp b = new LifeUp();
                b.setId(idCnt);
                idCnt = idCnt + 1;
                getWorld().addObject(b, Greenfoot.getRandomNumber(560), 10);
            }
            if (prob > 97 && level > 1){
                BadButton b = new BadButton();
                b.setId(idCnt);
                idCnt = idCnt + 1;
                getWorld().addObject(b, Greenfoot.getRandomNumber(560), 10);
            }
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
    /**
     * checkLevel - muestra el nivel actual
     */
    public void checkLevel(){
        timer = timer + 1;
        level = 1 + timer / 2000;
        getWorld().showText(Integer.toString(level), 50, 40);
        getWorld().showText("LEVEL", 50, 20);
    }
    /**
     * getLevel - muestra el nivel actual
     */
    public int getLevel(){
        return level;
    }
    /**
     * changeLife - añade el input al total de vidas
     * 
     * @parameter change (boolean) true - +1 / false - -1
     */
    public void changeLife(boolean change){
        if (change){
            vidas = vidas + 1;
        }
        else {
            vidas = vidas - 1;
        }
    }
}
