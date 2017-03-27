
public class Game {

	private String CatName;
	private String TypeName;
	private String GameName;

	public String getCatName() {
		return CatName;
	}

	public void setCatName(String catName) {
		CatName = catName;
	}

	public String getTypeName() {
		return TypeName;
	}

	public void setTypeName(String typeName) {
		TypeName = typeName;
	}

	public String getGameName() {
		return GameName;
	}

	public void setGameName(String gameName) {
		GameName = gameName;
	}

	public boolean CreateGame(String Username) {
		Controller c = new Controller();
		int CatID = c.getCatID(CatName);
		int TypeID = c.getTypeID(TypeName);
		if (c.SaveGameData(GameName, CatID, TypeID, Username)) {
			return true;
		} else
			return false;

	}

	public void PlayGame(String Username, boolean isTeacher) {

	}

}
