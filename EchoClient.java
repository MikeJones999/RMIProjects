
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

public class EchoClient
{
	public static void main (String[] args) throws MalformedURLException, RemoteException, NotBoundException
	{
		new EchoClient().launch();
	
	}

	
	public void launch() throws MalformedURLException, RemoteException, NotBoundException
	{
	
		System.out.print("Insert word to Send: ");
		String str = System.console().readLine();
		
		System.out.print("Insert IP: ");
		String ip = System.console().readLine();
		
		System.out.print("Insert Port: ");
		String port = System.console().readLine();
		
		System.out.println("Looking up " + "//"+ip+":"+port +"/echo");
		Remote service = Naming.lookup("//"+ip+":"+port +"/echo");
		System.out.println("Looked up " + "//"+ip+":"+port +"/echo");
		//Remote service = Naming.lookup("//193.61.8.125:1099/echo");
	    //Remote service = Naming.lookup("//127.0.0.1:1099/echo");
		EchoService echoService = (EchoService) service; 
		
		//send STR and return same string and place in receivedEcho string
		String receivedEcho = echoService.echo(str);	
		
		//calls method on server and returns the set word
		//String receivedWord = echoService.returnWord();
		
		System.out.println("Returned word from Server: " + receivedEcho + " Mike says: "); //+ receivedWord);
		
	}

	
//to run client// java -Djava.security.policy=client.policy EchoClient
}