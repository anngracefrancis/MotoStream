package i.a.g.t.d;

import i.a.d;
import i.a.g.f;
import i.a.g.g;
import i.a.g.h;
import i.a.g.l;
import i.a.g.s.e;
import java.io.IOException;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ServiceResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f21906i;

    public c(l lVar, String str) {
        super(lVar);
        this.f21906i = str;
    }

    @Override // i.a.g.t.a
    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceResolver(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    @Override // i.a.g.t.d.a
    protected f g(f fVar) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        for (d dVar : e().y0().values()) {
            fVar = b(fVar, new h.e(dVar.s(), i.a.g.s.d.CLASS_IN, false, 3600, dVar.o()), jCurrentTimeMillis);
        }
        return fVar;
    }

    @Override // i.a.g.t.d.a
    protected f h(f fVar) throws IOException {
        return d(fVar, g.C(this.f21906i, e.TYPE_PTR, i.a.g.s.d.CLASS_IN, false));
    }

    @Override // i.a.g.t.d.a
    protected String i() {
        return "querying service";
    }
}
