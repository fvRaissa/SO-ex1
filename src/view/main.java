package view;

import controller.RedesController;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		RedesController redesController = new RedesController();
		
		int opc;
		
		do {
			System.out.println("Escolha a opção desejada: \n  1-ip\n  2-ping\n  9-encerrar");
			opc = in.nextInt();
			switch (opc) {
			case 1:
				redesController.ip();
			case 2:
				redesController.ping();
			}
		}while(opc != 9);
		
		//redesController.ip();
		//redesController.ping();
		

	}

}
