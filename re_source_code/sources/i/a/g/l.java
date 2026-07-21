package i.a.g;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JmDNSImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class l extends i.a.a implements i.a.g.i, i.a.g.j {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static k.b.b f21801g = k.b.c.i(l.class.getName());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Random f21802h = new Random();
    private final String A;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile InetAddress f21803i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile MulticastSocket f21804j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final List<i.a.g.d> f21805k;
    final ConcurrentMap<String, List<m.a>> l;
    private final Set<m.b> m;
    private final i.a.g.a n;
    private final ConcurrentMap<String, i.a.d> o;
    private final ConcurrentMap<String, j> p;
    private volatile i.a.a.InterfaceC0302a q;
    protected Thread r;
    private k s;
    private Thread t;
    private int u;
    private long v;
    private i.a.g.c y;
    private final ConcurrentMap<String, i> z;
    private final ExecutorService w = Executors.newSingleThreadExecutor(new i.a.g.u.a("JmDNS"));
    private final ReentrantLock x = new ReentrantLock();
    private final Object B = new Object();

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class a implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m.a f21806f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i.a.c f21807g;

        a(m.a aVar, i.a.c cVar) {
            this.f21806f = aVar;
            this.f21807g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21806f.f(this.f21807g);
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class b implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m.b f21809f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i.a.c f21810g;

        b(m.b bVar, i.a.c cVar) {
            this.f21809f = bVar;
            this.f21810g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21809f.c(this.f21810g);
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m.b f21812f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i.a.c f21813g;

        c(m.b bVar, i.a.c cVar) {
            this.f21812f = bVar;
            this.f21813g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21812f.d(this.f21813g);
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class d implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m.a f21815f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i.a.c f21816g;

        d(m.a aVar, i.a.c cVar) {
            this.f21815f = aVar;
            this.f21816g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21815f.d(this.f21816g);
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ m.a f21818f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ i.a.c f21819g;

        e(m.a aVar, i.a.c cVar) {
            this.f21818f = aVar;
            this.f21819g = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f21818f.e(this.f21819g);
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    class f extends Thread {
        f(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            l.this.D();
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    static /* synthetic */ class g {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.values().length];
            a = iArr;
            try {
                iArr[h.Add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[h.Remove.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    public enum h {
        Remove,
        Update,
        Add,
        RegisterServiceType,
        Noop
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    private static class i implements i.a.e {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21829c;
        private final ConcurrentMap<String, i.a.d> a = new ConcurrentHashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<String, i.a.c> f21828b = new ConcurrentHashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private volatile boolean f21830d = true;

        public i(String str) {
            this.f21829c = str;
        }

        @Override // i.a.e
        public void serviceAdded(i.a.c cVar) {
            synchronized (this) {
                i.a.d dVarE = cVar.e();
                if (dVarE == null || !dVarE.u()) {
                    q qVarU1 = ((l) cVar.d()).u1(cVar.g(), cVar.f(), dVarE != null ? dVarE.q() : HttpUrl.FRAGMENT_ENCODE_SET, true);
                    if (qVarU1 != null) {
                        this.a.put(cVar.f(), qVarU1);
                    } else {
                        this.f21828b.put(cVar.f(), cVar);
                    }
                } else {
                    this.a.put(cVar.f(), dVarE);
                }
            }
        }

        @Override // i.a.e
        public void serviceRemoved(i.a.c cVar) {
            synchronized (this) {
                this.a.remove(cVar.f());
                this.f21828b.remove(cVar.f());
            }
        }

        @Override // i.a.e
        public void serviceResolved(i.a.c cVar) {
            synchronized (this) {
                this.a.put(cVar.f(), cVar.e());
                this.f21828b.remove(cVar.f());
            }
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("\n\tType: ");
            stringBuffer.append(this.f21829c);
            if (this.a.isEmpty()) {
                stringBuffer.append("\n\tNo services collected.");
            } else {
                stringBuffer.append("\n\tServices");
                for (String str : this.a.keySet()) {
                    stringBuffer.append("\n\t\tService: ");
                    stringBuffer.append(str);
                    stringBuffer.append(": ");
                    stringBuffer.append(this.a.get(str));
                }
            }
            if (this.f21828b.isEmpty()) {
                stringBuffer.append("\n\tNo event queued.");
            } else {
                stringBuffer.append("\n\tEvents");
                for (String str2 : this.f21828b.keySet()) {
                    stringBuffer.append("\n\t\tEvent: ");
                    stringBuffer.append(str2);
                    stringBuffer.append(": ");
                    stringBuffer.append(this.f21828b.get(str2));
                }
            }
            return stringBuffer.toString();
        }
    }

    /* JADX INFO: compiled from: JmDNSImpl.java */
    public static class j extends AbstractMap<String, String> implements Cloneable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Set<Map.Entry<String, String>> f21831f = new HashSet();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f21832g;

        /* JADX INFO: compiled from: JmDNSImpl.java */
        private static class a implements Map.Entry<String, String>, Serializable, Cloneable {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final String f21833f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final String f21834g;

            public a(String str) {
                str = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
                this.f21834g = str;
                this.f21833f = str.toLowerCase();
            }

            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public a clone() {
                return this;
            }

            @Override // java.util.Map.Entry
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public String getKey() {
                return this.f21833f;
            }

            @Override // java.util.Map.Entry
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public String getValue() {
                return this.f21834g;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return getKey().equals(entry.getKey()) && getValue().equals(entry.getValue());
            }

            @Override // java.util.Map.Entry
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public String setValue(String str) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                String str = this.f21833f;
                int iHashCode = str == null ? 0 : str.hashCode();
                String str2 = this.f21834g;
                return iHashCode ^ (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return this.f21833f + "=" + this.f21834g;
            }
        }

        public j(String str) {
            this.f21832g = str;
        }

        public boolean b(String str) {
            if (str == null || e(str)) {
                return false;
            }
            this.f21831f.add(new a(str));
            return true;
        }

        @Override // java.util.AbstractMap
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public j clone() {
            j jVar = new j(f());
            Iterator<Map.Entry<String, String>> it = entrySet().iterator();
            while (it.hasNext()) {
                jVar.b(it.next().getValue());
            }
            return jVar;
        }

        public boolean e(String str) {
            return str != null && containsKey(str.toLowerCase());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set<Map.Entry<String, String>> entrySet() {
            return this.f21831f;
        }

        public String f() {
            return this.f21832g;
        }

        @Override // java.util.AbstractMap
        public String toString() {
            StringBuilder sb = new StringBuilder(200);
            if (isEmpty()) {
                sb.append("empty");
            } else {
                Iterator<String> it = values().iterator();
                while (it.hasNext()) {
                    sb.append(it.next());
                    sb.append(", ");
                }
                sb.setLength(sb.length() - 2);
            }
            return sb.toString();
        }
    }

    public l(InetAddress inetAddress, String str) throws IOException {
        if (f21801g.b()) {
            f21801g.c("JmDNS instance created");
        }
        this.n = new i.a.g.a(100);
        this.f21805k = Collections.synchronizedList(new ArrayList());
        this.l = new ConcurrentHashMap();
        this.m = Collections.synchronizedSet(new HashSet());
        this.z = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap(20);
        this.p = new ConcurrentHashMap(20);
        k kVarA = k.A(inetAddress, this, str);
        this.s = kVarA;
        this.A = str == null ? kVarA.q() : str;
        f1(n0());
        A1(y0().values());
        j();
    }

    private void A1(Collection<? extends i.a.d> collection) {
        if (this.t == null) {
            r rVar = new r(this);
            this.t = rVar;
            rVar.start();
        }
        k();
        Iterator<? extends i.a.d> it = collection.iterator();
        while (it.hasNext()) {
            try {
                l1(new q(it.next()));
            } catch (Exception e2) {
                f21801g.f("start() Registration exception ", e2);
            }
        }
    }

    static String B1(String str, String str2) {
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        return (!lowerCase2.endsWith(lowerCase) || lowerCase2.equals(lowerCase)) ? str2 : str2.substring(0, (str2.length() - str.length()) - 1);
    }

    private List<i.a.g.h> H(List<i.a.g.h> list) {
        ArrayList arrayList = new ArrayList(list.size());
        ArrayList arrayList2 = new ArrayList();
        for (i.a.g.h hVar : list) {
            if (hVar.f().equals(i.a.g.s.e.TYPE_A) || hVar.f().equals(i.a.g.s.e.TYPE_AAAA)) {
                arrayList2.add(hVar);
            } else {
                arrayList.add(hVar);
            }
        }
        arrayList.addAll(arrayList2);
        return arrayList;
    }

    private void J(String str, i.a.e eVar, boolean z) {
        m.a aVar = new m.a(eVar, z);
        String lowerCase = str.toLowerCase();
        List<m.a> list = this.l.get(lowerCase);
        if (list == null) {
            if (this.l.putIfAbsent(lowerCase, new LinkedList()) == null && this.z.putIfAbsent(lowerCase, new i(str)) == null) {
                J(lowerCase, this.z.get(lowerCase), true);
            }
            list = this.l.get(lowerCase);
        }
        if (list != null) {
            synchronized (list) {
                if (!list.contains(aVar)) {
                    list.add(aVar);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<i.a.g.b> it = Z().c().iterator();
        while (it.hasNext()) {
            i.a.g.h hVar = (i.a.g.h) it.next();
            if (hVar.f() == i.a.g.s.e.TYPE_SRV && hVar.b().endsWith(lowerCase)) {
                arrayList.add(new p(this, hVar.h(), B1(hVar.h(), hVar.c()), hVar.C()));
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            aVar.d((i.a.c) it2.next());
        }
        c(str);
    }

    private void T() {
        if (f21801g.b()) {
            f21801g.c("closeMulticastSocket()");
        }
        if (this.f21804j != null) {
            try {
                try {
                    this.f21804j.leaveGroup(this.f21803i);
                    while (true) {
                        Thread thread = this.t;
                        if (thread == null || !thread.isAlive()) {
                            break;
                        }
                        synchronized (this) {
                            try {
                                Thread thread2 = this.t;
                                if (thread2 != null && thread2.isAlive()) {
                                    if (f21801g.b()) {
                                        f21801g.c("closeMulticastSocket(): waiting for jmDNS monitor");
                                    }
                                    wait(1000L);
                                }
                            } catch (InterruptedException unused) {
                            }
                        }
                    }
                } catch (Exception e2) {
                    f21801g.f("closeMulticastSocket() Close socket exception ", e2);
                }
            } catch (SocketException unused2) {
            }
            this.f21804j.close();
            this.t = null;
            this.f21804j = null;
        }
    }

    private void Y() {
        if (f21801g.b()) {
            f21801g.c("disposeServiceCollectors()");
        }
        for (String str : this.z.keySet()) {
            i iVar = this.z.get(str);
            if (iVar != null) {
                s1(str, iVar);
                this.z.remove(str, iVar);
            }
        }
    }

    private boolean c1(q qVar) {
        boolean z;
        String strL = qVar.L();
        long jCurrentTimeMillis = System.currentTimeMillis();
        do {
            z = false;
            for (i.a.g.b bVar : Z().f(qVar.L())) {
                if (i.a.g.s.e.TYPE_SRV.equals(bVar.f()) && !bVar.j(jCurrentTimeMillis)) {
                    i.a.g.h.f fVar = (i.a.g.h.f) bVar;
                    if (fVar.T() != qVar.l() || !fVar.V().equals(this.s.q())) {
                        if (f21801g.b()) {
                            f21801g.c("makeServiceNameUnique() JmDNS.makeServiceNameUnique srv collision:" + bVar + " s.server=" + fVar.V() + " " + this.s.q() + " equals:" + fVar.V().equals(this.s.q()));
                        }
                        qVar.d0(n.c.a().a(this.s.o(), qVar.k(), n.d.SERVICE));
                        z = true;
                        break;
                    }
                }
            }
            i.a.d dVar = this.o.get(qVar.L());
            if (dVar != null && dVar != qVar) {
                qVar.d0(n.c.a().a(this.s.o(), qVar.k(), n.d.SERVICE));
                z = true;
            }
        } while (z);
        return !strL.equals(qVar.L());
    }

    private void f1(k kVar) throws IOException {
        if (this.f21803i == null) {
            if (kVar.o() instanceof Inet6Address) {
                this.f21803i = InetAddress.getByName("FF02::FB");
            } else {
                this.f21803i = InetAddress.getByName("224.0.0.251");
            }
        }
        if (this.f21804j != null) {
            T();
        }
        this.f21804j = new MulticastSocket(i.a.g.s.a.a);
        if (kVar != null && kVar.p() != null) {
            try {
                this.f21804j.setNetworkInterface(kVar.p());
            } catch (SocketException e2) {
                if (f21801g.b()) {
                    f21801g.c("openMulticastSocket() Set network interface exception: " + e2.getMessage());
                }
            }
        }
        this.f21804j.setTimeToLive(255);
        this.f21804j.joinGroup(this.f21803i);
    }

    public static Random q0() {
        return f21802h;
    }

    @Override // i.a.a
    public void B() {
        if (f21801g.b()) {
            f21801g.c("unregisterAllServices()");
        }
        Iterator<String> it = this.o.keySet().iterator();
        while (it.hasNext()) {
            q qVar = (q) this.o.get(it.next());
            if (qVar != null) {
                if (f21801g.b()) {
                    f21801g.c("Cancelling service info: " + qVar);
                }
                qVar.F();
            }
        }
        f();
        for (String str : this.o.keySet()) {
            q qVar2 = (q) this.o.get(str);
            if (qVar2 != null) {
                if (f21801g.b()) {
                    f21801g.c("Wait for service info cancel: " + qVar2);
                }
                qVar2.k0(5000L);
                this.o.remove(str, qVar2);
            }
        }
    }

    public void C1(long j2, i.a.g.h hVar, h hVar2) {
        ArrayList arrayList;
        List<m.a> listEmptyList;
        synchronized (this.f21805k) {
            arrayList = new ArrayList(this.f21805k);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((i.a.g.d) it.next()).b(Z(), j2, hVar);
        }
        if (i.a.g.s.e.TYPE_PTR.equals(hVar.f())) {
            i.a.c cVarB = hVar.B(this);
            if (cVarB.e() == null || !cVarB.e().u()) {
                q qVarT0 = t0(cVarB.g(), cVarB.f(), HttpUrl.FRAGMENT_ENCODE_SET, false);
                if (qVarT0.u()) {
                    cVarB = new p(this, cVarB.g(), cVarB.f(), qVarT0);
                }
            }
            List<m.a> list = this.l.get(cVarB.g().toLowerCase());
            if (list != null) {
                synchronized (list) {
                    listEmptyList = new ArrayList(list);
                }
            } else {
                listEmptyList = Collections.emptyList();
            }
            if (f21801g.d()) {
                f21801g.i(p0() + ".updating record for event: " + cVarB + " list " + listEmptyList + " operation: " + hVar2);
            }
            if (listEmptyList.isEmpty()) {
                return;
            }
            int i2 = g.a[hVar2.ordinal()];
            if (i2 == 1) {
                for (m.a aVar : listEmptyList) {
                    if (aVar.b()) {
                        aVar.d(cVarB);
                    } else {
                        this.w.submit(new d(aVar, cVarB));
                    }
                }
                return;
            }
            if (i2 != 2) {
                return;
            }
            for (m.a aVar2 : listEmptyList) {
                if (aVar2.b()) {
                    aVar2.e(cVarB);
                } else {
                    this.w.submit(new e(aVar2, cVarB));
                }
            }
        }
    }

    void D() {
        if (f21801g.b()) {
            f21801g.c(p0() + "recover() Cleanning up");
        }
        f21801g.h("RECOVERING");
        a();
        ArrayList arrayList = new ArrayList(y0().values());
        B();
        Y();
        E1(5000L);
        p();
        T();
        Z().clear();
        if (f21801g.b()) {
            f21801g.c(p0() + "recover() All is clean");
        }
        if (!V0()) {
            f21801g.h(p0() + "recover() Could not recover we are Down!");
            if (a0() != null) {
                a0().a(e0(), arrayList);
                return;
            }
            return;
        }
        Iterator<i.a.d> it = arrayList.iterator();
        while (it.hasNext()) {
            ((q) it.next()).X();
        }
        k1();
        try {
            f1(n0());
            A1(arrayList);
        } catch (Exception e2) {
            f21801g.f(p0() + "recover() Start services exception ", e2);
        }
        f21801g.h(p0() + "recover() We are back!");
    }

    public boolean D1(long j2) {
        return this.s.F(j2);
    }

    public MulticastSocket E0() {
        return this.f21804j;
    }

    public boolean E1(long j2) {
        return this.s.G(j2);
    }

    public int F0() {
        return this.u;
    }

    void G0(i.a.g.c cVar, InetAddress inetAddress, int i2) throws IOException {
        if (f21801g.b()) {
            f21801g.c(p0() + ".handle query: " + cVar);
        }
        boolean zF = false;
        long jCurrentTimeMillis = System.currentTimeMillis() + 120;
        Iterator<i.a.g.h> it = cVar.b().iterator();
        while (it.hasNext()) {
            zF |= it.next().F(this, jCurrentTimeMillis);
        }
        N0();
        try {
            i.a.g.c cVar2 = this.y;
            if (cVar2 != null) {
                cVar2.y(cVar);
            } else {
                i.a.g.c cVarZ = cVar.clone();
                if (cVar.r()) {
                    this.y = cVarZ;
                }
                m(cVarZ, inetAddress, i2);
            }
            Q0();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            Iterator<? extends i.a.g.h> it2 = cVar.c().iterator();
            while (it2.hasNext()) {
                J0(it2.next(), jCurrentTimeMillis2);
            }
            if (zF) {
                k();
            }
        } catch (Throwable th) {
            Q0();
            throw th;
        }
    }

    public void I(i.a.g.d dVar, i.a.g.g gVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f21805k.add(dVar);
        if (gVar != null) {
            for (i.a.g.b bVar : Z().f(gVar.c().toLowerCase())) {
                if (gVar.A(bVar) && !bVar.j(jCurrentTimeMillis)) {
                    dVar.b(Z(), jCurrentTimeMillis, bVar);
                }
            }
        }
    }

    void J0(i.a.g.h hVar, long j2) {
        h hVar2 = h.Noop;
        boolean zJ = hVar.j(j2);
        if (f21801g.b()) {
            f21801g.c(p0() + " handle response: " + hVar);
        }
        if (!hVar.o() && !hVar.i()) {
            boolean zP = hVar.p();
            i.a.g.h hVar3 = (i.a.g.h) Z().e(hVar);
            if (f21801g.b()) {
                f21801g.c(p0() + " handle response cached record: " + hVar3);
            }
            if (zP) {
                for (i.a.g.b bVar : Z().f(hVar.b())) {
                    if (hVar.f().equals(bVar.f()) && hVar.e().equals(bVar.e()) && bVar != hVar3) {
                        ((i.a.g.h) bVar).P(j2);
                    }
                }
            }
            if (hVar3 != null) {
                if (zJ) {
                    if (hVar.E() == 0) {
                        hVar2 = h.Noop;
                        hVar3.P(j2);
                    } else {
                        hVar2 = h.Remove;
                        Z().i(hVar3);
                    }
                } else if (hVar.N(hVar3) && (hVar.u(hVar3) || hVar.g().length() <= 0)) {
                    hVar3.L(hVar);
                    hVar = hVar3;
                } else if (hVar.I()) {
                    hVar2 = h.Update;
                    Z().j(hVar, hVar3);
                } else {
                    hVar2 = h.Add;
                    Z().b(hVar);
                }
            } else if (!zJ) {
                hVar2 = h.Add;
                Z().b(hVar);
            }
        }
        if (hVar.f() == i.a.g.s.e.TYPE_PTR) {
            if (hVar.o()) {
                if (zJ) {
                    return;
                }
                n1(((i.a.g.h.e) hVar).T());
                return;
            } else if ((n1(hVar.c()) | false) && hVar2 == h.Noop) {
                hVar2 = h.RegisterServiceType;
            }
        }
        if (hVar2 != h.Noop) {
            C1(j2, hVar, hVar2);
        }
    }

    public void K(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        this.s.b(aVar, gVar);
    }

    void K0(i.a.g.c cVar) throws IOException {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean zG = false;
        boolean zG2 = false;
        for (i.a.g.h hVar : H(cVar.b())) {
            J0(hVar, jCurrentTimeMillis);
            if (i.a.g.s.e.TYPE_A.equals(hVar.f()) || i.a.g.s.e.TYPE_AAAA.equals(hVar.f())) {
                zG |= hVar.G(this);
            } else {
                zG2 |= hVar.G(this);
            }
        }
        if (zG || zG2) {
            k();
        }
    }

    void M0(i.a.c cVar) {
        ArrayList arrayList;
        List<m.a> list = this.l.get(cVar.g().toLowerCase());
        if (list == null || list.isEmpty() || cVar.e() == null || !cVar.e().u()) {
            return;
        }
        synchronized (list) {
            arrayList = new ArrayList(list);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.w.submit(new a((m.a) it.next(), cVar));
        }
    }

    public boolean N() {
        return this.s.c();
    }

    public void N0() {
        this.x.lock();
    }

    public void Q() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        HashSet hashSet = new HashSet();
        for (i.a.g.b bVar : Z().c()) {
            try {
                i.a.g.h hVar = (i.a.g.h) bVar;
                if (hVar.j(jCurrentTimeMillis)) {
                    C1(jCurrentTimeMillis, hVar, h.Remove);
                    Z().i(hVar);
                } else if (hVar.K(jCurrentTimeMillis)) {
                    hVar.H();
                    String lowerCase = hVar.C().s().toLowerCase();
                    if (hashSet.add(lowerCase)) {
                        t1(lowerCase);
                    }
                }
            } catch (Exception e2) {
                f21801g.f(p0() + ".Error while reaping records: " + bVar, e2);
                f21801g.h(toString());
            }
        }
    }

    public void Q0() {
        this.x.unlock();
    }

    public boolean R0() {
        return this.s.s();
    }

    public boolean T0(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        return this.s.t(aVar, gVar);
    }

    public boolean V0() {
        return this.s.u();
    }

    public boolean W() {
        return this.s.e();
    }

    public boolean X0() {
        return this.s.v();
    }

    public i.a.g.a Z() {
        return this.n;
    }

    public boolean Z0() {
        return this.s.x();
    }

    @Override // i.a.g.j
    public void a() {
        i.a.g.j.b.b().c(e0()).a();
    }

    public i.a.a.InterfaceC0302a a0() {
        return this.q;
    }

    public boolean a1() {
        return this.s.y();
    }

    @Override // i.a.g.j
    public void b() {
        i.a.g.j.b.b().c(e0()).b();
    }

    @Override // i.a.g.j
    public void c(String str) {
        i.a.g.j.b.b().c(e0()).c(str);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (Z0()) {
            return;
        }
        if (f21801g.b()) {
            f21801g.c("Cancelling JmDNS: " + this);
        }
        if (W()) {
            f21801g.c("Canceling the timer");
            e();
            B();
            Y();
            if (f21801g.b()) {
                f21801g.c("Wait for JmDNS cancel: " + this);
            }
            E1(5000L);
            f21801g.c("Canceling the state timer");
            b();
            this.w.shutdown();
            T();
            if (this.r != null) {
                Runtime.getRuntime().removeShutdownHook(this.r);
            }
            i.a.g.j.b.b().a(e0());
            if (f21801g.b()) {
                f21801g.c("JmDNS closed.");
            }
        }
        d(null);
    }

    @Override // i.a.g.i
    public boolean d(i.a.g.t.a aVar) {
        return this.s.d(aVar);
    }

    @Override // i.a.g.j
    public void e() {
        i.a.g.j.b.b().c(e0()).e();
    }

    public l e0() {
        return this;
    }

    @Override // i.a.g.j
    public void f() {
        i.a.g.j.b.b().c(e0()).f();
    }

    public InetAddress f0() {
        return this.f21803i;
    }

    public void h1() {
        f21801g.c(p0() + "recover()");
        if (Z0() || isClosed() || X0() || V0()) {
            return;
        }
        synchronized (this.B) {
            if (N()) {
                f21801g.c(p0() + "recover() thread " + Thread.currentThread().getName());
                StringBuilder sb = new StringBuilder();
                sb.append(p0());
                sb.append(".recover()");
                new f(sb.toString()).start();
            }
        }
    }

    public InetAddress i0() throws IOException {
        return this.s.o();
    }

    public boolean isClosed() {
        return this.s.w();
    }

    @Override // i.a.g.j
    public void j() {
        i.a.g.j.b.b().c(e0()).j();
    }

    @Override // i.a.g.j
    public void k() {
        i.a.g.j.b.b().c(e0()).k();
    }

    public boolean k1() {
        return this.s.B();
    }

    @Override // i.a.g.j
    public void l() {
        i.a.g.j.b.b().c(e0()).l();
    }

    public void l1(i.a.d dVar) throws IOException {
        if (Z0() || isClosed()) {
            throw new IllegalStateException("This DNS is closed.");
        }
        q qVar = (q) dVar;
        if (qVar.K() != null) {
            if (qVar.K() != this) {
                throw new IllegalStateException("A service information can only be registered with a single instamce of JmDNS.");
            }
            if (this.o.get(qVar.L()) != null) {
                throw new IllegalStateException("A service information can only be registered once.");
            }
        }
        qVar.c0(this);
        n1(qVar.O());
        qVar.X();
        qVar.g0(this.s.q());
        qVar.B(this.s.m());
        qVar.C(this.s.n());
        D1(6000L);
        c1(qVar);
        while (this.o.putIfAbsent(qVar.L(), qVar) != null) {
            c1(qVar);
        }
        k();
        qVar.j0(6000L);
        if (f21801g.b()) {
            f21801g.c("registerService() JmDNS registered service as " + qVar);
        }
    }

    @Override // i.a.g.j
    public void m(i.a.g.c cVar, InetAddress inetAddress, int i2) {
        i.a.g.j.b.b().c(e0()).m(cVar, inetAddress, i2);
    }

    public long m0() {
        return this.v;
    }

    public k n0() {
        return this.s;
    }

    public boolean n1(String str) {
        boolean z;
        j jVar;
        Map<i.a.d.a, String> mapJ = q.J(str);
        String str2 = mapJ.get(i.a.d.a.Domain);
        String str3 = mapJ.get(i.a.d.a.Protocol);
        String str4 = mapJ.get(i.a.d.a.Application);
        String str5 = mapJ.get(i.a.d.a.Subtype);
        StringBuilder sb = new StringBuilder();
        sb.append(str4.length() > 0 ? "_" + str4 + "." : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(str3.length() > 0 ? "_" + str3 + "." : HttpUrl.FRAGMENT_ENCODE_SET);
        sb.append(str2);
        sb.append(".");
        String string = sb.toString();
        String lowerCase = string.toLowerCase();
        if (f21801g.b()) {
            k.b.b bVar = f21801g;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(p0());
            sb2.append(".registering service type: ");
            sb2.append(str);
            sb2.append(" as: ");
            sb2.append(string);
            sb2.append(str5.length() > 0 ? " subtype: " + str5 : HttpUrl.FRAGMENT_ENCODE_SET);
            bVar.c(sb2.toString());
        }
        boolean z2 = true;
        if (this.p.containsKey(lowerCase) || str4.toLowerCase().equals("dns-sd") || str2.toLowerCase().endsWith("in-addr.arpa") || str2.toLowerCase().endsWith("ip6.arpa")) {
            z = false;
        } else {
            z = this.p.putIfAbsent(lowerCase, new j(string)) == null;
            if (z) {
                Set<m.b> set = this.m;
                m.b[] bVarArr = (m.b[]) set.toArray(new m.b[set.size()]);
                p pVar = new p(this, string, HttpUrl.FRAGMENT_ENCODE_SET, null);
                for (m.b bVar2 : bVarArr) {
                    this.w.submit(new b(bVar2, pVar));
                }
            }
        }
        if (str5.length() <= 0 || (jVar = this.p.get(lowerCase)) == null || jVar.e(str5)) {
            return z;
        }
        synchronized (jVar) {
            if (jVar.e(str5)) {
                z2 = z;
            } else {
                jVar.b(str5);
                Set<m.b> set2 = this.m;
                m.b[] bVarArr2 = (m.b[]) set2.toArray(new m.b[set2.size()]);
                p pVar2 = new p(this, "_" + str5 + "._sub." + string, HttpUrl.FRAGMENT_ENCODE_SET, null);
                for (m.b bVar3 : bVarArr2) {
                    this.w.submit(new c(bVar3, pVar2));
                }
            }
        }
        return z2;
    }

    @Override // i.a.g.j
    public void p() {
        i.a.g.j.b.b().c(e0()).p();
    }

    public String p0() {
        return this.A;
    }

    public void q1(i.a.g.t.a aVar) {
        this.s.C(aVar);
    }

    public void r1(i.a.g.d dVar) {
        this.f21805k.remove(dVar);
    }

    public void s1(String str, i.a.e eVar) {
        String lowerCase = str.toLowerCase();
        List<m.a> list = this.l.get(lowerCase);
        if (list != null) {
            synchronized (list) {
                list.remove(new m.a(eVar, false));
                if (list.isEmpty()) {
                    this.l.remove(lowerCase, list);
                }
            }
        }
    }

    q t0(String str, String str2, String str3, boolean z) {
        q qVar;
        q qVar2;
        String strP;
        i.a.d dVarD;
        i.a.d dVarD2;
        i.a.d dVarD3;
        i.a.d dVarD4;
        q qVar3 = new q(str, str2, str3, 0, 0, 0, z, null);
        i.a.g.a aVarZ = Z();
        i.a.g.s.d dVar = i.a.g.s.d.CLASS_ANY;
        i.a.g.b bVarE = aVarZ.e(new i.a.g.h.e(str, dVar, false, 0, qVar3.o()));
        if (!(bVarE instanceof i.a.g.h) || (qVar = (q) ((i.a.g.h) bVarE).D(z)) == null) {
            return qVar3;
        }
        Map<i.a.d.a, String> mapN = qVar.N();
        byte[] bArrR = null;
        i.a.g.b bVarD = Z().d(qVar3.o(), i.a.g.s.e.TYPE_SRV, dVar);
        if (!(bVarD instanceof i.a.g.h) || (dVarD4 = ((i.a.g.h) bVarD).D(z)) == null) {
            qVar2 = qVar;
            strP = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            qVar2 = new q(mapN, dVarD4.l(), dVarD4.t(), dVarD4.m(), z, (byte[]) null);
            bArrR = dVarD4.r();
            strP = dVarD4.p();
        }
        Iterator<? extends i.a.g.b> it = Z().h(strP, i.a.g.s.e.TYPE_A, dVar).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            i.a.g.b next = it.next();
            if ((next instanceof i.a.g.h) && (dVarD3 = ((i.a.g.h) next).D(z)) != null) {
                for (Inet4Address inet4Address : dVarD3.h()) {
                    qVar2.B(inet4Address);
                }
                qVar2.A(dVarD3.r());
            }
        }
        for (i.a.g.b bVar : Z().h(strP, i.a.g.s.e.TYPE_AAAA, i.a.g.s.d.CLASS_ANY)) {
            if ((bVar instanceof i.a.g.h) && (dVarD2 = ((i.a.g.h) bVar).D(z)) != null) {
                for (Inet6Address inet6Address : dVarD2.i()) {
                    qVar2.C(inet6Address);
                }
                qVar2.A(dVarD2.r());
            }
        }
        i.a.g.b bVarD2 = Z().d(qVar2.o(), i.a.g.s.e.TYPE_TXT, i.a.g.s.d.CLASS_ANY);
        if ((bVarD2 instanceof i.a.g.h) && (dVarD = ((i.a.g.h) bVarD2).D(z)) != null) {
            qVar2.A(dVarD.r());
        }
        if (qVar2.r().length == 0) {
            qVar2.A(bArrR);
        }
        return qVar2.u() ? qVar2 : qVar3;
    }

    public void t1(String str) {
        if (this.z.containsKey(str.toLowerCase())) {
            c(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11, types: [i.a.g.l$j, java.util.AbstractMap] */
    /* JADX WARN: Type inference failed for: r3v13, types: [java.lang.String] */
    public String toString() {
        StringBuilder sb = new StringBuilder(RecyclerView.l.FLAG_MOVED);
        sb.append("\n");
        sb.append("\t---- Local Host -----");
        sb.append("\n\t");
        sb.append(this.s);
        sb.append("\n\t---- Services -----");
        for (String str : this.o.keySet()) {
            sb.append("\n\t\tService: ");
            sb.append(str);
            sb.append(": ");
            sb.append(this.o.get(str));
        }
        sb.append("\n");
        sb.append("\t---- Types ----");
        Iterator<String> it = this.p.keySet().iterator();
        while (it.hasNext()) {
            j jVar = this.p.get(it.next());
            sb.append("\n\t\tType: ");
            sb.append(jVar.f());
            sb.append(": ");
            if (jVar.isEmpty()) {
                jVar = "no subtypes";
            }
            sb.append(jVar);
        }
        sb.append("\n");
        sb.append(this.n.toString());
        sb.append("\n");
        sb.append("\t---- Service Collectors ----");
        for (String str2 : this.z.keySet()) {
            sb.append("\n\t\tService Collector: ");
            sb.append(str2);
            sb.append(": ");
            sb.append(this.z.get(str2));
        }
        sb.append("\n");
        sb.append("\t---- Service Listeners ----");
        for (String str3 : this.l.keySet()) {
            sb.append("\n\t\tService Listener: ");
            sb.append(str3);
            sb.append(": ");
            sb.append(this.l.get(str3));
        }
        return sb.toString();
    }

    q u1(String str, String str2, String str3, boolean z) {
        Q();
        String lowerCase = str.toLowerCase();
        n1(str);
        if (this.z.putIfAbsent(lowerCase, new i(str)) == null) {
            J(lowerCase, this.z.get(lowerCase), true);
        }
        q qVarT0 = t0(str, str2, str3, z);
        y(qVarT0);
        return qVarT0;
    }

    public void v1(i.a.g.c cVar) {
        N0();
        try {
            if (this.y == cVar) {
                this.y = null;
            }
        } finally {
            Q0();
        }
    }

    public boolean w1() {
        return this.s.D();
    }

    @Override // i.a.g.j
    public void x() {
        i.a.g.j.b.b().c(e0()).x();
    }

    public Map<String, j> x0() {
        return this.p;
    }

    public void x1(i.a.g.f fVar) throws IOException {
        InetAddress address;
        int port;
        if (fVar.n()) {
            return;
        }
        if (fVar.D() != null) {
            address = fVar.D().getAddress();
            port = fVar.D().getPort();
        } else {
            address = this.f21803i;
            port = i.a.g.s.a.a;
        }
        byte[] bArrC = fVar.C();
        DatagramPacket datagramPacket = new DatagramPacket(bArrC, bArrC.length, address, port);
        if (f21801g.d()) {
            try {
                i.a.g.c cVar = new i.a.g.c(datagramPacket);
                if (f21801g.d()) {
                    f21801g.i("send(" + p0() + ") JmDNS out:" + cVar.C(true));
                }
            } catch (IOException e2) {
                f21801g.a(l.class.toString(), "send(" + p0() + ") - JmDNS can not parse what it sends!!!", e2);
            }
        }
        MulticastSocket multicastSocket = this.f21804j;
        if (multicastSocket == null || multicastSocket.isClosed()) {
            return;
        }
        multicastSocket.send(datagramPacket);
    }

    @Override // i.a.g.j
    public void y(q qVar) {
        i.a.g.j.b.b().c(e0()).y(qVar);
    }

    public Map<String, i.a.d> y0() {
        return this.o;
    }

    public void y1(long j2) {
        this.v = j2;
    }

    @Override // i.a.a
    public void z(String str, i.a.e eVar) {
        J(str, eVar, false);
    }

    public void z1(int i2) {
        this.u = i2;
    }
}
