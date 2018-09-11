package com.example.cs_group.basiccalculato.Culculator;

public class OperationsDeclaration extends Libarary {

    public static void Plus(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) + Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public static void Minus(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) - Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public static void Multiple(int pos) {
        if (variables.get(pos + 1) == null) {
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) * Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

    public static void Division(int pos) {
        if (variables.get(pos + 1) == null) {
            if (variables.get(pos).equals("0"))
                Error = true;
        } else {
            variables.set(pos, Double.parseDouble(variables.get(pos)) / Double.parseDouble(variables.get(pos + 1)) + "");
        }
    }

}
