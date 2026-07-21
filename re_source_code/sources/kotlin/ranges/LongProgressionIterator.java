package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.LongIterator;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.e0.h, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ProgressionIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\b\u001a\u00020\tH\u0096\u0002J\b\u0010\r\u001a\u00020\u0003H\u0016R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lkotlin/ranges/LongProgressionIterator;", "Lkotlin/collections/LongIterator;", "first", HttpUrl.FRAGMENT_ENCODE_SET, "last", "step", "(JJJ)V", "finalElement", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "getStep", "()J", "nextLong", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LongProgressionIterator extends LongIterator {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final long f22985f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f22986g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f22987h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f22988i;

    public LongProgressionIterator(long j2, long j3, long j4) {
        this.f22985f = j4;
        this.f22986g = j3;
        boolean z = true;
        if (j4 <= 0 ? j2 < j3 : j2 > j3) {
            z = false;
        }
        this.f22987h = z;
        this.f22988i = z ? j2 : j3;
    }

    @Override // kotlin.collections.LongIterator
    public long b() {
        long j2 = this.f22988i;
        if (j2 != this.f22986g) {
            this.f22988i = this.f22985f + j2;
        } else {
            if (!this.f22987h) {
                throw new NoSuchElementException();
            }
            this.f22987h = false;
        }
        return j2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f22987h;
    }
}
