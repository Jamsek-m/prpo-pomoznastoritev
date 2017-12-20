package si.pomozna.zrna;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeoutException;

@ApplicationScoped
public class UpravljalecVrste {
	
	private static final String IME_VRSTE = "pomozna";
	private static final String IME_EXCHANGE = "";
	private static final String HOST = "localhost";
	private static final String USERNAME = "rabbit";
	private static final String PASSWORD = "rabbit";

	private Connection connection;
	private Channel channel;
	
	@PostConstruct
	private void init(){
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(HOST);
		factory.setUsername(USERNAME);
		factory.setPassword(PASSWORD);
		
		try {
			connection = factory.newConnection();
			
			channel = connection.createChannel();
			
			channel.queueDeclare(IME_VRSTE, false, false, false, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	
	@PreDestroy
	private void stop(){
		try {
			channel.close();
			connection.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	public void posljiObvestiloODodanemPonudniku(Long ponudnikId){
		try {
			System.out.println("=============> pošiljam sporočilo: " + ponudnikId + ", bytes: " + Arrays.toString(ponudnikId.toString().getBytes()));
			channel.basicPublish(IME_EXCHANGE, IME_VRSTE, null, ponudnikId.toString().getBytes());
		} catch (IOException e) {
			System.err.println("Napaka pri posiljanju v vrsto!");
			e.printStackTrace();
		} catch(Exception er){
			System.err.println("Neznana napaka pri dodajanju v vrsto! " + er.getMessage() + "\n-------------------\n");
			er.printStackTrace();
		}
	}
	
}
