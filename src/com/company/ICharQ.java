package com.company;

public interface ICharQ {
    //put a character into the queue
    void push(char ch);
    //returns the top of the queue without removing it
    char peak();
    //get a character
    char pop();
}
