package com.oracle;

import com.oracle.dao.UserDAO;
import com.oracle.model.User;
import com.oracle.util.JPAUtil;

import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        UserDAO userDAO = new UserDAO(em);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n========= User Menu =========");
            System.out.println("1. Insert User");
            System.out.println("2. Get User by ID");
            System.out.println("3. Update User");
            System.out.println("4. Delete User");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    User newUser = new User();

                    System.out.print("Enter username: ");
                    newUser.setUsername(sc.nextLine());

                    System.out.print("Enter password: ");
                    newUser.setPassword(sc.nextLine());

                    System.out.print("Enter name: ");
                    newUser.setName(sc.nextLine());

                    System.out.print("Enter email: ");
                    newUser.setEmail(sc.nextLine());

                    System.out.print("Enter phone: ");
                    newUser.setPhone(sc.nextLine());

                    System.out.print("Enter account number: ");
                    newUser.setAccountNumber(sc.nextLine());

                    System.out.print("Enter bank name: ");
                    newUser.setBankName(sc.nextLine());

                    System.out.print("Enter card type: ");
                    newUser.setCardType(sc.nextLine());

                    newUser.setCreatedAt(LocalDate.now());
                    newUser.setRegistrationDate(LocalDate.now());

                    System.out.print("Enter DOB (yyyy-mm-dd): ");
                    newUser.setDob(LocalDate.parse(sc.nextLine()));

                    System.out.print("Enter IFSC code: ");
                    newUser.setIfscCode(sc.nextLine());

                    System.out.print("Is Activated (Y/N): ");
                    newUser.setIsActivated(sc.nextLine());

                    System.out.print("Is Verified (Y/N): ");
                    newUser.setIsVerified(sc.nextLine());

                    System.out.print("Enter salary: ");
                    newUser.setSalary(sc.nextLine());

                    userDAO.insert(newUser);
                    System.out.println("✅ User inserted successfully.");
                }

                case 2 -> {
                    System.out.print("Enter user ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    User found = userDAO.getById(id);
                    if (found != null) {
                        System.out.println("===== User Details =====");
                        System.out.println("ID: " + found.getId());
                        System.out.println("Username: " + found.getUsername());
                        System.out.println("Name: " + found.getName());
                        System.out.println("Email: " + found.getEmail());
                        System.out.println("Phone: " + found.getPhone());
                        System.out.println("Account Number: " + found.getAccountNumber());
                        System.out.println("Bank Name: " + found.getBankName());
                        System.out.println("DOB: " + found.getDob());
                        System.out.println("Salary: " + found.getSalary());
                        System.out.println("Activated: " + found.getIsActivated());
                        System.out.println("Verified: " + found.getIsVerified());
                    } else {
                        System.out.println("❌ User not found.");
                    }
                }

                case 3 -> {
                    System.out.print("Enter user ID to update: ");
                    int uid = Integer.parseInt(sc.nextLine());
                    User updateUser = userDAO.getById(uid);
                    if (updateUser != null) {
                        System.out.print("Enter new phone: ");
                        updateUser.setPhone(sc.nextLine());

                        System.out.print("Enter new email: ");
                        updateUser.setEmail(sc.nextLine());

                        userDAO.update(updateUser);
                        System.out.println("✅ User updated successfully.");
                    } else {
                        System.out.println("❌ User not found.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter user ID to delete: ");
                    int did = Integer.parseInt(sc.nextLine());
                    User deleteUser = userDAO.getById(did);
                    if (deleteUser != null) {
                        userDAO.delete(deleteUser);
                        System.out.println("✅ User deleted successfully.");
                    } else {
                        System.out.println("❌ User not found.");
                    }
                }

                case 5 -> {
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    em.close();
                    JPAUtil.close();
                    return;
                }

                default -> System.out.println("❗ Invalid choice. Please enter between 1 and 5.");
            }
        }
    }
}
