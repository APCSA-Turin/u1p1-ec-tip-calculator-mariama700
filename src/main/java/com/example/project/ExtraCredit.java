package com.example.project;
import java.util.Scanner;

public class ExtraCredit {
    public static String calculateTip(int people, int percent, double cost, String items) { //You must use these  variable in your calculations
        StringBuilder result = new StringBuilder();

        // I learned how to round from here: https://www.educative.io/answers/how-to-use-the-java-mathround-method

        // calculating tip and rounding
        double tip = cost * (percent/100.0);
        tip = Math.round(tip * 100) / 100.0;

        // calculating the cost per person before tip
        double costPerPersonBeforeTip = Math.round((cost / people) * 100) / 100.0;

        // calculating total cost and tip together
        double costAndTip = tip + cost;

        // calculating the tip per person
        double tipPerPerson = tip / people;
        tipPerPerson = Math.round(tipPerPerson * 100) / 100.0;
        
        // calculating the cost per person after tip
        double costPerPersonAfterTip = (cost + (cost * ((double) percent / 100))) / people;
        costPerPersonAfterTip = Math.round(costPerPersonAfterTip * 100.0) / 100.0;
                      
        // running code
        result.append("-------------------------------\n");
        result.append("Total bill before tip: $" + cost + "\n"); //concatenate to this string. DO NOT ERASE AND REWRITE
        result.append("Total percentage: " + percent + "%" + "\n");
        result.append("Total tip: $" + tip + "\n");
        result.append("Total Bill with tip: $" + costAndTip + "\n");
        result.append("Per person cost before tip: $" + costPerPersonBeforeTip + "\n");
        result.append("Tip per person: $" + tipPerPerson + "\n");
        result.append("Total cost per person: $" + costPerPersonAfterTip + "\n");
        result.append("-------------------------------\n");
        result.append("Items ordered:\n");
        result.append(items);
        return result.toString();
    }

     //TEST YOUR PROGRAM IN main
     public static void main(String[] args) {
        int people = 6; 
        int percent = 25;
        double cost = 52.27;     
        String items= "";

        Scanner scan = new Scanner(System.in);
        boolean endCode = false;
        while (endCode == false){
            System.out.println("Enter an item name or type -1 to finish");
            String userInput = scan.nextLine();

            if (userInput.equals("-1")){
                endCode = true;
            }else{
                items += userInput + "\n"; 
            }
        }
        scan.close();
  
        System.out.println(calculateTip(people, percent, cost, items));
    }
}