import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

public class RunTest {

	Run r = new Run();

	@DataProvider(name = "Sign_up")
	public static Object[][] numbers() {
		return new Object[][] { { "ahmed", "1234", "ahmed@gmail.com", false, true },
				{ "ahmed2", "1234", "ahmed@gmail.com", true, false }, { "ehab", "", "ehaboo@gmail.com", false, false },
				{ "", "", "", true, false } };
	}

	@Test(enabled = false,dataProvider = "Sign_up")
	public void Sign_up(String name, String pass, String mail, boolean type, boolean res) {
		Profile profile = new Profile();
		profile.setname(name);
		profile.setpassword(pass);
		profile.setemail(mail);
		profile.settype(type);
		r.Sign_up();
		User user = r.Users.get(r.Users.size() - 1);
		/*
		 * String Prof = user.GetProfileName() + ","+
		 * user.getProfile().getpassword() + ","+ user.GetProfileEmail() + ","+
		 * user.Is_Teacher();
		 */

		Assert.assertEquals(res, this.check_sign_up(user, profile));
	}

	public boolean check_sign_up(User user, Profile profile) {

		Profile p = user.getProfile();
		if (p.getname().equals(profile.getname())) {
			if (p.getemail().equals(profile.getemail()))
				if (p.getpassword().equals(profile.getpassword()))
					if (p.gettype().equals(profile.gettype()))
						return true;
		}
		return false;
	}

	@DataProvider(name = "logIn")
	public Object[][] logIn() {
		return new Object[][] { { "ahmed", "1234", true }, { "sameh", "1234", false }, { "ahmed", "-1", false },
				{ "", "", false } };
	}

	@Test(dataProvider = "logIn")
	public void ValidateUser(String userName, String pass, boolean res) {
		try {
			r.user_name = userName;
			r.password = pass;
			boolean valid = false;
			if(r.ValidateUser(0)!=-1)
			{
				valid = true;
			}
			Assert.assertEquals(res, valid);
		} catch (Exception e) {
			throw new RuntimeException("Test not implemented");
		}
	}
}
