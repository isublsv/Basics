package by.etc.code_review.module6.task01.utils;

import by.etc.code_review.module6.task01.entity.user.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserUtils {

	private static String csvFile = "D:/WORK/Dropbox/Java/Basics/src/by/etc/code_review/module6/task01/data/users.csv";

	private static List<User> users = new ArrayList<>();

	/**
	 * Get user by provided username and password.
	 *
	 * @param username the username of user.
	 * @param password the password of user.
	 * @return user with full data or throw IllegalArgumentException if user doesn't exist with provided username
	 * and password.
	 */
	public static User login(String username, String password) {

		for (User user : users) {
			if (user.getUsername()
			        .equalsIgnoreCase(username) && PasswordUtils.verifyUserPassword(password, new String(user.getPassword()), user
					.getSalt())) {
				return user;
			}
		}

		throw new IllegalArgumentException("The current user doesn't exists!");
	}

	/**
	 * Load users ti the list from csv file.
	 *
	 * @return the list of users.
	 */
	public static List<User> loadUsers() {

		String line;
		String splitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				String[] data = line.split(splitBy);


				User user = new UserBuilder(data[5], data[6]).withName(data[0])
				                                             .withLastname(data[1])
				                                             .setSex(Sex.valueOf(data[2].toUpperCase()))
				                                             .setRole(Role.valueOf(data[3].toUpperCase()))
				                                             .setEmail(new Email(data[4]))
				                                             .setSalt(data[7])
				                                             .build();
				users.add(user);

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Add user to the user list.
	 *
	 * @param user the object to add to the user list
	 * @return false if user exists with provided username, true otherwise.
	 */
	public static boolean addUser(User user) {
		if (isUserExist(user)) {
			System.out.println("The user with \"" + user.getUsername() + "\" is exist!");
			return false;
		} else {
			users.add(user);
			saveUserList();
			return true;
		}
	}

	/**
	 * Remove user from the user list.
	 *
	 * @param user the object to remove from the user list
	 * @return false if user not exists with provided username, true otherwise.
	 */
	public static boolean removeUser(User user) {
		if (!isUserExist(user)) {
			System.out.println("The user with \"" + user.getUsername() + "\" isn't exist!");
			return false;
		} else {
			users.remove(user);
			saveUserList();
			return true;
		}
	}

	/**
	 * Save user list in the csv file in the next format:
	 * "name,lastname,sex,role,email,username,securedPassword,salt".
	 */
	private static void saveUserList() {

		StringBuilder sb = new StringBuilder();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {

			for (User user : users) {
				sb.append(user.getName());
				sb.append(",");
				sb.append(user.getLastname());
				sb.append(",");
				sb.append(user.getSex().name().toLowerCase());
				sb.append(",");
				sb.append(user.getRole().name().toLowerCase());
				sb.append(",");
				sb.append(user.getEmail());
				sb.append(",");
				sb.append(user.getUsername());
				sb.append(",");
				sb.append(user.getPassword());
				sb.append(",");
				sb.append(user.getSalt());

				bw.newLine();
				bw.write(sb.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Checks if user exist with provided username.
	 *
	 * @param user the user with provided the username.
	 * @return true if user exist with provided username, false otherwise.
	 */
	private static boolean isUserExist(User user) {
		return users.stream().anyMatch(u -> u.getUsername().equalsIgnoreCase(user.getUsername()));
	}

	/**
	 * Checks if user has admin role.
	 *
	 * @param user the user is a possible admin.
	 * @return true if the provided user has admin role.
	 */
	public static boolean isAdmin(User user) {
		return user.getRole() == Role.ADMIN;
	}
}
