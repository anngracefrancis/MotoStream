package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;
import cm.aptoide.pt.root.execution.Command;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbxx implements zzbzb {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzbzc f14825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final JSONObject f14826c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzccj f14827d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzbyt f14828e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzdh f14829f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbrt f14830g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbri f14831h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcxm f14832i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbai f14833j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzcxv f14834k;
    private final zzbmn l;
    private final zzbzq m;
    private final Clock n;
    private final zzbva o;
    private final zzdae p;
    private boolean r;
    private zzaag y;
    private boolean q = false;
    private boolean s = false;
    private boolean t = false;
    private Point u = new Point();
    private Point v = new Point();
    private long w = 0;
    private long x = 0;

    public zzbxx(Context context, zzbzc zzbzcVar, JSONObject jSONObject, zzccj zzccjVar, zzbyt zzbytVar, zzdh zzdhVar, zzbrt zzbrtVar, zzbri zzbriVar, zzcxm zzcxmVar, zzbai zzbaiVar, zzcxv zzcxvVar, zzbmn zzbmnVar, zzbzq zzbzqVar, Clock clock, zzbva zzbvaVar, zzdae zzdaeVar) {
        this.a = context;
        this.f14825b = zzbzcVar;
        this.f14826c = jSONObject;
        this.f14827d = zzccjVar;
        this.f14828e = zzbytVar;
        this.f14829f = zzdhVar;
        this.f14830g = zzbrtVar;
        this.f14831h = zzbriVar;
        this.f14832i = zzcxmVar;
        this.f14833j = zzbaiVar;
        this.f14834k = zzcxvVar;
        this.l = zzbmnVar;
        this.m = zzbzqVar;
        this.n = clock;
        this.o = zzbvaVar;
        this.p = zzdaeVar;
    }

    private final JSONObject A(View view) {
        String str;
        JSONObject jSONObjectW;
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            int[] iArrE = E(view);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("width", x(view.getMeasuredWidth()));
            jSONObject2.put("height", x(view.getMeasuredHeight()));
            jSONObject2.put("x", x(iArrE[0]));
            jSONObject2.put("y", x(iArrE[1]));
            jSONObject2.put("relative_to", "window");
            jSONObject.put("frame", jSONObject2);
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                jSONObjectW = w(rect);
            } else {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("width", 0);
                jSONObject3.put("height", 0);
                jSONObject3.put("x", x(iArrE[0]));
                jSONObject3.put("y", x(iArrE[1]));
                jSONObject3.put("relative_to", "window");
                jSONObjectW = jSONObject3;
            }
            jSONObject.put("visible_bounds", jSONObjectW);
        } catch (Exception unused) {
            zzbad.i("Unable to get native ad view bounding box");
        }
        if (((Boolean) zzyt.e().c(zzacu.d5)).booleanValue()) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                try {
                    str = (String) parent.getClass().getMethod("getTemplateTypeName", new Class[0]).invoke(parent, new Object[0]);
                } catch (IllegalAccessException e2) {
                    zzbad.c("Cannot access method getTemplateTypeName: ", e2);
                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                } catch (NoSuchMethodException unused2) {
                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                } catch (SecurityException e3) {
                    zzbad.c("Cannot access method getTemplateTypeName: ", e3);
                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                } catch (InvocationTargetException e4) {
                    zzbad.c("Cannot access method getTemplateTypeName: ", e4);
                    str = HttpUrl.FRAGMENT_ENCODE_SET;
                }
            } else {
                str = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            byte b2 = -1;
            try {
                int iHashCode = str.hashCode();
                if (iHashCode != -2066603854) {
                    if (iHashCode == 2019754500 && str.equals("medium_template")) {
                        b2 = 1;
                    }
                } else if (str.equals("small_template")) {
                    b2 = 0;
                }
                if (b2 == 0) {
                    jSONObject.put("native_template_type", 1);
                } else if (b2 != 1) {
                    jSONObject.put("native_template_type", 0);
                } else {
                    jSONObject.put("native_template_type", 2);
                }
            } catch (JSONException e5) {
                zzbad.c("Could not log native template signal to JSON", e5);
            }
        }
        return jSONObject;
    }

    private static JSONObject B(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("contained_in_scroll_view", zzaxi.e0(view) != -1);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    private final JSONObject C(View view) {
        JSONObject jSONObject = new JSONObject();
        if (view == null) {
            return jSONObject;
        }
        try {
            zzk.zzlg();
            jSONObject.put("can_show_on_lock_screen", zzaxi.d0(view));
            zzk.zzlg();
            jSONObject.put("is_keyguard_locked", zzaxi.D(this.a));
        } catch (JSONException unused) {
            zzbad.i("Unable to get lock screen information");
        }
        return jSONObject;
    }

    private final String D(View view) {
        try {
            JSONObject jSONObjectOptJSONObject = this.f14826c.optJSONObject("tracking_urls_and_actions");
            if (jSONObjectOptJSONObject == null) {
                jSONObjectOptJSONObject = new JSONObject();
            }
            return this.f14829f.f().zza(this.a, jSONObjectOptJSONObject.optString("click_string"), view);
        } catch (Exception e2) {
            zzbad.c("Exception obtaining click signals", e2);
            return null;
        }
    }

    private static int[] E(View view) {
        int[] iArr = new int[2];
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return iArr;
    }

    private final JSONObject p(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View view) {
        String str;
        String str2;
        JSONObject jSONObject;
        String str3 = "ad_view";
        String str4 = "relative_to";
        JSONObject jSONObject2 = new JSONObject();
        if (map != null && view != null) {
            int[] iArrE = E(view);
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, WeakReference<View>> next = it.next();
                View view2 = next.getValue().get();
                if (view2 != null) {
                    int[] iArrE2 = E(view2);
                    JSONObject jSONObject3 = new JSONObject();
                    JSONObject jSONObject4 = new JSONObject();
                    Iterator<Map.Entry<String, WeakReference<View>>> it2 = it;
                    try {
                        jSONObject4.put("width", x(view2.getMeasuredWidth()));
                        jSONObject4.put("height", x(view2.getMeasuredHeight()));
                        jSONObject4.put("x", x(iArrE2[0] - iArrE[0]));
                        jSONObject4.put("y", x(iArrE2[1] - iArrE[1]));
                        jSONObject4.put(str4, str3);
                        jSONObject3.put("frame", jSONObject4);
                        Rect rect = new Rect();
                        if (view2.getLocalVisibleRect(rect)) {
                            jSONObject = w(rect);
                        } else {
                            jSONObject = new JSONObject();
                            jSONObject.put("width", 0);
                            jSONObject.put("height", 0);
                            jSONObject.put("x", x(iArrE2[0] - iArrE[0]));
                            jSONObject.put("y", x(iArrE2[1] - iArrE[1]));
                            jSONObject.put(str4, str3);
                        }
                        jSONObject3.put("visible_bounds", jSONObject);
                        if (view2 instanceof TextView) {
                            TextView textView = (TextView) view2;
                            jSONObject3.put("text_color", textView.getCurrentTextColor());
                            str = str3;
                            str2 = str4;
                            try {
                                jSONObject3.put("font_size", textView.getTextSize());
                                jSONObject3.put(Command.CommandHandler.TEXT, textView.getText());
                            } catch (JSONException unused) {
                                zzbad.i("Unable to get asset views information");
                            }
                        } else {
                            str = str3;
                            str2 = str4;
                        }
                        jSONObject3.put("is_clickable", map2 != null && map2.containsKey(next.getKey()) && view2.isClickable());
                        jSONObject2.put(next.getKey(), jSONObject3);
                    } catch (JSONException unused2) {
                        str = str3;
                        str2 = str4;
                    }
                    it = it2;
                    str3 = str;
                    str4 = str2;
                }
            }
        }
        return jSONObject2;
    }

    private final void q(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.f("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.f14826c);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            jSONObject7.put("has_custom_click_handler", this.f14825b.i(this.f14828e.e()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.f14828e.w());
            jSONObject8.put("view_aware_api_used", z);
            zzady zzadyVar = this.f14834k.f15755i;
            jSONObject8.put("custom_mute_requested", zzadyVar != null && zzadyVar.l);
            jSONObject8.put("custom_mute_enabled", (this.f14828e.i().isEmpty() || this.f14828e.y() == null) ? false : true);
            if (this.m.c() != null && this.f14826c.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.n.a());
            if (this.t && s()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            jSONObject8.put("has_custom_click_handler", this.f14825b.i(this.f14828e.e()) != null);
            jSONObject8.put("click_signals", D(view));
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long jA = this.n.a();
            jSONObject9.put("time_from_last_touch_down", jA - this.w);
            jSONObject9.put("time_from_last_touch", jA - this.x);
            jSONObject7.put("touch_signal", jSONObject9);
            zzbao.a(this.f14827d.i("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e2) {
            zzbad.c("Unable to create click JSON.", e2);
        }
    }

    private final boolean r(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Preconditions.f("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.f14826c);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            pf pfVar = null;
            this.f14827d.d("/logScionEvent", new qf(this));
            this.f14827d.d("/nativeImpression", new sf(this));
            zzbao.a(this.f14827d.i("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            boolean z = this.q;
            if (z || this.f14832i.z == null) {
                return true;
            }
            this.q = z | zzk.zzlq().c(this.a, this.f14833j.f14326f, this.f14832i.z.toString(), this.f14834k.f15752f);
            return true;
        } catch (JSONException e2) {
            zzbad.c("Unable to create impression JSON.", e2);
            return false;
        }
    }

    private final boolean s() {
        return this.f14826c.optBoolean("allow_custom_click_gesture", false);
    }

    private final JSONObject t() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", x(this.u.x));
            jSONObject.put("y", x(this.u.y));
            jSONObject.put("start_x", x(this.v.x));
            jSONObject.put("start_y", x(this.v.y));
            return jSONObject;
        } catch (JSONException e2) {
            zzbad.c("Error occurred while putting signals into JSON object.", e2);
            return null;
        }
    }

    private final String v(View view, Map<String, WeakReference<View>> map) {
        if (map != null && view != null) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                if (view.equals(entry.getValue().get())) {
                    return entry.getKey();
                }
            }
        }
        int iW = this.f14828e.w();
        if (iW == 1) {
            return "1099";
        }
        if (iW == 2) {
            return "2099";
        }
        if (iW != 6) {
            return null;
        }
        return "3099";
    }

    private final JSONObject w(Rect rect) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("width", x(rect.right - rect.left));
        jSONObject.put("height", x(rect.bottom - rect.top));
        jSONObject.put("x", x(rect.left));
        jSONObject.put("y", x(rect.top));
        jSONObject.put("relative_to", "self");
        return jSONObject;
    }

    private final int x(int i2) {
        return zzyt.a().j(this.a, i2);
    }

    private final boolean y(String str) {
        JSONObject jSONObjectOptJSONObject = this.f14826c.optJSONObject("allow_pub_event_reporting");
        return jSONObjectOptJSONObject != null && jSONObjectOptJSONObject.optBoolean(str, false);
    }

    private final JSONObject z(String str) {
        JSONObject jSONObject = null;
        try {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("click_point", t());
                jSONObject2.put("asset_id", str);
                return jSONObject2;
            } catch (Exception e2) {
                e = e2;
                jSONObject = jSONObject2;
                zzbad.c("Error occurred while grabbing click signals.", e);
                return jSONObject;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void G0(zzaag zzaagVar) {
        this.y = zzaagVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void W() {
        if (this.f14826c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.m.a();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void a(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.u = new Point();
        this.v = new Point();
        if (!this.r) {
            this.o.Y(view);
            this.r = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.l.F(this);
        if (map != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                View view2 = it.next().getValue().get();
                if (view2 != null) {
                    view2.setOnTouchListener(onTouchListener);
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, WeakReference<View>>> it2 = map2.entrySet().iterator();
            while (it2.hasNext()) {
                View view3 = it2.next().getValue().get();
                if (view3 != null) {
                    view3.setOnTouchListener(onTouchListener);
                    view3.setClickable(false);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void b(Bundle bundle) {
        if (bundle == null) {
            zzbad.e("Touch event data is null. No touch event is reported.");
            return;
        }
        if (!y("touch_reporting")) {
            zzbad.g("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
            return;
        }
        this.f14829f.f().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), bundle.getInt("duration_ms"));
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void c(View view) {
        if (!this.f14826c.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzbad.i("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzbzq zzbzqVar = this.m;
        if (view != null) {
            view.setOnClickListener(zzbzqVar);
            view.setClickable(true);
            zzbzqVar.l = new WeakReference<>(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d() {
        Preconditions.f("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.f14826c);
            zzbao.a(this.f14827d.i("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void d0(zzagd zzagdVar) {
        if (this.f14826c.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.m.b(zzagdVar);
        } else {
            zzbad.i("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void destroy() {
        this.f14827d.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e(View view, Map<String, WeakReference<View>> map) {
        this.u = new Point();
        this.v = new Point();
        this.o.f0(view);
        this.r = false;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void e0(zzaak zzaakVar) {
        try {
            if (this.s) {
                return;
            }
            if (zzaakVar != null || this.f14828e.y() == null) {
                this.s = true;
                this.p.e(zzaakVar.Z1());
                n();
            } else {
                this.s = true;
                this.p.e(this.f14828e.y().Z1());
                n();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void f(Bundle bundle) {
        if (bundle == null) {
            zzbad.e("Click data is null. No click is reported.");
        } else if (!y("click_reporting")) {
            zzbad.g("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            q(null, null, null, null, null, bundle2 != null ? bundle2.getString("asset_id") : null, null, zzk.zzlg().h(bundle, null), false, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void g(View view, MotionEvent motionEvent, View view2) {
        int[] iArrE = E(view2);
        this.u = new Point(((int) motionEvent.getRawX()) - iArrE[0], ((int) motionEvent.getRawY()) - iArrE[1]);
        long jA = this.n.a();
        this.x = jA;
        if (motionEvent.getAction() == 0) {
            this.w = jA;
            this.v = this.u;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        Point point = this.u;
        motionEventObtain.setLocation(point.x, point.y);
        this.f14829f.c(motionEventObtain);
        motionEventObtain.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void h(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        JSONObject jSONObjectP = p(map, map2, view2);
        JSONObject jSONObjectA = A(view2);
        JSONObject jSONObjectB = B(view2);
        JSONObject jSONObjectC = C(view2);
        String strV = v(view, map);
        q(view, jSONObjectA, jSONObjectP, jSONObjectB, jSONObjectC, strV, z(strV), null, z, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void i(String str) {
        q(null, null, null, null, null, str, null, null, false, false);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        r(A(view), p(map, map2, view), B(view), C(view), null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void j0() {
        this.t = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void k(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.t) {
            zzbad.e("Custom click reporting failed. enableCustomClickGesture is not set.");
            return;
        }
        if (!s()) {
            zzbad.e("Custom click reporting failed. Ad unit id not whitelisted.");
            return;
        }
        JSONObject jSONObjectP = p(map, map2, view);
        JSONObject jSONObjectA = A(view);
        JSONObject jSONObjectB = B(view);
        JSONObject jSONObjectC = C(view);
        String strV = v(null, map);
        q(view, jSONObjectA, jSONObjectP, jSONObjectB, jSONObjectC, strV, z(strV), null, z, true);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void l() {
        r(null, null, null, null, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final boolean m(Bundle bundle) {
        if (y("impression_reporting")) {
            return r(null, null, null, null, zzk.zzlg().h(bundle, null));
        }
        zzbad.g("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbzb
    public final void n() {
        try {
            zzaag zzaagVar = this.y;
            if (zzaagVar != null) {
                zzaagVar.onAdMuted();
            }
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
