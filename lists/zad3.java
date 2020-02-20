import java.util.*;

 // Compiler version JDK 11.0.2

 class Dcoder
 {
   public static void main(String args[])
   { 
     Scanner sc = new Scanner(System.in);
     List<String> partyList = new ArrayList<>();
     
     int n = Integer.parseInt(sc.nextLine());
     for(int i=0;i<n;i++) {
       String input = sc.nextLine();
       if(input.contains("is going")) {
         addToList(partyList, input);
       } else if(input.contains("is not going")) {
         rmFromList(partyList, input);
       }
     }
     
     for(String name: partyList){
       System.out.println(name);
     }
    
   }
   
   static void addToList(List<String> partyList,String input) {
     String name = input.split(" ")[0];
         if(partyList.contains(name)) {
           System.out.println(
             name + " is already in the list!"
             );
         } else {
           partyList.add(name);
         }
   }
   
   static void rmFromList(List<String> partyList,String input) {
     String name = input.split(" ")[0];
         if(!partyList.contains(name)) {
           System.out.println(
             name + " is not in the list!"
             );
         } else {
           partyList.remove(name);
         }
   }
   
 }
    
