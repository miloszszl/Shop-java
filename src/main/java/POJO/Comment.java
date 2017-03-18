package POJO;

import java.security.Timestamp;

/**
 * Created by Miłosz on 18.03.2017.
 */
public class Comment {

    private CommentId idComment;
    private Timestamp datetime;
    private String description;

    public Comment(){}

    public Comment(CommentId idComment, Timestamp datetime, String description) {
        this.idComment = idComment;
        this.datetime = datetime;
        this.description = description;
    }

    public CommentId getIdComment() {
        return idComment;
    }

    public void setIdComment(CommentId idComment) {
        this.idComment = idComment;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
