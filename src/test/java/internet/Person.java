package internet;

public class Person {

    String lastName, firstName, due;

    public Person(String lastName, String firstName, String due) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.due = due;
    }

    public Double getDue(){
        return Double.parseDouble(this.due.replace("$"," "));
    }

    public String getFullName(){
        return String.format("%s %s", lastName, firstName);
    }


}
