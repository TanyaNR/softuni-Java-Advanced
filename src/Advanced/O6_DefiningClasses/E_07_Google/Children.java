package Advanced.O6_DefiningClasses.E_07_Google;

public class Children {

    //children {childName} {childBirthday}
    private String childName;
    private String childBirthday;


    public Children(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    @Override
    public String toString() {
        return childName + " " + childBirthday;
    }
}
