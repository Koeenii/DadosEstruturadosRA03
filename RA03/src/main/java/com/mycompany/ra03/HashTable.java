/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ra03;

/**
 *
 * @author alves
 */
public class HashTable {
    private Node[] array;
    private int size;
    private int hashFunc;
    private String name;
    
    public HashTable(int size, String name, int hashFunc) {
        this.size = size;
        this.name = name;
        this.array = new Node[size];
        this.hashFunc = hashFunc;
    }
    
    public int getKey(int data) {
        switch(this.hashFunc) {
            case 1:
                return this.HashFunc1(data);
            case 2:
                return this.HashFunc2(data);
            case 3:
                return this.HashFunc3(data);
        };
        
        System.out.printf("Função Hash %d Não Encontrada, Utilizando Função Hash 1 no lugar.", this.hashFunc);
        
        return this.HashFunc1(data);
    };
    
    public void insert(int data) {
        int key = this.getKey(data);
        this.insertAt(data, key);
    }
    
    public void insertAt(int data, int index) {
        if (index < this.size) {
            Node node = new Node();
            node.setData(data);
            
            if (this.array[index] != null) {
                Node current = this.array[index];
                Node previous = null;
                
                while (current.getNext() != null && current.getData() > data) {
                    previous = current;
                    current = current.getNext();
                }
                
                if (current.getData() > data) {
                    current.setNext(node);
                } else {
                    node.setNext(current);
                    
                    if (previous != null) {
                        previous.setNext(node);
                    } else {
                        this.array[index] = node;
                    }
                }
                        
            } else {
                this.array[index] = node;
            }
            
        } else {
            System.out.println("Erro de inserção");
        }
    }
    
    public Node search(int data) {
        int key = this.getKey(data);
        
        if (this.array[key] != null) {
            Node current = this.array[key];
            
            while (current.getNext() != null && current.getData() != data) {
                current = current.getNext();
            }
            
            if (current.getData() == data) {
                return current;  
            }
        }
        
        System.out.printf("Elemento %d não encontrado.\n", data);
        return null;
    }
    
    public void remove(int data) {
        int key = this.getKey(data);
        
        if (this.array[key] != null) {
            Node current = this.array[key];
            Node previous = null;
            
            while (current.getNext() != null && current.getData() != data) {
                previous = current;
                current = current.getNext();
            }
            
            if (current.getData() == data) {
                if (previous != null) {
                    previous.setNext(current.getNext());
                } else if (current.getNext() != null) {
                    this.array[key] = current.getNext();
                } else {
                    this.array[key] = null;
                }
                
            } else {
               System.out.printf("Elemento %d não encontrado.\n", data);
            }
        }
    }
    
    public void print() {
        int total = 0;
        
        System.out.printf("\nTABELA HASH %s\nTamanho: %d\nFunção Hash: %d\n", this.name.toUpperCase(), this.size, this.hashFunc);
        for (int i = 0; i < this.size; i++) {
            if (this.array[i] != null) {
                System.out.printf("%d - ", i);
                
                Node current = this.array[i];
                current.print();
                
                while (current.getNext() != null) {
                    current = current.getNext();
                    
                    System.out.printf(" -> ");
                    
                    current.print();
                    total++;
                }
                
                total++;
                System.out.printf("\n");
            }
        }
        
        System.out.printf("Total de Elementos: %d\n", total);
    }
    
    // Divisionaria 
    public int HashFunc1(int data) {
        int calc1 = data % this.size;
        
        return calc1;
    }
    
    // Multiplicativa
    public int HashFunc2(int data) {
        float constant = 0.25f;
        float calc1 = (data * constant) % 1;
        int calc2 = (int) (calc1 * this.size);
        
        return calc2;
    }
    
    // Fim do Quadrado
    public int HashFunc3(int data) {
        float calc1 = (float) data * (float) data;
        float calc2 = (calc1 / this.size) % 1;
        int calc3 = (int) (calc2 * this.size);
        
        return calc3;
    }
} 
