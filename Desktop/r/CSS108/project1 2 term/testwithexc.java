public class testwithexc {
   import java.io.*;
import java.util.Scanner;

public class test{
   Map map;
   public static void main(String[] args)  throws IOException{
      Scanner input = new Scanner(System.in);
      test game;
      try {
         game = new test(new Map(input.nextInt()));
         java.io.File file = new java.io.File("position.txt");
         java.io.PrintWriter output = new java.io.PrintWriter(file);
      
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
      } catch (InvalidMapException e) {
         e.printStackTrace();
      }
      
   }
   
   public test(Map map){
      this.map = map;
   }
   public void setMap(Map map){
      this.map = map;   
   }
}

class Map{
   final static Scanner in = new Scanner(System.in);
   private int size;
   public  char[][] mapIn;
   public Map(int size) throws InvalidMapException{
      if(size>0){
         this.size =size;
      }
      else{
         throw new InvalidMapException(""+size);
      }
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
}

class InvalidMapException extends Exception{
   String string;
   public InvalidMapException(String string){
      super("Invalid size " + string);
      this.string = string;
   }
}
}
