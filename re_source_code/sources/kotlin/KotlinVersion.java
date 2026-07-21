package kotlin;

import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: KotlinVersion.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u000e\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0016\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u001e\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lkotlin/KotlinVersion;", HttpUrl.FRAGMENT_ENCODE_SET, "major", HttpUrl.FRAGMENT_ENCODE_SET, "minor", "(II)V", "patch", "(III)V", "getMajor", "()I", "getMinor", "getPatch", "version", "compareTo", "other", "equals", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "isAtLeast", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "versionOf", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KotlinVersion implements Comparable<KotlinVersion> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22955f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final KotlinVersion f22956g = KotlinVersionCurrentValue.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22957h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f22958i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int f22959j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f22960k;

    /* JADX INFO: renamed from: kotlin.e$a */
    /* JADX INFO: compiled from: KotlinVersion.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlin/KotlinVersion$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "CURRENT", "Lkotlin/KotlinVersion;", "MAX_COMPONENT_VALUE", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public KotlinVersion(int i2, int i3, int i4) {
        this.f22957h = i2;
        this.f22958i = i3;
        this.f22959j = i4;
        this.f22960k = k(i2, i3, i4);
    }

    private final int k(int i2, int i3, int i4) {
        boolean z = false;
        if (new IntRange(0, 255).o(i2) && new IntRange(0, 255).o(i3) && new IntRange(0, 255).o(i4)) {
            z = true;
        }
        if (z) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        KotlinVersion kotlinVersion = other instanceof KotlinVersion ? (KotlinVersion) other : null;
        return kotlinVersion != null && this.f22960k == kotlinVersion.f22960k;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public int compareTo(KotlinVersion kotlinVersion) {
        kotlin.jvm.internal.m.f(kotlinVersion, "other");
        return this.f22960k - kotlinVersion.f22960k;
    }

    /* JADX INFO: renamed from: hashCode, reason: from getter */
    public int getF22960k() {
        return this.f22960k;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f22957h);
        sb.append('.');
        sb.append(this.f22958i);
        sb.append('.');
        sb.append(this.f22959j);
        return sb.toString();
    }

    public KotlinVersion(int i2, int i3) {
        this(i2, i3, 0);
    }
}
