package kotlin.sequences;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.g0.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0096\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "take", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DropSequence<T> implements Sequence<T>, DropTakeSequence<T> {
    private final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25021b;

    /* JADX INFO: renamed from: kotlin.g0.b$a */
    /* JADX INFO: compiled from: Sequences.kt */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"kotlin/sequences/DropSequence$iterator$1", HttpUrl.FRAGMENT_ENCODE_SET, "iterator", "getIterator", "()Ljava/util/Iterator;", "left", HttpUrl.FRAGMENT_ENCODE_SET, "getLeft", "()I", "setLeft", "(I)V", "drop", HttpUrl.FRAGMENT_ENCODE_SET, "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Iterator<T>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25022f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25023g;

        a(DropSequence<T> dropSequence) {
            this.f25022f = ((DropSequence) dropSequence).a.iterator();
            this.f25023g = ((DropSequence) dropSequence).f25021b;
        }

        private final void b() {
            while (this.f25023g > 0 && this.f25022f.hasNext()) {
                this.f25022f.next();
                this.f25023g--;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            return this.f25022f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            b();
            return this.f25022f.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DropSequence(Sequence<? extends T> sequence, int i2) {
        m.f(sequence, "sequence");
        this.a = sequence;
        this.f25021b = i2;
        if (i2 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i2 + '.').toString());
    }

    @Override // kotlin.sequences.DropTakeSequence
    public Sequence<T> a(int i2) {
        int i3 = this.f25021b + i2;
        return i3 < 0 ? new DropSequence(this, i2) : new DropSequence(this.a, i3);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new a(this);
    }
}
