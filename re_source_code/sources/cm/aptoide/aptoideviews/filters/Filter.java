package cm.aptoide.aptoideviews.filters;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import kotlin.Metadata;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Filter.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\tHÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcm/aptoide/aptoideviews/filters/Filter;", HttpUrl.FRAGMENT_ENCODE_SET, "name", HttpUrl.FRAGMENT_ENCODE_SET, "selected", HttpUrl.FRAGMENT_ENCODE_SET, "identifier", "(Ljava/lang/String;ZLjava/lang/String;)V", DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "getId$aptoide_views_prodRelease", "()I", "setId$aptoide_views_prodRelease", "(I)V", "getIdentifier", "()Ljava/lang/String;", "getName", "getSelected", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Filter {
    private int id;
    private final String identifier;
    private final String name;
    private final boolean selected;

    public Filter() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Filter(String str) {
        this(str, false, null, 6, null);
        m.f(str, "name");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Filter(String str, boolean z) {
        this(str, z, null, 4, null);
        m.f(str, "name");
    }

    public Filter(String str, boolean z, String str2) {
        m.f(str, "name");
        this.name = str;
        this.selected = z;
        this.identifier = str2;
        this.id = -1;
    }

    public static /* synthetic */ Filter copy$default(Filter filter, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = filter.name;
        }
        if ((i2 & 2) != 0) {
            z = filter.selected;
        }
        if ((i2 & 4) != 0) {
            str2 = filter.identifier;
        }
        return filter.copy(str, z, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    public final Filter copy(String name, boolean selected, String identifier) {
        m.f(name, "name");
        return new Filter(name, selected, identifier);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) other;
        return m.a(this.name, filter.name) && this.selected == filter.selected && m.a(this.identifier, filter.identifier);
    }

    /* JADX INFO: renamed from: getId$aptoide_views_prodRelease, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        boolean z = this.selected;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        int i2 = (iHashCode + r1) * 31;
        String str = this.identifier;
        return i2 + (str == null ? 0 : str.hashCode());
    }

    public final void setId$aptoide_views_prodRelease(int i2) {
        this.id = i2;
    }

    public String toString() {
        return "Filter(name=" + this.name + ", selected=" + this.selected + ", identifier=" + this.identifier + ')';
    }

    public /* synthetic */ Filter(String str, boolean z, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? HttpUrl.FRAGMENT_ENCODE_SET : str, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? null : str2);
    }
}
