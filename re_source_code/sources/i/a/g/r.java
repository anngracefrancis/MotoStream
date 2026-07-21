package i.a.g;

import java.io.IOException;
import java.net.DatagramPacket;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: SocketListener.java */
/* JADX INFO: loaded from: classes2.dex */
class r extends Thread {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static k.b.b f21852f = k.b.c.i(r.class.getName());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final l f21853g;

    r(l lVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("SocketListener(");
        sb.append(lVar != null ? lVar.p0() : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(")");
        super(sb.toString());
        setDaemon(true);
        this.f21853g = lVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            DatagramPacket datagramPacket = new DatagramPacket(new byte[8972], 8972);
            while (!this.f21853g.X0() && !this.f21853g.V0()) {
                datagramPacket.setLength(8972);
                this.f21853g.E0().receive(datagramPacket);
                if (this.f21853g.X0() || this.f21853g.V0() || this.f21853g.Z0() || this.f21853g.isClosed()) {
                    break;
                }
                try {
                    if (!this.f21853g.n0().E(datagramPacket)) {
                        c cVar = new c(datagramPacket);
                        if (cVar.s()) {
                            if (f21852f.d()) {
                                f21852f.i(getName() + ".run() JmDNS in:" + cVar.C(true));
                            }
                            if (cVar.p()) {
                                int port = datagramPacket.getPort();
                                int i2 = i.a.g.s.a.a;
                                if (port != i2) {
                                    this.f21853g.G0(cVar, datagramPacket.getAddress(), datagramPacket.getPort());
                                }
                                l lVar = this.f21853g;
                                lVar.G0(cVar, lVar.f0(), i2);
                            } else {
                                this.f21853g.K0(cVar);
                            }
                        } else if (f21852f.b()) {
                            f21852f.c(getName() + ".run() JmDNS in message with error code:" + cVar.C(true));
                        }
                    }
                } catch (IOException e2) {
                    f21852f.f(getName() + ".run() exception ", e2);
                }
            }
        } catch (IOException e3) {
            if (!this.f21853g.X0() && !this.f21853g.V0() && !this.f21853g.Z0() && !this.f21853g.isClosed()) {
                f21852f.f(getName() + ".run() exception ", e3);
                this.f21853g.h1();
            }
        }
        if (f21852f.d()) {
            f21852f.i(getName() + ".run() exiting.");
        }
    }
}
