package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.store.ManageStoreErrorMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvideManageStoreErrorMapperFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvideManageStoreErrorMapperFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvideManageStoreErrorMapperFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvideManageStoreErrorMapperFactory(fragmentModule);
    }

    public static ManageStoreErrorMapper provideManageStoreErrorMapper(FragmentModule fragmentModule) {
        return (ManageStoreErrorMapper) f.b.b.c(fragmentModule.provideManageStoreErrorMapper());
    }

    @Override // javax.inject.Provider
    public ManageStoreErrorMapper get() {
        return provideManageStoreErrorMapper(this.module);
    }
}
