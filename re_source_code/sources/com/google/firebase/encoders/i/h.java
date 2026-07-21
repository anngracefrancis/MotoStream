package com.google.firebase.encoders.i;

import com.google.firebase.encoders.EncodingException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ProtobufEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    private final Map<Class<?>, com.google.firebase.encoders.c<?>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, com.google.firebase.encoders.e<?>> f19610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.firebase.encoders.c<Object> f19611c;

    /* JADX INFO: compiled from: ProtobufEncoder.java */
    public static final class a implements com.google.firebase.encoders.g.b<a> {
        private static final com.google.firebase.encoders.c<Object> a = new com.google.firebase.encoders.c() { // from class: com.google.firebase.encoders.i.b
            @Override // com.google.firebase.encoders.c
            public final void a(Object obj, Object obj2) throws IOException {
                h.a.d(obj, (com.google.firebase.encoders.d) obj2);
                throw null;
            }
        };

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Map<Class<?>, com.google.firebase.encoders.c<?>> f19612b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map<Class<?>, com.google.firebase.encoders.e<?>> f19613c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private com.google.firebase.encoders.c<Object> f19614d = a;

        static /* synthetic */ void d(Object obj, com.google.firebase.encoders.d dVar) throws IOException {
            throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }

        public h b() {
            return new h(new HashMap(this.f19612b), new HashMap(this.f19613c), this.f19614d);
        }

        public a c(com.google.firebase.encoders.g.a aVar) {
            aVar.a(this);
            return this;
        }

        @Override // com.google.firebase.encoders.g.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public <U> a a(Class<U> cls, com.google.firebase.encoders.c<? super U> cVar) {
            this.f19612b.put(cls, cVar);
            this.f19613c.remove(cls);
            return this;
        }
    }

    h(Map<Class<?>, com.google.firebase.encoders.c<?>> map, Map<Class<?>, com.google.firebase.encoders.e<?>> map2, com.google.firebase.encoders.c<Object> cVar) {
        this.a = map;
        this.f19610b = map2;
        this.f19611c = cVar;
    }

    public static a a() {
        return new a();
    }

    public void b(Object obj, OutputStream outputStream) throws IOException {
        new g(outputStream, this.a, this.f19610b, this.f19611c).u(obj);
    }

    public byte[] c(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            b(obj, byteArrayOutputStream);
        } catch (IOException unused) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
