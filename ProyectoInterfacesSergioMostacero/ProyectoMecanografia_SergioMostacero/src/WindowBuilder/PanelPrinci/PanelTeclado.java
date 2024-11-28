package WindowBuilder.PanelPrinci;

import java.awt.Color;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JPanel;

import javax.swing.JLabel;
import javax.swing.JTextArea;

@SuppressWarnings("unused")
public class PanelTeclado extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	private JButton btn0;

	private JButton btnQ;
	private JButton btnW;
	private JButton btnE;
	private JButton btnR;
	private JButton btnT;
	private JButton btnY;
	private JButton btnU;
	private JButton btnI;
	private JButton btnO;
	private JButton btnP;

	private JButton btnA;
	private JButton btnS;
	private JButton btnD;
	private JButton btnF;
	private JButton btnG;
	private JButton btnH;
	private JButton btnJ;
	private JButton btnK;
	private JButton btnL;
	private JButton btnEne;

	private JButton btnZ;
	private JButton btnX;
	private JButton btnC;
	private JButton btnV;
	private JButton btnB;
	private JButton btnN;
	private JButton btnM;
	private JButton btnComa;
	private JButton btnPunto;
	private JButton btnEspacio;

	private JLabel lblError;

	HashMap<Character, JButton> btnTeclado;

	public PanelTeclado(HashMap<Character, JButton> btnTeclado) {

		this.btnTeclado = btnTeclado;
		setBounds(getHeight() - 600, 200, 781, 368);
		setLayout(null);

		btn1 = new JButton("1");
		btn1.setBounds(21, 11, 65, 60);
		disenoBoton(btn1);
		btnTeclado.put('1', btn1);
		add(btn1);

		btn2 = new JButton("2");
		btn2.setBounds(96, 11, 65, 60);
		disenoBoton(btn2);
		btnTeclado.put('2', btn2);
		add(btn2);

		btn3 = new JButton("3");
		btn3.setBounds(171, 11, 65, 60);
		disenoBoton(btn3);
		btnTeclado.put('3', btn3);
		add(btn3);

		btn4 = new JButton("4");
		btn4.setBounds(246, 11, 65, 60);
		disenoBoton(btn4);
		btnTeclado.put('4', btn4);
		add(btn4);

		btn5 = new JButton("5");
		btn5.setBounds(321, 11, 65, 60);
		disenoBoton(btn5);
		btnTeclado.put('5', btn5);
		add(btn5);

		btn6 = new JButton("6");
		btn6.setBounds(396, 11, 65, 60);
		disenoBoton(btn6);
		btnTeclado.put('6', btn6);
		add(btn6);

		btn7 = new JButton("7");
		btn7.setLocation(471, 11);
		btn7.setSize(65, 60);
		disenoBoton(btn7);
		btnTeclado.put('7', btn7);
		add(btn7);

		btn8 = new JButton("8");
		btn8.setBounds(546, 11, 65, 60);
		disenoBoton(btn8);
		btnTeclado.put('8', btn8);
		add(btn8);

		btn9 = new JButton("9");
		btn9.setBounds(621, 11, 65, 60);
		disenoBoton(btn9);
		btnTeclado.put('9', btn9);
		add(btn9);

		btn0 = new JButton("0");
		btn0.setBounds(696, 11, 65, 60);
		disenoBoton(btn0);
		btnTeclado.put('0', btn0);
		add(btn0);

		btnQ = new JButton("Q");
		btnQ.setBounds(21, 82, 65, 60);
		disenoBoton(btnQ);
		btnTeclado.put('q', btnQ);
		add(btnQ);

		btnW = new JButton("W");
		btnW.setBounds(96, 82, 65, 60);
		disenoBoton(btnW);
		btnTeclado.put('w', btnW);
		add(btnW);

		btnE = new JButton("E");
		btnE.setBounds(171, 82, 65, 60);
		disenoBoton(btnE);
		btnTeclado.put('e', btnE);
		add(btnE);

		btnR = new JButton("R");
		btnR.setBounds(246, 82, 65, 60);
		disenoBoton(btnR);
		btnTeclado.put('r', btnR);
		add(btnR);

		btnT = new JButton("T");
		btnT.setBounds(321, 82, 65, 60);
		disenoBoton(btnT);
		btnTeclado.put('t', btnT);
		add(btnT);

		btnY = new JButton("Y");
		btnY.setBounds(396, 82, 65, 60);
		btnTeclado.put('y', btnY);
		disenoBoton(btnY);
		add(btnY);

		btnU = new JButton("U");
		btnU.setBounds(471, 82, 65, 60);
		disenoBoton(btnU);
		btnTeclado.put('u', btnU);
		add(btnU);

		btnI = new JButton("I");
		btnI.setBounds(546, 82, 65, 60);
		disenoBoton(btnI);
		btnTeclado.put('i', btnI);
		add(btnI);

		btnO = new JButton("O");
		btnO.setBounds(621, 82, 65, 60);
		disenoBoton(btnO);
		btnTeclado.put('o', btnO);
		add(btnO);

		btnP = new JButton("P");
		btnP.setBounds(696, 82, 65, 60);
		disenoBoton(btnP);
		btnTeclado.put('p', btnP);
		add(btnP);

		btnA = new JButton("A");
		btnA.setBounds(21, 153, 65, 60);
		disenoBoton(btnA);
		btnTeclado.put('a', btnA);
		add(btnA);

		btnS = new JButton("S");
		btnS.setBounds(96, 153, 65, 60);
		disenoBoton(btnS);
		btnTeclado.put('s', btnS);
		add(btnS);

		btnD = new JButton("D");
		btnD.setBounds(171, 153, 65, 60);
		disenoBoton(btnD);
		btnTeclado.put('d', btnD);
		add(btnD);

		btnF = new JButton("F");
		btnF.setBounds(246, 153, 65, 60);
		disenoBoton(btnF);
		btnTeclado.put('f', btnF);
		add(btnF);

		btnG = new JButton("G");
		btnG.setBounds(321, 153, 65, 60);
		disenoBoton(btnG);
		btnTeclado.put('g', btnG);
		add(btnG);

		btnH = new JButton("H");
		btnH.setBounds(396, 153, 65, 60);
		disenoBoton(btnH);
		btnTeclado.put('h', btnH);
		add(btnH);

		btnJ = new JButton("J");
		btnJ.setBounds(471, 153, 65, 60);
		disenoBoton(btnJ);
		btnTeclado.put('j', btnJ);
		add(btnJ);

		btnK = new JButton("K");
		btnK.setBounds(546, 153, 65, 60);
		disenoBoton(btnK);
		btnTeclado.put('k', btnK);
		add(btnK);

		btnL = new JButton("L");
		btnL.setBounds(621, 153, 65, 60);
		disenoBoton(btnL);
		btnTeclado.put('l', btnL);
		add(btnL);

		btnEne = new JButton("Ñ");
		btnEne.setBounds(696, 153, 65, 60);
		disenoBoton(btnEne);
		btnTeclado.put('ñ', btnEne);
		add(btnEne);

		btnZ = new JButton("Z");
		btnZ.setBounds(56, 224, 65, 60);
		disenoBoton(btnZ);
		btnTeclado.put('z', btnZ);
		add(btnZ);

		btnX = new JButton("X");
		btnX.setBounds(131, 224, 65, 60);
		disenoBoton(btnX);
		btnTeclado.put('x', btnX);
		add(btnX);

		btnC = new JButton("C");
		btnC.setBounds(206, 224, 65, 60);
		disenoBoton(btnC);
		btnTeclado.put('c', btnC);
		add(btnC);

		btnV = new JButton("V");
		btnV.setBounds(281, 224, 65, 60);
		disenoBoton(btnV);
		btnTeclado.put('v', btnV);
		add(btnV);

		btnB = new JButton("B");
		btnB.setBounds(356, 224, 65, 60);
		disenoBoton(btnB);
		btnTeclado.put('b', btnB);
		add(btnB);

		btnN = new JButton("N");
		btnN.setBounds(431, 224, 65, 60);
		disenoBoton(btnN);
		btnTeclado.put('n', btnN);
		add(btnN);

		btnM = new JButton("M");
		btnM.setLocation(506, 224);
		btnM.setSize(65, 60);
		btnM.setBackground(Color.WHITE);
		disenoBoton(btnM);
		btnTeclado.put('m', btnM);
		add(btnM);

		btnComa = new JButton(",");
		btnComa.setBounds(581, 224, 65, 60);
		disenoBoton(btnComa);
		btnTeclado.put(',', btnComa);
		add(btnComa);

		btnPunto = new JButton(".");
		btnPunto.setBounds(656, 224, 65, 60);
		disenoBoton(btnPunto);
		btnTeclado.put('.', btnPunto);
		add(btnPunto);

		btnEspacio = new JButton("ESPACIO");
		btnEspacio.setLocation(171, 295);
		btnEspacio.setSize(430, 60);
		disenoBoton(btnEspacio);
		btnTeclado.put(' ', btnEspacio);
		add(btnEspacio);

		lblError = new JLabel(" ");
		lblError.setBounds(21, 11, 158, 39);
		add(lblError);

		setVisible(true);
	}

	public JLabel getLblError() {
		return lblError;
	}

	public void setLblError(JLabel lblError) {
		this.lblError = lblError;
	}

	public HashMap<Character, JButton> getBtnTeclado() {
		return btnTeclado;
	}

	public void setBtnTeclado(HashMap<Character, JButton> btnTeclado) {
		this.btnTeclado = btnTeclado;
	}

	public void disenoBoton(JButton buton) {
		buton.setBackground(Color.WHITE);
	}
}
