package cm.aptoide.pt.app;

import cm.aptoide.pt.dataprovider.ws.v2.GenericResponseV2;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class FlagManager {
    private final FlagService flagService;

    public FlagManager(FlagService flagService) {
        this.flagService = flagService;
    }

    public Single<GenericResponseV2> flagApk(String str, String str2, String str3) {
        return this.flagService.doApkFlagRequest(str, str2, str3);
    }
}
