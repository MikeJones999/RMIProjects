import java.rmi.Remote;
import java.rmi.RemoteException;

/**
*An implementation of the echo service
*/
public interface EchoService extends Remote 
{
	/**
	*Returns the same string passed as parameter
	*@params s a string
	*@retrurn the same string passed as parameter
	*/
	public String echo(String s) throws RemoteException;

	
	public String returnWord() throws RemoteException;
}
