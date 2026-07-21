package kotlin.collections;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¢\u0006\u0002\b\u0004\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\b\u001a\u001d\u0010\t\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"asReversed", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "asReversedMutable", "reverseElementIndex", HttpUrl.FRAGMENT_ENCODE_SET, "index", "reverseElementIndex$CollectionsKt__ReversedViewsKt", "reversePositionIndex", "reversePositionIndex$CollectionsKt__ReversedViewsKt", "kotlin-stdlib"}, k = 5, mv = {1, 7, 1}, xi = 49, xs = "kotlin/collections/CollectionsKt")
public class a0 extends z {
    public static <T> List<T> F(List<T> list) {
        m.f(list, "<this>");
        return new ReversedList(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G(List<?> list, int i2) {
        if (new IntRange(0, u.l(list)).o(i2)) {
            return u.l(list) - i2;
        }
        throw new IndexOutOfBoundsException("Element index " + i2 + " must be in range [" + new IntRange(0, u.l(list)) + "].");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H(List<?> list, int i2) {
        if (new IntRange(0, list.size()).o(i2)) {
            return list.size() - i2;
        }
        throw new IndexOutOfBoundsException("Position index " + i2 + " must be in range [" + new IntRange(0, list.size()) + "].");
    }
}
