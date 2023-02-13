package Engine;

import org.joml.Vector3f;

import java.util.List;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.*;

public class Object2d extends ShaderProgram{
    List<Vector3f> vertices;
    int vao;
    int vbo;
    public Object2d(List<ShaderModuleData> shaderModuleDataList ,List<Vector3f> vertices) {
        super(shaderModuleDataList);
        this.vertices = vertices;
        setupVAOVBO();
    }

    public void setupVAOVBO(){
        vao = glGenVertexArrays();
        glBindVertexArray(vao);

        vbo = glGenBuffers();
        glBindBuffer(GL_ARRAY_BUFFER,vbo);

        glBufferData(GL_ARRAY_BUFFER,Utils.listoFloat(vertices),GL_STATIC_DRAW);



    }

    public void drawSetup(){
        bind();

        glEnableVertexAttribArray(0);
        glBindBuffer(GL_ARRAY_BUFFER,vbo);
        glVertexAttribPointer(0,3,GL_FLOAT,false,0,0);
    }

    public void draw(){
        drawSetup();

        glLineWidth(1);
        glPointSize(0);
        glDrawArrays(GL_TRIANGLES/*GL_LINE_LOOP*/,0,vertices.size());
    }
}