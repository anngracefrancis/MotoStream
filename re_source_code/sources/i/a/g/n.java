package i.a.g;

import java.net.InetAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: compiled from: NameRegister.java */
/* JADX INFO: loaded from: classes2.dex */
public interface n {

    /* JADX INFO: compiled from: NameRegister.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.HOST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.SERVICE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: NameRegister.java */
    public static abstract class b implements n {
        protected String b(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int iIndexOf = str.indexOf(".local.");
            int iLastIndexOf = str.lastIndexOf(45);
            int i2 = 1;
            if (iLastIndexOf < 0) {
                sb.append(str.substring(0, iIndexOf));
            } else {
                try {
                    int i3 = Integer.parseInt(str.substring(iLastIndexOf + 1, iIndexOf)) + 1;
                    sb.append(str.substring(0, iLastIndexOf));
                    i2 = i3;
                } catch (Exception unused) {
                    sb.append(str.substring(0, iIndexOf));
                }
            }
            sb.append('-');
            sb.append(i2);
            sb.append(".local.");
            return sb.toString();
        }

        protected String c(String str) {
            StringBuilder sb = new StringBuilder(str.length() + 5);
            int iLastIndexOf = str.lastIndexOf(40);
            int iLastIndexOf2 = str.lastIndexOf(41);
            if (iLastIndexOf < 0 || iLastIndexOf >= iLastIndexOf2) {
                sb.append(str);
                sb.append(" (2)");
            } else {
                try {
                    sb.append(str.substring(0, iLastIndexOf));
                    sb.append('(');
                    sb.append(Integer.parseInt(str.substring(iLastIndexOf + 1, iLastIndexOf2)) + 1);
                    sb.append(')');
                } catch (NumberFormatException unused) {
                    sb.setLength(0);
                    sb.append(str);
                    sb.append(" (2)");
                }
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: NameRegister.java */
    public static class c {
        private static volatile n a;

        public static n a() {
            if (a == null) {
                a = new e();
            }
            return a;
        }
    }

    /* JADX INFO: compiled from: NameRegister.java */
    public enum d {
        HOST,
        SERVICE
    }

    /* JADX INFO: compiled from: NameRegister.java */
    public static class e extends b {
        private final ConcurrentMap<InetAddress, String> a = new ConcurrentHashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ConcurrentMap<InetAddress, Set<String>> f21843b = new ConcurrentHashMap();

        @Override // i.a.g.n
        public String a(InetAddress inetAddress, String str, d dVar) {
            int i2 = a.a[dVar.ordinal()];
            if (i2 != 1) {
                return i2 != 2 ? str : c(str);
            }
            return b(str);
        }
    }

    String a(InetAddress inetAddress, String str, d dVar);
}
