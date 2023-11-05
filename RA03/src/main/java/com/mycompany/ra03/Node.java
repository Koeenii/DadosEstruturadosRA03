/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ra03;

/**
 *
 * @author alves
 */
public class Node {
    private Node next;
    private int data;
    
    public Node() {
        this.next = null;
        this.next = null;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public int getData() {
        return this.data;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
    
    public void setData(int data) {
        this.data = data;
    }
    
    public void print() {
        System.out.printf("%d", this.data);
    }
}
