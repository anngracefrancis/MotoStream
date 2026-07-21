package i.a;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/* JADX INFO: compiled from: ServiceInfo.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class d implements Cloneable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final byte[] f21745f = new byte[0];

    /* JADX INFO: compiled from: ServiceInfo.java */
    public enum a {
        Domain,
        Protocol,
        Application,
        Instance,
        Subtype
    }

    @Override // 
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public d clone() {
        try {
            return (d) super.clone();
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public abstract String f();

    public abstract String g();

    public abstract Inet4Address[] h();

    public abstract Inet6Address[] i();

    public abstract InetAddress[] j();

    public abstract String k();

    public abstract int l();

    public abstract int m();

    public abstract String n();

    public abstract String o();

    public abstract String p();

    public abstract String q();

    public abstract byte[] r();

    public abstract String s();

    public abstract int t();

    public abstract boolean u();

    public abstract boolean v(d dVar);

    public abstract boolean w();
}
