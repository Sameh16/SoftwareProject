
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Template {
	private String templateName;
	private ArrayList<Image> TmplateImage;
	private JFrame GUI;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public ArrayList<Image> getTmplateImage() {
		return TmplateImage;
	}

	public void setTmplateImage(ArrayList<Image> tmplateImage) {
		TmplateImage = tmplateImage;
	}

	public JFrame getGUI() {
		return GUI;
	}

	public void setGUI(JFrame gUI) {
		GUI = gUI;
	}

}
