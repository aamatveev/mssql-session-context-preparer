package xyz.matve.spreparer;

public class UserContext {
    private static final ThreadLocal<Integer> CONTEXT = new ThreadLocal<>();

    public static void setUserId(int userId) {
        CONTEXT.set(userId);
    }

    public static int getUserId() {
        if(CONTEXT.get() != null)
            return CONTEXT.get();
        else
            return 0;
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
