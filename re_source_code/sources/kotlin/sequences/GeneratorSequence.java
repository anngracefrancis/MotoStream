package kotlin.sequences;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.g0.g, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0096\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/sequences/GeneratorSequence;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class GeneratorSequence<T> implements Sequence<T> {
    private final Function0<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1<T, T> f25035b;

    /* JADX INFO: renamed from: kotlin.g0.g$a */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0096\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, d2 = {"kotlin/sequences/GeneratorSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", HttpUrl.FRAGMENT_ENCODE_SET, "getNextState", "()I", "setNextState", "(I)V", "calcNext", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private T f25036f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25037g = -2;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ GeneratorSequence<T> f25038h;

        a(GeneratorSequence<T> generatorSequence) {
            this.f25038h = generatorSequence;
        }

        private final void b() {
            T t;
            if (this.f25037g == -2) {
                t = (T) ((GeneratorSequence) this.f25038h).a.invoke();
            } else {
                Function1 function1 = ((GeneratorSequence) this.f25038h).f25035b;
                T t2 = this.f25036f;
                m.c(t2);
                t = (T) function1.invoke(t2);
            }
            this.f25036f = t;
            this.f25037g = t == null ? 0 : 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f25037g < 0) {
                b();
            }
            return this.f25037g == 1;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25037g < 0) {
                b();
            }
            if (this.f25037g == 0) {
                throw new NoSuchElementException();
            }
            T t = this.f25036f;
            m.d(t, "null cannot be cast to non-null type T of kotlin.sequences.GeneratorSequence");
            this.f25037g = -1;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GeneratorSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        m.f(function0, "getInitialValue");
        m.f(function1, "getNextValue");
        this.a = function0;
        this.f25035b = function1;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }
}
