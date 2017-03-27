
import java.util.ArrayList;

public class Category {

	private String categoryName;
	private ArrayList<Type> types;

	public Category(String categoryName, ArrayList<Type> types) {
		super();
		this.categoryName = categoryName;
		this.types = types;
	}

	public Category() {
		super();
		types = new ArrayList<>();
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String name) {
		this.categoryName = name;
	}

	public ArrayList<Type> getTypes() {
		return types;
	}

	public Type gettype(String typename) {
		for (int i = 0; i < types.size(); i++) {
			if (typename.equals(types.get(i).getTypeName())) {
				return types.get(i);
			}
		}

		return null;
	}

}
