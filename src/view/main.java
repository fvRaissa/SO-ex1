package view;

import javax.swing.JOptionPane;
import controller.RedesController;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		RedesController redesController = new RedesController();
		
		int opc;
		
		do {
			
			opc = Integer.parseInt(JOptionPane.showInputDialog(" Escolha a opção desejada:  \n  1-ip \n  2-ping\n  9-encerrar"));
			
			switch (opc) {
			case 1:
				redesController.ip();
				break;
			case 2:
				redesController.ping();
				break;
			case 9:
				System.exit(0);
			}
		}while(opc != 9);
		
		//redesController.ip();
		//redesController.ping();
		

	}

}
