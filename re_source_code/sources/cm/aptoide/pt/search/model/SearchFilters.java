package cm.aptoide.pt.search.model;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SearchFilters.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcm/aptoide/pt/search/model/SearchFilters;", HttpUrl.FRAGMENT_ENCODE_SET, "onlyFollowedStores", HttpUrl.FRAGMENT_ENCODE_SET, "onlyTrustedApps", "onlyBetaApps", "onlyAppcApps", "(ZZZZ)V", "getOnlyAppcApps", "()Z", "getOnlyBetaApps", "getOnlyFollowedStores", "getOnlyTrustedApps", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class SearchFilters {
    private final boolean onlyAppcApps;
    private final boolean onlyBetaApps;
    private final boolean onlyFollowedStores;
    private final boolean onlyTrustedApps;

    public SearchFilters(boolean z, boolean z2, boolean z3, boolean z4) {
        this.onlyFollowedStores = z;
        this.onlyTrustedApps = z2;
        this.onlyBetaApps = z3;
        this.onlyAppcApps = z4;
    }

    public static /* synthetic */ SearchFilters copy$default(SearchFilters searchFilters, boolean z, boolean z2, boolean z3, boolean z4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = searchFilters.onlyFollowedStores;
        }
        if ((i2 & 2) != 0) {
            z2 = searchFilters.onlyTrustedApps;
        }
        if ((i2 & 4) != 0) {
            z3 = searchFilters.onlyBetaApps;
        }
        if ((i2 & 8) != 0) {
            z4 = searchFilters.onlyAppcApps;
        }
        return searchFilters.copy(z, z2, z3, z4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getOnlyFollowedStores() {
        return this.onlyFollowedStores;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getOnlyTrustedApps() {
        return this.onlyTrustedApps;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getOnlyBetaApps() {
        return this.onlyBetaApps;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final boolean getOnlyAppcApps() {
        return this.onlyAppcApps;
    }

    public final SearchFilters copy(boolean onlyFollowedStores, boolean onlyTrustedApps, boolean onlyBetaApps, boolean onlyAppcApps) {
        return new SearchFilters(onlyFollowedStores, onlyTrustedApps, onlyBetaApps, onlyAppcApps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SearchFilters)) {
            return false;
        }
        SearchFilters searchFilters = (SearchFilters) other;
        return this.onlyFollowedStores == searchFilters.onlyFollowedStores && this.onlyTrustedApps == searchFilters.onlyTrustedApps && this.onlyBetaApps == searchFilters.onlyBetaApps && this.onlyAppcApps == searchFilters.onlyAppcApps;
    }

    public final boolean getOnlyAppcApps() {
        return this.onlyAppcApps;
    }

    public final boolean getOnlyBetaApps() {
        return this.onlyBetaApps;
    }

    public final boolean getOnlyFollowedStores() {
        return this.onlyFollowedStores;
    }

    public final boolean getOnlyTrustedApps() {
        return this.onlyTrustedApps;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public int hashCode() {
        boolean z = this.onlyFollowedStores;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i2 = r0 * 31;
        boolean z2 = this.onlyTrustedApps;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i3 = (i2 + r2) * 31;
        boolean z3 = this.onlyBetaApps;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i4 = (i3 + r3) * 31;
        boolean z4 = this.onlyAppcApps;
        return i4 + (z4 ? 1 : z4);
    }

    public String toString() {
        return "SearchFilters(onlyFollowedStores=" + this.onlyFollowedStores + ", onlyTrustedApps=" + this.onlyTrustedApps + ", onlyBetaApps=" + this.onlyBetaApps + ", onlyAppcApps=" + this.onlyAppcApps + ')';
    }
}
