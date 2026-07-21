package cm.aptoide.pt;

import cm.aptoide.pt.navigator.ExternalNavigator;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: CatappultNavigator.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcm/aptoide/pt/CatappultNavigator;", HttpUrl.FRAGMENT_ENCODE_SET, "externalNavigator", "Lcm/aptoide/pt/navigator/ExternalNavigator;", "(Lcm/aptoide/pt/navigator/ExternalNavigator;)V", "navigateToCatappultWebsite", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CatappultNavigator {
    private final ExternalNavigator externalNavigator;

    public CatappultNavigator(ExternalNavigator externalNavigator) {
        kotlin.jvm.internal.m.f(externalNavigator, "externalNavigator");
        this.externalNavigator = externalNavigator;
    }

    public final void navigateToCatappultWebsite() {
        this.externalNavigator.navigateToExternalWebsite("https://catappult.io/?utm_source=vanilla");
    }
}
