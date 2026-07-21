package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacf {
    private final Context a;

    public zzacf(Context context) {
        Preconditions.l(context, "Context can not be null");
        this.a = context;
    }

    private final boolean a(Intent intent) {
        Preconditions.l(intent, "Intent can not be null");
        return !this.a.getPackageManager().queryIntentActivities(intent, 0).isEmpty();
    }

    public final boolean b() {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        return a(intent);
    }

    public final boolean c() {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse("sms:"));
        return a(intent);
    }

    public final boolean d() {
        return ((Boolean) zzazl.a(this.a, new k())).booleanValue() && Wrappers.a(this.a).a("android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    @TargetApi(14)
    public final boolean e() {
        return a(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"));
    }
}
