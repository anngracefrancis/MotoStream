package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.CharIterator;
import kotlin.internal.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e0.a, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\t\u0010\u0015\u001a\u00020\u0016H\u0096\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0011\u0010\b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lkotlin/ranges/CharProgression;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "start", "endInclusive", "step", HttpUrl.FRAGMENT_ENCODE_SET, "(CCI)V", "first", "getFirst", "()C", "last", "getLast", "getStep", "()I", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "isEmpty", "iterator", "Lkotlin/collections/CharIterator;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class CharProgression implements Iterable<Character>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22961f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final char f22962g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final char f22963h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f22964i;

    /* JADX INFO: renamed from: kotlin.e0.a$a */
    /* JADX INFO: compiled from: Progressions.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lkotlin/ranges/CharProgression$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "fromClosedRange", "Lkotlin/ranges/CharProgression;", "rangeStart", HttpUrl.FRAGMENT_ENCODE_SET, "rangeEnd", "step", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public CharProgression(char c2, char c3, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i2 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f22962g = c2;
        this.f22963h = (char) c.c(c2, c3, i2);
        this.f22964i = i2;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final char getF22962g() {
        return this.f22962g;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final char getF22963h() {
        return this.f22963h;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public CharIterator iterator() {
        return new CharProgressionIterator(this.f22962g, this.f22963h, this.f22964i);
    }
}
