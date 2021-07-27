import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Instructions - muestra las instrucciones e inicia el juego
 * 
 * @author Manuel Alejandro Martinez Flores 
 * @version 2
 */
public class Instrucciones extends Actor
{
    /**
     * Act - do whatever the Instructions wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        mostrarInstrucciones();
        startGame();
    }
    /**
     * mostrarInstrucciones - muestra las instrucciones
     */
    public void mostrarInstrucciones(){
        World w = getWorld();
        w.showText("Evita que las ruedas lleguen al fondo de la pantalla", 280, 100);
        w.showText("Presiona la letra que muestran para eliminarlas", 280, 200);
        w.showText("Tienes 3 vidas. Los corazones te dan una vida extra", 280, 300);
        w.showText("Las bombas y las ruedas que lleguen", 280, 350);
        w.showText("al final te quitan una vida", 280, 370);
        w.showText("Presiona letra 'x' para comenzar", 280, 450);
    }
    /**
     * limpiar - elimina las instrucciones
     */
    public void limpiar(){
        World w = getWorld();
        w.showText("", 280, 100);
        w.showText("", 280, 200);
        w.showText("", 280, 300);
        w.showText("", 280, 350);
        w.showText("", 280, 370);
        w.showText("", 280, 450);
    }
    /**
     * startGame - inicia el juego
     */
    public void startGame(){
        if (Greenfoot.isKeyDown("x")){
            limpiar();
            World w = getWorld();
            // añade un Manager para que inicie el juego
            Manager m = new Manager();
            w.addObject(m, 560, 560);
            for (Instrucciones i: w.getObjects(Instrucciones.class)){
                w.removeObject(i);
            }
        }
    }
}
