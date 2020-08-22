package com.company;

import java.util.Random;

public class Main {

    /*
    * There are 100 passengers about to board a plane with 100 seats.
    * Each passenger is assigned a distinct seat on the plane. The first passenger who boards has
    * forgotten his seat number and sits in a randomly selected seat on the plane.
    * Each passenger who boards after him either sits in his or her assigned seat if it is
    * empty or sits in a randomly selected seat from the unoccupied seats.
    * What is the probability that the last passenger to board the plane sits in his/her assigned seat?
    */

    // when all seats are filled and only one seat is remaining to be filled this function returns the empty
    // seat at the last iteration when the last passenger comes in the aeroplane.
    public static int remaingSeats(int[] seats){
        if(seats.length<0 || seats.length>100)
            return 1000;
        int count = 0;
        for (int i = 0 ; i < seats.length ;i++) {
            if(seats[i]==0) count++;

        }
        return count;
    }
    // checkAll Seats() : A function which checks weather the number of seats are filled or not
    // This function is mainly designed to avoid the program from going in infinite loop so that in case of every
    // seat is filled code will come out of loop.
    public static boolean checkAllSeats(int[] seats){
        if(seats.length<0 || seats.length>100)
            return false;
        for(int i = 0 ; i < seats.length;i++){
            if(seats[i]==0){
                return true;
            }
        }
        return false;
    }

    //allocateRandom() : This function randomly allocates seats to the passengers who's allocated seat numbers
    // are taken by other passengers
    // It chooses from the remaining unallocated seats and randomly allocates the seat from the remaining seats.
    public static void  allocateRandom(int[] seats, int number,Random random ){

        int r = random.nextInt(100);
        while(seats[r]==1) {
            r = random.nextInt(100);
        }

        System.out.println("Person "+number+" sits on : "+r);
        seats[r] = 1;

    }


    public static void main(String[] args) {
        //Number of available seats in aeroplane
        int[] seats = new int[100];
        // using inbuilt library to generate random numbers in a range of 0 to 99 for seat allocation
        Random r = new Random();
        //First passenger comes in and because he has forgotten the seat number he sits on random seat
        // firstFill is the variable which store the first passenger's random location.
        int firstFill = r.nextInt(100);
        seats[firstFill] = 1;
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Detailed chart of people would sit on when first person forgets his seat number : ");
        System.out.println();
        System.out.println("Person "+0+" sits on : "+firstFill+" : First person who forgets his seat number");
        for(int i = 1 ; i  < 100 ;i++){
            //When the last person comes in, this is the 99th person since our person number starts with 0
            if(i==99){
                int emptySeats = remaingSeats(seats);

                System.out.println();
                System.out.println("Last person comes in -->");
                System.out.println();
                System.out.println("Person "+i+" sits on : "+emptySeats);
                System.out.println("Since we have two conditions weather last person can sit on his allocated seat number we divide the remaining seats by 2 ");
                System.out.println("--------------------------------------------------------------------------------------------------------------------------");
                System.out.println("Probability  "+ (double)emptySeats/2);
                break;
            }
            //Possibility 1
            if(seats[i]!=1){
                seats[i]=1;
                System.out.println("Person "+i+" sits on : "+i);

            }
            //Possibility 2
            else{
                if(checkAllSeats(seats)){
                    allocateRandom(seats,i,r);

                }else
                    break;

            }
        }
        System.out.println("No matter how many times we run this  we can conclude the fact that however " +
                " the result set works we ultimately end up getting two choices at the end when the last person comes in the aeroplane");
    }

}

