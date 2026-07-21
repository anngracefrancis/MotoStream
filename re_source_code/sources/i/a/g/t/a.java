package i.a.g.t;

import com.google.android.gms.ads.AdRequest;
import i.a.g.f;
import i.a.g.g;
import i.a.g.h;
import i.a.g.l;
import java.io.IOException;
import java.util.TimerTask;

/* JADX INFO: compiled from: DNSTask.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends TimerTask {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final l f21896f;

    protected a(l lVar) {
        this.f21896f = lVar;
    }

    public f a(f fVar, i.a.g.c cVar, h hVar) throws IOException {
        try {
            fVar.x(cVar, hVar);
            return fVar;
        } catch (IOException unused) {
            int iE = fVar.e();
            boolean zO = fVar.o();
            int iE2 = fVar.E();
            int iF = fVar.f();
            fVar.v(iE | AdRequest.MAX_CONTENT_URL_LENGTH);
            fVar.w(iF);
            this.f21896f.x1(fVar);
            f fVar2 = new f(iE, zO, iE2);
            fVar2.x(cVar, hVar);
            return fVar2;
        }
    }

    public f b(f fVar, h hVar, long j2) throws IOException {
        try {
            fVar.y(hVar, j2);
            return fVar;
        } catch (IOException unused) {
            int iE = fVar.e();
            boolean zO = fVar.o();
            int iE2 = fVar.E();
            int iF = fVar.f();
            fVar.v(iE | AdRequest.MAX_CONTENT_URL_LENGTH);
            fVar.w(iF);
            this.f21896f.x1(fVar);
            f fVar2 = new f(iE, zO, iE2);
            fVar2.y(hVar, j2);
            return fVar2;
        }
    }

    public f c(f fVar, h hVar) throws IOException {
        try {
            fVar.z(hVar);
            return fVar;
        } catch (IOException unused) {
            int iE = fVar.e();
            boolean zO = fVar.o();
            int iE2 = fVar.E();
            int iF = fVar.f();
            fVar.v(iE | AdRequest.MAX_CONTENT_URL_LENGTH);
            fVar.w(iF);
            this.f21896f.x1(fVar);
            f fVar2 = new f(iE, zO, iE2);
            fVar2.z(hVar);
            return fVar2;
        }
    }

    public f d(f fVar, g gVar) throws IOException {
        try {
            fVar.A(gVar);
            return fVar;
        } catch (IOException unused) {
            int iE = fVar.e();
            boolean zO = fVar.o();
            int iE2 = fVar.E();
            int iF = fVar.f();
            fVar.v(iE | AdRequest.MAX_CONTENT_URL_LENGTH);
            fVar.w(iF);
            this.f21896f.x1(fVar);
            f fVar2 = new f(iE, zO, iE2);
            fVar2.A(gVar);
            return fVar2;
        }
    }

    public l e() {
        return this.f21896f;
    }

    public abstract String f();

    public String toString() {
        return f();
    }
}
