package com.google.firebase.encoders.i;

import cm.aptoide.pt.database.room.RoomNotification;
import com.google.firebase.encoders.EncodingException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ProtobufDataEncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class g implements com.google.firebase.encoders.d {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.google.firebase.encoders.b f19602b = com.google.firebase.encoders.b.a(RoomNotification.KEY).b(c.b().c(1).a()).a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final com.google.firebase.encoders.b f19603c = com.google.firebase.encoders.b.a("value").b(c.b().c(2).a()).a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final com.google.firebase.encoders.c<Map.Entry<Object, Object>> f19604d = new com.google.firebase.encoders.c() { // from class: com.google.firebase.encoders.i.a
        @Override // com.google.firebase.encoders.c
        public final void a(Object obj, Object obj2) throws IOException {
            g.x((Map.Entry) obj, (com.google.firebase.encoders.d) obj2);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private OutputStream f19605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.c<?>> f19606f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.e<?>> f19607g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.google.firebase.encoders.c<Object> f19608h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final i f19609i = new i(this);

    /* JADX INFO: compiled from: ProtobufDataEncoderContext.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[f.a.values().length];
            a = iArr;
            try {
                iArr[f.a.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[f.a.SIGNED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[f.a.FIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    g(OutputStream outputStream, Map<Class<?>, com.google.firebase.encoders.c<?>> map, Map<Class<?>, com.google.firebase.encoders.e<?>> map2, com.google.firebase.encoders.c<Object> cVar) {
        this.f19605e = outputStream;
        this.f19606f = map;
        this.f19607g = map2;
        this.f19608h = cVar;
    }

    private static ByteBuffer q(int i2) {
        return ByteBuffer.allocate(i2).order(ByteOrder.LITTLE_ENDIAN);
    }

    private <T> long r(com.google.firebase.encoders.c<T> cVar, T t) throws IOException {
        d dVar = new d();
        try {
            OutputStream outputStream = this.f19605e;
            this.f19605e = dVar;
            try {
                cVar.a(t, this);
                this.f19605e = outputStream;
                long jA = dVar.a();
                dVar.close();
                return jA;
            } catch (Throwable th) {
                this.f19605e = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                dVar.close();
            } catch (Throwable unused) {
            }
            throw th2;
        }
    }

    private <T> g s(com.google.firebase.encoders.c<T> cVar, com.google.firebase.encoders.b bVar, T t, boolean z) throws IOException {
        long jR = r(cVar, t);
        if (z && jR == 0) {
            return this;
        }
        y((w(bVar) << 3) | 2);
        z(jR);
        cVar.a(t, this);
        return this;
    }

    private <T> g t(com.google.firebase.encoders.e<T> eVar, com.google.firebase.encoders.b bVar, T t, boolean z) throws IOException {
        this.f19609i.b(bVar, z);
        eVar.a(t, this.f19609i);
        return this;
    }

    private static f v(com.google.firebase.encoders.b bVar) {
        f fVar = (f) bVar.c(f.class);
        if (fVar != null) {
            return fVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private static int w(com.google.firebase.encoders.b bVar) {
        f fVar = (f) bVar.c(f.class);
        if (fVar != null) {
            return fVar.tag();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    static /* synthetic */ void x(Map.Entry entry, com.google.firebase.encoders.d dVar) throws IOException {
        dVar.i(f19602b, entry.getKey());
        dVar.i(f19603c, entry.getValue());
    }

    private void y(int i2) throws IOException {
        while ((i2 & (-128)) != 0) {
            this.f19605e.write((i2 & 127) | 128);
            i2 >>>= 7;
        }
        this.f19605e.write(i2 & 127);
    }

    private void z(long j2) throws IOException {
        while (((-128) & j2) != 0) {
            this.f19605e.write((((int) j2) & 127) | 128);
            j2 >>>= 7;
        }
        this.f19605e.write(((int) j2) & 127);
    }

    @Override // com.google.firebase.encoders.d
    public com.google.firebase.encoders.d d(com.google.firebase.encoders.b bVar, double d2) throws IOException {
        return f(bVar, d2, true);
    }

    @Override // com.google.firebase.encoders.d
    public com.google.firebase.encoders.d e(String str, int i2) throws IOException {
        return c(com.google.firebase.encoders.b.d(str), i2);
    }

    com.google.firebase.encoders.d f(com.google.firebase.encoders.b bVar, double d2, boolean z) throws IOException {
        if (z && d2 == 0.0d) {
            return this;
        }
        y((w(bVar) << 3) | 1);
        this.f19605e.write(q(8).putDouble(d2).array());
        return this;
    }

    com.google.firebase.encoders.d g(com.google.firebase.encoders.b bVar, float f2, boolean z) throws IOException {
        if (z && f2 == 0.0f) {
            return this;
        }
        y((w(bVar) << 3) | 5);
        this.f19605e.write(q(4).putFloat(f2).array());
        return this;
    }

    @Override // com.google.firebase.encoders.d
    public com.google.firebase.encoders.d h(String str, Object obj) throws IOException {
        return i(com.google.firebase.encoders.b.d(str), obj);
    }

    @Override // com.google.firebase.encoders.d
    public com.google.firebase.encoders.d i(com.google.firebase.encoders.b bVar, Object obj) throws IOException {
        return j(bVar, obj, true);
    }

    com.google.firebase.encoders.d j(com.google.firebase.encoders.b bVar, Object obj, boolean z) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            y((w(bVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(a);
            y(bytes.length);
            this.f19605e.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                j(bVar, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                s(f19604d, bVar, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            return f(bVar, ((Double) obj).doubleValue(), z);
        }
        if (obj instanceof Float) {
            return g(bVar, ((Float) obj).floatValue(), z);
        }
        if (obj instanceof Number) {
            return n(bVar, ((Number) obj).longValue(), z);
        }
        if (obj instanceof Boolean) {
            return p(bVar, ((Boolean) obj).booleanValue(), z);
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            y((w(bVar) << 3) | 2);
            y(bArr.length);
            this.f19605e.write(bArr);
            return this;
        }
        com.google.firebase.encoders.c<?> cVar = this.f19606f.get(obj.getClass());
        if (cVar != null) {
            return s(cVar, bVar, obj, z);
        }
        com.google.firebase.encoders.e<?> eVar = this.f19607g.get(obj.getClass());
        if (eVar != null) {
            return t(eVar, bVar, obj, z);
        }
        if (obj instanceof e) {
            return c(bVar, ((e) obj).f());
        }
        return obj instanceof Enum ? c(bVar, ((Enum) obj).ordinal()) : s(this.f19608h, bVar, obj, z);
    }

    @Override // com.google.firebase.encoders.d
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public g c(com.google.firebase.encoders.b bVar, int i2) throws IOException {
        return l(bVar, i2, true);
    }

    g l(com.google.firebase.encoders.b bVar, int i2, boolean z) throws IOException {
        if (z && i2 == 0) {
            return this;
        }
        f fVarV = v(bVar);
        int i3 = a.a[fVarV.intEncoding().ordinal()];
        if (i3 == 1) {
            y(fVarV.tag() << 3);
            y(i2);
        } else if (i3 == 2) {
            y(fVarV.tag() << 3);
            y((i2 << 1) ^ (i2 >> 31));
        } else if (i3 == 3) {
            y((fVarV.tag() << 3) | 5);
            this.f19605e.write(q(4).putInt(i2).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.d
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public g b(com.google.firebase.encoders.b bVar, long j2) throws IOException {
        return n(bVar, j2, true);
    }

    g n(com.google.firebase.encoders.b bVar, long j2, boolean z) throws IOException {
        if (z && j2 == 0) {
            return this;
        }
        f fVarV = v(bVar);
        int i2 = a.a[fVarV.intEncoding().ordinal()];
        if (i2 == 1) {
            y(fVarV.tag() << 3);
            z(j2);
        } else if (i2 == 2) {
            y(fVarV.tag() << 3);
            z((j2 >> 63) ^ (j2 << 1));
        } else if (i2 == 3) {
            y((fVarV.tag() << 3) | 1);
            this.f19605e.write(q(8).putLong(j2).array());
        }
        return this;
    }

    @Override // com.google.firebase.encoders.d
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public g a(com.google.firebase.encoders.b bVar, boolean z) throws IOException {
        return p(bVar, z, true);
    }

    g p(com.google.firebase.encoders.b bVar, boolean z, boolean z2) throws IOException {
        return l(bVar, z ? 1 : 0, z2);
    }

    g u(Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        com.google.firebase.encoders.c<?> cVar = this.f19606f.get(obj.getClass());
        if (cVar != null) {
            cVar.a(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for " + obj.getClass());
    }
}
