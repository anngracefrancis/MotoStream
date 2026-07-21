package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaqd {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @VisibleForTesting
    private static boolean f14074b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @VisibleForTesting
    private static boolean f14075c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @VisibleForTesting
    private zzdah f14076d;

    @VisibleForTesting
    private final void h(Context context) {
        synchronized (a) {
            if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && !f14075c) {
                try {
                    f14075c = true;
                    this.f14076d = (zzdah) zzbae.a(context, "com.google.android.gms.ads.omid.DynamiteOmid", n3.a);
                } catch (zzbag e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final String a(Context context) {
        if (!((Boolean) zzyt.e().c(zzacu.b4)).booleanValue()) {
            return null;
        }
        try {
            h(context);
            String strValueOf = String.valueOf(this.f14076d.H0());
            return strValueOf.length() != 0 ? "a.".concat(strValueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final IObjectWrapper b(String str, WebView webView, String str2, String str3, String str4) {
        return c(str, webView, str2, str3, str4, "Google");
    }

    public final IObjectWrapper c(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (a) {
            try {
                try {
                    if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && f14074b) {
                        try {
                            return this.f14076d.d3(str, ObjectWrapper.E0(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e2) {
                            zzbad.f("#007 Could not call remote method.", e2);
                            return null;
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public final void d(IObjectWrapper iObjectWrapper, View view) {
        synchronized (a) {
            if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && f14074b) {
                try {
                    this.f14076d.p1(iObjectWrapper, ObjectWrapper.E0(view));
                } catch (RemoteException | NullPointerException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void e(IObjectWrapper iObjectWrapper) {
        synchronized (a) {
            if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && f14074b) {
                try {
                    this.f14076d.w6(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final void f(IObjectWrapper iObjectWrapper) {
        synchronized (a) {
            if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue() && f14074b) {
                try {
                    this.f14076d.a7(iObjectWrapper);
                } catch (RemoteException | NullPointerException e2) {
                    zzbad.f("#007 Could not call remote method.", e2);
                }
            }
        }
    }

    public final boolean g(Context context) {
        synchronized (a) {
            if (!((Boolean) zzyt.e().c(zzacu.b4)).booleanValue()) {
                return false;
            }
            if (f14074b) {
                return true;
            }
            try {
                h(context);
                boolean zH1 = this.f14076d.H1(ObjectWrapper.E0(context));
                f14074b = zH1;
                return zH1;
            } catch (RemoteException e2) {
                e = e2;
                zzbad.f("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e3) {
                e = e3;
                zzbad.f("#007 Could not call remote method.", e);
                return false;
            }
        }
    }
}
