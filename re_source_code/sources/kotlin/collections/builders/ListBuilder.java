package kotlin.collections.builders;

import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArrayDeque;
import kotlin.collections.j;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableList;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.w.z0.b, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010)\n\u0002\b\u0002\n\u0002\u0010+\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u00042\b\u0012\u0004\u0012\u0002H\u00010\u00052\u00060\u0006j\u0002`\u0007:\u0001VB\u0007\b\u0016¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bBM\b\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000\u0012\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u001d\u0010\u001b\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010 J\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0016\u0010!\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J&\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010&\u001a\u00020\nH\u0002J\u001d\u0010'\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010 J\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)J\b\u0010*\u001a\u00020\u001eH\u0002J\b\u0010+\u001a\u00020\u001eH\u0016J\u0014\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u0006\u0012\u0002\b\u00030)H\u0002J\u0010\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020\nH\u0002J\u0013\u00101\u001a\u00020\u00112\b\u0010-\u001a\u0004\u0018\u000102H\u0096\u0002J\u0016\u00103\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0096\u0002¢\u0006\u0002\u00104J\b\u00105\u001a\u00020\nH\u0016J\u0015\u00106\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\nH\u0002J\b\u00109\u001a\u00020\u0011H\u0016J\u000f\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;H\u0096\u0002J\u0015\u0010<\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u00107J\u000e\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0016J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000>2\u0006\u0010\u001f\u001a\u00020\nH\u0016J\u0015\u0010?\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001dJ\u0016\u0010@\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J\u0015\u0010A\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\nH\u0016¢\u0006\u0002\u00104J\u0015\u0010B\u001a\u00028\u00002\u0006\u0010%\u001a\u00020\nH\u0002¢\u0006\u0002\u00104J\u0018\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\nH\u0002J\u0016\u0010F\u001a\u00020\u00112\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0016J.\u0010G\u001a\u00020\n2\u0006\u0010D\u001a\u00020\n2\u0006\u0010E\u001a\u00020\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#2\u0006\u0010H\u001a\u00020\u0011H\u0002J\u001e\u0010I\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010JJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010L\u001a\u00020\n2\u0006\u0010M\u001a\u00020\nH\u0016J\u0015\u0010N\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001020\rH\u0016¢\u0006\u0002\u0010OJ'\u0010N\u001a\b\u0012\u0004\u0012\u0002HP0\r\"\u0004\b\u0001\u0010P2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0\rH\u0016¢\u0006\u0002\u0010RJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u000202H\u0002R\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015R\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006W"}, d2 = {"Lkotlin/collections/builders/ListBuilder;", "E", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "Lkotlin/collections/AbstractMutableList;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "array", HttpUrl.FRAGMENT_ENCODE_SET, "offset", "length", "isReadOnly", HttpUrl.FRAGMENT_ENCODE_SET, "backing", "root", "([Ljava/lang/Object;IIZLkotlin/collections/builders/ListBuilder;Lkotlin/collections/builders/ListBuilder;)V", "[Ljava/lang/Object;", "isEffectivelyReadOnly", "()Z", "size", "getSize", "()I", "add", "element", "(Ljava/lang/Object;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "index", "(ILjava/lang/Object;)V", "addAll", "elements", HttpUrl.FRAGMENT_ENCODE_SET, "addAllInternal", "i", "n", "addAtInternal", "build", HttpUrl.FRAGMENT_ENCODE_SET, "checkIsMutable", "clear", "contentEquals", "other", "ensureCapacity", "minCapacity", "ensureExtraCapacity", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "get", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "insertAtInternal", "isEmpty", "iterator", HttpUrl.FRAGMENT_ENCODE_SET, "lastIndexOf", "listIterator", HttpUrl.FRAGMENT_ENCODE_SET, "remove", "removeAll", "removeAt", "removeAtInternal", "removeRangeInternal", "rangeOffset", "rangeLength", "retainAll", "retainOrRemoveAllInternal", "retain", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "fromIndex", "toIndex", "toArray", "()[Ljava/lang/Object;", "T", "destination", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "writeReplace", "Itr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ListBuilder<E> extends AbstractMutableList<E> implements List<E>, RandomAccess, Serializable, KMutableList {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private E[] f25566f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f25567g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f25568h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f25569i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final ListBuilder<E> f25570j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ListBuilder<E> f25571k;

    /* JADX INFO: renamed from: kotlin.w.z0.b$a */
    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\b\u0016\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fJ\t\u0010\r\u001a\u00020\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u000e\u0010\u0010\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\r\u0010\u0013\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u0011J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\u0015\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lkotlin/collections/builders/ListBuilder$Itr;", "E", HttpUrl.FRAGMENT_ENCODE_SET, "list", "Lkotlin/collections/builders/ListBuilder;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/collections/builders/ListBuilder;I)V", "lastIndex", "add", HttpUrl.FRAGMENT_ENCODE_SET, "element", "(Ljava/lang/Object;)V", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "hasPrevious", "next", "()Ljava/lang/Object;", "nextIndex", "previous", "previousIndex", "remove", "set", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a<E> implements ListIterator<E>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final ListBuilder<E> f25572f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25573g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f25574h;

        public a(ListBuilder<E> listBuilder, int i2) {
            m.f(listBuilder, "list");
            this.f25572f = listBuilder;
            this.f25573g = i2;
            this.f25574h = -1;
        }

        @Override // java.util.ListIterator
        public void add(E element) {
            ListBuilder<E> listBuilder = this.f25572f;
            int i2 = this.f25573g;
            this.f25573g = i2 + 1;
            listBuilder.add(i2, element);
            this.f25574h = -1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f25573g < ((ListBuilder) this.f25572f).f25568h;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f25573g > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            if (this.f25573g >= ((ListBuilder) this.f25572f).f25568h) {
                throw new NoSuchElementException();
            }
            int i2 = this.f25573g;
            this.f25573g = i2 + 1;
            this.f25574h = i2;
            return (E) ((ListBuilder) this.f25572f).f25566f[((ListBuilder) this.f25572f).f25567g + this.f25574h];
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f25573g;
        }

        @Override // java.util.ListIterator
        public E previous() {
            int i2 = this.f25573g;
            if (i2 <= 0) {
                throw new NoSuchElementException();
            }
            int i3 = i2 - 1;
            this.f25573g = i3;
            this.f25574h = i3;
            return (E) ((ListBuilder) this.f25572f).f25566f[((ListBuilder) this.f25572f).f25567g + this.f25574h];
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f25573g - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i2 = this.f25574h;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before removing element from the iterator.".toString());
            }
            this.f25572f.remove(i2);
            this.f25573g = this.f25574h;
            this.f25574h = -1;
        }

        @Override // java.util.ListIterator
        public void set(E element) {
            int i2 = this.f25574h;
            if (!(i2 != -1)) {
                throw new IllegalStateException("Call next() or previous() before replacing element from the iterator.".toString());
            }
            this.f25572f.set(i2, element);
        }
    }

    private ListBuilder(E[] eArr, int i2, int i3, boolean z, ListBuilder<E> listBuilder, ListBuilder<E> listBuilder2) {
        this.f25566f = eArr;
        this.f25567g = i2;
        this.f25568h = i3;
        this.f25569i = z;
        this.f25570j = listBuilder;
        this.f25571k = listBuilder2;
    }

    private final int A(int i2, int i3, Collection<? extends E> collection, boolean z) {
        ListBuilder<E> listBuilder = this.f25570j;
        if (listBuilder != null) {
            int iA = listBuilder.A(i2, i3, collection, z);
            this.f25568h -= iA;
            return iA;
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < i3) {
            int i6 = i2 + i4;
            if (collection.contains(this.f25566f[i6]) == z) {
                E[] eArr = this.f25566f;
                i4++;
                eArr[i5 + i2] = eArr[i6];
                i5++;
            } else {
                i4++;
            }
        }
        int i7 = i3 - i5;
        E[] eArr2 = this.f25566f;
        j.e(eArr2, eArr2, i2 + i5, i3 + i2, this.f25568h);
        E[] eArr3 = this.f25566f;
        int i8 = this.f25568h;
        c.g(eArr3, i8 - i7, i8);
        this.f25568h -= i7;
        return i7;
    }

    private final void o(int i2, Collection<? extends E> collection, int i3) {
        ListBuilder<E> listBuilder = this.f25570j;
        if (listBuilder != null) {
            listBuilder.o(i2, collection, i3);
            this.f25566f = this.f25570j.f25566f;
            this.f25568h += i3;
        } else {
            w(i2, i3);
            Iterator<? extends E> it = collection.iterator();
            for (int i4 = 0; i4 < i3; i4++) {
                this.f25566f[i2 + i4] = it.next();
            }
        }
    }

    private final void q(int i2, E e2) {
        ListBuilder<E> listBuilder = this.f25570j;
        if (listBuilder == null) {
            w(i2, 1);
            this.f25566f[i2] = e2;
        } else {
            listBuilder.q(i2, e2);
            this.f25566f = this.f25570j.f25566f;
            this.f25568h++;
        }
    }

    private final void s() {
        if (x()) {
            throw new UnsupportedOperationException();
        }
    }

    private final boolean t(List<?> list) {
        return c.h(this.f25566f, this.f25567g, this.f25568h, list);
    }

    private final void u(int i2) {
        if (this.f25570j != null) {
            throw new IllegalStateException();
        }
        if (i2 < 0) {
            throw new OutOfMemoryError();
        }
        E[] eArr = this.f25566f;
        if (i2 > eArr.length) {
            this.f25566f = (E[]) c.e(this.f25566f, ArrayDeque.f25551f.a(eArr.length, i2));
        }
    }

    private final void v(int i2) {
        u(this.f25568h + i2);
    }

    private final void w(int i2, int i3) {
        v(i3);
        E[] eArr = this.f25566f;
        j.e(eArr, eArr, i2 + i3, i2, this.f25567g + this.f25568h);
        this.f25568h += i3;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (x()) {
            return new SerializedCollection(this, 0);
        }
        throw new NotSerializableException("The list cannot be serialized while it is being built.");
    }

    private final boolean x() {
        ListBuilder<E> listBuilder;
        return this.f25569i || ((listBuilder = this.f25571k) != null && listBuilder.f25569i);
    }

    private final E y(int i2) {
        ListBuilder<E> listBuilder = this.f25570j;
        if (listBuilder != null) {
            E eY = listBuilder.y(i2);
            this.f25568h--;
            return eY;
        }
        E[] eArr = this.f25566f;
        E e2 = eArr[i2];
        j.e(eArr, eArr, i2, i2 + 1, this.f25567g + this.f25568h);
        c.f(this.f25566f, (this.f25567g + this.f25568h) - 1);
        this.f25568h--;
        return e2;
    }

    private final void z(int i2, int i3) {
        ListBuilder<E> listBuilder = this.f25570j;
        if (listBuilder != null) {
            listBuilder.z(i2, i3);
        } else {
            E[] eArr = this.f25566f;
            j.e(eArr, eArr, i2, i2 + i3, this.f25568h);
            E[] eArr2 = this.f25566f;
            int i4 = this.f25568h;
            c.g(eArr2, i4 - i3, i4);
        }
        this.f25568h -= i3;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E element) {
        s();
        q(this.f25567g + this.f25568h, element);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> elements) {
        m.f(elements, "elements");
        s();
        int size = elements.size();
        o(this.f25567g + this.f25568h, elements, size);
        return size > 0;
    }

    @Override // kotlin.collections.AbstractMutableList
    /* JADX INFO: renamed from: c, reason: from getter */
    public int getF25568h() {
        return this.f25568h;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        s();
        z(this.f25567g, this.f25568h);
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object other) {
        return other == this || ((other instanceof List) && t((List) other));
    }

    @Override // kotlin.collections.AbstractMutableList
    public E f(int i2) {
        s();
        AbstractList.f25535f.a(i2, this.f25568h);
        return y(this.f25567g + i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int index) {
        AbstractList.f25535f.a(index, this.f25568h);
        return this.f25566f[this.f25567g + index];
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        return c.i(this.f25566f, this.f25567g, this.f25568h);
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object element) {
        for (int i2 = 0; i2 < this.f25568h; i2++) {
            if (m.a(this.f25566f[this.f25567g + i2], element)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean isEmpty() {
        return this.f25568h == 0;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new a(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public int lastIndexOf(Object element) {
        for (int i2 = this.f25568h - 1; i2 >= 0; i2--) {
            if (m.a(this.f25566f[this.f25567g + i2], element)) {
                return i2;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return new a(this, 0);
    }

    public final List<E> r() {
        if (this.f25570j != null) {
            throw new IllegalStateException();
        }
        s();
        this.f25569i = true;
        return this;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object element) {
        s();
        int iIndexOf = indexOf(element);
        if (iIndexOf >= 0) {
            remove(iIndexOf);
        }
        return iIndexOf >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<? extends Object> elements) {
        m.f(elements, "elements");
        s();
        return A(this.f25567g, this.f25568h, elements, false) > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<? extends Object> elements) {
        m.f(elements, "elements");
        s();
        return A(this.f25567g, this.f25568h, elements, true) > 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int index, E element) {
        s();
        AbstractList.f25535f.a(index, this.f25568h);
        E[] eArr = this.f25566f;
        int i2 = this.f25567g;
        E e2 = eArr[i2 + index];
        eArr[i2 + index] = element;
        return e2;
    }

    @Override // java.util.AbstractList, java.util.List
    public List<E> subList(int fromIndex, int toIndex) {
        AbstractList.f25535f.c(fromIndex, toIndex, this.f25568h);
        E[] eArr = this.f25566f;
        int i2 = this.f25567g + fromIndex;
        int i3 = toIndex - fromIndex;
        boolean z = this.f25569i;
        ListBuilder<E> listBuilder = this.f25571k;
        return new ListBuilder(eArr, i2, i3, z, this, listBuilder == null ? this : listBuilder);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] destination) {
        m.f(destination, "destination");
        int length = destination.length;
        int i2 = this.f25568h;
        if (length < i2) {
            E[] eArr = this.f25566f;
            int i3 = this.f25567g;
            T[] tArr = (T[]) Arrays.copyOfRange(eArr, i3, i2 + i3, destination.getClass());
            m.e(tArr, "copyOfRange(array, offse…h, destination.javaClass)");
            return tArr;
        }
        E[] eArr2 = this.f25566f;
        m.d(eArr2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.builders.ListBuilder.toArray>");
        int i4 = this.f25567g;
        j.e(eArr2, destination, 0, i4, this.f25568h + i4);
        int length2 = destination.length;
        int i5 = this.f25568h;
        if (length2 > i5) {
            destination[i5] = null;
        }
        return destination;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return c.j(this.f25566f, this.f25567g, this.f25568h);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int index) {
        AbstractList.f25535f.b(index, this.f25568h);
        return new a(this, index);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int index, E element) {
        s();
        AbstractList.f25535f.b(index, this.f25568h);
        q(this.f25567g + index, element);
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int index, Collection<? extends E> elements) {
        m.f(elements, "elements");
        s();
        AbstractList.f25535f.b(index, this.f25568h);
        int size = elements.size();
        o(this.f25567g + index, elements, size);
        return size > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        E[] eArr = this.f25566f;
        int i2 = this.f25567g;
        Object[] objArrI = j.i(eArr, i2, this.f25568h + i2);
        m.d(objArrI, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return objArrI;
    }

    public ListBuilder() {
        this(10);
    }

    public ListBuilder(int i2) {
        this(c.d(i2), 0, 0, false, null, null);
    }
}
