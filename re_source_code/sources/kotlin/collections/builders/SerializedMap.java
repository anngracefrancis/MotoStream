package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: kotlin.w.z0.i, reason: from Kotlin metadata */
/* JADX INFO: compiled from: MapBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0015\u0012\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0016\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "()V", "map", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/util/Map;)V", "readExternal", HttpUrl.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInput;", "readResolve", HttpUrl.FRAGMENT_ENCODE_SET, "writeExternal", "output", "Ljava/io/ObjectOutput;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class SerializedMap implements Externalizable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f25592f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<?, ?> f25593g;

    /* JADX INFO: renamed from: kotlin.w.z0.i$a */
    /* JADX INFO: compiled from: MapBuilder.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlin/collections/builders/SerializedMap$Companion;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "serialVersionUID", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin-stdlib"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public SerializedMap(Map<?, ?> map) {
        m.f(map, "map");
        this.f25593g = map;
    }

    private final Object readResolve() {
        return this.f25593g;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput input) throws InvalidObjectException {
        m.f(input, "input");
        byte b2 = input.readByte();
        if (b2 != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + ((int) b2));
        }
        int i2 = input.readInt();
        if (i2 < 0) {
            throw new InvalidObjectException("Illegal size value: " + i2 + '.');
        }
        Map mapD = p0.d(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            mapD.put(input.readObject(), input.readObject());
        }
        this.f25593g = p0.b(mapD);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput output) throws IOException {
        m.f(output, "output");
        output.writeByte(0);
        output.writeInt(this.f25593g.size());
        for (Map.Entry<?, ?> entry : this.f25593g.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    public SerializedMap() {
        this(q0.i());
    }
}
