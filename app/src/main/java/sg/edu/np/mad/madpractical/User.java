package sg.edu.np.mad.madpractical;

public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public User(String Name, String Description, int Id, boolean Followed) {
        name = Name;
        description = Description;
        id = Id;
        followed = Followed;
    }
}
