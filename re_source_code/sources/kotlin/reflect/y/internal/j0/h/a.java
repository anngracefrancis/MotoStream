package kotlin.reflect.y.internal.j0.h;

import kotlin.jvm.internal.g;

/* JADX INFO: compiled from: DescriptorRenderer.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum a {
    NO_ARGUMENTS(false, false, 3, null),
    UNLESS_EMPTY(true, false, 2, null),
    ALWAYS_PARENTHESIZED(true, true);


    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f24245j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final boolean f24246k;

    a(boolean z, boolean z2) {
        this.f24245j = z;
        this.f24246k = z2;
    }

    public final boolean k() {
        return this.f24245j;
    }

    public final boolean q() {
        return this.f24246k;
    }

    /* synthetic */ a(boolean z, boolean z2, int i2, g gVar) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? false : z2);
    }
}
