package com.example.steve.sticks.impl;

import java.util.List;

import android.view.View.OnTouchListener;

import com.example.steve.sticks.Input.TouchEvent;

public interface TouchHandler extends OnTouchListener {
    public boolean isTouchDown(int pointer);
    
    public int getTouchX(int pointer);
    
    public int getTouchY(int pointer);
    
    public List<TouchEvent> getTouchEvents();
}
