package start;

import java.util.ArrayList;

public class Init {

	public static void main(String[] args) {
		
		//ArrayList<String>lstTablas=controller.CtrlXML.sacarTablas();
		//ontroller.CtrlXML.sacarTablas();
		//lstTablas.forEach(e->System.out.println(e));
		controller.CtrlXML.AddList(controller.CtrlXML.sacarTablas());
		
		//view.FrmPrincipal.inicio();

	}

}
