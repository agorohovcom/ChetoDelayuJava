package XML.DOM.ReadAndCreateXMLFile;

import java.util.Date;

public class Post {
    private static int ID = 0;

    private int id;
    private String username;
    private String subject;
    private String forum;
    private Date date;

    public Post(){
        setId(ID++);
    }

    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Post.ID = ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getForum() {
        return forum;
    }

    public void setForum(String forum) {
        this.forum = forum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
