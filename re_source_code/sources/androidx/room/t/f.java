package androidx.room.t;

/* JADX INFO: compiled from: StringUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public static final String[] a = new String[0];

    public static void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append("?");
            if (i3 < i2 - 1) {
                sb.append(",");
            }
        }
    }

    public static StringBuilder b() {
        return new StringBuilder();
    }
}
