package cm.aptoide.pt.app;

import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class AppCoinsAdvertisingManager {
    private final AppCoinsService appCoinsService;

    public AppCoinsAdvertisingManager(AppCoinsService appCoinsService) {
        this.appCoinsService = appCoinsService;
    }

    public Single<AppCoinsAdvertisingModel> getAdvertising(String str, int i2) {
        return this.appCoinsService.getValidCampaign(str, i2);
    }
}
