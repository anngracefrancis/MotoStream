package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import okhttp3.HttpUrl;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: loaded from: classes.dex */
@zzard
@TargetApi(16)
public final class zzbdq extends zzbco implements TextureView.SurfaceTextureListener {
    private boolean A;
    private int B;
    private int C;
    private float D;
    private int E;
    private int F;
    private final zzgh G;
    private final zzhh H;
    private final zzgq I;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbdf f14397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Context f14398j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f14399k;
    private final zzbdg l;
    private final boolean m;
    private final zzbde n;
    private zzbcn o;
    private Surface p;
    private zzbdk q;
    private zzge r;
    private zzhd s;
    private zzgn t;
    private String u;
    private boolean v;
    private int w;
    private zzbdd x;
    private boolean y;
    private boolean z;

    public zzbdq(Context context, zzbdg zzbdgVar, zzbdf zzbdfVar, int i2, boolean z, boolean z2, zzbde zzbdeVar) {
        super(context);
        this.w = 1;
        this.G = new y8(this);
        this.H = new z8(this);
        this.I = new a9(this);
        this.f14398j = context;
        this.m = z2;
        this.f14397i = zzbdfVar;
        this.f14399k = i2;
        this.l = zzbdgVar;
        this.y = z;
        this.n = zzbdeVar;
        setSurfaceTextureListener(this);
        zzbdgVar.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(int i2, int i3, float f2) {
        float f3 = i3 == 0 ? 1.0f : (i2 * f2) / i3;
        if (this.f14396h != f3) {
            this.f14396h = f3;
            requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L(final String str, final String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 19 + String.valueOf(str2).length());
        sb.append("Error received: ");
        sb.append(str);
        sb.append(" : ");
        sb.append(str2);
        zzbad.i(sb.toString());
        this.v = true;
        if (this.n.a) {
            T();
        }
        zzaxi.a.post(new Runnable(this, str, str2) { // from class: com.google.android.gms.internal.ads.s8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13319f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final String f13320g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final String f13321h;

            {
                this.f13319f = this;
                this.f13320g = str;
                this.f13321h = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13319f.M(this.f13320g, this.f13321h);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N() {
        zzawz.m("Video ended.");
        if (this.n.a) {
            T();
        }
        this.l.f();
        this.f14346g.e();
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.r8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13265f;

            {
                this.f13265f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13265f.Y();
            }
        });
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean O() {
        return (this.r == null || this.v) ? false : true;
    }

    @EnsuresNonNullIf(expression = {"mPlayer"}, result = true)
    private final boolean P() {
        return O() && this.w != 1;
    }

    private final void Q() {
        String str;
        zzhn zzigVar;
        zzjp b9Var;
        zzig zzigVar2;
        if (this.r != null || (str = this.u) == null || this.p == null) {
            return;
        }
        zzbdk zzbdkVar = null;
        if (str.startsWith("cache:")) {
            zzbft zzbftVarV = this.f14397i.V(this.u);
            if (zzbftVarV != null && (zzbftVarV instanceof zzbgl)) {
                zzbgl zzbglVar = (zzbgl) zzbftVarV;
                zzbglVar.E();
                zzbdkVar = zzbglVar.F();
                zzbdkVar.d(this.G, this.H, this.I);
            } else if (zzbftVarV instanceof zzbgg) {
                zzbgg zzbggVar = (zzbgg) zzbftVarV;
                ByteBuffer byteBufferB = zzbggVar.B();
                String strC = zzbggVar.C();
                boolean zE = zzbggVar.E();
                zzbdk zzbdkVar2 = new zzbdk();
                zzid zzjgVar = "video/webm".equals(null) ? new zzjg() : new zziv();
                if (!zE || byteBufferB.limit() <= 0) {
                    zzjp zzjtVar = new zzjt(this.f14397i.getContext(), zzk.zzlg().g0(this.f14397i.getContext(), this.f14397i.b().f14326f));
                    if (((Boolean) zzyt.e().c(zzacu.y3)).booleanValue()) {
                        zzjtVar = new zzbeh(this.f14398j, zzjtVar, new zzbei(this) { // from class: com.google.android.gms.internal.ads.m8
                            private final zzbdq a;

                            {
                                this.a = this;
                            }

                            @Override // com.google.android.gms.internal.ads.zzbei
                            public final void a(final boolean z, final long j2) {
                                final zzbdq zzbdqVar = this.a;
                                zzbbm.a.execute(new Runnable(zzbdqVar, z, j2) { // from class: com.google.android.gms.internal.ads.o8

                                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                                    private final zzbdq f13091f;

                                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                                    private final boolean f13092g;

                                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                                    private final long f13093h;

                                    {
                                        this.f13091f = zzbdqVar;
                                        this.f13092g = z;
                                        this.f13093h = j2;
                                    }

                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        this.f13091f.C(this.f13092g, this.f13093h);
                                    }
                                });
                            }
                        });
                    }
                    if (byteBufferB.limit() > 0) {
                        int iLimit = byteBufferB.limit();
                        byte[] bArr = new byte[iLimit];
                        byteBufferB.get(bArr);
                        b9Var = new b9(new zzjo(bArr), iLimit, zzjtVar);
                    } else {
                        b9Var = zzjtVar;
                    }
                    zzigVar2 = new zzig(Uri.parse(strC), b9Var, zzjgVar, 2, this.n.f14365c);
                } else {
                    byte[] bArr2 = new byte[byteBufferB.limit()];
                    byteBufferB.get(bArr2);
                    zzigVar2 = new zzig(Uri.parse(strC), new zzjo(bArr2), zzjgVar, 2, this.n.f14365c);
                }
                zzbdkVar2.d(this.G, this.H, this.I);
                if (!zzbdkVar2.e(zzigVar2)) {
                    L("AdExoPlayerHelper Error", "Prepare from ByteBuffer failed.");
                }
                zzbdkVar = zzbdkVar2;
            } else {
                String strValueOf = String.valueOf(this.u);
                zzbad.i(strValueOf.length() != 0 ? "Source is MD5 but not found in cache. Source: ".concat(strValueOf) : new String("Source is MD5 but not found in cache. Source: "));
            }
        } else {
            int i2 = this.f14399k;
            if (i2 == 1) {
                zzigVar = new zzgl(this.f14397i.getContext(), Uri.parse(this.u), null, 2);
            } else {
                Preconditions.a(i2 == 2);
                zzjt zzjtVar2 = new zzjt(this.f14397i.getContext(), zzk.zzlg().g0(this.f14397i.getContext(), this.f14397i.b().f14326f));
                zzigVar = new zzig(Uri.parse(this.u), ((Boolean) zzyt.e().c(zzacu.y3)).booleanValue() ? new zzbeh(this.f14398j, zzjtVar2, new zzbei(this) { // from class: com.google.android.gms.internal.ads.l8
                    private final zzbdq a;

                    {
                        this.a = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbei
                    public final void a(final boolean z, final long j2) {
                        final zzbdq zzbdqVar = this.a;
                        zzbbm.a.execute(new Runnable(zzbdqVar, z, j2) { // from class: com.google.android.gms.internal.ads.p8

                            /* JADX INFO: renamed from: f, reason: collision with root package name */
                            private final zzbdq f13155f;

                            /* JADX INFO: renamed from: g, reason: collision with root package name */
                            private final boolean f13156g;

                            /* JADX INFO: renamed from: h, reason: collision with root package name */
                            private final long f13157h;

                            {
                                this.f13155f = zzbdqVar;
                                this.f13156g = z;
                                this.f13157h = j2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.f13155f.F(this.f13156g, this.f13157h);
                            }
                        });
                    }
                }) : zzjtVar2, "video/webm".equals(null) ? new zzjg() : new zziv(), 2, this.n.f14365c);
            }
            zzbdkVar = new zzbdk();
            zzbdkVar.d(this.G, this.H, this.I);
            if (!zzbdkVar.e(zzigVar)) {
                L("AdExoPlayerHelper Error", "Prepare failed.");
            }
        }
        this.q = zzbdkVar;
        if (zzbdkVar == null) {
            String strValueOf2 = String.valueOf(this.u);
            zzbad.i(strValueOf2.length() != 0 ? "AdExoPlayerHelper is null. Source: ".concat(strValueOf2) : new String("AdExoPlayerHelper is null. Source: "));
            return;
        }
        this.r = zzbdkVar.j();
        this.s = this.q.k();
        this.t = this.q.l();
        if (this.r != null) {
            w(this.p, false);
            int iF = this.r.F();
            this.w = iF;
            if (iF == 4) {
                R();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R() {
        if (this.z) {
            return;
        }
        this.z = true;
        zzawz.m("Video is ready.");
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.q8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13226f;

            {
                this.f13226f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13226f.Z();
            }
        });
        b();
        this.l.d();
        if (this.A) {
            d();
        }
    }

    private final void S() {
        zzge zzgeVar = this.r;
        if (zzgeVar != null) {
            zzgeVar.l(0, true);
        }
    }

    private final void T() {
        zzge zzgeVar = this.r;
        if (zzgeVar != null) {
            zzgeVar.l(0, false);
        }
    }

    @SideEffectFree
    private final void v(float f2, boolean z) {
        zzgn zzgnVar;
        zzge zzgeVar = this.r;
        if (zzgeVar == null || (zzgnVar = this.t) == null) {
            zzbad.i("Trying to set volume before player and renderers are initalized.");
        } else if (z) {
            zzgeVar.h(zzgnVar, 1, Float.valueOf(f2));
        } else {
            zzgeVar.j(zzgnVar, 1, Float.valueOf(f2));
        }
    }

    @SideEffectFree
    private final void w(Surface surface, boolean z) {
        zzhd zzhdVar;
        zzge zzgeVar = this.r;
        if (zzgeVar == null || (zzhdVar = this.s) == null) {
            zzbad.i("Trying to set surface before player and renderers are initalized.");
        } else if (z) {
            zzgeVar.h(zzhdVar, 1, surface);
        } else {
            zzgeVar.j(zzhdVar, 1, surface);
        }
    }

    final /* synthetic */ void C(boolean z, long j2) {
        this.f14397i.R(z, j2);
    }

    final /* synthetic */ void F(boolean z, long j2) {
        this.f14397i.R(z, j2);
    }

    final /* synthetic */ void H(int i2) {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.onWindowVisibilityChanged(i2);
        }
    }

    final /* synthetic */ void K(int i2, int i3) {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.d(i2, i3);
        }
    }

    final /* synthetic */ void M(String str, String str2) {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.b(str, str2);
        }
    }

    final /* synthetic */ void U() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.g();
        }
    }

    final /* synthetic */ void V() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.c();
        }
    }

    final /* synthetic */ void W() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.e();
        }
    }

    final /* synthetic */ void X() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.i();
        }
    }

    final /* synthetic */ void Y() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.h();
        }
    }

    final /* synthetic */ void Z() {
        zzbcn zzbcnVar = this.o;
        if (zzbcnVar != null) {
            zzbcnVar.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco, com.google.android.gms.internal.ads.g8
    public final void b() {
        v(this.f14346g.a(), false);
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void c() {
        if (P()) {
            if (this.n.a) {
                T();
            }
            this.r.a(false);
            this.l.f();
            this.f14346g.e();
            zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.u8

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbdq f13390f;

                {
                    this.f13390f = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13390f.W();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void d() {
        if (!P()) {
            this.A = true;
            return;
        }
        if (this.n.a) {
            S();
        }
        this.r.a(true);
        this.l.e();
        this.f14346g.d();
        this.f14345f.b();
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.t8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13349f;

            {
                this.f13349f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13349f.X();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getCurrentPosition() {
        if (P()) {
            return (int) this.r.e();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getDuration() {
        if (P()) {
            return (int) this.r.g();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoHeight() {
        return this.C;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoWidth() {
        return this.B;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void h(int i2) {
        if (P()) {
            this.r.b(i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void i() {
        if (O()) {
            this.r.stop();
            if (this.r != null) {
                w(null, true);
                zzbdk zzbdkVar = this.q;
                if (zzbdkVar != null) {
                    zzbdkVar.i();
                    this.q = null;
                }
                this.r = null;
                this.s = null;
                this.t = null;
                this.w = 1;
                this.v = false;
                this.z = false;
                this.A = false;
            }
        }
        this.l.f();
        this.f14346g.e();
        this.l.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void j(float f2, float f3) {
        zzbdd zzbddVar = this.x;
        if (zzbddVar != null) {
            zzbddVar.e(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void k(zzbcn zzbcnVar) {
        this.o = zzbcnVar;
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int i4;
        super.onMeasure(i2, i3);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.f14396h;
        if (f2 != 0.0f && this.x == null) {
            float f3 = measuredWidth;
            float f4 = measuredHeight;
            float f5 = (f2 / (f3 / f4)) - 1.0f;
            if (f5 > 0.01f) {
                measuredHeight = (int) (f3 / f2);
            } else if (f5 < -0.01f) {
                measuredWidth = (int) (f4 * f2);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbdd zzbddVar = this.x;
        if (zzbddVar != null) {
            zzbddVar.i(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i5 = this.E;
            if (((i5 > 0 && i5 != measuredWidth) || ((i4 = this.F) > 0 && i4 != measuredHeight)) && this.m && O() && this.r.e() > 0 && !this.r.f()) {
                v(0.0f, true);
                this.r.a(true);
                long jE = this.r.e();
                long jA = zzk.zzln().a();
                while (O() && this.r.e() == jE && zzk.zzln().a() - jA <= 250) {
                }
                if (O()) {
                    this.r.a(false);
                }
                b();
            }
            this.E = measuredWidth;
            this.F = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        int i4;
        if (this.y) {
            zzbdd zzbddVar = new zzbdd(getContext());
            this.x = zzbddVar;
            zzbddVar.b(surfaceTexture, i2, i3);
            this.x.start();
            SurfaceTexture surfaceTextureK = this.x.k();
            if (surfaceTextureK != null) {
                surfaceTexture = surfaceTextureK;
            } else {
                this.x.j();
                this.x = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.p = surface;
        if (this.r == null) {
            Q();
        } else {
            w(surface, true);
            if (!this.n.a) {
                S();
            }
        }
        float f2 = 1.0f;
        int i5 = this.B;
        if (i5 != 0 && (i4 = this.C) != 0) {
            f2 = this.D;
            i2 = i5;
            i3 = i4;
        }
        A(i2, i3, f2);
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.v8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13446f;

            {
                this.f13446f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13446f.V();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.m("Surface destroyed");
        c();
        zzbdd zzbddVar = this.x;
        if (zzbddVar != null) {
            zzbddVar.j();
            this.x = null;
        }
        if (this.r != null) {
            T();
            Surface surface = this.p;
            if (surface != null) {
                surface.release();
            }
            this.p = null;
            w(null, true);
        }
        zzaxi.a.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.x8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13565f;

            {
                this.f13565f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13565f.U();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i2, final int i3) {
        zzbdd zzbddVar = this.x;
        if (zzbddVar != null) {
            zzbddVar.i(i2, i3);
        }
        zzaxi.a.post(new Runnable(this, i2, i3) { // from class: com.google.android.gms.internal.ads.w8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13500f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final int f13501g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private final int f13502h;

            {
                this.f13500f = this;
                this.f13501g = i2;
                this.f13502h = i3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13500f.K(this.f13501g, this.f13502h);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.l.c(this);
        this.f14345f.a(surfaceTexture, this.o);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView1 window visibility changed to ");
        sb.append(i2);
        zzawz.m(sb.toString());
        zzaxi.a.post(new Runnable(this, i2) { // from class: com.google.android.gms.internal.ads.n8

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbdq f13028f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final int f13029g;

            {
                this.f13028f = this;
                this.f13029g = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13028f.H(this.f13029g);
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String r() {
        String string;
        int i2 = this.f14399k;
        if (i2 == 1) {
            string = "/Framework";
        } else if (i2 == 2) {
            StringBuilder sb = new StringBuilder("null".length() + 12);
            sb.append("/Extractor(");
            sb.append((String) null);
            sb.append(")");
            string = sb.toString();
        } else {
            string = "/Unknown";
        }
        String str = this.y ? " spherical" : HttpUrl.FRAGMENT_ENCODE_SET;
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 11 + str.length());
        sb2.append("ExoPlayer/1");
        sb2.append(string);
        sb2.append(str);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void setVideoPath(String str) {
        if (str == null) {
            zzbad.i("Path is null.");
        } else {
            this.u = str;
            Q();
        }
    }
}
