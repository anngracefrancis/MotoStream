package i.a.g.t.d;

import i.a.g.f;
import i.a.g.g;
import i.a.g.h;
import i.a.g.l;
import i.a.g.q;
import i.a.g.s.d;
import i.a.g.s.e;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: ServiceInfoResolver.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final q f21905i;

    public b(l lVar, q qVar) {
        super(lVar);
        this.f21905i = qVar;
        qVar.c0(e());
        e().I(qVar, g.C(qVar.o(), e.TYPE_ANY, d.CLASS_IN, false));
    }

    @Override // java.util.TimerTask
    public boolean cancel() {
        boolean zCancel = super.cancel();
        if (!this.f21905i.w()) {
            e().r1(this.f21905i);
        }
        return zCancel;
    }

    @Override // i.a.g.t.a
    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append("ServiceInfoResolver(");
        sb.append(e() != null ? e().p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        return sb.toString();
    }

    @Override // i.a.g.t.d.a
    protected f g(f fVar) throws IOException {
        if (!this.f21905i.u()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            i.a.g.a aVarZ = e().Z();
            String strO = this.f21905i.o();
            e eVar = e.TYPE_SRV;
            d dVar = d.CLASS_IN;
            fVar = b(b(fVar, (h) aVarZ.d(strO, eVar, dVar), jCurrentTimeMillis), (h) e().Z().d(this.f21905i.o(), e.TYPE_TXT, dVar), jCurrentTimeMillis);
            if (this.f21905i.p().length() > 0) {
                Iterator<? extends i.a.g.b> it = e().Z().h(this.f21905i.p(), e.TYPE_A, dVar).iterator();
                while (it.hasNext()) {
                    fVar = b(fVar, (h) it.next(), jCurrentTimeMillis);
                }
                Iterator<? extends i.a.g.b> it2 = e().Z().h(this.f21905i.p(), e.TYPE_AAAA, d.CLASS_IN).iterator();
                while (it2.hasNext()) {
                    fVar = b(fVar, (h) it2.next(), jCurrentTimeMillis);
                }
            }
        }
        return fVar;
    }

    @Override // i.a.g.t.d.a
    protected f h(f fVar) throws IOException {
        if (this.f21905i.u()) {
            return fVar;
        }
        String strO = this.f21905i.o();
        e eVar = e.TYPE_SRV;
        d dVar = d.CLASS_IN;
        f fVarD = d(d(fVar, g.C(strO, eVar, dVar, false)), g.C(this.f21905i.o(), e.TYPE_TXT, dVar, false));
        return this.f21905i.p().length() > 0 ? d(d(fVarD, g.C(this.f21905i.p(), e.TYPE_A, dVar, false)), g.C(this.f21905i.p(), e.TYPE_AAAA, dVar, false)) : fVarD;
    }

    @Override // i.a.g.t.d.a
    protected String i() {
        StringBuilder sb = new StringBuilder();
        sb.append("querying service info: ");
        q qVar = this.f21905i;
        sb.append(qVar != null ? qVar.o() : "null");
        return sb.toString();
    }
}
