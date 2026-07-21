package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.internal.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e0.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lkotlin/ranges/IntProgression;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "start", "endInclusive", "step", "(III)V", "first", "getFirst", "()I", "last", "getLast", "getStep", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "isEmpty", "iterator", "Lkotlin/collections/IntIterator;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class IntProgression implements Iterable<Integer>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22971f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f22972g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f22973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f22974i;

    /* JADX INFO: renamed from: kotlin.e0.d$a */
    /* JADX INFO: compiled from: Progressions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/IntProgression$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "fromClosedRange", "Lkotlin/ranges/IntProgression;", "rangeStart", HttpUrl.FRAGMENT_ENCODE_SET, "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final IntProgression a(int i2, int i3, int i4) {
            return new IntProgression(i2, i3, i4);
        }
    }

    public IntProgression(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f22972g = i2;
        this.f22973h = c.c(i2, i3, i4);
        this.f22974i = i4;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final int getF22972g() {
        return this.f22972g;
    }

    public boolean equals(Object other) {
        if (other instanceof IntProgression) {
            if (!isEmpty() || !((IntProgression) other).isEmpty()) {
                IntProgression intProgression = (IntProgression) other;
                if (this.f22972g != intProgression.f22972g || this.f22973h != intProgression.f22973h || this.f22974i != intProgression.f22974i) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final int getF22973h() {
        return this.f22973h;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final int getF22974i() {
        return this.f22974i;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f22972g * 31) + this.f22973h) * 31) + this.f22974i;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public IntIterator iterator() {
        return new IntProgressionIterator(this.f22972g, this.f22973h, this.f22974i);
    }

    public boolean isEmpty() {
        if (this.f22974i > 0) {
            if (this.f22972g > this.f22973h) {
                return true;
            }
        } else if (this.f22972g < this.f22973h) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f22974i > 0) {
            sb = new StringBuilder();
            sb.append(this.f22972g);
            sb.append("..");
            sb.append(this.f22973h);
            sb.append(" step ");
            i2 = this.f22974i;
        } else {
            sb = new StringBuilder();
            sb.append(this.f22972g);
            sb.append(" downTo ");
            sb.append(this.f22973h);
            sb.append(" step ");
            i2 = -this.f22974i;
        }
        sb.append(i2);
        return sb.toString();
    }
}
