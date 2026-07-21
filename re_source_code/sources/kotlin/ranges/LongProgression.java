package kotlin.ranges;

import kotlin.Metadata;
import kotlin.collections.LongIterator;
import kotlin.internal.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e0.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0018B\u001f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0011\u0010\u0007\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lkotlin/ranges/LongProgression;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "start", "endInclusive", "step", "(JJJ)V", "first", "getFirst", "()J", "last", "getLast", "getStep", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "isEmpty", "iterator", "Lkotlin/collections/LongIterator;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class LongProgression implements Iterable<Long>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22981f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f22982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f22983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f22984i;

    /* JADX INFO: renamed from: kotlin.e0.g$a */
    /* JADX INFO: compiled from: Progressions.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/LongProgression$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "fromClosedRange", "Lkotlin/ranges/LongProgression;", "rangeStart", HttpUrl.FRAGMENT_ENCODE_SET, "rangeEnd", "step", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public LongProgression(long j2, long j3, long j4) {
        if (j4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j4 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f22982g = j2;
        this.f22983h = c.d(j2, j3, j4);
        this.f22984i = j4;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final long getF22982g() {
        return this.f22982g;
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final long getF22983h() {
        return this.f22983h;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public LongIterator iterator() {
        return new LongProgressionIterator(this.f22982g, this.f22983h, this.f22984i);
    }
}
