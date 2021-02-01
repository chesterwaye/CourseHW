/**
 * Class: Courses
 *
 * @author Chester Waye
 * @version 1.0 Course : ITEC 3150, Spring, 2021 Written: January 27, 2021
 *
 *
 *          This class � This class describes the common attributes and
 *          methods of the Courses being collected for different categories
 *
 *          Purpose: � The courses should fall into three disciplines:  English, Math, and History.
 *          •All courses should have a unique CRN (numeric code), name, category (English, Math, History)
 *
 */
public class Courses {

    private String crn;
    private String name;
    private String category;

    public Courses(String crn, String name, String category) {
        this.crn = crn;
        this.name = name;
        this.category = category;
    }

    public String getCrn(){
        return crn;
    }

  public String getName(){
        return name;
  }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString()
    {
        return "Course [CRN=" + crn + " Course name=" + name + " Category name= " + category +"]";
    }

}
