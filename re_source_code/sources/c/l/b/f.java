package c.l.b;

import androidx.datastore.preferences.protobuf.j0;
import androidx.datastore.preferences.protobuf.k0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.r1;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.y0;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: PreferencesProto.java */
/* JADX INFO: loaded from: classes.dex */
public final class f extends y<f, a> implements r0 {
    private static final f DEFAULT_INSTANCE;
    private static volatile y0<f> PARSER = null;
    public static final int PREFERENCES_FIELD_NUMBER = 1;
    private k0<String, h> preferences_ = k0.f();

    /* JADX INFO: compiled from: PreferencesProto.java */
    public static final class a extends y.a<f, a> implements r0 {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a w(String str, h hVar) {
            str.getClass();
            hVar.getClass();
            r();
            ((f) this.f1448g).L().put(str, hVar);
            return this;
        }

        private a() {
            super(f.DEFAULT_INSTANCE);
        }
    }

    /* JADX INFO: compiled from: PreferencesProto.java */
    private static final class b {
        static final j0<String, h> a = j0.d(r1.b.n, HttpUrl.FRAGMENT_ENCODE_SET, r1.b.p, h.S());
    }

    static {
        f fVar = new f();
        DEFAULT_INSTANCE = fVar;
        y.H(f.class, fVar);
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, h> L() {
        return N();
    }

    private k0<String, h> N() {
        if (!this.preferences_.k()) {
            this.preferences_ = this.preferences_.n();
        }
        return this.preferences_;
    }

    private k0<String, h> O() {
        return this.preferences_;
    }

    public static a P() {
        return DEFAULT_INSTANCE.r();
    }

    public static f Q(InputStream inputStream) throws IOException {
        return (f) y.F(DEFAULT_INSTANCE, inputStream);
    }

    public Map<String, h> M() {
        return Collections.unmodifiableMap(O());
    }

    @Override // androidx.datastore.preferences.protobuf.y
    protected final Object u(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[fVar.ordinal()]) {
            case 1:
                return new f();
            case 2:
                return new a(eVar);
            case 3:
                return y.E(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", new Object[]{"preferences_", b.a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                y0<f> bVar = PARSER;
                if (bVar == null) {
                    synchronized (f.class) {
                        bVar = PARSER;
                        if (bVar == null) {
                            bVar = new y.b<>(DEFAULT_INSTANCE);
                            PARSER = bVar;
                        }
                        break;
                    }
                }
                return bVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
