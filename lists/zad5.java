import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> field = createField(sc.nextLine());
		String[] tokens = sc.nextLine().split(" ");
		int bombNumber = Integer.parseInt(tokens[0]);
		int bombRadius = Integer.parseInt(tokens[1]);
		field = detonateBombs(field, bombNumber, bombRadius);
		
		System.out.println(field.stream().mapToInt(i->i).sum());
		
		sc.close();
	}
	
	static List<Integer> createField(String input) {
		  List<Integer> field = new ArrayList<>();
		  for(String token : input.split(" ")) {
		  	 field.add(Integer.parseInt(token));
		  }
		  return field;
	}
	
	
	static List<Integer> detonateBombs(List<Integer> field, int bombNumber, int bombRadius) {
	      while(field.contains(bombNumber)) {
	            int center = field.indexOf(bombNumber);
	            int leftCorner = bounds(center - bombRadius, 0, field.size()-1); 
	            int rightCorner = bounds(center + bombRadius, 0, field.size()-1); 
	            /*System.out.printf("Debug: leftCorner: %d : rightCorner: %d%n", leftCorner, rightCorner);
	            System.out.print("Debug: ");
	            System.out.println(field);*/
	            List<Integer> newField = new ArrayList<>();
	            for(int i=0; i<field.size(); i++) {
	            	    if(i>=leftCorner && i<=rightCorner) {
	            	    	  continue;
	            	    }
	            			newField.add(field.get(i));
	            }
	            field = newField;
	            
	      }
				return field;
	}
	
	static int bounds(int n, int min, int max) {
		  if(n>max) {
		  	   return max;
		  }
		  if(n<min) {
		  	   return min;
		  }
		  return n;
	}
}
