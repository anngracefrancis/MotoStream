package e.e.a;

import com.google.android.gms.ads.AdSize;

/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public final class c {
    public static final c a = new c(-1, -2, "mb");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f20718b = new c(320, 50, "mb");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f20719c = new c(300, 250, "as");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f20720d = new c(468, 60, "as");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f20721e = new c(728, 90, "as");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c f20722f = new c(160, 600, "as");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final AdSize f20723g;

    public c(AdSize adSize) {
        this.f20723g = adSize;
    }

    public final int a() {
        return this.f20723g.getHeight();
    }

    public final int b() {
        return this.f20723g.getWidth();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof c) {
            return this.f20723g.equals(((c) obj).f20723g);
        }
        return false;
    }

    public final int hashCode() {
        return this.f20723g.hashCode();
    }

    public final String toString() {
        return this.f20723g.toString();
    }

    private c(int i2, int i3, String str) {
        this(new AdSize(i2, i3));
    }
}
