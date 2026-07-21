package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.g0.f, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0096\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FlatteningSequence<T, R, E> implements Sequence<E> {
    private final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<T, R> f25030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Function1<R, Iterator<E>> f25031c;

    /* JADX INFO: renamed from: kotlin.g0.f$a */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0096\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, d2 = {"kotlin/sequences/FlatteningSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<E>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25032f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Iterator<? extends E> f25033g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ FlatteningSequence<T, R, E> f25034h;

        a(FlatteningSequence<T, R, E> flatteningSequence) {
            this.f25034h = flatteningSequence;
            this.f25032f = ((FlatteningSequence) flatteningSequence).a.iterator();
        }

        private final boolean b() {
            Iterator<? extends E> it = this.f25033g;
            if ((it == null || it.hasNext()) ? false : true) {
                this.f25033g = null;
            }
            while (this.f25033g == null) {
                if (!this.f25032f.hasNext()) {
                    return false;
                }
                Iterator<? extends E> it2 = (Iterator) ((FlatteningSequence) this.f25034h).f25031c.invoke(((FlatteningSequence) this.f25034h).f25030b.invoke(this.f25032f.next()));
                if (it2.hasNext()) {
                    this.f25033g = it2;
                    break;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return b();
        }

        @Override // java.util.Iterator
        public E next() {
            if (!b()) {
                throw new NoSuchElementException();
            }
            Iterator<? extends E> it = this.f25033g;
            m.c(it);
            return it.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public FlatteningSequence(Sequence<? extends T> sequence, Function1<? super T, ? extends R> function1, Function1<? super R, ? extends Iterator<? extends E>> function2) {
        m.f(sequence, "sequence");
        m.f(function1, "transformer");
        m.f(function2, "iterator");
        this.a = sequence;
        this.f25030b = function1;
        this.f25031c = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<E> iterator() {
        return new a(this);
    }
}
