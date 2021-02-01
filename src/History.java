/**
 * Class: History
 *
 * @author Chester Waye
 * @version 1.0 Course : ITEC 3150, Spring, 2021 Written: January 27, 2021
 *
 *
 *          This class � This class describes a subclass of Course called History
 *
 *          Purpose: �History courses have the additional attributes of Area E eligible or not,
 *          and they can be recorded, online, or in-person.
 *
 */

public class History extends Courses {
    private boolean areaEeligible;
    private String classType;

    public History(String crn, String name, String category, boolean areaEeligible, String classType) {
        super(crn, name, category);
        this.areaEeligible = areaEeligible;
        this.classType = classType;
    }
    public boolean isAreaEeligible()
    {
        return areaEeligible;
    }
    public String getClassType()
    {
        return classType;
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + "History [Area E eligible=" + areaEeligible + " Class Type=" + classType + "]";
    }
}
