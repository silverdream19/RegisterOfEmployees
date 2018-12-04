package domain;

import entity.Issure;
import entity.ListWrapper;
import entity.Project;
import entity.User;


import java.io.*;
import java.text.ParseException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Domain {
    public static long id;
    public static long proj_id;
    public static long usr_id;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int point = 1;
        String descr, date, projName, userName, email;
        while (point != 0) {
            System.out.println("Menu: ");
            System.out.println("1. Enter new record");
            System.out.println("2. Display the list of entities");
            System.out.println("3. Generate a report of Issues");
            System.out.println("0. Exit");
            System.out.println("Select the menu item:");
            Domain instance = new Domain();
            point = Integer.parseInt(in.nextLine());
            switch (point) {
                case 1:
                    System.out.println("Enter descripton of issure");
                    descr = in.nextLine();
                    System.out.println("Enter date of issure");
                    date = in.nextLine();
                    System.out.println("Enter name of project");
                    projName = in.nextLine();
                    System.out.println("Enter name of user");
                    userName = in.nextLine();
                    System.out.println("Enter email of user");
                    email = in.nextLine();

                    File file = new File("temp.out");
                    ListWrapper listWrapper = new ListWrapper();
                    if (file.exists()) {
                        listWrapper = instance.outStream();
                        instance.inStream(listWrapper, descr, date, projName, userName, email);

                    } else {
                        try{
                        file.createNewFile();
                        } catch (Exception except){
                            System.out.println(except);
                        }

                        instance.inStream(listWrapper, descr, date, projName, userName, email);

                    }

                    System.out.println("Done");
                    break;
                case 2:
                    File file1 = new File("temp.out");
                    if (file1.exists()) {
                        System.out.println("Choose the entity");
                        System.out.println("1. Issure");
                        System.out.println("2. Projects");
                        System.out.println("3. Users");
                        point = Integer.parseInt(in.nextLine());
                        instance.displayTheIssures(point);
                        }
                     else {
                        System.out.println("File do not exist. Create new record at first");
                    }
                    break;
                case 3:
                    File file2 = new File("temp.out");
                    if (file2.exists()) {
                        System.out.println("Enter parametres");
                        System.out.println("Project ID");
                        int project_id = in.nextInt();
                        System.out.println("User ID");
                        int user_id = in.nextInt();
                        instance.displayReport(project_id, user_id);
                    }
                    else {
                        System.out.println("File do not exist. Create new record at first");
                    }
                    break;
                case 0:
                    System.out.println("End of programm");
                    break;
                default:
                    System.out.println("This item of menu does not exist");
                    break;
            }
        }


    }


    public ListWrapper createJavaObjectExample1(ListWrapper listWrapper, String descr, String date, String projName, String userName, String email) {
        Issure issure = new Issure();
        issure.setId(id);
        issure.setDescr(descr);
        issure.setDate(date);
        try {
            Set<Project> newProjects = new HashSet<Project>();
            newProjects.add(createProject(projName));
            issure.setProjects(newProjects);
            Set<User> newUsers = new HashSet<User>();
            newUsers.add(createUser(userName, email));
            issure.setUsers(newUsers);

        } catch (ParseException exception) {
            Logger.getLogger(Domain.class.getName()).
                    log(Level.ALL, "createJavaObjectExample1 threw ParseException", exception);
        }
        Set<Issure> issures = new HashSet<Issure>();
        if (listWrapper.getIssures() == null){
            issures.add(issure);
        }else {
            issures = listWrapper.getIssures();
            issures.add(issure);
        }
        listWrapper.setIssures(issures);
        id++;
        return listWrapper;
    }

    public Project createProject(String name) throws ParseException {
        Project project = new Project();
        project.setId(proj_id);
        project.setName(name);
        proj_id++;
        return project;
    }

    public User createUser(String name, String email) throws ParseException {
        User user = new User();
       user.setId(usr_id);
        user.setName(name);
        user.setEmail(email);
        usr_id++;
        return user;
    }

    public ListWrapper outStream(){
        ListWrapper listWrapper1 = new ListWrapper();
        try {

            FileInputStream fis = new FileInputStream("temp.out");
            ObjectInputStream oin = new ObjectInputStream(fis);
            listWrapper1 = (ListWrapper) oin.readObject();

        } catch (Exception ex){
            System.out.println(ex);
        }
        return listWrapper1;

    }

    public void inStream(ListWrapper listWrapper1, String descr, String date, String projName, String userName, String email){
        try {

            FileOutputStream fos = new FileOutputStream("temp.out");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            ListWrapper listWrapper = createJavaObjectExample1(listWrapper1, descr, date, projName, userName, email);

            oos.writeObject(listWrapper);
            oos.flush();
            oos.close();
        } catch (Exception ex){
            System.out.println(ex);
        }
    }

    public void displayTheIssures(int point){
        ListWrapper listWrapper = new ListWrapper();
        listWrapper = outStream();
        for(Issure issure : listWrapper.getIssures()) {
            if (point == 1) {
                System.out.println(listWrapper.getIssures());
            }
            if (point == 2) {
                for (Project project : issure.getProjects()) {
                    System.out.println(project);
                }
            }
            if (point == 3) {
                for (User user : issure.getUsers()) {
                    System.out.println(user);
                }
            }
        }
    }

    public void displayReport(int projectId, int userId){
        // listWrapper = new ListWrapper();
        ListWrapper listWrapper = outStream();
        for(Issure issure : listWrapper.getIssures()){
            for (Project project : issure.getProjects()) {
                for (User user : issure.getUsers()) {
                    if((project.getId() == projectId)&&(user.getId() == userId)){
                        System.out.println(issure);
                    }
                }
            }


        }
    }





}
