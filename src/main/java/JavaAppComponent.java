import dagger.Component;
import dagger.Provides;

/**
 * Interface to dagger object graph.
 * Internal dependencies do not need any public interface
 * In large application, multiple component must be used for clarity
 */
@Component(modules = JavaAppModule.class)
public interface JavaAppComponent {
    App getApp();
}
