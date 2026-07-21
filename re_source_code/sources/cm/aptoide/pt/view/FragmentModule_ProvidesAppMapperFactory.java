package cm.aptoide.pt.view;

import cm.aptoide.pt.home.apps.AppMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesAppMapperFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesAppMapperFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesAppMapperFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesAppMapperFactory(fragmentModule);
    }

    public static AppMapper providesAppMapper(FragmentModule fragmentModule) {
        return (AppMapper) f.b.b.c(fragmentModule.providesAppMapper());
    }

    @Override // javax.inject.Provider
    public AppMapper get() {
        return providesAppMapper(this.module);
    }
}
