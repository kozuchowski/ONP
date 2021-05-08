import java.util.Arrays;

public class Onp {
	//klasyczny zapis: 3*(9-2*4+1)-2
	static String onp ="3 9 2 4 x - 1 + x 2 -";
					 	
	
	static String[] array = onp.split(" ");
	static String[] temp;
	static int count;
	static String[] tmp;
	
	static boolean plus(String[] arr, int i) {
		if(arr[i].equals("+"))
			return true;
		
		return false;
	}
	static boolean minus(String[] arr, int i) {
		if(arr[i].equals("-"))
			return true;
		return false;
	}
	static boolean multi(String[] arr, int i) {
		if(arr[i].equals("x"))
			return true;
		return false;
	}
	static boolean divide(String[] arr, int i) {
		if(arr[i].equals("/"))
			return true;
		return false;
	}
	static boolean modulo(String[] arr, int i) {
		if(arr[i].equals("%"))
			return true;
		return false;
	}
	
	static boolean onp(String[] arr) {
		temp = new String[array.length];
		count = 0;
		
		if(arr.length == 1) {
			System.out.println(arr[0]);
			return true;
		}
		
		for(int i = 0; i < arr.length; i++) {
			
			//je¿eli jest liczb¹	
			if((!plus(arr, i) && !minus(arr, i) && !multi(arr, i) && !divide(arr, i) && !modulo(arr, i))){
				
				//dwie w przód jest liczb¹ , ale jeœli da siê iœæ dwa do przodu
			if(i + 2 < arr.length) {
				if((!plus(arr, i + 2) && !minus(arr, i + 2) && !multi(arr, i + 2) && !divide(arr, i + 2) && !modulo(arr, i + 2))) {
					temp[count] = arr[i];
					count++;
					
				//dwie w przód jest dzia³aniem
				}else {					
					
					if(!plus(arr, i + 1) && !minus(arr, i + 1) && !multi(arr, i + 1) && !divide(arr, i + 1) && !modulo(arr, i + 1)) {
						if(plus(arr, i + 2))
							temp[count] = Integer.toString(Integer.parseInt(arr[i]) + Integer.parseInt(arr[i + 1]));
						if(minus(arr, i + 2))
							temp[count] = Integer.toString(Integer.parseInt(arr[i]) - Integer.parseInt(arr[i + 1]));
						if(multi(arr, i + 2))
							temp[count] = Integer.toString(Integer.parseInt(arr[i]) * Integer.parseInt(arr[i + 1]));
						if(divide(arr, i + 2))
							temp[count] = Integer.toString(Integer.parseInt(arr[i]) / Integer.parseInt(arr[i + 1]));
						if(modulo(arr, i + 2))
							temp[count] = Integer.toString(Integer.parseInt(arr[i]) % Integer.parseInt(arr[i + 1]));
						count++;
						i += 2;
					}else {
						temp[count] = arr[i];
						count++;
					}
				}
			}else {
				temp[count] = arr[i];
				count++;
			}
			
			 //jest dzia³aniem
			}else {
				temp[count] = arr[i];
				count++;
			}
					 
		}
		
		int tmpLength = 0;
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				tmpLength++;
			}
		}
		tmp = new String[tmpLength];
		
		for(int i = 0; i < temp.length; i++) {
			if(temp[i] != null) {
				tmp[i] = temp[i];
			}
		}
		
		
		array = new String[tmp.length];
		array = tmp;
		System.out.println(Arrays.toString(array));
		onp(array);
		return false;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(array));
				onp(array);
		
	}
}
