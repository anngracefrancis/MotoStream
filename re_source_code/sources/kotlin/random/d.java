package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0007\u001a\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\fH\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0000\u001a\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u000f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\u0012\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0013H\u0007\u001a\u0014\u0010\u0014\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0000¨\u0006\u0016"}, d2 = {"Random", "Lkotlin/random/Random;", "seed", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "boundsErrorMessage", HttpUrl.FRAGMENT_ENCODE_SET, "from", HttpUrl.FRAGMENT_ENCODE_SET, "until", "checkRangeBounds", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "fastLog2", "value", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "takeUpperBits", "bitCount", "kotlin-stdlib"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class d {
    public static final String a(Object obj, Object obj2) {
        m.f(obj, "from");
        m.f(obj2, "until");
        return "Random range is empty: [" + obj + ", " + obj2 + ").";
    }

    public static final void b(int i2, int i3) {
        if (!(i3 > i2)) {
            throw new IllegalArgumentException(a(Integer.valueOf(i2), Integer.valueOf(i3)).toString());
        }
    }

    public static final int c(int i2) {
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static final int d(Random random, IntRange intRange) {
        m.f(random, "<this>");
        m.f(intRange, "range");
        if (!intRange.isEmpty()) {
            if (intRange.getF22973h() < Integer.MAX_VALUE) {
                return random.e(intRange.getF22972g(), intRange.getF22973h() + 1);
            }
            return intRange.getF22972g() > Integer.MIN_VALUE ? random.e(intRange.getF22972g() - 1, intRange.getF22973h()) + 1 : random.c();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + intRange);
    }

    public static final int e(int i2, int i3) {
        return (i2 >>> (32 - i3)) & ((-i3) >> 31);
    }
}
