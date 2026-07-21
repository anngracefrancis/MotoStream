package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.FirebaseConstants;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new i0();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    Bundle f19778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f19779g;

    /* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    public static class b {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19780b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String[] f19781c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f19782d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f19783e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String[] f19784f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f19785g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f19786h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final String f19787i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final String f19788j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final String f19789k;
        private final String l;
        private final String m;
        private final Uri n;
        private final String o;
        private final Integer p;
        private final Integer q;
        private final Integer r;
        private final int[] s;
        private final Long t;
        private final boolean u;
        private final boolean v;
        private final boolean w;
        private final boolean x;
        private final boolean y;
        private final long[] z;

        private b(h0 h0Var) {
            this.a = h0Var.p("gcm.n.title");
            this.f19780b = h0Var.h("gcm.n.title");
            this.f19781c = c(h0Var, "gcm.n.title");
            this.f19782d = h0Var.p("gcm.n.body");
            this.f19783e = h0Var.h("gcm.n.body");
            this.f19784f = c(h0Var, "gcm.n.body");
            this.f19785g = h0Var.p("gcm.n.icon");
            this.f19787i = h0Var.o();
            this.f19788j = h0Var.p("gcm.n.tag");
            this.f19789k = h0Var.p("gcm.n.color");
            this.l = h0Var.p("gcm.n.click_action");
            this.m = h0Var.p("gcm.n.android_channel_id");
            this.n = h0Var.f();
            this.f19786h = h0Var.p("gcm.n.image");
            this.o = h0Var.p("gcm.n.ticker");
            this.p = h0Var.b("gcm.n.notification_priority");
            this.q = h0Var.b("gcm.n.visibility");
            this.r = h0Var.b("gcm.n.notification_count");
            this.u = h0Var.a("gcm.n.sticky");
            this.v = h0Var.a("gcm.n.local_only");
            this.w = h0Var.a("gcm.n.default_sound");
            this.x = h0Var.a("gcm.n.default_vibrate_timings");
            this.y = h0Var.a("gcm.n.default_light_settings");
            this.t = h0Var.j("gcm.n.event_time");
            this.s = h0Var.e();
            this.z = h0Var.q();
        }

        private static String[] c(h0 h0Var, String str) {
            Object[] objArrG = h0Var.g(str);
            if (objArrG == null) {
                return null;
            }
            String[] strArr = new String[objArrG.length];
            for (int i2 = 0; i2 < objArrG.length; i2++) {
                strArr[i2] = String.valueOf(objArrG[i2]);
            }
            return strArr;
        }

        public String a() {
            return this.f19782d;
        }

        public Uri b() {
            String str = this.f19786h;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public String d() {
            return this.a;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.f19778f = bundle;
    }

    @KeepForSdk
    public Intent W() {
        Intent intent = new Intent();
        intent.putExtras(this.f19778f);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        i0.c(this, parcel, i2);
    }

    public String y() {
        String string = this.f19778f.getString(FirebaseConstants.FIREBASE_MESSAGE_ID);
        return string == null ? this.f19778f.getString("message_id") : string;
    }

    public b z() {
        if (this.f19779g == null && h0.t(this.f19778f)) {
            this.f19779g = new b(new h0(this.f19778f));
        }
        return this.f19779g;
    }
}
