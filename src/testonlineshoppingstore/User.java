package testonlineshoppingstore;

public class User {

    protected int userID;
    protected String userName;
    protected int password;
    protected String email;
    protected char userType;

    // no arg constructor 
    public User() {

    }

    // constructor with arg
    public User(int userID, String userName, int password, String email, char userType) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.userType = userType;
    }

    // constructor with arg
    public User(int userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    // getter method
    public int getUserID() {
        return userID;
    }

    // getter method
    public String getUserName() {
        return userName;
    }

    // getter method
    public int getPassword() {
        return password;
    }

    // getter method
    public String getEmail() {
        return email;
    }

    // getter method
    public char getUserType() {
        return userType;
    }

    // setter method
    public void setUserID(int userID) {
        this.userID = userID;
    }

    // setter method
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // setter method
    public void setPassword(int password) {
        this.password = password;
    }

    // setter method
    public void setEmail(String email) {
        this.email = email;
    }

    // setter method
    public void setUserType(char userType) {
        this.userType = userType;
    }

    // toString method
    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", userName=" + userName + ", password=" + password + ", email=" + email + ", userType=" + userType + '}';
    }

}
