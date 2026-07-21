package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbml implements zzalm<zzbmp> {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzty f14542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PowerManager f14543c;

    public zzbml(Context context, zzty zztyVar) {
        this.a = context;
        this.f14542b = zztyVar;
        this.f14543c = (PowerManager) context.getSystemService("power");
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final JSONObject b(zzbmp zzbmpVar) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzud zzudVar = zzbmpVar.f14555f;
        if (zzudVar == null) {
            jSONObject = new JSONObject();
        } else {
            if (this.f14542b.c() == null) {
                throw new JSONException("Active view Info cannot be null.");
            }
            boolean z = zzudVar.f16798c;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.f14542b.b()).put("activeViewJSON", this.f14542b.c()).put("timestamp", zzbmpVar.f14553d).put("adFormat", this.f14542b.a()).put("hashCode", this.f14542b.d()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbmpVar.f14551b).put("isNative", this.f14542b.e()).put("isScreenOn", Build.VERSION.SDK_INT >= 20 ? this.f14543c.isInteractive() : this.f14543c.isScreenOn()).put("appMuted", zzk.zzll().e()).put("appVolume", zzk.zzll().d()).put("deviceVolume", zzaya.c(this.a.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzudVar.f16799d).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzudVar.f16800e.top).put("bottom", zzudVar.f16800e.bottom).put("left", zzudVar.f16800e.left).put("right", zzudVar.f16800e.right)).put("adBox", new JSONObject().put("top", zzudVar.f16801f.top).put("bottom", zzudVar.f16801f.bottom).put("left", zzudVar.f16801f.left).put("right", zzudVar.f16801f.right)).put("globalVisibleBox", new JSONObject().put("top", zzudVar.f16802g.top).put("bottom", zzudVar.f16802g.bottom).put("left", zzudVar.f16802g.left).put("right", zzudVar.f16802g.right)).put("globalVisibleBoxVisible", zzudVar.f16803h).put("localVisibleBox", new JSONObject().put("top", zzudVar.f16804i.top).put("bottom", zzudVar.f16804i.bottom).put("left", zzudVar.f16804i.left).put("right", zzudVar.f16804i.right)).put("localVisibleBoxVisible", zzudVar.f16805j).put("hitBox", new JSONObject().put("top", zzudVar.f16806k.top).put("bottom", zzudVar.f16806k.bottom).put("left", zzudVar.f16806k.left).put("right", zzudVar.f16806k.right)).put("screenDensity", this.a.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmpVar.a);
            if (((Boolean) zzyt.e().c(zzacu.S1)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzudVar.n;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put("left", rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmpVar.f14554e)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
