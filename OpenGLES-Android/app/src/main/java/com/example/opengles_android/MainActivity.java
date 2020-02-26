package com.example.opengles_android;

import androidx.appcompat.app.AppCompatActivity;

import android.opengl.GLSurfaceView;
import android.os.Bundle;

import  android.content.Context;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class GLRenderer implements GLSurfaceView.Renderer {

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Native.onSurfaceCreated();
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        Native.onSurfaceChanged(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        Native.onDrawFrame();
    }
}

class GLSurfface extends GLSurfaceView {
    GLRenderer mRenderer;
    public GLSurfface(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        mRenderer = new GLRenderer();
        setRenderer(mRenderer);
    }
}

public class MainActivity extends AppCompatActivity {
    GLSurfface mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Native.initAssertManager(getAssets());
        mView = new GLSurfface(getApplication());
        setContentView(mView);
    }
}
