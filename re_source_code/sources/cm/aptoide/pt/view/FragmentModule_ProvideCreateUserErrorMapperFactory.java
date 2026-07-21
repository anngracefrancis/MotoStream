package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.AccountErrorMapper;
import cm.aptoide.pt.account.view.user.CreateUserErrorMapper;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvideCreateUserErrorMapperFactory implements Provider {
    private final Provider<AccountErrorMapper> accountErrorMapperProvider;
    private final FragmentModule module;

    public FragmentModule_ProvideCreateUserErrorMapperFactory(FragmentModule fragmentModule, Provider<AccountErrorMapper> provider) {
        this.module = fragmentModule;
        this.accountErrorMapperProvider = provider;
    }

    public static FragmentModule_ProvideCreateUserErrorMapperFactory create(FragmentModule fragmentModule, Provider<AccountErrorMapper> provider) {
        return new FragmentModule_ProvideCreateUserErrorMapperFactory(fragmentModule, provider);
    }

    public static CreateUserErrorMapper provideCreateUserErrorMapper(FragmentModule fragmentModule, AccountErrorMapper accountErrorMapper) {
        return (CreateUserErrorMapper) f.b.b.c(fragmentModule.provideCreateUserErrorMapper(accountErrorMapper));
    }

    @Override // javax.inject.Provider
    public CreateUserErrorMapper get() {
        return provideCreateUserErrorMapper(this.module, this.accountErrorMapperProvider.get());
    }
}
