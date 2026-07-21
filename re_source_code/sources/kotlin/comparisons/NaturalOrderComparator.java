package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.x.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\"\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004¨\u0006\u000b"}, d2 = {"Lkotlin/comparisons/NaturalOrderComparator;", "Ljava/util/Comparator;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/Comparator;", "()V", "compare", HttpUrl.FRAGMENT_ENCODE_SET, "a", "b", "reversed", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class NaturalOrderComparator implements Comparator<Comparable<? super Object>> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NaturalOrderComparator f25595f = new NaturalOrderComparator();

    private NaturalOrderComparator() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable<Object> comparable, Comparable<Object> comparable2) {
        m.f(comparable, "a");
        m.f(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    public final Comparator<Comparable<? super Object>> reversed() {
        return ReverseOrderComparator.f25596f;
    }
}
