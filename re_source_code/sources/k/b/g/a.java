package k.b.g;

import cm.aptoide.pt.dataprovider.model.v7.Malware;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import k.b.f.i;

/* JADX INFO: compiled from: SimpleLogger.java */
/* JADX INFO: loaded from: classes3.dex */
public class a extends k.b.f.b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static long f22923g = System.currentTimeMillis();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Properties f22924h = new Properties();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static boolean f22925i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static int f22926j = 20;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static boolean f22927k = false;
    private static String l = null;
    private static DateFormat m = null;
    private static boolean n = true;
    private static boolean o = true;
    private static boolean p = false;
    private static String q = "System.err";
    private static PrintStream r = null;
    private static boolean s = false;
    private static String t = "WARN";
    protected int u;
    private transient String v = null;

    /* JADX INFO: renamed from: k.b.g.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SimpleLogger.java */
    static class C0311a implements PrivilegedAction<InputStream> {
        C0311a() {
        }

        @Override // java.security.PrivilegedAction
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public InputStream run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            return contextClassLoader != null ? contextClassLoader.getResourceAsStream("simplelogger.properties") : ClassLoader.getSystemResourceAsStream("simplelogger.properties");
        }
    }

    a(String str) {
        this.u = 20;
        this.f22914f = str;
        String strV = v();
        if (strV != null) {
            this.u = w(strV);
        } else {
            this.u = f22926j;
        }
    }

    private String k() {
        String str = this.f22914f;
        return str.substring(str.lastIndexOf(".") + 1);
    }

    private static PrintStream l(String str) {
        if ("System.err".equalsIgnoreCase(str)) {
            return System.err;
        }
        if ("System.out".equalsIgnoreCase(str)) {
            return System.out;
        }
        try {
            return new PrintStream(new FileOutputStream(str));
        } catch (FileNotFoundException e2) {
            i.b("Could not open [" + str + "]. Defaulting to System.err", e2);
            return System.err;
        }
    }

    private void m(int i2, String str, Object obj, Object obj2) {
        if (s(i2)) {
            k.b.f.a aVarI = k.b.f.c.i(str, obj, obj2);
            u(i2, aVarI.a(), aVarI.b());
        }
    }

    private static boolean n(String str, boolean z) {
        String strP = p(str);
        return strP == null ? z : "true".equalsIgnoreCase(strP);
    }

    private String o() {
        String str;
        Date date = new Date();
        synchronized (m) {
            str = m.format(date);
        }
        return str;
    }

    private static String p(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? f22924h.getProperty(str) : property;
    }

    private static String q(String str, String str2) {
        String strP = p(str);
        return strP == null ? str2 : strP;
    }

    static void r() {
        if (f22925i) {
            return;
        }
        f22925i = true;
        t();
        String strQ = q("org.slf4j.simpleLogger.defaultLogLevel", null);
        if (strQ != null) {
            f22926j = w(strQ);
        }
        o = n("org.slf4j.simpleLogger.showLogName", o);
        p = n("org.slf4j.simpleLogger.showShortLogName", p);
        f22927k = n("org.slf4j.simpleLogger.showDateTime", f22927k);
        n = n("org.slf4j.simpleLogger.showThreadName", n);
        l = q("org.slf4j.simpleLogger.dateTimeFormat", l);
        s = n("org.slf4j.simpleLogger.levelInBrackets", s);
        t = q("org.slf4j.simpleLogger.warnLevelString", t);
        String strQ2 = q("org.slf4j.simpleLogger.logFile", q);
        q = strQ2;
        r = l(strQ2);
        if (l != null) {
            try {
                m = new SimpleDateFormat(l);
            } catch (IllegalArgumentException e2) {
                i.b("Bad date format in simplelogger.properties; will output relative time", e2);
            }
        }
    }

    private static void t() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new C0311a());
        if (inputStream != null) {
            try {
                f22924h.load(inputStream);
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    private void u(int i2, String str, Throwable th) {
        if (s(i2)) {
            StringBuilder sb = new StringBuilder(32);
            if (f22927k) {
                if (m != null) {
                    sb.append(o());
                    sb.append(' ');
                } else {
                    sb.append(System.currentTimeMillis() - f22923g);
                    sb.append(' ');
                }
            }
            if (n) {
                sb.append('[');
                sb.append(Thread.currentThread().getName());
                sb.append("] ");
            }
            if (s) {
                sb.append('[');
            }
            if (i2 == 0) {
                sb.append("TRACE");
            } else if (i2 == 10) {
                sb.append("DEBUG");
            } else if (i2 == 20) {
                sb.append("INFO");
            } else if (i2 == 30) {
                sb.append(t);
            } else if (i2 == 40) {
                sb.append("ERROR");
            }
            if (s) {
                sb.append(']');
            }
            sb.append(' ');
            if (p) {
                if (this.v == null) {
                    this.v = k();
                }
                sb.append(String.valueOf(this.v));
                sb.append(" - ");
            } else if (o) {
                sb.append(String.valueOf(this.f22914f));
                sb.append(" - ");
            }
            sb.append(str);
            x(sb, th);
        }
    }

    private static int w(String str) {
        if ("trace".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("debug".equalsIgnoreCase(str)) {
            return 10;
        }
        if ("info".equalsIgnoreCase(str)) {
            return 20;
        }
        if (Malware.WARN.equalsIgnoreCase(str)) {
            return 30;
        }
        return "error".equalsIgnoreCase(str) ? 40 : 20;
    }

    @Override // k.b.b
    public void a(String str, Object obj, Object obj2) {
        m(10, str, obj, obj2);
    }

    @Override // k.b.b
    public boolean b() {
        return s(10);
    }

    @Override // k.b.b
    public void c(String str) {
        u(10, str, null);
    }

    @Override // k.b.b
    public boolean d() {
        return s(0);
    }

    @Override // k.b.b
    public void e(String str, Throwable th) {
        u(20, str, th);
    }

    @Override // k.b.b
    public void f(String str, Throwable th) {
        u(30, str, th);
    }

    @Override // k.b.b
    public void g(String str, Throwable th) {
        u(10, str, th);
    }

    @Override // k.b.b
    public void h(String str) {
        u(30, str, null);
    }

    @Override // k.b.b
    public void i(String str) {
        u(0, str, null);
    }

    protected boolean s(int i2) {
        return i2 >= this.u;
    }

    String v() {
        String strSubstring = this.f22914f;
        int length = strSubstring.length();
        String strQ = null;
        while (strQ == null && length > -1) {
            strSubstring = strSubstring.substring(0, length);
            strQ = q("org.slf4j.simpleLogger.log." + strSubstring, null);
            length = String.valueOf(strSubstring).lastIndexOf(".");
        }
        return strQ;
    }

    void x(StringBuilder sb, Throwable th) {
        r.println(sb.toString());
        if (th != null) {
            th.printStackTrace(r);
        }
        r.flush();
    }
}
