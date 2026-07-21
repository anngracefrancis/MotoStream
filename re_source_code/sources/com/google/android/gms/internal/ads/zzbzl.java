package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.formats.AdChoicesView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbzl {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzaxb f14920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcxv f14921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbyx f14922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbyt f14923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzbzt f14924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Executor f14925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Executor f14926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzady f14927i;

    public zzbzl(Context context, zzaxb zzaxbVar, zzcxv zzcxvVar, zzbyx zzbyxVar, zzbyt zzbytVar, zzbzt zzbztVar, Executor executor, Executor executor2) {
        this.a = context;
        this.f14920b = zzaxbVar;
        this.f14921c = zzcxvVar;
        this.f14927i = zzcxvVar.f15755i;
        this.f14922d = zzbyxVar;
        this.f14923e = zzbytVar;
        this.f14924f = zzbztVar;
        this.f14925g = executor;
        this.f14926h = executor2;
    }

    private static void a(RelativeLayout.LayoutParams layoutParams, int i2) {
        if (i2 == 0) {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        } else if (i2 == 2) {
            layoutParams.addRule(12);
            layoutParams.addRule(11);
        } else if (i2 != 3) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(12);
            layoutParams.addRule(9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(zzcab zzcabVar, String[] strArr) {
        Map<String, WeakReference<View>> mapV3 = zzcabVar.V3();
        if (mapV3 == null) {
            return false;
        }
        for (String str : strArr) {
            if (mapV3.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(ViewGroup viewGroup) {
        View viewZ = this.f14923e.z();
        if (viewZ == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (viewZ.getParent() instanceof ViewGroup) {
            ((ViewGroup) viewZ.getParent()).removeView(viewZ);
        }
        viewGroup.addView(viewZ, ((Boolean) zzyt.e().c(zzacu.R2)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    final /* synthetic */ void e(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.f14923e.z() != null) {
            if (2 == this.f14923e.w() || 1 == this.f14923e.w()) {
                this.f14920b.z(this.f14921c.f15752f, String.valueOf(this.f14923e.w()), z);
            } else if (6 == this.f14923e.w()) {
                this.f14920b.z(this.f14921c.f15752f, "2", z);
                this.f14920b.z(this.f14921c.f15752f, "1", z);
            }
        }
    }

    public final void f(final zzcab zzcabVar) {
        this.f14925g.execute(new Runnable(this, zzcabVar) { // from class: com.google.android.gms.internal.ads.zf

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbzl f13705f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final zzcab f13706g;

            {
                this.f13705f = this;
                this.f13706g = zzcabVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13705f.h(this.f13706g);
            }
        });
    }

    public final void g(zzcab zzcabVar) {
        if (zzcabVar == null || this.f14924f == null || zzcabVar.E0() == null) {
            return;
        }
        try {
            zzcabVar.E0().addView(this.f14924f.c());
        } catch (zzbhj e2) {
            zzawz.l("web view can not be obtained", e2);
        }
    }

    final /* synthetic */ void h(zzcab zzcabVar) {
        ViewGroup viewGroup;
        View viewX;
        final ViewGroup viewGroup2;
        Drawable drawable;
        if (!(this.f14922d.c() || this.f14922d.b())) {
            viewGroup = null;
            break;
        }
        String[] strArr = {NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW};
        int i2 = 0;
        while (true) {
            if (i2 < 2) {
                View viewY4 = zzcabVar.Y4(strArr[i2]);
                if (viewY4 != null && (viewY4 instanceof ViewGroup)) {
                    viewGroup = (ViewGroup) viewY4;
                    break;
                }
                i2++;
            } else {
                viewGroup = null;
                break;
            }
        }
        boolean z = viewGroup != null;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f14923e.x() != null) {
            viewX = this.f14923e.x();
            zzady zzadyVar = this.f14927i;
            if (zzadyVar != null && !z) {
                a(layoutParams, zzadyVar.f13849j);
                viewX.setLayoutParams(layoutParams);
            }
        } else if (this.f14923e.V() instanceof zzadt) {
            zzadt zzadtVar = (zzadt) this.f14923e.V();
            if (!z) {
                a(layoutParams, zzadtVar.n7());
            }
            View zzaduVar = new zzadu(this.a, zzadtVar, layoutParams);
            zzaduVar.setContentDescription((CharSequence) zzyt.e().c(zzacu.O2));
            viewX = zzaduVar;
        } else {
            viewX = null;
        }
        if (viewX != null) {
            if (viewX.getParent() instanceof ViewGroup) {
                ((ViewGroup) viewX.getParent()).removeView(viewX);
            }
            if (z) {
                viewGroup.removeAllViews();
                viewGroup.addView(viewX);
            } else {
                AdChoicesView adChoicesView = new AdChoicesView(zzcabVar.k0().getContext());
                adChoicesView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                adChoicesView.addView(viewX);
                FrameLayout frameLayoutE0 = zzcabVar.E0();
                if (frameLayoutE0 != null) {
                    frameLayoutE0.addView(adChoicesView);
                }
            }
            zzcabVar.H(zzcabVar.A5(), viewX, true);
        }
        if (!((Boolean) zzyt.e().c(zzacu.X4)).booleanValue()) {
            g(zzcabVar);
        }
        String[] strArr2 = zzbzj.f14914f;
        int length = strArr2.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                viewGroup2 = null;
                break;
            }
            View viewY5 = zzcabVar.Y4(strArr2[i3]);
            if (viewY5 instanceof ViewGroup) {
                viewGroup2 = (ViewGroup) viewY5;
                break;
            }
            i3++;
        }
        this.f14926h.execute(new Runnable(this, viewGroup2) { // from class: com.google.android.gms.internal.ads.ag

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbzl f12253f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final ViewGroup f12254g;

            {
                this.f12253f = this;
                this.f12254g = viewGroup2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f12253f.e(this.f12254g);
            }
        });
        if (viewGroup2 != null) {
            if (b(viewGroup2)) {
                if (this.f14923e.A() != null) {
                    this.f14923e.A().x0(new bg(this, zzcabVar, viewGroup2));
                    return;
                }
                return;
            }
            viewGroup2.removeAllViews();
            View viewK0 = zzcabVar.k0();
            Context context = viewK0 != null ? viewK0.getContext() : null;
            if (context == null || this.f14923e.h() == null || this.f14923e.h().isEmpty()) {
                return;
            }
            zzadw zzadwVar = this.f14923e.h().get(0);
            zzaei zzaeiVarH7 = zzadwVar instanceof IBinder ? zzaej.h7(zzadwVar) : null;
            if (zzaeiVarH7 != null) {
                try {
                    IObjectWrapper iObjectWrapperT4 = zzaeiVarH7.t4();
                    if (iObjectWrapperT4 == null || (drawable = (Drawable) ObjectWrapper.k0(iObjectWrapperT4)) == null) {
                        return;
                    }
                    ImageView imageView = new ImageView(context);
                    imageView.setImageDrawable(drawable);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                    viewGroup2.addView(imageView);
                } catch (RemoteException unused) {
                    zzbad.i("Could not get drawable from image");
                }
            }
        }
    }
}
