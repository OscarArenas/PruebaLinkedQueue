/*
 * Copyright (C) 2020 Oscar Arenas
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package modelo;

import edu.oharenas.util.EmptyQueueException;

/**
 *
 * @author Oscar Arenas
 */
public class LinkedQueue {

    private Node front;
    private Node back;
    private int n;

    public LinkedQueue() {
        front = null;
        back = null;
        n = 0;
    }

    public void enqueue(double item) {
        Node newNode = new Node(item);

        if (front != null) {
            back.next = newNode;
        } else {
            front = newNode;
        }

        back = newNode;
        n++;
    }

    public double dequeue() throws EmptyQueueException {
        if (front != null) {
            double item = front.item;
            front = front.next;
            n--;

            if (front == null) {
                back = null;
            }
            return item;
        }
        throw new EmptyQueueException();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int size() {
        return n;
    }

    @Override
    public String toString() {
        String text = "";

        if (front != null) {
            Node current = front;

            while (current.next != null) {
                text += numberToString(current.item) + ", ";
                current = current.next;
            }
            text += numberToString(current.item);
        }
        return "[" + text + "]";
    }

    private String numberToString(double real) {
        int entero = (int) real;
        String cadena = real + "";

        if (real == entero) {
            cadena = entero + "";
        }
        return cadena;
    }

    private class Node {

        // Campos (Atributos)
        double item;
        Node next;

        // Métodos (Comportamientos)
        public Node(double item) {
            this.item = item;
            next = null;
        }

        public Node(double item, Node next) {
            this.item = item;
            this.next = next;
        }

        public double getItem() {
            return item;
        }

        public void setItem(double item) {
            this.item = item;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
