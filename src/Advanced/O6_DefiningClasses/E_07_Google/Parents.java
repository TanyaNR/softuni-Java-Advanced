package Advanced.O6_DefiningClasses.E_07_Google;

public class Parents {

    //parents {parentName} {parentBirthday}
    private String parentName;
    private String parentBirthday;

    public Parents(String parentName, String parentBirthday) {
        this.parentName = parentName;
        this.parentBirthday = parentBirthday;
    }


    @Override
    public String toString() {
        return parentName + " " + parentBirthday;
    }
}
