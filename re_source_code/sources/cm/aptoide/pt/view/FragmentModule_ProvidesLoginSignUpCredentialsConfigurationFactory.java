package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.LoginSignUpCredentialsConfiguration;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesLoginSignUpCredentialsConfigurationFactory(fragmentModule);
    }

    public static LoginSignUpCredentialsConfiguration providesLoginSignUpCredentialsConfiguration(FragmentModule fragmentModule) {
        return (LoginSignUpCredentialsConfiguration) f.b.b.c(fragmentModule.providesLoginSignUpCredentialsConfiguration());
    }

    @Override // javax.inject.Provider
    public LoginSignUpCredentialsConfiguration get() {
        return providesLoginSignUpCredentialsConfiguration(this.module);
    }
}
