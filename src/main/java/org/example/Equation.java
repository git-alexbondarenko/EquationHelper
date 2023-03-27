package org.example;

import jakarta.persistence.*;

@Entity
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String equation;

    private Double root;

    @Column(name = "number_of_variables")
    private int numberOfVariables;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public double getRoot() {
        return root;
    }

    public void setRoot(Double root) {
        this.root = root;
    }

    public int getNumberOfVariables() {
        return numberOfVariables;
    }

    public void setNumberOfVariables(int numberOfRoots) {
        this.numberOfVariables = numberOfRoots;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", equation=" + equation +
                ", root=" + root +
                ", numberOfVariables=" + numberOfVariables;
    }
}
