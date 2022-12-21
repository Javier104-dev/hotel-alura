import java.sql.Connection;
import java.sql.SQLException;

import com.alura.hotel.jdbc.factory.ConnectionFactory;

public class prueba {

	public static void main(String[] args){
		ConnectionFactory con = new ConnectionFactory();
		
		for(int i = 0; i < 20; i++) {
			Connection conexion = con.recuperaConexion();
			
			System.out.println("arbiendo conexion " + (i+1));
		}
	}
}
