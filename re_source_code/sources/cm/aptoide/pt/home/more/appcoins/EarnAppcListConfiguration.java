package cm.aptoide.pt.home.more.appcoins;

import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: EarnAppcListConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcm/aptoide/pt/home/more/appcoins/EarnAppcListConfiguration;", HttpUrl.FRAGMENT_ENCODE_SET, "title", HttpUrl.FRAGMENT_ENCODE_SET, StoreTabGridRecyclerFragment.BundleCons.TAG, "(Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getTitle", "component1", "component2", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class EarnAppcListConfiguration {
    private final String tag;
    private final String title;

    public EarnAppcListConfiguration(String str, String str2) {
        this.title = str;
        this.tag = str2;
    }

    public static /* synthetic */ EarnAppcListConfiguration copy$default(EarnAppcListConfiguration earnAppcListConfiguration, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = earnAppcListConfiguration.title;
        }
        if ((i2 & 2) != 0) {
            str2 = earnAppcListConfiguration.tag;
        }
        return earnAppcListConfiguration.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTag() {
        return this.tag;
    }

    public final EarnAppcListConfiguration copy(String title, String tag) {
        return new EarnAppcListConfiguration(title, tag);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarnAppcListConfiguration)) {
            return false;
        }
        EarnAppcListConfiguration earnAppcListConfiguration = (EarnAppcListConfiguration) other;
        return kotlin.jvm.internal.m.a(this.title, earnAppcListConfiguration.title) && kotlin.jvm.internal.m.a(this.tag, earnAppcListConfiguration.tag);
    }

    public final String getTag() {
        return this.tag;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.tag;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "EarnAppcListConfiguration(title=" + this.title + ", tag=" + this.tag + ')';
    }
}
