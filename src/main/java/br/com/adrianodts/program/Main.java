package br.com.adrianodts.program;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.codec.binary.Base64;

public class Main {
	
	public static void main(String[] args) throws IOException {
		/**
		1 - Escreva uma fun��o que receba de entrada uma lista de nomes e senhas de usu�rios 
		2 - armazene estes dados com seguran�a, de forma que os dados sens�veis n�o sejam facilmente obtidos
		3 - Posteriormente o programa recebe um nome de usu�rio e senha e valida se este usu�rio e senha consta ou n�o da lista recebida.
		**/
		Map<String,String> users = new HashMap<String,String>();  
		users.put("Maria", "xyz123");
		users.put("Jose", "xpt456");
		users.put("Israel", "abc123");
		
		String filename = TextFile.saveFile("Users", ".txt", crypt(users).toString());		 
	    String name;
	    String password;
	 
	    Scanner ler = new Scanner(System.in);
	    System.out.printf("Informe o nome do usuario:\n");
	    name = ler.nextLine(); 
	    System.out.printf("\nInforme a senha: ");
	    password = ler.nextLine();
	 	
	    List<User> userList = decrypt(TextFile.getData(filename));
	    boolean userExists = findUser(userList, name, password);  
	    
	    if(userExists)
	    	System.out.printf("O usuario: \"%s\" foi localizado com sucesso.\n", name);
	    else
	    	System.out.printf("O usuario: \"%s\" nao foi localizado.\n", name);
	    ler.close();
	}
	
	private static StringBuilder crypt(Map<String,String> users) {    		
		User user;
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String> entry : users.entrySet()) {
			String name = Base64.encodeBase64String(entry.getKey().getBytes());
			String password = Base64.encodeBase64String(entry.getValue().getBytes());
			user = new User(name, password);
			sb.append(user);
			sb.append("\r\n");
		}		
		return sb;
	}
	
	private static List<User> decrypt(Map<String,String> data) {    		
		List<User> users = new ArrayList<User>();
		for (Map.Entry<String, String> entry : data.entrySet()) {
			String name = new String(Base64.decodeBase64(entry.getKey().getBytes()));
			String password = new String(Base64.decodeBase64(entry.getValue().getBytes()));
			users.add(new User(name, password));			
		}		
		return users;
	}
	
	private static boolean findUser(List<User> userList, String name, String password) {
		for (User user : userList) {
			if (user.getName().equals(name) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}
}
