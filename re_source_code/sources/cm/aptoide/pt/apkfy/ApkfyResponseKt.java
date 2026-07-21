package cm.aptoide.pt.apkfy;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: ApkfyResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"mapToApkfyModel", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "Lcm/aptoide/pt/apkfy/ApkfyResponse;", "app_vanillaProdRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApkfyResponseKt {
    public static final ApkfyModel mapToApkfyModel(ApkfyResponse apkfyResponse) {
        m.f(apkfyResponse, "<this>");
        return new ApkfyModel(apkfyResponse.getPackageName(), apkfyResponse.getAppId(), apkfyResponse.getOemid(), apkfyResponse.getGuestUId(), apkfyResponse.getUtmSource(), apkfyResponse.getUtmMedium(), apkfyResponse.getUtmCampaign(), apkfyResponse.getUtmTerm(), apkfyResponse.getUtmContent());
    }
}
