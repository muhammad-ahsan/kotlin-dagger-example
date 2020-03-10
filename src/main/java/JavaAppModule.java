import dagger.Module;
import dagger.Provides;

/**
 * The place where dagger looks for in order to provide concrete implementation
 * Use the "new" keywords for creation of objects
 */
@Module
public class JavaAppModule {

    @Provides
    Parent provideParent() {
        return new ChildTwo();
    }

    @Provides
    App provideApp(Parent p1, Parent p2) {
        return new App(p1, p2);
    }
}
