package service;

import utils.RandomRequest;

public class UsersManager {

	public static long createID(StudentsDB studentsDB) {

		return studentsDB.getLastID() + 1;
	}

	public static String createUser(StudentsDB studentsDB, String name, String surname) {
		
		StringBuilder newUser = new StringBuilder();
		
		newUser.append(name.substring(0, (name.length() / 2)));
		newUser.append(surname.substring(0, (surname.length() / 2)));
		
		while (true) {
			if (studentsDB.checkIfUserExist(newUser.toString())) {
				newUser.append(0);
			} else {
				return newUser.toString();
			}
		}
	}

	public static String createPassword() {

		StringBuilder newPassword = new StringBuilder();
		
		//Password length 10 chars
		
		for (int i = 0; i < 10; i++) {
			newPassword.append(RandomRequest.getChar());
		}
		
		return newPassword.toString();
	}
}
