@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) throws Exception {
        this.username = username;
        for (Field f : this.getClass().getDeclaredFields()) {
            if (f.isAnnotationPresent(MaxLength.class)) {
                int max = f.getAnnotation(MaxLength.class).value();
                String val = (String) f.get(this);
                if (val.length() > max) {
                    throw new IllegalArgumentException("Max length exceeded!");
                }
            }
        }
    }
}

class Main9 {
    public static void main(String[] args) throws Exception {
        User u1 = new User("ShortName");
        System.out.println("User created: " + u1);
    }
}
