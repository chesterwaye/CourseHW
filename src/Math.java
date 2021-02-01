/**
 * Class: Math
 *
 * @author Chester Waye
 * @version 1.0 Course : ITEC 3150, Spring, 2021 Written: January 27, 2021
 *
 *
 *          This class � This class describes a subclass of Course called Math
 *
 *          Purpose: � Math courses have the additional attributes of STEM or non-STEM (but not both),
 *          and they can be online, in person or hybrid courses.
 *
 */

public class Math extends Courses{

    private boolean stem;
    private String classType;

    public Math(String crn, String name, String category, boolean stem, String classType) {
        super(crn, name, category);
        this.stem = stem;
        this.classType = classType;
    }
    public boolean isStem()
    {
        return stem;
    }

    public String getClassType() {
        return classType;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + "Math [Stem=" + stem + " Class Type=" + classType + "]";
    }



}
