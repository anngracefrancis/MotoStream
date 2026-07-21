package cm.aptoide.pt.app.appsflyer;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AppsFlyerResponse.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcm/aptoide/pt/app/appsflyer/AppsFlyerResponse;", HttpUrl.FRAGMENT_ENCODE_SET, "ok", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;)V", "getOk", "()Ljava/lang/String;", "component1", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class AppsFlyerResponse {
    private final String ok;

    public AppsFlyerResponse(String str) {
        m.f(str, "ok");
        this.ok = str;
    }

    public static /* synthetic */ AppsFlyerResponse copy$default(AppsFlyerResponse appsFlyerResponse, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appsFlyerResponse.ok;
        }
        return appsFlyerResponse.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getOk() {
        return this.ok;
    }

    public final AppsFlyerResponse copy(String ok) {
        m.f(ok, "ok");
        return new AppsFlyerResponse(ok);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof AppsFlyerResponse) && m.a(this.ok, ((AppsFlyerResponse) other).ok);
    }

    public final String getOk() {
        return this.ok;
    }

    public int hashCode() {
        return this.ok.hashCode();
    }

    public String toString() {
        return "AppsFlyerResponse(ok=" + this.ok + ')';
    }
}
