import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameDataBase extends DataBaseConnection {

	public int getCategoryID(String name) {

		int Id = 0;

		String query = "SELECT `category`.`CATID` FROM `software`.`category` where category.CATNAME like '" + name
				+ "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			if (res.next())
				Id = res.getInt("CATID");

		} catch (SQLException e) {
			e.printStackTrace();

			return -1;
		}

		return Id;

	}

	public int getTypeID(String name) {

		int Id = 0;

		String query = "SELECT `type`.`TYPEID` FROM `software`.`type` where type.TYPENAME like '" + name + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			if (res.next())
				Id = res.getInt("TYPEID");

		} catch (SQLException e) {
			e.printStackTrace();

			return -1;
		}

		return Id;

	}

	public ArrayList<Category> LoadCategory() {
		ArrayList<Category> categories = new ArrayList<>();
		String query = "select * from software.category ;";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		try {
			while (res.next()) {
				Category category = new Category();
				category.setName(res.getString("CATNAME"));
				categories.add(category);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return categories;
	}

	public ArrayList<Type> LoadGameTypes(String CatName) {
		ArrayList<Type> types = new ArrayList<>();
		String query = "select * from software.category  where CATNAME like '" + CatName + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		int id = 0;
		try {
			if (res.next()) {
				id = res.getInt("CATID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		query = "select * from software.type  where CATID='" + id + "';";
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

		try {
			while (res.next()) {
				Type type = new Type();
				type.setTypeName(res.getString("TYPENAME"));
				types.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return types;

	}

	public boolean SaveGameData(String gameName, int catID, int typeID) {
		String query = "INSERT INTO `software`.`game`(`CATID`,`TYPEID`,`GAMENAME`)VALUES('" + catID + "','" + typeID
				+ "','" + gameName + "');";

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean SaveTeacherGameData(String GameName, String Username) {
		int id = getGameID(GameName);
		String query = "INSERT INTO `software`.`teachergame`(`GAMEID`,`USERNAME`)VALUES('" + id + "', '" + Username
				+ "');";
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public ArrayList<Game> LoadGameData(String catName, String typeName) {
		int catid = getCategoryID(catName);
		int typeid = getTypeID(typeName);
		ArrayList<Game> games = new ArrayList<>();
		String query = "SELECT * FROM `software`.`game` where game.CATID = '" + catid + "' and game.TYPEID = '" + typeid
				+ "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			while (res.next()) {
				Game game = new Game();

				game.setCatName(catName);
				game.setTypeName(typeName);
				game.setGameName(res.getString("GAMENAME"));
				games.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

		return games;

	}

	public ArrayList<MCQQuestion> loadMSQQuestion(String GameName, int level) {
		int id = getGameID(GameName);
		ArrayList<MCQQuestion> mcqQuestions = new ArrayList<>();
		String query = "SELECT * FROM `software`.`mcqgame` where `GAMEID` ='" + id + "' and  LEVEL='" + level + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			while (res.next()) {
				MCQQuestion mcqQuestion = new MCQQuestion();
				mcqQuestion.setQuestion_(res.getString("QUESTION"));
				mcqQuestion.setAnswer_1(res.getString("ANSWER1"));
				mcqQuestion.setAnswer_2(res.getString("ANSWER2"));
				mcqQuestion.setAnswer_3(res.getString("ANSWER3"));
				mcqQuestion.setAnswer_4(res.getString("ANSWER4"));
				mcqQuestion.setCorrecranswer_(res.getString("CORRECTANSWER"));
				mcqQuestion.setLevel(level);
				mcqQuestions.add(mcqQuestion);
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}

		return mcqQuestions;

	}

	public int loadMSQQuestionLevel(String GameName) {
		int id = getGameID(GameName);
		int level = -1;
		String query = "SELECT `mcqgame`.`LEVEL` FROM `software`.`mcqgame` where `GAMEID` ='" + id + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			while (res.next()) {
				if (level < res.getInt("LEVEL"))
					level = res.getInt("LEVEL");
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return level;
		}

		return level;

	}

	public boolean SaveMSQQuestion(String gameName, MCQQuestion mcqQuestion) {
		int Game_ID = getGameID(gameName);
		String query = "INSERT INTO `software`.`mcqgame`(`GAMEID`,`QUESTION`,`ANSWER1`,`ANSWER2`,`ANSWER3`,`ANSWER4`,`CORRECTANSWER`,`LEVEL`)VALUES"
				+ "('" + Game_ID + "','" + mcqQuestion.getQuestion_() + "','" + mcqQuestion.getAnswer_1() + "','"
				+ mcqQuestion.getAnswer_2() + "','" + mcqQuestion.getAnswer_3() + "','" + mcqQuestion.getAnswer_4()
				+ "','" + mcqQuestion.getCorrecranswer_() + "','" + mcqQuestion.getLevel() + "');";

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public int getGameID(String name) {

		int Id = 0;

		String query = "SELECT `game`.`GAMEID` FROM `software`.`game` where game.GAMENAME like '" + name + "';";
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			if (res.next())
				Id = res.getInt("GAMEID");

		} catch (SQLException e) {
			e.printStackTrace();

			return -1;
		}

		return Id;

	}

	public boolean SaveTFQuestion(String question_, boolean checked, String gameName, int level) {

		int Game_ID = getGameID(gameName);
		char answer = 't';
		if (checked) {
			answer = 't';
		} else {
			answer = 'f';
		}
		String query = "INSERT INTO `software`.`tfgmae`(`GAMEID`,`QUESTION`,`CORRECTANSWER`,`LEVEL`)" + "VALUES('"
				+ Game_ID + "','" + question_ + "','" + answer + "','" + level + "');";
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean SaveTFQuestion(TFQuestion tfQuestion) {
		// public boolean SaveTFQuestion(String question_, boolean checked,
		// String gameName, int level) {

		int Game_ID = getGameID(tfQuestion.getGameName());
		char answer = '\0';
		if (tfQuestion.getAnswer()) {
			answer = 't';
		} else {
			answer = 'f';
		}
		String query = "INSERT INTO `software`.`tfgmae`(`GAMEID`,`QUESTION`,`CORRECTANSWER`,`LEVEL`)" + "VALUES('"
				+ Game_ID + "','" + tfQuestion.getQuestion() + "','" + answer + "','" + tfQuestion.getLevel() + "');";
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public ArrayList<TFQuestion> LoadTFQuestion(String Gamename, int level) {

		int GameID = getGameID(Gamename);
		String query = "SELECT `tfgmae`.`QUESTIONID`,    `tfgmae`.`GAMEID`,`tfgmae`.`QUESTION`,    `tfgmae`.`CORRECTANSWER`,    `tfgmae`.`LEVEL`FROM `software`.`tfgmae`"
				+ "where level= '" + level + "' and GAMEID='" + GameID + "';";

		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();

			return null;
		}
		ArrayList<TFQuestion> list = new ArrayList<>();
		boolean has = false;
		try {

			while (res.next()) {
				has = true;
				TFQuestion question = new TFQuestion();
				question.setLevel(level);
				question.setQuestion(res.getString("QUESTION"));
				if (res.getString("CORRECTANSWER").charAt(0) == 't') {
					question.setAnswer(true);
				} else
					question.setAnswer(false);
				list.add(question);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (has == false) {
			return null;
		}

		// return templates;

		return list;
	}

	public boolean updateStudentGameData(String UserName, String GameName, int Rate, String Comment, int achievement) {

		int GameID = getGameID(GameName);
		String query = "UPDATE `software`.`studentgame`" + " SET `COMENT` = '" + Comment + "', `RATE` = '" + Rate
				+ "',ACHIEVEMENT= '" + achievement + "' " + "WHERE `GAMEID` ='" + GameID + "' AND `USERNAME` = '"
				+ UserName + "' ;";

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public int loadStudentAchievement(String Username, String GameName) {
		int gameid = getGameID(GameName);
		String query = "SELECT * FROM `software`.`studentgame`where USERNAME like '" + Username + "' and GAMEID='"
				+ gameid + "';";
		int Achievement = -1;
		ResultSet res;
		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			res = st.executeQuery();
			if (res.next())
				Achievement = res.getInt("ACHIEVEMENT");

		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

		return Achievement;

	}

	public boolean SaveStudentAchievement(String Username, String GameName)

	{
		int gameid = getGameID(GameName);
		String query = "INSERT INTO `software`.`studentgame`(`GAMEID`,`USERNAME`,`ACHIEVEMENT`)" + "VALUES('" + gameid
				+ "','" + Username + "','0');";

		PreparedStatement st;
		try {
			st = (java.sql.PreparedStatement) ((java.sql.Connection) connection).prepareStatement(query);
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;

	}

}
