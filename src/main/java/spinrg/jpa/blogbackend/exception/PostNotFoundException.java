package spinrg.jpa.blogbackend.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String s) {
        super(s);
    }
}
