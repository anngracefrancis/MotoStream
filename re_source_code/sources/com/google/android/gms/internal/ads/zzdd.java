package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdd implements zzdc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected static volatile zzdy f15874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected MotionEvent f15875g;
    protected double p;
    private double q;
    private double r;
    protected float s;
    protected float t;
    protected float u;
    protected float v;
    protected DisplayMetrics y;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected LinkedList<MotionEvent> f15876h = new LinkedList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected long f15877i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected long f15878j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected long f15879k = 0;
    protected long l = 0;
    protected long m = 0;
    protected long n = 0;
    protected long o = 0;
    private boolean w = false;
    protected boolean x = false;

    protected zzdd(Context context) {
        try {
            if (((Boolean) zzyt.e().c(zzacu.t2)).booleanValue()) {
                ij.f();
            } else {
                qy.a(f15874f);
            }
            this.y = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002d  */
    private final String d(Context context, String str, boolean z, View view, Activity activity, byte[] bArr) {
        zzbk.zza zzaVarX;
        zzda zzdaVarW;
        String strH;
        zzbp.zza.C0176zza c0176zzaC = null;
        if (bArr == null || bArr.length <= 0) {
            zzaVarX = null;
        } else {
            try {
                zzaVarX = zzbk.zza.x(bArr, zzdno.e());
            } catch (zzdok unused) {
                zzaVarX = null;
            }
        }
        if (f15874f != null) {
            if (((Boolean) zzyt.e().c(zzacu.j2)).booleanValue()) {
                zzdaVarW = f15874f.w();
            } else {
                zzdaVarW = null;
            }
        } else {
            zzdaVarW = null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (z) {
                c0176zzaC = b(context, view, activity);
                this.w = true;
            } else {
                c0176zzaC = c(context, zzaVarX);
            }
            if (zzdaVarW != null) {
                zzdaVarW.b(z ? 1002 : 1000, -1, System.currentTimeMillis() - jCurrentTimeMillis);
            }
        } catch (Exception e2) {
            if (zzdaVarW != null) {
                zzdaVarW.c(z ? 1003 : WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY, -1, System.currentTimeMillis() - jCurrentTimeMillis, e2);
            }
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        if (c0176zzaC != null) {
            try {
                if (((zzbp.zza) ((zzdob) c0176zzaC.p0())).i() == 0) {
                    strH = Integer.toString(5);
                } else {
                    strH = ij.h((zzbp.zza) ((zzdob) c0176zzaC.p0()), str);
                    if (zzdaVarW != null) {
                        zzdaVarW.b(z ? 1006 : 1004, -1, System.currentTimeMillis() - jCurrentTimeMillis2);
                    }
                }
            } catch (Exception e3) {
                strH = Integer.toString(7);
                if (zzdaVarW != null) {
                    zzdaVarW.c(z ? 1007 : WebSocketProtocol.CLOSE_NO_STATUS_CODE, -1, System.currentTimeMillis() - jCurrentTimeMillis2, e3);
                }
            }
        } else {
            strH = Integer.toString(5);
        }
        return strH;
    }

    protected abstract long a(StackTraceElement[] stackTraceElementArr) throws zzdv;

    protected abstract zzbp.zza.C0176zza b(Context context, View view, Activity activity);

    protected abstract zzbp.zza.C0176zza c(Context context, zzbk.zza zzaVar);

    protected abstract zzee e(MotionEvent motionEvent) throws zzdv;

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context) {
        if (zzef.a()) {
            if (((Boolean) zzyt.e().c(zzacu.v2)).booleanValue()) {
                throw new IllegalStateException("The caller must not be called from the UI thread.");
            }
        }
        return d(context, null, false, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public void zzb(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view) {
        return zza(context, str, view, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final String zza(Context context, String str, View view, Activity activity) {
        return d(context, str, true, view, activity, null);
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(MotionEvent motionEvent) {
        boolean z = false;
        if (this.w) {
            this.l = 0L;
            this.f15879k = 0L;
            this.f15878j = 0L;
            this.f15877i = 0L;
            this.m = 0L;
            this.o = 0L;
            this.n = 0L;
            Iterator<MotionEvent> it = this.f15876h.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.f15876h.clear();
            this.f15875g = null;
            this.w = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.p = 0.0d;
            this.q = motionEvent.getRawX();
            this.r = motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = motionEvent.getRawX();
            double rawY = motionEvent.getRawY();
            double d2 = this.q;
            Double.isNaN(rawX);
            double d3 = rawX - d2;
            double d4 = this.r;
            Double.isNaN(rawY);
            double d5 = rawY - d4;
            this.p += Math.sqrt((d3 * d3) + (d5 * d5));
            this.q = rawX;
            this.r = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 != 0) {
            try {
                if (action2 == 1) {
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    this.f15875g = motionEventObtain;
                    this.f15876h.add(motionEventObtain);
                    if (this.f15876h.size() > 6) {
                        this.f15876h.remove().recycle();
                    }
                    this.f15879k++;
                    this.m = a(new Throwable().getStackTrace());
                } else if (action2 == 2) {
                    this.f15878j += (long) (motionEvent.getHistorySize() + 1);
                    zzee zzeeVarE = e(motionEvent);
                    if ((zzeeVarE == null || zzeeVarE.f16195e == null || zzeeVarE.f16198h == null) ? false : true) {
                        this.n += zzeeVarE.f16195e.longValue() + zzeeVarE.f16198h.longValue();
                    }
                    if (this.y != null && zzeeVarE != null && zzeeVarE.f16196f != null && zzeeVarE.f16199i != null) {
                        z = true;
                    }
                    if (z) {
                        this.o += zzeeVarE.f16196f.longValue() + zzeeVarE.f16199i.longValue();
                    }
                } else if (action2 == 3) {
                    this.l++;
                }
            } catch (zzdv unused) {
            }
        } else {
            this.s = motionEvent.getX();
            this.t = motionEvent.getY();
            this.u = motionEvent.getRawX();
            this.v = motionEvent.getRawY();
            this.f15877i++;
        }
        this.x = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdc
    public final void zza(int i2, int i3, int i4) {
        MotionEvent motionEvent = this.f15875g;
        if (motionEvent != null) {
            motionEvent.recycle();
        }
        DisplayMetrics displayMetrics = this.y;
        if (displayMetrics != null) {
            float f2 = displayMetrics.density;
            this.f15875g = MotionEvent.obtain(0L, i4, 1, i2 * f2, i3 * f2, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        } else {
            this.f15875g = null;
        }
        this.x = false;
    }
}
