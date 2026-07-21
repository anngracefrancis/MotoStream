package c.l.b;

import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.y;
import androidx.datastore.preferences.protobuf.y0;
import java.util.List;

/* JADX INFO: compiled from: PreferencesProto.java */
/* JADX INFO: loaded from: classes.dex */
public final class g extends y<g, a> implements r0 {
    private static final g DEFAULT_INSTANCE;
    private static volatile y0<g> PARSER = null;
    public static final int STRINGS_FIELD_NUMBER = 1;
    private a0.i<String> strings_ = y.v();

    /* JADX INFO: compiled from: PreferencesProto.java */
    public static final class a extends y.a<g, a> implements r0 {
        /* synthetic */ a(e eVar) {
            this();
        }

        public a w(Iterable<String> iterable) {
            r();
            ((g) this.f1448g).L(iterable);
            return this;
        }

        private a() {
            super(g.DEFAULT_INSTANCE);
        }
    }

    static {
        g gVar = new g();
        DEFAULT_INSTANCE = gVar;
        y.H(g.class, gVar);
    }

    private g() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(Iterable<String> iterable) {
        M();
        androidx.datastore.preferences.protobuf.a.a(iterable, this.strings_);
    }

    private void M() {
        if (this.strings_.l1()) {
            return;
        }
        this.strings_ = y.C(this.strings_);
    }

    public static g N() {
        return DEFAULT_INSTANCE;
    }

    public static a P() {
        return DEFAULT_INSTANCE.r();
    }

    public List<String> O() {
        return this.strings_;
    }

    @Override // androidx.datastore.preferences.protobuf.y
    protected final Object u(y.f fVar, Object obj, Object obj2) {
        e eVar = null;
        switch (e.a[fVar.ordinal()]) {
            case 1:
                return new g();
            case 2:
                return new a(eVar);
            case 3:
                return y.E(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"strings_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                y0<g> bVar = PARSER;
                if (bVar == null) {
                    synchronized (g.class) {
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
