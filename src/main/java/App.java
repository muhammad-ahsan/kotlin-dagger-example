import javax.inject.Inject;

/**
 * Dagger dependency injection example for Java
 * The {@link App} must be concerned with itself and not creating its dependencies
 * The {@link App} can be tested independently without instantiation of internal
 * dependencies
 * Example of constructor injection
 */
public class App {
    /**
     * Bind to {@link ChildTwo}
     */
    private Parent p1;
    /**
     * Bind to {@link ChildOne}
     */
    private Parent p2;

    @Inject
    public App(Parent p1, Parent p2) {
        this.p1 = p1;
        this.p2 = p2;
        System.out.println("Here is p1".concat(p1.toString()));
        System.out.println("Here is p2".concat(p2.toString()));
    }

    public boolean run() {
        String className = this.getClass().getName();
        System.out.println(className.concat(" is running ..."));
        System.out.println("1st argument is of class: " + p1.getClass());
        System.out.println("2nd argument is of class: " + p2.getClass());
        System.out.println(className.concat(" is finished"));
        return true;
    }

    /**
     * The dependencies of {@link App} are provided by dagger.
     * Simplifies the creation of {@link App}
     *
     * @param args
     */
    public static void main(String[] args) {
        // Use component to create App instance and use it
        App app = DaggerJavaAppComponent.create().getApp();
        app.run();
        System.out.println("Main method is done here");
    }
}
