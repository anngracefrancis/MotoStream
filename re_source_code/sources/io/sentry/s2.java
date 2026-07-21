package io.sentry;

import io.sentry.protocol.DebugImage;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s2 implements c2 {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x4 f22696b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class<?>, l2<?>> f22697c;

    public s2(x4 x4Var) {
        this.f22696b = x4Var;
        HashMap map = new HashMap();
        this.f22697c = map;
        map.put(io.sentry.protocol.a.class, new io.sentry.protocol.a.C0308a());
        map.put(v0.class, new v0.a());
        map.put(io.sentry.protocol.b.class, new io.sentry.protocol.b.a());
        map.put(io.sentry.protocol.c.class, new io.sentry.protocol.c.a());
        map.put(DebugImage.class, new DebugImage.a());
        map.put(io.sentry.protocol.d.class, new io.sentry.protocol.d.a());
        map.put(io.sentry.protocol.e.class, new io.sentry.protocol.e.a());
        map.put(io.sentry.protocol.e.b.class, new io.sentry.protocol.e.b.a());
        map.put(io.sentry.protocol.g.class, new io.sentry.protocol.g.a());
        map.put(io.sentry.protocol.h.class, new io.sentry.protocol.h.a());
        map.put(io.sentry.protocol.i.class, new io.sentry.protocol.i.a());
        map.put(io.sentry.protocol.j.class, new io.sentry.protocol.j.a());
        map.put(io.sentry.protocol.k.class, new io.sentry.protocol.k.a());
        map.put(m3.class, new m3.b());
        map.put(n3.class, new n3.a());
        map.put(io.sentry.profilemeasurements.a.class, new io.sentry.profilemeasurements.a.C0307a());
        map.put(io.sentry.profilemeasurements.b.class, new io.sentry.profilemeasurements.b.a());
        map.put(io.sentry.protocol.l.class, new io.sentry.protocol.l.a());
        map.put(io.sentry.protocol.n.class, new io.sentry.protocol.n.a());
        map.put(io.sentry.protocol.o.class, new io.sentry.protocol.o.a());
        map.put(i4.class, new i4.a());
        map.put(k4.class, new k4.a());
        map.put(l4.class, new l4.a());
        map.put(io.sentry.protocol.p.class, new io.sentry.protocol.p.a());
        map.put(r4.class, new r4.a());
        map.put(s4.class, new s4.a());
        map.put(t4.class, new t4.a());
        map.put(io.sentry.protocol.r.class, new io.sentry.protocol.r.a());
        map.put(io.sentry.protocol.s.class, new io.sentry.protocol.s.a());
        map.put(io.sentry.protocol.t.class, new io.sentry.protocol.t.a());
        map.put(io.sentry.protocol.u.class, new io.sentry.protocol.u.a());
        map.put(io.sentry.protocol.v.class, new io.sentry.protocol.v.a());
        map.put(io.sentry.protocol.w.class, new io.sentry.protocol.w.a());
        map.put(io.sentry.protocol.x.class, new io.sentry.protocol.x.a());
        map.put(d5.class, new d5.a());
        map.put(f5.class, new f5.a());
        map.put(h5.class, new h5.a());
        map.put(j5.class, new j5.a());
        map.put(io.sentry.protocol.a0.class, new io.sentry.protocol.a0.a());
        map.put(io.sentry.protocol.f.class, new io.sentry.protocol.f.a());
        map.put(w5.class, new w5.a());
        map.put(io.sentry.clientreport.b.class, new io.sentry.clientreport.b.a());
        map.put(io.sentry.protocol.c0.class, new io.sentry.protocol.c0.a());
        map.put(io.sentry.protocol.b0.class, new io.sentry.protocol.b0.a());
    }

    private <T> boolean g(Class<T> cls) {
        return cls.isArray() || Collection.class.isAssignableFrom(cls) || String.class.isAssignableFrom(cls) || Map.class.isAssignableFrom(cls);
    }

    private String h(Object obj, boolean z) throws IOException {
        StringWriter stringWriter = new StringWriter();
        p2 p2Var = new p2(stringWriter, this.f22696b.getMaxDepth());
        if (z) {
            p2Var.s("\t");
        }
        p2Var.g(this.f22696b.getLogger(), obj);
        return stringWriter.toString();
    }

    @Override // io.sentry.c2
    public <T> void a(T t, Writer writer) throws IOException {
        io.sentry.util.q.c(t, "The entity is required.");
        io.sentry.util.q.c(writer, "The Writer object is required.");
        w1 logger = this.f22696b.getLogger();
        s4 s4Var = s4.DEBUG;
        if (logger.d(s4Var)) {
            this.f22696b.getLogger().c(s4Var, "Serializing object: %s", h(t, this.f22696b.isEnablePrettySerializationOutput()));
        }
        new p2(writer, this.f22696b.getMaxDepth()).g(this.f22696b.getLogger(), t);
        writer.flush();
    }

    @Override // io.sentry.c2
    public void b(h4 h4Var, OutputStream outputStream) throws Exception {
        io.sentry.util.q.c(h4Var, "The SentryEnvelope object is required.");
        io.sentry.util.q.c(outputStream, "The Stream object is required.");
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(outputStream), a));
        try {
            h4Var.b().serialize(new p2(bufferedWriter, this.f22696b.getMaxDepth()), this.f22696b.getLogger());
            bufferedWriter.write("\n");
            for (j4 j4Var : h4Var.c()) {
                try {
                    byte[] bArrH = j4Var.h();
                    j4Var.i().serialize(new p2(bufferedWriter, this.f22696b.getMaxDepth()), this.f22696b.getLogger());
                    bufferedWriter.write("\n");
                    bufferedWriter.flush();
                    outputStream.write(bArrH);
                    bufferedWriter.write("\n");
                } catch (Exception e2) {
                    this.f22696b.getLogger().b(s4.ERROR, "Failed to create envelope item. Dropping it.", e2);
                }
            }
            bufferedWriter.flush();
        } catch (Throwable th) {
            bufferedWriter.flush();
            throw th;
        }
    }

    @Override // io.sentry.c2
    public <T> T c(Reader reader, Class<T> cls) {
        try {
            n2 n2Var = new n2(reader);
            try {
                l2<?> l2Var = this.f22697c.get(cls);
                if (l2Var != null) {
                    T tCast = cls.cast(l2Var.a(n2Var, this.f22696b.getLogger()));
                    n2Var.close();
                    return tCast;
                }
                if (!g(cls)) {
                    n2Var.close();
                    return null;
                }
                T t = (T) n2Var.K0();
                n2Var.close();
                return t;
            } catch (Throwable th) {
                try {
                    n2Var.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Exception e2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error when deserializing", e2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public h4 d(InputStream inputStream) {
        io.sentry.util.q.c(inputStream, "The InputStream object is required.");
        try {
            return this.f22696b.getEnvelopeReader().a(inputStream);
        } catch (IOException e2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error deserializing envelope.", e2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public <T, R> T e(Reader reader, Class<T> cls, l2<R> l2Var) {
        try {
            n2 n2Var = new n2(reader);
            try {
                if (!Collection.class.isAssignableFrom(cls)) {
                    T t = (T) n2Var.K0();
                    n2Var.close();
                    return t;
                }
                if (l2Var == null) {
                    T t2 = (T) n2Var.K0();
                    n2Var.close();
                    return t2;
                }
                T t3 = (T) n2Var.F0(this.f22696b.getLogger(), l2Var);
                n2Var.close();
                return t3;
            } catch (Throwable th) {
                try {
                    n2Var.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (Throwable th2) {
            this.f22696b.getLogger().b(s4.ERROR, "Error when deserializing", th2);
            return null;
        }
    }

    @Override // io.sentry.c2
    public String f(Map<String, Object> map) throws Exception {
        return h(map, false);
    }
}
