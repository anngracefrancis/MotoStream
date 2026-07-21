package com.google.firebase.encoders.json;

import android.util.Base64;
import android.util.JsonWriter;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.b;
import com.google.firebase.encoders.c;
import com.google.firebase.encoders.d;
import com.google.firebase.encoders.f;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: JsonValueObjectEncoderContext.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements d, f {
    private e a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f19589b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JsonWriter f19590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Class<?>, c<?>> f19591d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.e<?>> f19592e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c<Object> f19593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f19594g;

    e(Writer writer, Map<Class<?>, c<?>> map, Map<Class<?>, com.google.firebase.encoders.e<?>> map2, c<Object> cVar, boolean z) {
        this.f19590c = new JsonWriter(writer);
        this.f19591d = map;
        this.f19592e = map2;
        this.f19593f = cVar;
        this.f19594g = z;
    }

    private void A() throws IOException {
        if (!this.f19589b) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        e eVar = this.a;
        if (eVar != null) {
            eVar.A();
            this.a.f19589b = false;
            this.a = null;
            this.f19590c.endObject();
        }
    }

    private boolean v(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    private e y(String str, Object obj) throws EncodingException, IOException {
        A();
        this.f19590c.name(str);
        if (obj != null) {
            return m(obj, false);
        }
        this.f19590c.nullValue();
        return this;
    }

    private e z(String str, Object obj) throws EncodingException, IOException {
        if (obj == null) {
            return this;
        }
        A();
        this.f19590c.name(str);
        return m(obj, false);
    }

    @Override // com.google.firebase.encoders.d
    public d a(b bVar, boolean z) throws IOException {
        return s(bVar.b(), z);
    }

    @Override // com.google.firebase.encoders.d
    public d b(b bVar, long j2) throws IOException {
        return q(bVar.b(), j2);
    }

    @Override // com.google.firebase.encoders.d
    public d c(b bVar, int i2) throws IOException {
        return e(bVar.b(), i2);
    }

    @Override // com.google.firebase.encoders.d
    public d d(b bVar, double d2) throws IOException {
        return o(bVar.b(), d2);
    }

    @Override // com.google.firebase.encoders.d
    public d i(b bVar, Object obj) throws IOException {
        return h(bVar.b(), obj);
    }

    public e j(double d2) throws IOException {
        A();
        this.f19590c.value(d2);
        return this;
    }

    public e k(int i2) throws IOException {
        A();
        this.f19590c.value(i2);
        return this;
    }

    public e l(long j2) throws IOException {
        A();
        this.f19590c.value(j2);
        return this;
    }

    e m(Object obj, boolean z) throws IOException {
        int i2 = 0;
        if (z && v(obj)) {
            Object[] objArr = new Object[1];
            objArr[0] = obj == null ? null : obj.getClass();
            throw new EncodingException(String.format("%s cannot be encoded inline", objArr));
        }
        if (obj == null) {
            this.f19590c.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f19590c.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f19590c.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m(it.next(), false);
                }
                this.f19590c.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f19590c.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        h((String) key, entry.getValue());
                    } catch (ClassCastException e2) {
                        throw new EncodingException(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e2);
                    }
                }
                this.f19590c.endObject();
                return this;
            }
            c<?> cVar = this.f19591d.get(obj.getClass());
            if (cVar != null) {
                return x(cVar, obj, z);
            }
            com.google.firebase.encoders.e<?> eVar = this.f19592e.get(obj.getClass());
            if (eVar != null) {
                eVar.a(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return x(this.f19593f, obj, z);
            }
            if (obj instanceof NumberedEnum) {
                k(((NumberedEnum) obj).getM());
            } else {
                f(((Enum) obj).name());
            }
            return this;
        }
        if (obj instanceof byte[]) {
            return u((byte[]) obj);
        }
        this.f19590c.beginArray();
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            int length = iArr.length;
            while (i2 < length) {
                this.f19590c.value(iArr[i2]);
                i2++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i2 < length2) {
                l(jArr[i2]);
                i2++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i2 < length3) {
                this.f19590c.value(dArr[i2]);
                i2++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i2 < length4) {
                this.f19590c.value(zArr[i2]);
                i2++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                m(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                m(obj2, false);
            }
        }
        this.f19590c.endArray();
        return this;
    }

    @Override // com.google.firebase.encoders.f
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public e f(String str) throws IOException {
        A();
        this.f19590c.value(str);
        return this;
    }

    public e o(String str, double d2) throws IOException {
        A();
        this.f19590c.name(str);
        return j(d2);
    }

    @Override // com.google.firebase.encoders.d
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public e e(String str, int i2) throws IOException {
        A();
        this.f19590c.name(str);
        return k(i2);
    }

    public e q(String str, long j2) throws IOException {
        A();
        this.f19590c.name(str);
        return l(j2);
    }

    @Override // com.google.firebase.encoders.d
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public e h(String str, Object obj) throws IOException {
        return this.f19594g ? z(str, obj) : y(str, obj);
    }

    public e s(String str, boolean z) throws IOException {
        A();
        this.f19590c.name(str);
        return g(z);
    }

    @Override // com.google.firebase.encoders.f
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public e g(boolean z) throws IOException {
        A();
        this.f19590c.value(z);
        return this;
    }

    public e u(byte[] bArr) throws IOException {
        A();
        if (bArr == null) {
            this.f19590c.nullValue();
        } else {
            this.f19590c.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    void w() throws IOException {
        A();
        this.f19590c.flush();
    }

    e x(c<Object> cVar, Object obj, boolean z) throws IOException {
        if (!z) {
            this.f19590c.beginObject();
        }
        cVar.a(obj, this);
        if (!z) {
            this.f19590c.endObject();
        }
        return this;
    }
}
