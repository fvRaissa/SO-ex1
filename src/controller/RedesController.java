package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class RedesController {
	
	private String os() {
		return System.getProperty("os.name");
	}
	
	public void ip(){
		String nomeOs = os();
		
		
		if(nomeOs.contains("Windows")) {
			
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				
				String adaptador="";
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("Adaptador"))
					adaptador = linha;
					
					if(linha.contains("IPv4")) {
						String [] dados = linha.split(" : ");
						String ipv4 = dados[1];
						
						System.out.println("Adaptador: "+ adaptador);
						System.out.println("IPv4:"+ipv4);
					}
					linha = buffer.readLine();
				}
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
		}else if(nomeOs.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				
				String adaptador="";
				String linha = buffer.readLine();
				while (linha != null) {
					if(linha.contains("flags")) {
						adaptador = linha.split(":")[0];
						
					}
					
					if(linha.contains("netmask")) {
						String ipv4 = linha.split(" ")[9];
						
						
						System.out.println("Adaptador: "+ adaptador);
						System.out.println("IPv4:"+ipv4);
					}
					linha = buffer.readLine();
				}
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
		}else {
			System.out.println("Sistema Operecional não identificado");
		}
	}
	
	public void ping() {
		String nomeOs = os();
		
		if(nomeOs.contains("Windows")) {
			
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -n 10 www.google.com.br");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				
				String lMedia= null;
				String linha = buffer.readLine();
				while (linha != null) {
					linha = buffer.readLine();
					if(linha != null)
						lMedia = linha;
				}
				
				String media = lMedia.split(", ")[2];
				String ms = media.split(" = ")[1];
				
				System.out.println("A média do ping foi de: "+ms);
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
		}else if(nomeOs.contains("Linux")) {
			
			try {
				Process p = Runtime.getRuntime().exec("ping -4 -c 10 www.google.com.br");
				InputStream stream = p.getInputStream();
				InputStreamReader reader = new InputStreamReader(stream);
				BufferedReader buffer = new BufferedReader(reader);
				
				
				String lMedia= null;
				String linha = buffer.readLine();
				while (linha != null) {
					
					if(linha.contains("avg")) {
						
						lMedia= linha.split("/")[5];
						
					}
					linha = buffer.readLine();
					
				}
				
				
				
				
				System.out.println("A média do ping foi de: "+lMedia);
				
				buffer.close();
				reader.close();
				stream.close();
				
			}catch(IOException e) {
				String err = e.getMessage();
				System.err.println(err);
			}
			
			
		}else {
			System.out.println("Sistema Operecional não identificado");
		}
	}
}
