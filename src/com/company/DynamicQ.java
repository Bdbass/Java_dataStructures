package com.company;

public class DynamicQ implements ICharQ{
    private char queue[] = new char[10];
    private int size = 0;

    public void push(char value_){
        resize();
        queue[size] = value_;
        size++;
    }

    public char pop(){
        char temp = queue[0];
        for (int i = 1; i < queue.length; i++){
            queue[i-1] = queue[i];
        }
        size--;
        return temp;
    }

    public char peak(){
        return queue[0];
    }

    private void resize(){
        if (queue.length == size){
            char newQ[] = new char[size*2];
            for (int i = 0; i < queue.length; i++){
                newQ[i] = queue[i];
            }
            queue = newQ;
        }
    }

    void print(){
        for (int i = 0; i < size; i++){
            System.out.println(queue[i]);
        }
    }
}

