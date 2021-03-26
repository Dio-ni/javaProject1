import java.io.*;
import java.util.Scanner;

public class test{
   Map map;
   public static void main(String[] args)  throws IOException{
      Scanner input = new Scanner(System.in);
      //input map size
      Map map = new Map(input.nextInt());
      //create new game with map
      test game = new test(map);
      //create new file with outputs
      java.io.File file = new java.io.File("position.txt");
      java.io.PrintWriter output = new java.io.PrintWriter(file);
      
      //save mapSize and map values
      output.println(game.map.getSize());
      char[][] mapFill = game.map.mapIn;
      for(char[] i: mapFill){
         for(char j : i){
            output.print(j+" ");
         }
         output.println();
      }
      // check if getValueAt works   code->   output.println(map.getValueAt(0,0));
      output.close();
      input.close();
   }
   
   public test(Map map){
      this.map = map;
   }
   public void setMap(Map map){
      this.map = map;   
   }
}

class Map extends InvalidMapException{
   final static Scanner in = new Scanner(System.in);
   private int size;
   public char[][] mapIn;
   public Map(int size){
      
      this.size = size;
      mapIn = new char[size][size];
      for(int i=0;i<size;i++)
      {
         for(int j =0;j<size;j++)
         {
            mapIn[i][j] = in.next().charAt(0);
         }
      }
   }
   public int getSize(){
      return this.size;
   }
   public char getValueAt(int a, int b){
      char value = this.mapIn[a][b];
      return value;

   }
   public void print(){
      for(char[] i: this.mapIn){
         for(char j : i){
            System.out.print(j);
         }
        System.out.println();
      }
      
   }
   public Map() {
   }
}