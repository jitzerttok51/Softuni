import java.util.*;

 // Compiler version JDK 11.0.2

 class Main
 {
   public static void main(String args[])
   { 
     Scanner sc = new Scanner(System.in);
     List<String> list = createList(sc.nextLine());
     
     while(true) {
       /*System.out.print("Debug Output: ");
       for(String number:list) {
         System.out.print(number+" ");
       }
       System.out.println();*/
       
       String line = sc.nextLine();
       
       if(line.equals("End")) {
         break;
       }
       
       String[] tokens = line.split(" ");
       String keyword;
       if(tokens[0].equals("Shift")) {
         keyword=tokens[0]+tokens[1];
       } else {
         keyword=tokens[0];
       }
       
       switch(keyword) {
         case "Add": addNumber(list, tokens[1]); break;
         case "Insert": insertNumber(list, tokens[1], Integer.parseInt(tokens[2])); break;
         case "Remove": removeNumber(list, Integer.parseInt(tokens[1])); break;
         case "Shiftleft": shiftLeft(list, Integer.parseInt(tokens[2])); break;
         case "Shiftright": shiftRight(list, Integer.parseInt(tokens[2]));
       }
     }
     
     for(String number:list) {
       System.out.print(number+" ");
     }
   }
   
   static List<String> createList(String init) {
     List<String> list = new ArrayList<>();
     for(String number:init.split(" ")) {
       list.add(number);
     }
     return list;
   }
   
   static void addNumber(List<String> list, String number) {
     list.add(number);
   }
   
   static void insertNumber(List<String> list, String number, int index) {
     if(!isIndexValid(list, index)) {
       return;
     }
     list.add(index, number);
   }
   
   static void removeNumber(List<String> list, int index) {
     if(!isIndexValid(list, index)) {
       return;
     }
     list.remove(index);
   }
   static void shiftRight(List<String> list, int count) {
     for(int i=0;i<count;i++) {
       String item = list.remove(list.size()-1);
       list.add(0, item);
     }
   }
   
   
   static void shiftLeft(List<String> list, int count) {
     for(int i=0;i<count;i++) {
       String item = list.remove(0);
       list.add(item);
     }
   }
   
   static boolean isIndexValid(List<String> list, int index) {
      boolean isValid=index>=0 && index<list.size();
      if(!isValid) {
        System.out.println("Invalid index");
      }
      return isValid;
   }
 }
