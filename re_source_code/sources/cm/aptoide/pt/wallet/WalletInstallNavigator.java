package cm.aptoide.pt.wallet;

import cm.aptoide.pt.navigator.FragmentNavigator;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: WalletInstallNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcm/aptoide/pt/wallet/WalletInstallNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "fragmentNavigator", "Lcm/aptoide/pt/navigator/FragmentNavigator;", "(Lcm/aptoide/pt/navigator/FragmentNavigator;)V", "getFragmentNavigator", "()Lcm/aptoide/pt/navigator/FragmentNavigator;", "navigateToWalletInstallView", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletInstallNavigator {
    private final FragmentNavigator fragmentNavigator;

    public WalletInstallNavigator(FragmentNavigator fragmentNavigator) {
        kotlin.jvm.internal.m.f(fragmentNavigator, "fragmentNavigator");
        this.fragmentNavigator = fragmentNavigator;
    }

    public final FragmentNavigator getFragmentNavigator() {
        return this.fragmentNavigator;
    }

    public final void navigateToWalletInstallView() {
    }
}
