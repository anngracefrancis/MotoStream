package cm.aptoide.pt.util;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ApkfyParameters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcm/aptoide/pt/util/ApkfyParameters;", HttpUrl.FRAGMENT_ENCODE_SET, "appId", HttpUrl.FRAGMENT_ENCODE_SET, DeepLinkIntentReceiver.DeepLinksKeys.OEM_ID_KEY, HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Long;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOemId", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcm/aptoide/pt/util/ApkfyParameters;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class ApkfyParameters {
    private final Long appId;
    private final String oemId;

    public ApkfyParameters(Long l, String str) {
        this.appId = l;
        this.oemId = str;
    }

    public static /* synthetic */ ApkfyParameters copy$default(ApkfyParameters apkfyParameters, Long l, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            l = apkfyParameters.appId;
        }
        if ((i2 & 2) != 0) {
            str = apkfyParameters.oemId;
        }
        return apkfyParameters.copy(l, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Long getAppId() {
        return this.appId;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOemId() {
        return this.oemId;
    }

    public final ApkfyParameters copy(Long appId, String oemId) {
        return new ApkfyParameters(appId, oemId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApkfyParameters)) {
            return false;
        }
        ApkfyParameters apkfyParameters = (ApkfyParameters) other;
        return m.a(this.appId, apkfyParameters.appId) && m.a(this.oemId, apkfyParameters.oemId);
    }

    public final Long getAppId() {
        return this.appId;
    }

    public final String getOemId() {
        return this.oemId;
    }

    public int hashCode() {
        Long l = this.appId;
        int iHashCode = (l == null ? 0 : l.hashCode()) * 31;
        String str = this.oemId;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ApkfyParameters(appId=" + this.appId + ", oemId=" + this.oemId + ')';
    }
}
