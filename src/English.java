/**
 * Class: English
 *
 * @author Chester Waye
 * @version 1.0 Course : ITEC 3150, Spring, 2021 Written: January 27, 2021
 *
 *
 *          This class � This class describes a subclass of Course called English
 *
 *          Purpose: � English courses additionally have attributes of level (freshman, sophomore, junior, senior),
 *          and can be either a reading or writing course or both.
 *
 */

public class English extends Courses {
    private String gradeLevel;
    private String type;

    public English(String  crn, String name, String category, String gradeLevel, String type) {
        super(crn, name, category);
        this.gradeLevel = gradeLevel;
        this.type = type;
    }
    public String getGradeLevel(){
        return gradeLevel;
    }
    public String getType(){
        return type;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + "English [Grade level=" + gradeLevel + " Lang Arts Type=" + type + "]";
    }
}
