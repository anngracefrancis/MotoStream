package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: NotificationCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class i {

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class a {
        final Bundle a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private IconCompat f872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final n[] f873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final n[] f874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f877g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final boolean f878h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f879i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public CharSequence f880j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public PendingIntent f881k;

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i2 != 0 ? IconCompat.c(null, HttpUrl.FRAGMENT_ENCODE_SET, i2) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f881k;
        }

        public boolean b() {
            return this.f875e;
        }

        public n[] c() {
            return this.f874d;
        }

        public Bundle d() {
            return this.a;
        }

        public IconCompat e() {
            int i2;
            if (this.f872b == null && (i2 = this.f879i) != 0) {
                this.f872b = IconCompat.c(null, HttpUrl.FRAGMENT_ENCODE_SET, i2);
            }
            return this.f872b;
        }

        public n[] f() {
            return this.f873c;
        }

        public int g() {
            return this.f877g;
        }

        public boolean h() {
            return this.f876f;
        }

        public CharSequence i() {
            return this.f880j;
        }

        public boolean j() {
            return this.f878h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, n[] nVarArr, n[] nVarArr2, boolean z, int i2, boolean z2, boolean z3) {
            this.f876f = true;
            this.f872b = iconCompat;
            if (iconCompat != null && iconCompat.i() == 2) {
                this.f879i = iconCompat.e();
            }
            this.f880j = e.e(charSequence);
            this.f881k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.f873c = nVarArr;
            this.f874d = nVarArr2;
            this.f875e = z;
            this.f877g = i2;
            this.f876f = z2;
            this.f878h = z3;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class b extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private IconCompat f883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private boolean f884g;

        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* JADX INFO: renamed from: androidx.core.app.i$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class C0020b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        @Override // androidx.core.app.i.f
        public void b(h hVar) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 16) {
                Notification.BigPictureStyle bigPictureStyleBigPicture = new Notification.BigPictureStyle(hVar.a()).setBigContentTitle(this.f896b).bigPicture(this.f882e);
                if (this.f884g) {
                    IconCompat iconCompat = this.f883f;
                    if (iconCompat == null) {
                        a.a(bigPictureStyleBigPicture, null);
                    } else if (i2 >= 23) {
                        C0020b.a(bigPictureStyleBigPicture, this.f883f.q(hVar instanceof j ? ((j) hVar).f() : null));
                    } else if (iconCompat.i() == 1) {
                        a.a(bigPictureStyleBigPicture, this.f883f.d());
                    } else {
                        a.a(bigPictureStyleBigPicture, null);
                    }
                }
                if (this.f898d) {
                    a.b(bigPictureStyleBigPicture, this.f897c);
                }
            }
        }

        @Override // androidx.core.app.i.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public b h(Bitmap bitmap) {
            this.f883f = bitmap == null ? null : IconCompat.b(bitmap);
            this.f884g = true;
            return this;
        }

        public b i(Bitmap bitmap) {
            this.f882e = bitmap;
            return this;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class c extends f {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private CharSequence f885e;

        @Override // androidx.core.app.i.f
        public void a(Bundle bundle) {
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.f885e);
            }
        }

        @Override // androidx.core.app.i.f
        public void b(h hVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigTextStyleBigText = new Notification.BigTextStyle(hVar.a()).setBigContentTitle(this.f896b).bigText(this.f885e);
                if (this.f898d) {
                    bigTextStyleBigText.setSummaryText(this.f897c);
                }
            }
        }

        @Override // androidx.core.app.i.f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public c h(CharSequence charSequence) {
            this.f885e = e.e(charSequence);
            return this;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static final class d {

        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class a {
            static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                throw null;
            }
        }

        /* JADX INFO: compiled from: NotificationCompat.java */
        private static class b {
            static Notification.BubbleMetadata a(d dVar) {
                if (dVar == null) {
                    return null;
                }
                throw null;
            }
        }

        public static Notification.BubbleMetadata a(d dVar) {
            if (dVar == null) {
                return null;
            }
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 30) {
                return b.a(dVar);
            }
            if (i2 == 29) {
                return a.a(dVar);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static abstract class f {
        protected e a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        CharSequence f896b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        CharSequence f897c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f898d = false;

        public void a(Bundle bundle) {
            if (this.f898d) {
                bundle.putCharSequence("android.summaryText", this.f897c);
            }
            CharSequence charSequence = this.f896b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(h hVar);

        protected abstract String c();

        public RemoteViews d(h hVar) {
            return null;
        }

        public RemoteViews e(h hVar) {
            return null;
        }

        public RemoteViews f(h hVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.a != eVar) {
                this.a = eVar;
                if (eVar != null) {
                    eVar.A(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return k.c(notification);
        }
        return null;
    }

    /* JADX INFO: compiled from: NotificationCompat.java */
    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        androidx.core.content.b N;
        long O;
        int P;
        boolean Q;
        d R;
        Notification S;
        boolean T;
        Icon U;

        @Deprecated
        public ArrayList<String> V;
        public Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<a> f886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public ArrayList<m> f887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ArrayList<a> f888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        CharSequence f889e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        CharSequence f890f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        PendingIntent f891g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        PendingIntent f892h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        RemoteViews f893i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Bitmap f894j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        CharSequence f895k;
        int l;
        int m;
        boolean n;
        boolean o;
        f p;
        CharSequence q;
        CharSequence r;
        CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;

        public e(Context context, String str) {
            this.f886b = new ArrayList<>();
            this.f887c = new ArrayList<>();
            this.f888d = new ArrayList<>();
            this.n = true;
            this.z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence e(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap f(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(c.i.b.f3167b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(c.i.b.a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double d2 = dimensionPixelSize;
            double dMax = Math.max(1, bitmap.getWidth());
            Double.isNaN(d2);
            Double.isNaN(dMax);
            double d3 = d2 / dMax;
            double d4 = dimensionPixelSize2;
            double dMax2 = Math.max(1, bitmap.getHeight());
            Double.isNaN(d4);
            Double.isNaN(dMax2);
            double dMin = Math.min(d3, d4 / dMax2);
            double width = bitmap.getWidth();
            Double.isNaN(width);
            int iCeil = (int) Math.ceil(width * dMin);
            double height = bitmap.getHeight();
            Double.isNaN(height);
            return Bitmap.createScaledBitmap(bitmap, iCeil, (int) Math.ceil(height * dMin), true);
        }

        private void o(int i2, boolean z) {
            if (z) {
                Notification notification = this.S;
                notification.flags = i2 | notification.flags;
            } else {
                Notification notification2 = this.S;
                notification2.flags = (i2 ^ (-1)) & notification2.flags;
            }
        }

        public e A(f fVar) {
            if (this.p != fVar) {
                this.p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        public e B(CharSequence charSequence) {
            this.S.tickerText = e(charSequence);
            return this;
        }

        public e C(long[] jArr) {
            this.S.vibrate = jArr;
            return this;
        }

        public e D(int i2) {
            this.F = i2;
            return this;
        }

        public e E(long j2) {
            this.S.when = j2;
            return this;
        }

        public e a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f886b.add(new a(i2, charSequence, pendingIntent));
            return this;
        }

        public e b(a aVar) {
            if (aVar != null) {
                this.f886b.add(aVar);
            }
            return this;
        }

        public Notification c() {
            return new j(this).c();
        }

        public Bundle d() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public e g(boolean z) {
            o(16, z);
            return this;
        }

        public e h(String str) {
            this.K = str;
            return this;
        }

        public e i(int i2) {
            this.E = i2;
            return this;
        }

        public e j(PendingIntent pendingIntent) {
            this.f891g = pendingIntent;
            return this;
        }

        public e k(CharSequence charSequence) {
            this.f890f = e(charSequence);
            return this;
        }

        public e l(CharSequence charSequence) {
            this.f889e = e(charSequence);
            return this;
        }

        public e m(int i2) {
            Notification notification = this.S;
            notification.defaults = i2;
            if ((i2 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public e n(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public e p(Bitmap bitmap) {
            this.f894j = f(bitmap);
            return this;
        }

        public e q(int i2, int i3, int i4) {
            Notification notification = this.S;
            notification.ledARGB = i2;
            notification.ledOnMS = i3;
            notification.ledOffMS = i4;
            notification.flags = ((i3 == 0 || i4 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public e r(boolean z) {
            this.z = z;
            return this;
        }

        public e s(int i2) {
            this.l = i2;
            return this;
        }

        public e t(boolean z) {
            o(2, z);
            return this;
        }

        public e u(boolean z) {
            o(8, z);
            return this;
        }

        public e v(int i2) {
            this.m = i2;
            return this;
        }

        public e w(int i2, int i3, boolean z) {
            this.t = i2;
            this.u = i3;
            this.v = z;
            return this;
        }

        public e x(boolean z) {
            this.n = z;
            return this;
        }

        public e y(int i2) {
            this.S.icon = i2;
            return this;
        }

        public e z(Uri uri) {
            Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            }
            return this;
        }

        @Deprecated
        public e(Context context) {
            this(context, null);
        }
    }
}
