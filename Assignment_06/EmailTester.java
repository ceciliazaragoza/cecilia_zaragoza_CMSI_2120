

public class EmailTester {
	
	public static void main(String[] args)

	{   
		
		String doc;
		EmailSort e_ls = new EmailSort("attendance.txt");
		
		doc = e_ls.getDocument();
		
		System.out.println("\n" + doc);
		
		e_ls.getHistogram();
		
		e_ls.findAttendee("bill.gates");
		
		e_ls.findAttendee("jerry.springer", "msft");
		
		e_ls.findAttendee("Bill Gates", "msft");
		
		e_ls.findAttendee("Jerry Springer");
		
		e_ls.tofile();
	}
}
