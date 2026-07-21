package cm.aptoide.pt.view;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class ActivityModule_ProvideLocalVersionCodeFactory implements Provider {
    private final ActivityModule module;
    private final Provider<String> packageNameProvider;

    public ActivityModule_ProvideLocalVersionCodeFactory(ActivityModule activityModule, Provider<String> provider) {
        this.module = activityModule;
        this.packageNameProvider = provider;
    }

    public static ActivityModule_ProvideLocalVersionCodeFactory create(ActivityModule activityModule, Provider<String> provider) {
        return new ActivityModule_ProvideLocalVersionCodeFactory(activityModule, provider);
    }

    public static int provideLocalVersionCode(ActivityModule activityModule, String str) {
        return activityModule.provideLocalVersionCode(str);
    }

    @Override // javax.inject.Provider
    public Integer get() {
        return Integer.valueOf(provideLocalVersionCode(this.module, this.packageNameProvider.get()));
    }
}
