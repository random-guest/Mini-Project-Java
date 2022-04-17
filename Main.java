package com.company; // only for building a new project

import java.util.Arrays; // A package needed to allow programer to use Arrays

import java.util.Scanner; // A package needed to allow user import input

public class Main {
    public static void main(String[] args) {

        // Read from the User the number of cities (min number of cities is 6)

        int num_of_cities = 0; // to be able to access num_of_cities outside the block of the while (true) loop
        int num_people = 0;   // o be able to access num_people outside the block of the while (true) loop

        Scanner keyboard = new Scanner(System.in); // to allow user to input values

        while (true) {
            System.out.print("Please enter the number of cities: "); // prompt, to allow the user to enter the number of cities, should be used before Reading Data !
            num_of_cities = keyboard.nextInt(); // number of cities is integer, get the number of cities and save it as Integer
            if (num_of_cities >= 6) // Check if the user inputted more than 6 cities to leave the while loop and continue the code
                break; // leave loop
            System.out.println("Minimum number of cities is 6 please enter at least 6 cities "); //if the user inputted number of cities less than 6, print a message to force the user to enter min 6 city names
        }

        // /* ... */ we can comment a long part of code
        ///////////////////////////////////////////////////////////////////////////

        String cities_names[]= new String[num_of_cities]; // define empty string array to save the names of the cities to be entered, its size is the number of the cities specified before
        int number_of_people[]= new int[num_of_cities];   // define empty integer array to save the number of persons in each city, its size is same as the cities specified before

        for (int i = 0; i < num_of_cities; i++) {

            // for each city, allow the user to enter the city name, then save them in an array, then allow the user to enter the number of persons for each city (min 10) and save it in its array

            Scanner keyboard1 = new Scanner(System.in); // to be able to solve the problem of getting two print statement on the same line
            System.out.print("Please enter the name of city " + (i+1) + " :");
            String city = keyboard1.nextLine(); // nextline can accept strings with spaces inbetween them, while next can't
            Scanner keyboard2 = new Scanner(System.in); // to be able to solve the problem of getting two print statement on the same line
            while(true) {
                System.out.print("Please enter the number of people in city " + (i + 1) + " :");
                num_people = keyboard2.nextInt();
                if (num_people >= 10)
                    break;
                System.out.println("min number of persons should be 10, please enter at least 10 people for each city");
            }

            cities_names[i] = city;
            number_of_people [i] = num_people;
        }

        // for each person in each city, the mass and the height should be entered, BMI and BMI category have to be
        // computed and printed.
        // For each city, the number of persons and percent ratio in each BMI category should be computed
        // and printed.

        double BMI = 0;
        double bmi_underweight = 0; double bmi_normal = 0; double bmi_overweight = 0; double bmi_obese = 0;

        // Define a matrix ( that is a multidimensional array )that will hold the details of each city the users enters, the matrix will have 5 rows, the first one will always be the
        // name of the city, and the next 4 rows will be the percentage_bmi_underweight, percentage_bmi_normal,percentage_bmi_overweight, and
        // percentage_bmi_obese respectively.

        double [][] save_data = new double [5][num_of_cities]; // we are defining the required matrix

        // define a summary array for the 5 main requirements , first entry is zero, rests are the needed values
        double [] summary = new double [5];


        for ( int j = 0; j < num_of_cities; j++)
        {

            save_data [0][j] = (j+1); // to specify the number of city that will appear in the given column, j+1 to start counting from 1

            for ( int k = 0; k < number_of_people[j];k++)
            {
                Scanner keyboard2 = new Scanner(System.in);
                System.out.print("Please enter mass of person number " + (k+1) + " in " + cities_names[j] + " : ");
                double mass = keyboard2.nextDouble();
                System.out.print("Please enter height of person number" + (k+1) + " in " + cities_names[j] + " : ");
                double height = keyboard2.nextDouble();
                BMI = (mass)/(height*height); // calculate the BMI
                System.out.println("The BMI of the person number" + (k+1) + "  in " + cities_names[j] + " is : " + BMI);

                if (BMI < 18.5 ) {
                    System.out.println("This is an underweight person");
                    bmi_underweight = bmi_underweight +1; // increase the number of underweight people to track the final output for a given city
                }
                else if (BMI >= 18.5 && BMI < 25) {
                    System.out.println("This is a normal person");
                    bmi_normal  = bmi_normal +1;
                }
                else if (BMI >= 25 && BMI < 30) {
                    System.out.println("This is an overweight person");
                    bmi_overweight  = bmi_overweight +1;
                }
                else {
                    System.out.println("This is an obese person");
                    bmi_obese = bmi_obese +1 ;
                }

            }

            double percentage_bmi_underweight    =   ( bmi_underweight / (double) number_of_people[j] ) * 100 ; // make sure that everything double
            double percentage_bmi_normal          =   ( bmi_normal / (double) number_of_people[j] ) * 100;
            double percentage_bmi_overweight      =   ( bmi_overweight / (double) number_of_people[j]) * 100 ;
            double percentage_bmi_obese           =   ( bmi_obese / (double) number_of_people[j]) * 100;


            // save them in an array
            // Note that we are skippping the first entry in the array summary, why is that ? since the zero entry in our save_data matrix is reserved for the number that will
            // correspond to the name of the city, thats why we started from the first not the zeroth index
            summary[1] = percentage_bmi_underweight;
            summary[2] = percentage_bmi_normal;
            summary[3] = percentage_bmi_overweight;
            summary[4] = percentage_bmi_obese;

            // call the matrix to save the data of the given city before moving to the next city

            for (int w = 1; w <=4 ; w++) {
                save_data[w][j] = summary[w]; // since w is starting from 1, and summary has values at 0, start from w-1
            }

            // print the number of people in the given city and the percentages

            System.out.println("\n The number of people in " + (cities_names[j]) + " city is " + number_of_people[j]+ "\n " );
            System.out.println(" \n The percentage of underweight persons in " + (cities_names[j]) + " city is " + percentage_bmi_underweight + " % " + " \n ");
            System.out.println(" \n The percentage of normal persons in " + (cities_names[j]) + " city is " + percentage_bmi_normal + " %"+"\n ");
            System.out.println(" \n The percentage of overweight persons in " + (cities_names[j]) + " city is " + percentage_bmi_overweight + " %"+"\n ");
            System.out.println(" \n The percentage of obese persons in " + (cities_names[j]) + " city is " + percentage_bmi_obese + " %"+"\n ");

            // Clear the below values to be able to calculate the percent ratio correctly for the next coming cities!

            bmi_underweight = 0;
            bmi_normal = 0;
            bmi_overweight = 0;
            bmi_obese = 0;

        }


        /////////////  Finally, Print the Summary Report  ////////////

        System.out.println("\n \n Summary Report: \n \n"); // just for easy reading

        System.out.println("The number of cities that the user entered is : " + num_of_cities + " \n");

        // Find the total number of people in all cities

        double sum = 0;
        for(int l =0; l < number_of_people.length; l++){

            sum = sum + number_of_people[l]; //  get the total sum of all people/city
        }

        System.out.println(" \n The total number of persons in all cities is: " + sum + " \n");

        // The percent ratio of persons in each BMI category can be summarized in the bellow matrix, where  the first entry of each column is the
        // number of the city, followed by the percent ratio of persons in each BMI category, in the following order:percentage_bmi_underweight,
        // percentage_bmi_normal,percentage_bmi_overweight, and percentage_bmi_obese .
        System.out.println("The percent ratio of persons in each BMI category can be summarized as following" + Arrays.deepToString(save_data) + " \n");


        // The name of the best city which has the maximum percent of persons in normal weight BMI category
        // here we need to get the highest entry in the third raw of our matrix that corresponds to the obese percentage in each cities

        // define best
        double best = 0;
        int city_number_max_normal = 0;

        for (int q=0; q< num_of_cities; q++) // loop over the number of cities which is the same as the number of columns in our matrix
        {
            if (save_data[2][q] >= best) { // to compare the percentages of normal weight in each city,
                best = save_data[2][q]; // update the best
                city_number_max_normal = q; // to use this index, to restore the name of the corresponding city
            }
        }
        System.out.println("The best city that has the maximum number of percent of people in normal weight BMI category is  : " + cities_names[city_number_max_normal] + " and their percent ratio is " + best + " \n ");


        // The name of the worst city which has the maximum percent of persons in obese BMI category and these people's percent ratio

        // define worse and loop over the fourth row of the matrix
        double worse = 0;
        int city_number_worse_obese = 0;

        for (int w=0; w< num_of_cities; w++) // loop over the number of cities which is the same as the number of columns in our matrix
        {
            if (save_data[4][w] > worse) {
                worse = save_data[4][w];
                city_number_worse_obese = w;
            }
        }
        System.out.println("The worse city that has the maximum number of percent of people in obese weight BMI category is  : " + cities_names[city_number_worse_obese] + " and their percent ratio is " + worse + " \n ");

        // The name of city which has the minimum percent of persons in underweight BMI category and these people's percent ratio
        // loop over the second row in the matrix

        double minimum = 1000;
        int city_number_min_underweight = 0;

        for (int n=0; n< num_of_cities;n++) // loop over the number of cities which is the same as the number of columns in our matrix
        {
            if (save_data[1][n] < minimum) {
                minimum = save_data[1][n];
                city_number_min_underweight = n;
            }
        }

        System.out.println("The  city that has the minimum  percent of people in  underweight BMI category is  : " + cities_names[city_number_min_underweight] + " and their percent ratio is " + minimum);

    }

}