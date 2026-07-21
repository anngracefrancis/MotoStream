package kotlin.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.w.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: AbstractIterator.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH$J\b\u0010\n\u001a\u00020\tH\u0004J\t\u0010\u000b\u001a\u00020\fH\u0096\u0002J\u000e\u0010\r\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lkotlin/collections/AbstractIterator;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "nextValue", "Ljava/lang/Object;", "state", "Lkotlin/collections/State;", "computeNext", HttpUrl.FRAGMENT_ENCODE_SET, "done", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "next", "()Ljava/lang/Object;", "setNext", "value", "(Ljava/lang/Object;)V", "tryToComputeNext", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AbstractIterator<T> implements Iterator<T>, KMappedMarker {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private State f25533f = State.NotReady;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private T f25534g;

    /* JADX INFO: renamed from: kotlin.w.b$a */
    /* JADX INFO: compiled from: AbstractIterator.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.Done.ordinal()] = 1;
            iArr[State.Ready.ordinal()] = 2;
            a = iArr;
        }
    }

    private final boolean e() {
        this.f25533f = State.Failed;
        b();
        return this.f25533f == State.Ready;
    }

    protected abstract void b();

    protected final void c() {
        this.f25533f = State.Done;
    }

    protected final void d(T t) {
        this.f25534g = t;
        this.f25533f = State.Ready;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        State state = this.f25533f;
        if (!(state != State.Failed)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i2 = a.a[state.ordinal()];
        if (i2 == 1) {
            return false;
        }
        if (i2 != 2) {
            return e();
        }
        return true;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f25533f = State.NotReady;
        return this.f25534g;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
