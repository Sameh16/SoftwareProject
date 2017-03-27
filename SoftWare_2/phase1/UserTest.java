import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserTest {

	User user = new User();

	@DataProvider(name = "checkNamePassword")
	public Object[][] checkName() {
		return new Object[][] { { "sameh", "sameh", true }, { "sameh", "@123", true }, { "sameh", "-1", false },
				{ "sameh", "", false } };
	}

	@Test(enabled=false ,dataProvider = "checkNamePassword")
	public void CheckNamePassword(String name, String pass, boolean res) {
		try {
			System.out.println("CheckNamePassword Test");
			user.Fill_profile();
			Assert.assertEquals(res, user.CheckNamePassword(name, pass));
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}

	@DataProvider(name = "createGame")
	public Object[][] createGame()
	{
		return new Object[][]{{true},{true},{false}};
	}
	
	@Test(dataProvider = "createGame")
	public void Create_Game(boolean res) {
		try {
			int gameSize = user.getGames().size();
			user.Create_Game();
			boolean created = true;
			if(gameSize==user.getGames().size())
			{
				created = false;
			}
			Assert.assertEquals(res, created);
			
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}

	@DataProvider(name = "profile")
	public Object[][] profile() {
		return new Object[][] { { "name", "pass", "mail", true, true }, { "name", "pass", "mail", true, false },
				{ "", "", "", true, false }, { "name", "pass", "", true, false } };
	}

	@Test(enabled=false , dataProvider = "profile")
	public void Fill_profile(String name, String pass, String mail, boolean type, boolean res) {
		try {
			System.out.println("Fill Profile Test");
			Profile profile = new Profile();
			profile.setname(name);
			profile.setemail(mail);
			profile.setpassword(pass);
			profile.settype(type);
			user.Fill_profile();
			Assert.assertEquals(res, this.check_Fill_profile(user, profile));
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}

	public boolean check_Fill_profile(User user, Profile profile) {

		Profile p = user.getProfile();
		if (p.getname().equals(profile.getname())) {
			if (p.getemail().equals(profile.getemail()))
				if (p.getpassword().equals(profile.getpassword()))
					if (p.gettype().equals(profile.gettype()))
						return true;
		}
		return false;
	}

	@Test(enabled = false)
	public void Play_Game() {
		try {
			
			
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}


}
