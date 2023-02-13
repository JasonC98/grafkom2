import Engine.Window;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.glClearColor;
import org.lwjgl.opengl.GL30.*;

public class Main {
    private Window window = new Window(800,800,"Title");


    public void run(){
        init();
        loop();

        //Terminate GLFW and free the error callback
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }
    public void init(){

    }
    public void loop(){

    }
}