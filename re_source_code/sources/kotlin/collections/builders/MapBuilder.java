package kotlin.collections.builders;

import cm.aptoide.pt.database.room.RoomNotification;
import java.io.NotSerializableException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.w.z0.d, reason: from Kotlin metadata */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 {*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u00060\u0004j\u0002`\u0005:\u0007{|}~\u007f\u0080\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tBE\b\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b\u0012\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u0017\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\b4\u00105J\u0013\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002¢\u0006\u0002\u00107J\u0012\u00108\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109J\r\u0010:\u001a\u00020;H\u0000¢\u0006\u0002\b<J\b\u0010=\u001a\u00020;H\u0016J\b\u0010>\u001a\u00020;H\u0002J\u0019\u0010?\u001a\u00020!2\n\u0010@\u001a\u0006\u0012\u0002\b\u00030AH\u0000¢\u0006\u0002\bBJ!\u0010C\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bFJ\u0015\u0010G\u001a\u00020!2\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00020!2\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010HJ\u0018\u0010K\u001a\u00020!2\u000e\u0010L\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u000309H\u0002J\u0010\u0010M\u001a\u00020;2\u0006\u0010\u0013\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020;2\u0006\u0010O\u001a\u00020\bH\u0002J\u0019\u0010P\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010QH\u0000¢\u0006\u0002\bRJ\u0013\u0010S\u001a\u00020!2\b\u0010L\u001a\u0004\u0018\u00010TH\u0096\u0002J\u0015\u0010U\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\u0015\u0010V\u001a\u00020\b2\u0006\u0010J\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00105J\u0018\u0010W\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010XJ\u0015\u0010Y\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\b\u0010Z\u001a\u00020\bH\u0016J\b\u0010[\u001a\u00020!H\u0016J\u0019\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010]H\u0000¢\u0006\u0002\b^J\u001f\u0010_\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010`J\u001e\u0010a\u001a\u00020;2\u0014\u0010b\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000109H\u0016J\"\u0010c\u001a\u00020!2\u0018\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010E0AH\u0002J\u001c\u0010d\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0002J\u0010\u0010e\u001a\u00020!2\u0006\u0010f\u001a\u00020\bH\u0002J\u0010\u0010g\u001a\u00020;2\u0006\u0010h\u001a\u00020\bH\u0002J\u0017\u0010i\u001a\u0004\u0018\u00018\u00012\u0006\u00103\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010XJ!\u0010j\u001a\u00020!2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010EH\u0000¢\u0006\u0002\bkJ\u0010\u0010l\u001a\u00020;2\u0006\u0010m\u001a\u00020\bH\u0002J\u0017\u0010n\u001a\u00020\b2\u0006\u00103\u001a\u00028\u0000H\u0000¢\u0006\u0004\bo\u00105J\u0010\u0010p\u001a\u00020;2\u0006\u0010q\u001a\u00020\bH\u0002J\u0017\u0010r\u001a\u00020!2\u0006\u0010s\u001a\u00028\u0001H\u0000¢\u0006\u0004\bt\u0010HJ\b\u0010u\u001a\u00020vH\u0016J\u0019\u0010w\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010xH\u0000¢\u0006\u0002\byJ\b\u0010z\u001a\u00020TH\u0002R\u0014\u0010\u0013\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00180\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001e\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u001e\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020!@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010\u001aR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u0010(\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0015R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00010-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010'R\u0016\u00100\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0081\u0001"}, d2 = {"Lkotlin/collections/builders/MapBuilder;", "K", "V", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "()V", "initialCapacity", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "keysArray", HttpUrl.FRAGMENT_ENCODE_SET, "valuesArray", "presenceArray", HttpUrl.FRAGMENT_ENCODE_SET, "hashArray", "maxProbeDistance", "length", "([Ljava/lang/Object;[Ljava/lang/Object;[I[III)V", "capacity", "getCapacity", "()I", "entries", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "getEntries", "()Ljava/util/Set;", "entriesView", "Lkotlin/collections/builders/MapBuilderEntries;", "hashShift", "hashSize", "getHashSize", "<set-?>", HttpUrl.FRAGMENT_ENCODE_SET, "isReadOnly", "isReadOnly$kotlin_stdlib", "()Z", "keys", "getKeys", "[Ljava/lang/Object;", "keysView", "Lkotlin/collections/builders/MapBuilderKeys;", "size", "getSize", "values", HttpUrl.FRAGMENT_ENCODE_SET, "getValues", "()Ljava/util/Collection;", "valuesView", "Lkotlin/collections/builders/MapBuilderValues;", "addKey", RoomNotification.KEY, "addKey$kotlin_stdlib", "(Ljava/lang/Object;)I", "allocateValuesArray", "()[Ljava/lang/Object;", "build", HttpUrl.FRAGMENT_ENCODE_SET, "checkIsMutable", HttpUrl.FRAGMENT_ENCODE_SET, "checkIsMutable$kotlin_stdlib", "clear", "compact", "containsAllEntries", "m", HttpUrl.FRAGMENT_ENCODE_SET, "containsAllEntries$kotlin_stdlib", "containsEntry", "entry", HttpUrl.FRAGMENT_ENCODE_SET, "containsEntry$kotlin_stdlib", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "value", "contentEquals", "other", "ensureCapacity", "ensureExtraCapacity", "n", "entriesIterator", "Lkotlin/collections/builders/MapBuilder$EntriesItr;", "entriesIterator$kotlin_stdlib", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "findKey", "findValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "hash", "hashCode", "isEmpty", "keysIterator", "Lkotlin/collections/builders/MapBuilder$KeysItr;", "keysIterator$kotlin_stdlib", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "putAll", "from", "putAllEntries", "putEntry", "putRehash", "i", "rehash", "newHashSize", "remove", "removeEntry", "removeEntry$kotlin_stdlib", "removeHashAt", "removedHash", "removeKey", "removeKey$kotlin_stdlib", "removeKeyAt", "index", "removeValue", "element", "removeValue$kotlin_stdlib", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "valuesIterator", "Lkotlin/collections/builders/MapBuilder$ValuesItr;", "valuesIterator$kotlin_stdlib", "writeReplace", "Companion", "EntriesItr", "EntryRef", "Itr", "KeysItr", "ValuesItr", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapBuilder<K, V> implements Map<K, V>, Serializable, KMutableMap {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f25575f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private K[] f25576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private V[] f25577h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f25578i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int[] f25579j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f25580k;
    private int l;
    private int m;
    private int n;
    private MapBuilderKeys<K> o;
    private MapBuilderValues<V> p;
    private MapBuilderEntries<K, V> q;
    private boolean r;

    /* JADX INFO: renamed from: kotlin.w.z0.d$a */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "INITIAL_CAPACITY", HttpUrl.FRAGMENT_ENCODE_SET, "INITIAL_MAX_PROBE_DISTANCE", "MAGIC", "TOMBSTONE", "computeHashSize", "capacity", "computeShift", "hashSize", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2) {
            return Integer.highestOneBit(l.b(i2, 1) * 3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int d(int i2) {
            return Integer.numberOfLeadingZeros(i2) + 1;
        }
    }

    /* JADX INFO: renamed from: kotlin.w.z0.d$b */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00050\u0004B\u0019\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0007¢\u0006\u0002\u0010\bJ\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nH\u0096\u0002J\u0012\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u000ej\u0002`\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntriesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "Lkotlin/collections/builders/MapBuilder$EntryRef;", "nextAppendString", HttpUrl.FRAGMENT_ENCODE_SET, "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "nextHashCode", HttpUrl.FRAGMENT_ENCODE_SET, "nextHashCode$kotlin_stdlib", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b<K, V> extends d<K, V> implements Iterator<Map.Entry<K, V>>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            m.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public c<K, V> next() {
            if (getF25584g() >= ((MapBuilder) d()).l) {
                throw new NoSuchElementException();
            }
            int f25584g = getF25584g();
            h(f25584g + 1);
            i(f25584g);
            c<K, V> cVar = new c<>(d(), getF25585h());
            e();
            return cVar;
        }

        public final void k(StringBuilder sb) {
            m.f(sb, "sb");
            if (getF25584g() >= ((MapBuilder) d()).l) {
                throw new NoSuchElementException();
            }
            int f25584g = getF25584g();
            h(f25584g + 1);
            i(f25584g);
            Object obj = ((MapBuilder) d()).f25576g[getF25585h()];
            if (m.a(obj, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = ((MapBuilder) d()).f25577h;
            m.c(objArr);
            Object obj2 = objArr[getF25585h()];
            if (m.a(obj2, d())) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            e();
        }

        public final int m() {
            if (getF25584g() >= ((MapBuilder) d()).l) {
                throw new NoSuchElementException();
            }
            int f25584g = getF25584g();
            h(f25584g + 1);
            i(f25584g);
            Object obj = ((MapBuilder) d()).f25576g[getF25585h()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = ((MapBuilder) d()).f25577h;
            m.c(objArr);
            Object obj2 = objArr[getF25585h()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            e();
            return iHashCode2;
        }
    }

    /* JADX INFO: renamed from: kotlin.w.z0.d$c */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\u0015\u0010\u0013\u001a\u00028\u00032\u0006\u0010\u0014\u001a\u00028\u0003H\u0016¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00028\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00028\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$EntryRef;", "K", "V", HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "index", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/collections/builders/MapBuilder;I)V", RoomNotification.KEY, "getKey", "()Ljava/lang/Object;", "value", "getValue", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", HttpUrl.FRAGMENT_ENCODE_SET, "hashCode", "setValue", "newValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c<K, V> implements Map.Entry<K, V>, KMappedMarker {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MapBuilder<K, V> f25581f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f25582g;

        public c(MapBuilder<K, V> mapBuilder, int i2) {
            m.f(mapBuilder, "map");
            this.f25581f = mapBuilder;
            this.f25582g = i2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object other) {
            if (other instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) other;
                if (m.a(entry.getKey(), getKey()) && m.a(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            return (K) ((MapBuilder) this.f25581f).f25576g[this.f25582g];
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            Object[] objArr = ((MapBuilder) this.f25581f).f25577h;
            m.c(objArr);
            return (V) objArr[this.f25582g];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            K key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            V value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public V setValue(V newValue) {
            this.f25581f.k();
            Object[] objArrI = this.f25581f.i();
            int i2 = this.f25582g;
            V v = (V) objArrI[i2];
            objArrI[i2] = newValue;
            return v;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: kotlin.w.z0.d$d */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010\u0014\u001a\u00020\u0015H\u0000¢\u0006\u0002\b\u0016J\u0006\u0010\u0017\u001a\u00020\u0015R\u001a\u0010\u0007\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lkotlin/collections/builders/MapBuilder$Itr;", "K", "V", HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "index", HttpUrl.FRAGMENT_ENCODE_SET, "getIndex$kotlin_stdlib", "()I", "setIndex$kotlin_stdlib", "(I)V", "lastIndex", "getLastIndex$kotlin_stdlib", "setLastIndex$kotlin_stdlib", "getMap$kotlin_stdlib", "()Lkotlin/collections/builders/MapBuilder;", "hasNext", HttpUrl.FRAGMENT_ENCODE_SET, "initNext", HttpUrl.FRAGMENT_ENCODE_SET, "initNext$kotlin_stdlib", "remove", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class d<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MapBuilder<K, V> f25583f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f25584g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f25585h;

        public d(MapBuilder<K, V> mapBuilder) {
            m.f(mapBuilder, "map");
            this.f25583f = mapBuilder;
            this.f25585h = -1;
            e();
        }

        /* JADX INFO: renamed from: b, reason: from getter */
        public final int getF25584g() {
            return this.f25584g;
        }

        /* JADX INFO: renamed from: c, reason: from getter */
        public final int getF25585h() {
            return this.f25585h;
        }

        public final MapBuilder<K, V> d() {
            return this.f25583f;
        }

        public final void e() {
            while (this.f25584g < ((MapBuilder) this.f25583f).l) {
                int[] iArr = ((MapBuilder) this.f25583f).f25578i;
                int i2 = this.f25584g;
                if (iArr[i2] >= 0) {
                    return;
                } else {
                    this.f25584g = i2 + 1;
                }
            }
        }

        public final void h(int i2) {
            this.f25584g = i2;
        }

        public final boolean hasNext() {
            return this.f25584g < ((MapBuilder) this.f25583f).l;
        }

        public final void i(int i2) {
            this.f25585h = i2;
        }

        public final void remove() {
            if (!(this.f25585h != -1)) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f25583f.k();
            this.f25583f.L(this.f25585h);
            this.f25585h = -1;
        }
    }

    /* JADX INFO: renamed from: kotlin.w.z0.d$e */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0002H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$KeysItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class e<K, V> extends d<K, V> implements Iterator<K>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            m.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public K next() {
            if (getF25584g() >= ((MapBuilder) d()).l) {
                throw new NoSuchElementException();
            }
            int f25584g = getF25584g();
            h(f25584g + 1);
            i(f25584g);
            K k2 = (K) ((MapBuilder) d()).f25576g[getF25585h()];
            e();
            return k2;
        }
    }

    /* JADX INFO: renamed from: kotlin.w.z0.d$f */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010)\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004B\u0019\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\b\u001a\u00028\u0003H\u0096\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/collections/builders/MapBuilder$ValuesItr;", "K", "V", "Lkotlin/collections/builders/MapBuilder$Itr;", HttpUrl.FRAGMENT_ENCODE_SET, "map", "Lkotlin/collections/builders/MapBuilder;", "(Lkotlin/collections/builders/MapBuilder;)V", "next", "()Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class f<K, V> extends d<K, V> implements Iterator<V>, KMappedMarker {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(MapBuilder<K, V> mapBuilder) {
            super(mapBuilder);
            m.f(mapBuilder, "map");
        }

        @Override // java.util.Iterator
        public V next() {
            if (getF25584g() >= ((MapBuilder) d()).l) {
                throw new NoSuchElementException();
            }
            int f25584g = getF25584g();
            h(f25584g + 1);
            i(f25584g);
            Object[] objArr = ((MapBuilder) d()).f25577h;
            m.c(objArr);
            V v = (V) objArr[getF25585h()];
            e();
            return v;
        }
    }

    private MapBuilder(K[] kArr, V[] vArr, int[] iArr, int[] iArr2, int i2, int i3) {
        this.f25576g = kArr;
        this.f25577h = vArr;
        this.f25578i = iArr;
        this.f25579j = iArr2;
        this.f25580k = i2;
        this.l = i3;
        this.m = f25575f.d(x());
    }

    private final int B(K k2) {
        return ((k2 != null ? k2.hashCode() : 0) * (-1640531527)) >>> this.m;
    }

    private final boolean E(Collection<? extends Map.Entry<? extends K, ? extends V>> collection) {
        boolean z = false;
        if (collection.isEmpty()) {
            return false;
        }
        r(collection.size());
        Iterator<? extends Map.Entry<? extends K, ? extends V>> it = collection.iterator();
        while (it.hasNext()) {
            if (F(it.next())) {
                z = true;
            }
        }
        return z;
    }

    private final boolean F(Map.Entry<? extends K, ? extends V> entry) {
        int iH = h(entry.getKey());
        V[] vArrI = i();
        if (iH >= 0) {
            vArrI[iH] = entry.getValue();
            return true;
        }
        int i2 = (-iH) - 1;
        if (m.a(entry.getValue(), vArrI[i2])) {
            return false;
        }
        vArrI[i2] = entry.getValue();
        return true;
    }

    private final boolean G(int i2) {
        int iB = B(this.f25576g[i2]);
        int i3 = this.f25580k;
        while (true) {
            int[] iArr = this.f25579j;
            if (iArr[iB] == 0) {
                iArr[iB] = i2 + 1;
                this.f25578i[i2] = iB;
                return true;
            }
            i3--;
            if (i3 < 0) {
                return false;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    private final void H(int i2) {
        if (this.l > size()) {
            m();
        }
        int i3 = 0;
        if (i2 != x()) {
            this.f25579j = new int[i2];
            this.m = f25575f.d(i2);
        } else {
            kotlin.collections.m.j(this.f25579j, 0, 0, x());
        }
        while (i3 < this.l) {
            int i4 = i3 + 1;
            if (!G(i3)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i3 = i4;
        }
    }

    private final void J(int i2) {
        int iD = l.d(this.f25580k * 2, x() / 2);
        int i3 = 0;
        int i4 = i2;
        do {
            i2 = i2 == 0 ? x() - 1 : i2 - 1;
            i3++;
            if (i3 > this.f25580k) {
                this.f25579j[i4] = 0;
                return;
            }
            int[] iArr = this.f25579j;
            int i5 = iArr[i2];
            if (i5 == 0) {
                iArr[i4] = 0;
                return;
            }
            if (i5 < 0) {
                iArr[i4] = -1;
            } else {
                int i6 = i5 - 1;
                if (((B(this.f25576g[i6]) - i2) & (x() - 1)) >= i3) {
                    this.f25579j[i4] = i5;
                    this.f25578i[i6] = i4;
                }
                iD--;
            }
            i4 = i2;
            i3 = 0;
            iD--;
        } while (iD >= 0);
        this.f25579j[i4] = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(int i2) {
        kotlin.collections.builders.c.f(this.f25576g, i2);
        J(this.f25578i[i2]);
        this.f25578i[i2] = -1;
        this.n = size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V[] i() {
        V[] vArr = this.f25577h;
        if (vArr != null) {
            return vArr;
        }
        V[] vArr2 = (V[]) kotlin.collections.builders.c.d(v());
        this.f25577h = vArr2;
        return vArr2;
    }

    private final void m() {
        int i2;
        V[] vArr = this.f25577h;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            i2 = this.l;
            if (i3 >= i2) {
                break;
            }
            if (this.f25578i[i3] >= 0) {
                K[] kArr = this.f25576g;
                kArr[i4] = kArr[i3];
                if (vArr != null) {
                    vArr[i4] = vArr[i3];
                }
                i4++;
            }
            i3++;
        }
        kotlin.collections.builders.c.g(this.f25576g, i4, i2);
        if (vArr != null) {
            kotlin.collections.builders.c.g(vArr, i4, this.l);
        }
        this.l = i4;
    }

    private final boolean p(Map<?, ?> map) {
        return size() == map.size() && n(map.entrySet());
    }

    private final void q(int i2) {
        if (i2 < 0) {
            throw new OutOfMemoryError();
        }
        if (i2 <= v()) {
            if ((this.l + i2) - size() > v()) {
                H(x());
                return;
            }
            return;
        }
        int iV = (v() * 3) / 2;
        if (i2 <= iV) {
            i2 = iV;
        }
        this.f25576g = (K[]) kotlin.collections.builders.c.e(this.f25576g, i2);
        V[] vArr = this.f25577h;
        this.f25577h = vArr != null ? (V[]) kotlin.collections.builders.c.e(vArr, i2) : null;
        int[] iArrCopyOf = Arrays.copyOf(this.f25578i, i2);
        m.e(iArrCopyOf, "copyOf(this, newSize)");
        this.f25578i = iArrCopyOf;
        int iC = f25575f.c(i2);
        if (iC > x()) {
            H(iC);
        }
    }

    private final void r(int i2) {
        q(this.l + i2);
    }

    private final int t(K k2) {
        int iB = B(k2);
        int i2 = this.f25580k;
        while (true) {
            int i3 = this.f25579j[iB];
            if (i3 == 0) {
                return -1;
            }
            if (i3 > 0) {
                int i4 = i3 - 1;
                if (m.a(this.f25576g[i4], k2)) {
                    return i4;
                }
            }
            i2--;
            if (i2 < 0) {
                return -1;
            }
            iB = iB == 0 ? x() - 1 : iB - 1;
        }
    }

    private final int u(V v) {
        int i2 = this.l;
        while (true) {
            i2--;
            if (i2 < 0) {
                return -1;
            }
            if (this.f25578i[i2] >= 0) {
                V[] vArr = this.f25577h;
                m.c(vArr);
                if (m.a(vArr[i2], v)) {
                    return i2;
                }
            }
        }
    }

    private final int v() {
        return this.f25576g.length;
    }

    private final Object writeReplace() throws NotSerializableException {
        if (this.r) {
            return new SerializedMap(this);
        }
        throw new NotSerializableException("The map cannot be serialized while it is being built.");
    }

    private final int x() {
        return this.f25579j.length;
    }

    public Collection<V> A() {
        MapBuilderValues<V> mapBuilderValues = this.p;
        if (mapBuilderValues != null) {
            return mapBuilderValues;
        }
        MapBuilderValues<V> mapBuilderValues2 = new MapBuilderValues<>(this);
        this.p = mapBuilderValues2;
        return mapBuilderValues2;
    }

    /* JADX INFO: renamed from: C, reason: from getter */
    public final boolean getR() {
        return this.r;
    }

    public final e<K, V> D() {
        return new e<>(this);
    }

    public final boolean I(Map.Entry<? extends K, ? extends V> entry) {
        m.f(entry, "entry");
        k();
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        V[] vArr = this.f25577h;
        m.c(vArr);
        if (!m.a(vArr[iT], entry.getValue())) {
            return false;
        }
        L(iT);
        return true;
    }

    public final int K(K k2) {
        k();
        int iT = t(k2);
        if (iT < 0) {
            return -1;
        }
        L(iT);
        return iT;
    }

    public final boolean M(V v) {
        k();
        int iU = u(v);
        if (iU < 0) {
            return false;
        }
        L(iU);
        return true;
    }

    public final f<K, V> N() {
        return new f<>(this);
    }

    @Override // java.util.Map
    public void clear() {
        k();
        IntIterator it = new IntRange(0, this.l - 1).iterator();
        while (it.hasNext()) {
            int iB = it.b();
            int[] iArr = this.f25578i;
            int i2 = iArr[iB];
            if (i2 >= 0) {
                this.f25579j[i2] = 0;
                iArr[iB] = -1;
            }
        }
        kotlin.collections.builders.c.g(this.f25576g, 0, this.l);
        V[] vArr = this.f25577h;
        if (vArr != null) {
            kotlin.collections.builders.c.g(vArr, 0, this.l);
        }
        this.n = 0;
        this.l = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsKey(Object key) {
        return t(key) >= 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public boolean containsValue(Object value) {
        return u(value) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return w();
    }

    @Override // java.util.Map
    public boolean equals(Object other) {
        return other == this || ((other instanceof Map) && p((Map) other));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V get(Object key) {
        int iT = t(key);
        if (iT < 0) {
            return null;
        }
        V[] vArr = this.f25577h;
        m.c(vArr);
        return vArr[iT];
    }

    public final int h(K k2) {
        k();
        while (true) {
            int iB = B(k2);
            int iD = l.d(this.f25580k * 2, x() / 2);
            int i2 = 0;
            while (true) {
                int i3 = this.f25579j[iB];
                if (i3 <= 0) {
                    if (this.l >= v()) {
                        r(1);
                        break;
                    }
                    int i4 = this.l;
                    int i5 = i4 + 1;
                    this.l = i5;
                    this.f25576g[i4] = k2;
                    this.f25578i[i4] = iB;
                    this.f25579j[iB] = i5;
                    this.n = size() + 1;
                    if (i2 > this.f25580k) {
                        this.f25580k = i2;
                    }
                    return i4;
                }
                if (m.a(this.f25576g[i3 - 1], k2)) {
                    return -i3;
                }
                i2++;
                if (i2 > iD) {
                    H(x() * 2);
                    break;
                }
                iB = iB == 0 ? x() - 1 : iB - 1;
            }
        }
    }

    @Override // java.util.Map
    public int hashCode() {
        b<K, V> bVarS = s();
        int iM = 0;
        while (bVarS.hasNext()) {
            iM += bVarS.m();
        }
        return iM;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final Map<K, V> j() {
        k();
        this.r = true;
        return this;
    }

    public final void k() {
        if (this.r) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return y();
    }

    public final boolean n(Collection<?> collection) {
        m.f(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!o((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean o(Map.Entry<? extends K, ? extends V> entry) {
        m.f(entry, "entry");
        int iT = t(entry.getKey());
        if (iT < 0) {
            return false;
        }
        V[] vArr = this.f25577h;
        m.c(vArr);
        return m.a(vArr[iT], entry.getValue());
    }

    @Override // java.util.Map
    public V put(K key, V value) {
        k();
        int iH = h(key);
        V[] vArrI = i();
        if (iH >= 0) {
            vArrI[iH] = value;
            return null;
        }
        int i2 = (-iH) - 1;
        V v = vArrI[i2];
        vArrI[i2] = value;
        return v;
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        m.f(from, "from");
        k();
        E(from.entrySet());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Map
    public V remove(Object key) {
        int iK = K(key);
        if (iK < 0) {
            return null;
        }
        V[] vArr = this.f25577h;
        m.c(vArr);
        V v = vArr[iK];
        kotlin.collections.builders.c.f(vArr, iK);
        return v;
    }

    public final b<K, V> s() {
        return new b<>(this);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getN();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b<K, V> bVarS = s();
        int i2 = 0;
        while (bVarS.hasNext()) {
            if (i2 > 0) {
                sb.append(", ");
            }
            bVarS.k(sb);
            i2++;
        }
        sb.append("}");
        String string = sb.toString();
        m.e(string, "sb.toString()");
        return string;
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<V> values() {
        return A();
    }

    public Set<Map.Entry<K, V>> w() {
        MapBuilderEntries<K, V> mapBuilderEntries = this.q;
        if (mapBuilderEntries != null) {
            return mapBuilderEntries;
        }
        MapBuilderEntries<K, V> mapBuilderEntries2 = new MapBuilderEntries<>(this);
        this.q = mapBuilderEntries2;
        return mapBuilderEntries2;
    }

    public Set<K> y() {
        MapBuilderKeys<K> mapBuilderKeys = this.o;
        if (mapBuilderKeys != null) {
            return mapBuilderKeys;
        }
        MapBuilderKeys<K> mapBuilderKeys2 = new MapBuilderKeys<>(this);
        this.o = mapBuilderKeys2;
        return mapBuilderKeys2;
    }

    /* JADX INFO: renamed from: z, reason: from getter */
    public int getN() {
        return this.n;
    }

    public MapBuilder() {
        this(8);
    }

    public MapBuilder(int i2) {
        this(kotlin.collections.builders.c.d(i2), null, new int[i2], new int[f25575f.c(i2)], 2, 0);
    }
}
