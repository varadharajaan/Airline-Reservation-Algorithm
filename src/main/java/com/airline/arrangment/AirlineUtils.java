package com.airline.arrangment;

import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author Varadharajan on 25/05/20 18:15
 * @Projectname Airline_Arrangement
 */
@Service
public class AirlineUtils {

    public int[][] replaceString(String str) {
        try {
            str = str.replaceAll("[^a-zA-Z0-9]", "").trim();
            int[][] seatMatrix = new int[str.length()/2][2];
            int count =0;
            for (int i = 0; i < str.length()/2; i++)
                for (int j = 0; j < 2; j++) {
                    if(count<str.length()) {
                        int value = Integer.parseInt(String.valueOf(str.charAt(count)));
                        seatMatrix[i][j] = value;
                        count++;
                    }
                    else
                        break ;
                }
            return seatMatrix;
        }

        catch (Exception e) {
            throw new RuntimeException(" given string is not valid in required format");
        }

    }

    public  String allocateSeats(String str, int passengersCount)  {

        final int[][] seatMatrix = replaceString(str);

        findColumnAndRowValues(seatMatrix);

        final List<Integer> largest = largestInColumn(seatMatrix);

        int colSize = largest.get(0);
        int rowSize = largest.get(1);

        List<List<String[]>> lists = fillWithMAandW(seatMatrix);

        Seats seats = new Seats();
        int counter = 1;

        replaceWithNumber("A",counter,lists,colSize,rowSize,passengersCount, seats);

        counter = seats.getCount();
        replaceWithNumber("W",counter,lists,colSize,rowSize,passengersCount, seats);

        counter = seats.getCount();
        replaceWithNumber("M",counter,lists,colSize,rowSize,passengersCount, seats);

        return printValues(lists, colSize, rowSize);

    }

    private void findColumnAndRowValues(int[][] seatMatrix) {
        for (int i = 0; i < seatMatrix.length; i++) {
                final int first = seatMatrix[i][0];
                final int second = seatMatrix[i][1];
                seatMatrix[i][0]= second;
                seatMatrix[i][1]= first;
        }
    }

    private  String printValues(List<List<String[]>> seats, int colSize, int rowSize)  {

        StringBuilder output = new StringBuilder();
        for(int i=0;i<colSize;i++){
            for(int j=0;j<rowSize;j++){
                if(j>= seats.size() || i>= seats.get(j).size()|| seats.get(j) ==null|| seats.get(j).get(i) ==null){
                    output.append("           ");
                    continue;
                }
                for( int k=0; k< seats.get(j).get(i).length; k++){
                    boolean isNumeric = seats.get(j).get(i)[k].chars().allMatch( Character::isDigit);
                    if(seats.get(j).get(i)[k].equals("xx") || (isNumeric && Integer.parseInt(seats.get(j).get(i)[k]) >=10) )
                        output.append(seats.get(j).get(i)[k]).append(" ");
                    else
                        output.append("0").append(seats.get(j).get(i)[k]).append(" ");
                }
                output.append("  ");
            }
            output.append("\n");
        }
        uploadtoFile(output.toString());
        return  output.toString();
    }

    private void uploadtoFile(String content)  {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File("./output.txt")))) {
            bw.write(content);
            bw.close();
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }

    }

    private  void replaceWithNumber(String val, int counter, List<List<String[]>> seats, int colSize, int rowSize,int passengersCount, Seats seat) {

        try {

            for(int i=0;i<colSize;i++){
                for(int j=0;j<rowSize;j++){
                    if(j>=seats.size()|| i>=seats.get(j).size() ||  seats.get(j) ==null|| seats.get(j).get(i) ==null)
                        continue;
                    for(int k=0; k< seats.get(j).get(i).length; k++){
                        if(seats.get(j) !=null&& seats.get(j).get(i) !=null && seats.get(j).get(i)[k].equals(val)){
                            if(counter>passengersCount)
                                seats.get(j).get(i)[k]="xx";
                            else
                                seats.get(j).get(i)[k]=String.valueOf(counter);
                            counter++;
                        }
                    }
                }
            }
        }
        catch (Exception e) {

            e.printStackTrace();
        }

        seat.setCount(counter);
    }


    public  List<List<String[]>> fillWithMAandW(int[][] array) {

        List<List<String[]>>  seats = new ArrayList<>();

        Arrays.stream(array).forEach(ints -> {
            List<String[]> checkSeats = new ArrayList<>();
            IntStream.range(0, ints[0]).mapToObj(j -> new String[ints[1]]).forEach(arr -> {
                Arrays.fill(arr, "M");
                checkSeats.add(arr);
            });
            seats.add(checkSeats);
        });

        seats.stream().flatMap(Collection::stream).forEach(strings -> {
            strings[0] = "A";
            strings[strings.length - 1] = "A";
        });

        IntStream.range(0, seats.get(0).size()).
                forEach(i -> seats.get(0).get(i)[0] = "W");

        IntStream.range(0, seats.get(seats.size() - 1).size()).
                forEach(i -> seats.get(seats.size() - 1).get(i)[(seats.get(seats.size() - 1).get(i).length) - 1] = "W");

        return seats;
    }

    private   List<Integer> largestInColumn(int[][] arr)
    {
        int cols = arr.length;
        List<Integer> maxInMatrix = new ArrayList<>();
        for (int i = 0; i < arr[i].length; i++) {
            int maxm = arr[0][i];
            for (int j = 1; j < cols; j++)
                if (arr[j][i] > maxm)
                    maxm = arr[j][i];
          maxInMatrix.add(maxm);
        }
        return maxInMatrix;
    }


}
