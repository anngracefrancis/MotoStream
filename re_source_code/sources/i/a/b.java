package i.a;

import i.a.g.o;
import java.net.InetAddress;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: NetworkTopologyDiscovery.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b {

    /* JADX INFO: compiled from: NetworkTopologyDiscovery.java */
    public static final class a {
        private static volatile b a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final AtomicReference<InterfaceC0303a> f21744b = new AtomicReference<>();

        /* JADX INFO: renamed from: i.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NetworkTopologyDiscovery.java */
        public interface InterfaceC0303a {
            b a();
        }

        private a() {
        }

        public static b a() {
            if (a == null) {
                synchronized (a.class) {
                    if (a == null) {
                        a = b();
                    }
                }
            }
            return a;
        }

        protected static b b() {
            InterfaceC0303a interfaceC0303a = f21744b.get();
            b bVarA = interfaceC0303a != null ? interfaceC0303a.a() : null;
            return bVarA != null ? bVarA : new o();
        }
    }

    InetAddress[] a();
}
