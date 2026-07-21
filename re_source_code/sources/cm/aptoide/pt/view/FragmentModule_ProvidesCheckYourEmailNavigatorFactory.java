package cm.aptoide.pt.view;

import cm.aptoide.pt.account.view.magiclink.CheckYourEmailNavigator;
import javax.inject.Provider;

/* JADX INFO: loaded from: classes.dex */
public final class FragmentModule_ProvidesCheckYourEmailNavigatorFactory implements Provider {
    private final FragmentModule module;

    public FragmentModule_ProvidesCheckYourEmailNavigatorFactory(FragmentModule fragmentModule) {
        this.module = fragmentModule;
    }

    public static FragmentModule_ProvidesCheckYourEmailNavigatorFactory create(FragmentModule fragmentModule) {
        return new FragmentModule_ProvidesCheckYourEmailNavigatorFactory(fragmentModule);
    }

    public static CheckYourEmailNavigator providesCheckYourEmailNavigator(FragmentModule fragmentModule) {
        return (CheckYourEmailNavigator) f.b.b.c(fragmentModule.providesCheckYourEmailNavigator());
    }

    @Override // javax.inject.Provider
    public CheckYourEmailNavigator get() {
        return providesCheckYourEmailNavigator(this.module);
    }
}
