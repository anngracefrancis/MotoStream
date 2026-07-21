package cm.aptoide.pt.view;

import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppViewConfigurationFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesAppViewConfigurationFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesAppViewConfigurationFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesAppViewConfigurationFactory(fragmentModule);
    }

    public static AppViewConfiguration providesAppViewConfiguration(FragmentModule fragmentModule) {
        return (AppViewConfiguration) f.b.b.c(fragmentModule.providesAppViewConfiguration());
    }

    @Override // javax.inject.Provider
    public AppViewConfiguration get() {
        return providesAppViewConfiguration(this.module);
    }
}
