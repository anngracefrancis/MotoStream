package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.provider.CalendarContract;
import android.text.TextUtils;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzapo extends zzaqb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f14036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f14037d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14038e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f14039f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f14040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f14042i;

    public zzapo(zzbgz zzbgzVar, Map<String, String> map) {
        super(zzbgzVar, "createCalendarEvent");
        this.f14036c = map;
        this.f14037d = zzbgzVar.a();
        this.f14038e = k("description");
        this.f14041h = k("summary");
        this.f14039f = l("start_ticks");
        this.f14040g = l("end_ticks");
        this.f14042i = k("location");
    }

    private final String k(String str) {
        return TextUtils.isEmpty(this.f14036c.get(str)) ? HttpUrl.FRAGMENT_ENCODE_SET : this.f14036c.get(str);
    }

    private final long l(String str) {
        String str2 = this.f14036c.get(str);
        if (str2 == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str2);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    @TargetApi(14)
    final Intent h() {
        Intent data = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
        data.putExtra("title", this.f14038e);
        data.putExtra("eventLocation", this.f14042i);
        data.putExtra("description", this.f14041h);
        long j2 = this.f14039f;
        if (j2 > -1) {
            data.putExtra("beginTime", j2);
        }
        long j3 = this.f14040g;
        if (j3 > -1) {
            data.putExtra("endTime", j3);
        }
        data.setFlags(268435456);
        return data;
    }

    public final void i() {
        if (this.f14037d == null) {
            e("Activity context is not available.");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.y(this.f14037d).e()) {
            e("This feature is not available on the device.");
            return;
        }
        zzk.zzlg();
        AlertDialog.Builder builderX = zzaxi.x(this.f14037d);
        Resources resourcesB = zzk.zzlk().b();
        builderX.setTitle(resourcesB != null ? resourcesB.getString(R.string.s5) : "Create calendar event");
        builderX.setMessage(resourcesB != null ? resourcesB.getString(R.string.s6) : "Allow Ad to create a calendar event?");
        builderX.setPositiveButton(resourcesB != null ? resourcesB.getString(R.string.s3) : "Accept", new h3(this));
        builderX.setNegativeButton(resourcesB != null ? resourcesB.getString(R.string.s4) : "Decline", new i3(this));
        builderX.create().show();
    }
}
