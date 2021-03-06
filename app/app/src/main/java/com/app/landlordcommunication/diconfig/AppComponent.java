package com.app.landlordcommunication.diconfig;

import android.app.Application;

import com.app.landlordcommunication.AndroidApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;


@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class,
        ResidencesListModule.class,
        ResidenceOverviewModule.class,
        HttpModule.class,
        AsyncModule.class,
        ViewsModule.class,
        ServicesModule.class,
        RepositoryModule.class,
        ParserModule.class,
        ResidenceOverviewPresenterModule.class,
        UsersListModule.class,
        UserDetailsModule.class,
        UsersViewsModule.class,
        RealLoginScreenModule.class,
        LoginScreenPresenterModule.class,
        ChatScreenModule.class,
        ChatScreenPresenterModule.class,
        MainMenuModule.class,

})
public interface AppComponent extends AndroidInjector<AndroidApplication> {

    //  TasksRepository getTasksRepository();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
