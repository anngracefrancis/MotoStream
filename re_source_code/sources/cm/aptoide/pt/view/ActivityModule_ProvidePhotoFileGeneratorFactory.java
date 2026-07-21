package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.PhotoFileGenerator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvidePhotoFileGeneratorFactory implements Provider {
    private final ActivityModule module;

    public ActivityModule_ProvidePhotoFileGeneratorFactory(ActivityModule activityModule) {
        this.module = activityModule;
    }

    public static ActivityModule_ProvidePhotoFileGeneratorFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidePhotoFileGeneratorFactory(activityModule);
    }

    public static PhotoFileGenerator providePhotoFileGenerator(ActivityModule activityModule) {
        return (PhotoFileGenerator) f.b.b.c(activityModule.providePhotoFileGenerator());
    }

    @Override // javax.inject.Provider
    public PhotoFileGenerator get() {
        return providePhotoFileGenerator(this.module);
    }
}
