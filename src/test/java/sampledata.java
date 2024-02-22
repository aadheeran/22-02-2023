import java.io.IOException;
import java.util.ArrayList;

public class sampledata {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Data driven=new Data();
		ArrayList d=driven.getdata("Profile");
		
		System.out.println(d.get(2));
		
		System.out.println(d);
	}

}
