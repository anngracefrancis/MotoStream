package com.google.firebase.encoders.json;

import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.c;
import com.google.firebase.encoders.d;
import com.google.firebase.encoders.e;
import com.google.firebase.encoders.f;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements com.google.firebase.encoders.g.b<d> {
    private static final c<Object> a = new c() { // from class: com.google.firebase.encoders.h.a
        @Override // com.google.firebase.encoders.c
        public final void a(Object obj, Object obj2) throws IOException {
            d.i(obj, (d) obj2);
            throw null;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e<String> f19582b = new e() { // from class: com.google.firebase.encoders.h.b
        @Override // com.google.firebase.encoders.e
        public final void a(Object obj, Object obj2) throws IOException {
            ((f) obj2).f((String) obj);
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e<Boolean> f19583c = new e() { // from class: com.google.firebase.encoders.h.c
        @Override // com.google.firebase.encoders.e
        public final void a(Object obj, Object obj2) throws IOException {
            ((f) obj2).g(((Boolean) obj).booleanValue());
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final b f19584d = new b(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, c<?>> f19585e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<Class<?>, e<?>> f19586f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private c<Object> f19587g = a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f19588h = false;

    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    class a implements com.google.firebase.encoders.a {
        a() {
        }

        @Override // com.google.firebase.encoders.a
        public void a(Object obj, Writer writer) throws IOException {
            e eVar = new e(writer, d.this.f19585e, d.this.f19586f, d.this.f19587g, d.this.f19588h);
            eVar.m(obj, false);
            eVar.w();
        }

        @Override // com.google.firebase.encoders.a
        public String b(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                a(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    /* JADX INFO: compiled from: JsonDataEncoderBuilder.java */
    private static final class b implements e<Date> {
        private static final DateFormat a;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        private b() {
        }

        @Override // com.google.firebase.encoders.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Date date, f fVar) throws IOException {
            fVar.f(a.format(date));
        }

        /* synthetic */ b(a aVar) {
            this();
        }
    }

    public d() {
        m(String.class, f19582b);
        m(Boolean.class, f19583c);
        m(Date.class, f19584d);
    }

    static /* synthetic */ void i(Object obj, com.google.firebase.encoders.d dVar) throws IOException {
        throw new EncodingException("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    public com.google.firebase.encoders.a f() {
        return new a();
    }

    public d g(com.google.firebase.encoders.g.a aVar) {
        aVar.a(this);
        return this;
    }

    public d h(boolean z) {
        this.f19588h = z;
        return this;
    }

    @Override // com.google.firebase.encoders.g.b
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public <T> d a(Class<T> cls, c<? super T> cVar) {
        this.f19585e.put(cls, cVar);
        this.f19586f.remove(cls);
        return this;
    }

    public <T> d m(Class<T> cls, e<? super T> eVar) {
        this.f19586f.put(cls, eVar);
        this.f19585e.remove(cls);
        return this;
    }
}
