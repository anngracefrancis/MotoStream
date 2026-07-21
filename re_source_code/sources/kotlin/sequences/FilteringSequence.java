package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.g0.e, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", HttpUrl.FRAGMENT_ENCODE_SET, "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FilteringSequence<T> implements Sequence<T> {
    private final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f25024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<T, Boolean> f25025c;

    /* JADX INFO: renamed from: kotlin.g0.e$a */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"kotlin/sequences/FilteringSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", HttpUrl.FRAGMENT_ENCODE_SET, "getNextState", "()I", "setNextState", "(I)V", "calcNext", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25026f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25027g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private T f25028h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ FilteringSequence<T> f25029i;

        a(FilteringSequence<T> filteringSequence) {
            this.f25029i = filteringSequence;
            this.f25026f = ((FilteringSequence) filteringSequence).a.iterator();
        }

        private final void b() {
            while (this.f25026f.hasNext()) {
                T next = this.f25026f.next();
                if (((Boolean) ((FilteringSequence) this.f25029i).f25025c.invoke(next)).booleanValue() == ((FilteringSequence) this.f25029i).f25024b) {
                    this.f25028h = next;
                    this.f25027g = 1;
                    return;
                }
            }
            this.f25027g = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25027g == -1) {
                b();
            }
            return this.f25027g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25027g == -1) {
                b();
            }
            if (this.f25027g == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25028h;
            this.f25028h = null;
            this.f25027g = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FilteringSequence(Sequence<? extends T> sequence, boolean z, Function1<? super T, Boolean> function1) {
        m.f(sequence, "sequence");
        m.f(function1, "predicate");
        this.a = sequence;
        this.f25024b = z;
        this.f25025c = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }
}
