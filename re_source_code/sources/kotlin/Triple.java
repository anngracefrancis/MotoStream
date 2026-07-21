package kotlin;

import java.io.Serializable;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.r, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u00012\u00060\u0004j\u0002`\u0005B\u001d\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002¢\u0006\u0002\u0010\tJ\u000e\u0010\u000f\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000e\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000bJ>\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u001c"}, d2 = {"Lkotlin/Triple;", "A", "B", "C", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "first", "second", "third", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getSecond", "getThird", "component1", "component2", "component3", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Triple;", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class Triple<A, B, C> implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final A f25118f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final B f25119g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final C f25120h;

    public Triple(A a, B b2, C c2) {
        this.f25118f = a;
        this.f25119g = b2;
        this.f25120h = c2;
    }

    public final A a() {
        return this.f25118f;
    }

    public final B b() {
        return this.f25119g;
    }

    public final C c() {
        return this.f25120h;
    }

    public final C d() {
        return this.f25120h;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) other;
        return kotlin.jvm.internal.m.a(this.f25118f, triple.f25118f) && kotlin.jvm.internal.m.a(this.f25119g, triple.f25119g) && kotlin.jvm.internal.m.a(this.f25120h, triple.f25120h);
    }

    public int hashCode() {
        A a = this.f25118f;
        int iHashCode = (a == null ? 0 : a.hashCode()) * 31;
        B b2 = this.f25119g;
        int iHashCode2 = (iHashCode + (b2 == null ? 0 : b2.hashCode())) * 31;
        C c2 = this.f25120h;
        return iHashCode2 + (c2 != null ? c2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f25118f + ", " + this.f25119g + ", " + this.f25120h + ')';
    }
}
