

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface RoleAllowed {
    String value();
}

class SecureService {
    @RoleAllowed("ADMIN")
    public void adminOnlyTask() {
        System.out.println("Admin task executed!");
    }
}

class Main10 {
    public static void main(String[] args) throws Exception {
        String currentUserRole = "USER"; // Change to "ADMIN" to allow
        SecureService service = new SecureService();

        for (Method m : SecureService.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(RoleAllowed.class)) {
                RoleAllowed ra = m.getAnnotation(RoleAllowed.class);
                if (ra.value().equals(currentUserRole)) {
                    m.invoke(service);
                } else {
                    System.out.println("Access Denied!");
                }
            }
        }
    }
}

