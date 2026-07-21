package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.g0.o, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0096\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TakeWhileSequence<T> implements Sequence<T> {
    private final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<T, Boolean> f25046b;

    /* JADX INFO: renamed from: kotlin.g0.o$a */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0096\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"kotlin/sequences/TakeWhileSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", HttpUrl.FRAGMENT_ENCODE_SET, "getNextState", "()I", "setNextState", "(I)V", "calcNext", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25047f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25048g = -1;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private T f25049h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ TakeWhileSequence<T> f25050i;

        a(TakeWhileSequence<T> takeWhileSequence) {
            this.f25050i = takeWhileSequence;
            this.f25047f = ((TakeWhileSequence) takeWhileSequence).a.iterator();
        }

        private final void b() {
            if (this.f25047f.hasNext()) {
                T next = this.f25047f.next();
                if (((Boolean) ((TakeWhileSequence) this.f25050i).f25046b.invoke(next)).booleanValue()) {
                    this.f25048g = 1;
                    this.f25049h = next;
                    return;
                }
            }
            this.f25048g = 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25048g == -1) {
                b();
            }
            return this.f25048g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25048g == -1) {
                b();
            }
            if (this.f25048g == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25049h;
            this.f25049h = null;
            this.f25048g = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TakeWhileSequence(Sequence<? extends T> sequence, Function1<? super T, Boolean> function1) {
        m.f(sequence, "sequence");
        m.f(function1, "predicate");
        this.a = sequence;
        this.f25046b = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }
}
