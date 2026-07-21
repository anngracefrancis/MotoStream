package cm.aptoide.pt.app.mmpcampaigns;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Campaign.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcm/aptoide/pt/app/mmpcampaigns/CampaignUrl;", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "url", "(Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class CampaignUrl {
    private final String name;
    private final String url;

    public CampaignUrl(String str, String str2) {
        m.f(str, "name");
        m.f(str2, "url");
        this.name = str;
        this.url = str2;
    }

    public static /* synthetic */ CampaignUrl copy$default(CampaignUrl campaignUrl, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = campaignUrl.name;
        }
        if ((i2 & 2) != 0) {
            str2 = campaignUrl.url;
        }
        return campaignUrl.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    public final CampaignUrl copy(String name, String url) {
        m.f(name, "name");
        m.f(url, "url");
        return new CampaignUrl(name, url);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CampaignUrl)) {
            return false;
        }
        CampaignUrl campaignUrl = (CampaignUrl) other;
        return m.a(this.name, campaignUrl.name) && m.a(this.url, campaignUrl.url);
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.url.hashCode();
    }

    public String toString() {
        return "CampaignUrl(name=" + this.name + ", url=" + this.url + ')';
    }
}
