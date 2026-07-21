package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.ImagePickerNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideImagePickerNavigatorFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvideImagePickerNavigatorFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvideImagePickerNavigatorFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideImagePickerNavigatorFactory(activityModule);
    }

    public static ImagePickerNavigator provideImagePickerNavigator(ActivityModule activityModule) {
        return (ImagePickerNavigator) f.b.b.c(activityModule.provideImagePickerNavigator());
    }

    @Override // javax.inject.Provider
    public ImagePickerNavigator get() {
        return provideImagePickerNavigator(this.module);
    }
}
