import java.util.Arrays;
public class Exer4{
	public static void main(String[] args){
		String s = "          a,b, c, d    ";
		String[] parts = s.trim().split(",");
		System.out.println(Arrays.toString(parts));
	}
}
