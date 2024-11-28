package Passwd;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class PasswordEvent extends AbstractAction{

	private static final long serialVersionUID = 1L;

	private JCheckBox mostrarPsw;
	private JPasswordField contrasenaField;

	public PasswordEvent(JCheckBox mostrarPsw, JPasswordField contrasenaField) {
		this.mostrarPsw = mostrarPsw;
		this.contrasenaField = contrasenaField;
	}

	//ocultar contraseña cuando le da al boton al volver a esconderla sale con *
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mostrarPsw.isSelected()) {
			contrasenaField.setEchoChar((char)0);
		}

		if(!mostrarPsw.isSelected()) {
			contrasenaField.setEchoChar('*');
		}
	}


}
