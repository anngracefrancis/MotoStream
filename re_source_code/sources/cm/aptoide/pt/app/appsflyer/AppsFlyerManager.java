package cm.aptoide.pt.app.appsflyer;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: AppsFlyerManager.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/app/appsflyer/AppsFlyerManager;", HttpUrl.FRAGMENT_ENCODE_SET, "appsFlyerRepository", "Lcm/aptoide/pt/app/appsflyer/AppsFlyerRepository;", "(Lcm/aptoide/pt/app/appsflyer/AppsFlyerRepository;)V", "registerImpression", "Lrx/Single;", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AppsFlyerManager {
    private final AppsFlyerRepository appsFlyerRepository;

    public AppsFlyerManager(AppsFlyerRepository appsFlyerRepository) {
        m.f(appsFlyerRepository, "appsFlyerRepository");
        this.appsFlyerRepository = appsFlyerRepository;
    }

    public final Single<Boolean> registerImpression() {
        return this.appsFlyerRepository.registerImpression();
    }
}
