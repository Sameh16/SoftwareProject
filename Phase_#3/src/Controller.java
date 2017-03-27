import java.util.ArrayList;

public class Controller {

	private StudentDataBase studentDataBase;
	private TeacherDataBasse teacherDataBasse;
	private GameDataBase gameDataBase;

	public Controller() {
		super();
		studentDataBase = new StudentDataBase();
		teacherDataBasse = new TeacherDataBasse();
		gameDataBase = new GameDataBase();
	}

	public boolean SaveStudentData(Student student) {
		studentDataBase.ConnectDataBase();
		boolean z = studentDataBase.SaveStudentData(student);
		studentDataBase.DisconnectDataBase();
		return z;
	}

	public boolean SaveTeacherData(Teacher teacher) {
		teacherDataBasse.ConnectDataBase();
		boolean z = teacherDataBasse.SaveTeacherData(teacher);
		teacherDataBasse.DisconnectDataBase();
		return z;
	}

	public Student LoadStudentData(String User_name, String password) {
		studentDataBase.ConnectDataBase();
		Student z = studentDataBase.LoadStudentData(User_name, password);
		studentDataBase.DisconnectDataBase();
		return z;
	}

	public Teacher LoadTeacherData(String username, String password) {

		teacherDataBasse.ConnectDataBase();
		Teacher z = teacherDataBasse.LoadTeacherData(username, password);
		teacherDataBasse.DisconnectDataBase();
		return z;
	}

	public boolean CheckStudentprimaryKey(String username) {

		studentDataBase.ConnectDataBase();
		boolean z = studentDataBase.CheckprimaryKey(username);
		studentDataBase.DisconnectDataBase();
		return z;
	}

	public boolean CheckTeacherprimaryKey(String username) {

		teacherDataBasse.ConnectDataBase();
		boolean z = teacherDataBasse.CheckprimaryKey(username);
		teacherDataBasse.DisconnectDataBase();
		return z;
	}

	public boolean CheckValidUser(String Username, String Password, boolean z) {
		if (z) {
			teacherDataBasse.ConnectDataBase();
			z = teacherDataBasse.CheckValidUser(Username, Password);
			teacherDataBasse.DisconnectDataBase();
			return z;
		} else {
			studentDataBase.ConnectDataBase();
			z = studentDataBase.CheckValidUser(Username, Password);
			studentDataBase.DisconnectDataBase();
			return z;
		}

	}

	public ArrayList<Category> LoadCategory() {
		gameDataBase.ConnectDataBase();
		ArrayList<Category> categories = gameDataBase.LoadCategory();
		gameDataBase.DisconnectDataBase();
		return categories;

	}

	public ArrayList<Type> LoadGameTypes(String CatName) {
		gameDataBase.ConnectDataBase();
		ArrayList<Type> types = gameDataBase.LoadGameTypes(CatName);
		gameDataBase.DisconnectDataBase();
		return types;
	}

	public boolean SaveGameData(String gameName, int catID, int typeID, String username) {
		gameDataBase.ConnectDataBase();
		boolean z = gameDataBase.SaveGameData(gameName, catID, typeID);
		if (z) {
			z = gameDataBase.SaveTeacherGameData(gameName, username);
		}
		gameDataBase.DisconnectDataBase();
		return z;
	}

	public ArrayList<Game> LoadGameData(String catName, String typeName) {
		gameDataBase.ConnectDataBase();
		ArrayList<Game> games = gameDataBase.LoadGameData(catName, typeName);
		gameDataBase.DisconnectDataBase();
		return games;
	}

	public int getCatID(String catName) {
		gameDataBase.ConnectDataBase();
		int id = gameDataBase.getCategoryID(catName);
		gameDataBase.DisconnectDataBase();
		return id;
	}

	public int getTypeID(String typeName) {
		gameDataBase.ConnectDataBase();
		int id = gameDataBase.getTypeID(typeName);
		gameDataBase.DisconnectDataBase();
		return id;
	}

	public int getGameID(String GameName) {
		gameDataBase.ConnectDataBase();
		int id = gameDataBase.getGameID(GameName);
		gameDataBase.DisconnectDataBase();
		return id;
	}

	public boolean SaveMSQQuestion(String gameName, MCQQuestion mcqQuestion) {
		gameDataBase.ConnectDataBase();
		boolean z = gameDataBase.SaveMSQQuestion(gameName, mcqQuestion);
		gameDataBase.DisconnectDataBase();
		return z;

	}

	public int loadMSQQuestionLevel(String GameName) {
		gameDataBase.ConnectDataBase();
		int level = gameDataBase.loadMSQQuestionLevel(GameName);
		gameDataBase.DisconnectDataBase();
		return level;
	}

	public ArrayList<MCQQuestion> loadMSQQuestion(String GameName, int level) {
		gameDataBase.ConnectDataBase();
		ArrayList<MCQQuestion> questions = gameDataBase.loadMSQQuestion(GameName, level);
		gameDataBase.DisconnectDataBase();
		return questions;
	}

	public boolean SaveTFQuestion(TFQuestion tfQuestion) {

		boolean z;
		gameDataBase.ConnectDataBase();
		z = gameDataBase.SaveTFQuestion(tfQuestion);
		gameDataBase.DisconnectDataBase();
		return z;
	}

	public ArrayList<TFQuestion> LoadTFQuestion(String Gamename, int level) {
		gameDataBase.ConnectDataBase();
		ArrayList<TFQuestion> list = gameDataBase.LoadTFQuestion(Gamename, level);
		gameDataBase.DisconnectDataBase();
		return list;

	}

	public boolean updateStudentGameData(String userName, String gameName, int rate, String commentt, int achievement) {
		gameDataBase.ConnectDataBase();
		boolean z = gameDataBase.updateStudentGameData(userName, gameName, rate, commentt,achievement);
		gameDataBase.DisconnectDataBase();
		return z;
	}

	public int loadStudentAchievement(String Username, String GameName) {
		gameDataBase.ConnectDataBase();
		int Achievement = gameDataBase.loadStudentAchievement(Username, GameName);
		gameDataBase.DisconnectDataBase();
		return Achievement;
	}
	
	public boolean SaveStudentAchievement(String Username, String GameName)
	{
		gameDataBase.ConnectDataBase();
		boolean z = gameDataBase.SaveStudentAchievement(Username,GameName);
		gameDataBase.DisconnectDataBase();
		return z;
	}

}
