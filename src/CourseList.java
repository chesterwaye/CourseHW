/**
 * Class: CourseList
 *
 * @author Chester Waye
 * @version 1.0 Course : ITEC 3150, Spring, 2021 Written: January 27, 2021
 *
 *
 * This class � This class describes CourseList used to contain the Courses
 * item CourseList. It also contains the main method which starts the
 * program.
 *
 * Purpose: � Methods and attributes needed to create a CourseList of
 * Courses class items. Print them, read them from a file,search for a
 * particular id and add a new item.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CourseList {




    //actual CourseList data
    private ArrayList<Courses> courseList = new ArrayList<Courses>();


    /**
     * Method:printCourseListItems()
     *
     * This method prints the CourseList items contained in the courseList
     * Array list. It relies on the toString method of the various Course types to
     * print the items in a user friendly format.
     *
     *
     */

    public void printCourseListItems() {
        for (int i = 0; i < courseList.size(); i++) {
            Courses temp = courseList.get(i);
            System.out.println(temp);
        }

    }

    /**
     * Method:searchByName()
     *
     * This method looks at each item in the courseList array list and if
     * its name attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     *
     * @param name
     *
     * @return Courses
     *
     */
    public Courses searchByName(String name) {
        Courses item = null;
        for (Courses temp : courseList) {
            if (temp.getName().equalsIgnoreCase(name)) {
                item = temp;
            }

        }
        return item;
    }

    /**
     * Method:searchByCrn()
     *
     * This method looks at each item in the courseList array list and if
     * its CRN attribute matches the input parameter id, that item is
     * returned to the caller. It returns null if item is not found.
     *
     * @param crn
     *
     * @return Courses
     *
     */

    public Courses searchByCrn(String crn) {
        Courses item = null;
        for (Courses temp : courseList) {

            if (temp.getCrn().equalsIgnoreCase(crn)) {
                item = temp;
            }

        }
        return item;
    }

    /**
     * @return the courseList
     */
    public ArrayList<Courses> getCourseList() {
        return courseList;
    }

    /**
     * Method:addCourse()
     *
     * This method adds the parameter course to the courseList array list
     *
     * @param courseNames
     *
     */
    public void addCourse(Courses courseNames) {

        courseList.add(courseNames);
    }

    /**
     * Method:removeCourse()
     *
     * This method removes the course with name from the courseList array list
     *
     * @param courseName
     */
    public void removeCourse(String courseName) {
        Courses removeSingleCourse = this.searchByName(courseName);
        if (removeSingleCourse != null) {
            courseList.remove(removeSingleCourse);
        }
    }

    /**
     *
     * Method:main()
     *
     * This method is the starting point of the program. It contains the initial
     * reading of items from the text file Courselist.txt and a menu for allowing user
     * to choose various tasks.
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        // create ClientList by reading in from text file named courses.txt
        CourseList myCourseList = new CourseList();

        // open text file
        File courseFile = new File("courses.txt");
        // open a Scanner to read data from File
        Scanner courseReader = null;
        try {
            courseReader = new Scanner(courseFile);
        } catch (FileNotFoundException e) {

            System.out.println("No CourseList Courses found- CourseList is empty");

        }

        // read one course at a time
        while (courseReader != null && courseReader.hasNext()) {

            String category = courseReader.nextLine();
            String name = courseReader.nextLine();
            String crn = courseReader.nextLine();


            if (category.equalsIgnoreCase("Math")) {
                String temp = courseReader.nextLine();
                boolean stem = Boolean.parseBoolean(temp);
                String classType = courseReader.nextLine();
                Math math = new Math(crn, name, category, stem, classType);
                myCourseList.addCourse(math);

            } else if (category.equalsIgnoreCase("English")) {
                String gradeLevel = courseReader.nextLine();
                String type = courseReader.nextLine();
                English eng = new English(crn, name, category, gradeLevel, type);
                myCourseList.addCourse(eng);

            } else if (category.equalsIgnoreCase("History")) {
                String temp = courseReader.nextLine();
                boolean areaEeligible = Boolean.parseBoolean(temp);
                String classType = courseReader.nextLine();
                History his = new History(crn, name, category, areaEeligible, classType);
                myCourseList.addCourse(his);
            } else {
                System.out.println("Unknown Course type " + category);
            }

        }
        Scanner keyboard = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("Welcome to the Course List");
        System.out.println(" ");
        boolean done = false;
        while (!done) {
            System.out.println("Would you like to :");
            System.out.println(" ");
            System.out.println("  1. View contents of Course List");
            System.out.println("  2. Search for a Course");
            System.out.println("  3. Search for a CRN");
            System.out.println("  4. Remove a Course");
            System.out.println("  5. Add a course");
            System.out.println("  6.  Exit");

            String optionChoice = keyboard.nextLine();
            int userInput = Integer.parseInt(optionChoice);
            if (userInput == 1) {
                myCourseList.printCourseListItems();
            } else if (userInput == 2) {
                System.out.println("Please enter course name");
                String id = keyboard.nextLine();
                Courses item = myCourseList.searchByName(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sorry- course not found");
                }
            } else if (userInput == 3) {
                System.out.println("Please enter CRN");
                String id2 = keyboard.nextLine();
                Courses item = myCourseList.searchByCrn(id2);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Sorry- CRN not found");
                }
            } else if (userInput == 4) {
                System.out.println("Please enter course name");
                String id3 = keyboard.nextLine();
                myCourseList.removeCourse(id3);
            } else if (userInput == 5) {
                //Add all common var
                System.out.println("Please enter CRN");
                String crn = keyboard.next();
                keyboard.nextLine();
                System.out.println("Please enter course name");
                String name = keyboard.nextLine();
                System.out.println("Please enter category");
                String category = keyboard.nextLine();
               //Add new Math Course
                if (category.equalsIgnoreCase("Math")) {
                    System.out.println("Is this this class online , in-person, or hybird? ");
                    String ctype = keyboard.nextLine();
                    System.out.println("Is this a stem class? (yes/no) ");
                    String stem = keyboard.nextLine();
                    boolean stems = true;
                    if (stem.equalsIgnoreCase("no")) {
                        stems = false;
                    }
                    Math newClass = new Math(crn, name, category, stems, ctype);
                    myCourseList.addCourse(newClass);

                    //Add new History Course
                } else if (category.equalsIgnoreCase("History")){
                    System.out.println("Is this this class  Area E eligible or not?(yes/no) ");
                    String eligible = keyboard.nextLine();
                    System.out.println("Is this class recorded, online, or in-person? ");
                    String classType = keyboard.nextLine();
                    boolean areaEeligible = true;
                    if (eligible.equalsIgnoreCase("no")) {
                        areaEeligible = false;
                    }
                    History newClass = new History(crn, name, category, areaEeligible, classType);
                    myCourseList.addCourse(newClass);
                } else {
                    //Add new English Course
                    System.out.println("Is this this class level freshman, sophomore, junior, senior? ");
                    String classlevel = keyboard.nextLine();
                    System.out.println("Is this this class reading or writing course or both? ");
                    String ctypes = keyboard.nextLine();
                    English newClass = new English(crn, name, category, classlevel, ctypes);
                    myCourseList.addCourse(newClass);
                }
            } else {
                done = true;
                // write out contents of courseList back to original file
                PrintWriter out = null;
                // open file for writing
                try {
                    out = new PrintWriter(new File("courses.txt"));
                } catch (FileNotFoundException e) {

                    e.printStackTrace();
                }
                // write contents of each courseList item to file
                for (Courses courseL : myCourseList.getCourseList()) {
                    // first write the attributes common to all
                    out.println(courseL.getCategory());
                    out.println(courseL.getName());
                    out.println(courseL.getCrn());


                    if (courseL.getCategory().equalsIgnoreCase("Math")) {
                        // cast to appropriate subclass
                        Math math = (Math) courseL;
                        // write attributes specific to Math
                        out.println(math.isStem());
                        out.println(math.getClassType());

                    } else if (courseL.getCategory().equalsIgnoreCase("English")) {
                        // cast to appropriate subclass
                        English eng = (English) courseL;
                        // write attributes specific to English
                        out.println(eng.getGradeLevel());
                        out.println(eng.getType());

                    } else if (courseL.getCategory().equalsIgnoreCase("History")) {
                        History hist = (History) courseL;
                        // write attributes specific to History
                        out.println(hist.isAreaEeligible());
                        out.println(hist.getClassType());


                    } else {
                        System.out.println("Unknown Courses type " + courseL.getCategory());
                    }

                }
                out.close();

            }

        }


    }


}
