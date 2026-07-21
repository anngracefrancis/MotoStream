package kotlin.collections.builders;

import cm.aptoide.pt.store.view.StoreTabGridRecyclerFragment;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.w.z0.h, reason: from Kotlin metadata */
/* JADX INFO: compiled from: ListBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0019\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "()V", "collection", HttpUrl.FRAGMENT_ENCODE_SET, StoreTabGridRecyclerFragment.BundleCons.TAG, HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/Collection;I)V", "readExternal", HttpUrl.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInput;", "readResolve", HttpUrl.FRAGMENT_ENCODE_SET, "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SerializedCollection implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25589f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Collection<?> f25590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f25591h;

    /* JADX INFO: renamed from: kotlin.w.z0.h$a */
    /* JADX INFO: compiled from: ListBuilder.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlin/collections/builders/SerializedCollection$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "serialVersionUID", HttpUrl.FRAGMENT_ENCODE_SET, "tagList", HttpUrl.FRAGMENT_ENCODE_SET, "tagSet", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public SerializedCollection(Collection<?> collection, int i2) {
        m.f(collection, "collection");
        this.f25590g = collection;
        this.f25591h = i2;
    }

    private final Object readResolve() {
        return this.f25590g;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws InvalidObjectException {
        Collection<?> collectionA;
        m.f(input, "input");
        byte b2 = input.readByte();
        int i2 = b2 & 1;
        if ((b2 & (-2)) != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b2) + '.');
        }
        int i3 = input.readInt();
        if (i3 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i3 + '.');
        }
        int i4 = 0;
        if (i2 == 0) {
            List listD = t.d(i3);
            while (i4 < i3) {
                listD.add(input.readObject());
                i4++;
            }
            collectionA = t.a(listD);
        } else {
            if (i2 != 1) {
                throw new InvalidObjectException("Unsupported collection type tag: " + i2 + '.');
            }
            Set setB = v0.b(i3);
            while (i4 < i3) {
                setB.add(input.readObject());
                i4++;
            }
            collectionA = v0.a(setB);
        }
        this.f25590g = collectionA;
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        m.f(output, "output");
        output.writeByte(this.f25591h);
        output.writeInt(this.f25590g.size());
        Iterator<?> it = this.f25590g.iterator();
        while (it.hasNext()) {
            output.writeObject(it.next());
        }
    }

    public SerializedCollection() {
        this(u.j(), 0);
    }
}
