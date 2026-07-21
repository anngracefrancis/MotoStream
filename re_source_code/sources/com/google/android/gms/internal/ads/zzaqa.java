package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaqa extends zzaqb implements zzaho<zzbgz> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbgz f14064c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f14065d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final WindowManager f14066e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzacf f14067f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private DisplayMetrics f14068g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f14069h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f14070i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f14071j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14072k;
    private int l;
    private int m;
    private int n;
    private int o;

    public zzaqa(zzbgz zzbgzVar, Context context, zzacf zzacfVar) {
        super(zzbgzVar);
        this.f14070i = -1;
        this.f14071j = -1;
        this.l = -1;
        this.m = -1;
        this.n = -1;
        this.o = -1;
        this.f14064c = zzbgzVar;
        this.f14065d = context;
        this.f14067f = zzacfVar;
        this.f14066e = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        this.f14068g = new DisplayMetrics();
        Display defaultDisplay = this.f14066e.getDefaultDisplay();
        defaultDisplay.getMetrics(this.f14068g);
        this.f14069h = this.f14068g.density;
        this.f14072k = defaultDisplay.getRotation();
        zzyt.a();
        DisplayMetrics displayMetrics = this.f14068g;
        this.f14070i = zzazt.k(displayMetrics, displayMetrics.widthPixels);
        zzyt.a();
        DisplayMetrics displayMetrics2 = this.f14068g;
        this.f14071j = zzazt.k(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityA = this.f14064c.a();
        if (activityA == null || activityA.getWindow() == null) {
            this.l = this.f14070i;
            this.m = this.f14071j;
        } else {
            zzk.zzlg();
            int[] iArrP = zzaxi.P(activityA);
            zzyt.a();
            this.l = zzazt.k(this.f14068g, iArrP[0]);
            zzyt.a();
            this.m = zzazt.k(this.f14068g, iArrP[1]);
        }
        if (this.f14064c.o().e()) {
            this.n = this.f14070i;
            this.o = this.f14071j;
        } else {
            this.f14064c.measure(0, 0);
        }
        c(this.f14070i, this.f14071j, this.l, this.m, this.f14069h, this.f14072k);
        this.f14064c.j("onDeviceFeaturesReceived", new zzapx(new zzapz().i(this.f14067f.b()).h(this.f14067f.c()).j(this.f14067f.e()).b(this.f14067f.d()).c(true)).a());
        int[] iArr = new int[2];
        this.f14064c.getLocationOnScreen(iArr);
        h(zzyt.a().j(this.f14065d, iArr[0]), zzyt.a().j(this.f14065d, iArr[1]));
        if (zzbad.a(2)) {
            zzbad.h("Dispatching Ready Event.");
        }
        f(this.f14064c.b().f14326f);
    }

    public final void h(int i2, int i3) {
        int i4 = this.f14065d instanceof Activity ? zzk.zzlg().W((Activity) this.f14065d)[0] : 0;
        if (this.f14064c.o() == null || !this.f14064c.o().e()) {
            this.n = zzyt.a().j(this.f14065d, this.f14064c.getWidth());
            this.o = zzyt.a().j(this.f14065d, this.f14064c.getHeight());
        }
        d(i2, i3 - i4, this.n, this.o);
        this.f14064c.p().g(i2, i3);
    }
}
