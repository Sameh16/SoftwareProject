
import java.util.ArrayList;

public class Type {

	private String typeName;
	private ArrayList<Template> templates;

	public Type() {
		super();
		templates = new ArrayList<>();
	}

	public Type(String typeName, ArrayList<Template> templates) {
		super();
		this.typeName = typeName;
		this.templates = templates;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public ArrayList<Template> getTemplates() {
		return templates;
	}

	public Template getTemplate(String tempName) {

		for (int i = 0; i < templates.size(); i++) {
			if (tempName.equals(templates.get(i).getTemplateName())) {
				return templates.get(i);
			}
		}

		return null;
	}

	public void AddTemplate(Template temp) {
		templates.add(temp);
	}

}
