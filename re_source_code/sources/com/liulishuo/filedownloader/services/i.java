package com.liulishuo.filedownloader.services;

import android.R;
import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import e.h.a.d0;

/* JADX INFO: compiled from: ForegroundServiceConfig.java */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(26)
public class i {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f20529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Notification f20531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f20532e;

    /* JADX INFO: compiled from: ForegroundServiceConfig.java */
    public static class b {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f20533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f20534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Notification f20535d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f20536e;

        public i a() {
            i iVar = new i();
            String str = this.f20533b;
            if (str == null) {
                str = "filedownloader_channel";
            }
            iVar.i(str);
            String str2 = this.f20534c;
            if (str2 == null) {
                str2 = "Filedownloader";
            }
            iVar.j(str2);
            int i2 = this.a;
            if (i2 == 0) {
                i2 = R.drawable.arrow_down_float;
            }
            iVar.k(i2);
            iVar.g(this.f20536e);
            iVar.h(this.f20535d);
            return iVar;
        }

        public b b(boolean z) {
            this.f20536e = z;
            return this;
        }
    }

    private Notification a(Context context) {
        String string = context.getString(d0.f21245b);
        String string2 = context.getString(d0.a);
        Notification.Builder builder = new Notification.Builder(context, this.f20529b);
        builder.setContentTitle(string).setContentText(string2).setSmallIcon(R.drawable.arrow_down_float);
        return builder.build();
    }

    public Notification b(Context context) {
        if (this.f20531d == null) {
            if (e.h.a.k0.d.a) {
                e.h.a.k0.d.a(this, "build default notification", new Object[0]);
            }
            this.f20531d = a(context);
        }
        return this.f20531d;
    }

    public String c() {
        return this.f20529b;
    }

    public String d() {
        return this.f20530c;
    }

    public int e() {
        return this.a;
    }

    public boolean f() {
        return this.f20532e;
    }

    public void g(boolean z) {
        this.f20532e = z;
    }

    public void h(Notification notification) {
        this.f20531d = notification;
    }

    public void i(String str) {
        this.f20529b = str;
    }

    public void j(String str) {
        this.f20530c = str;
    }

    public void k(int i2) {
        this.a = i2;
    }

    public String toString() {
        return "ForegroundServiceConfig{notificationId=" + this.a + ", notificationChannelId='" + this.f20529b + "', notificationChannelName='" + this.f20530c + "', notification=" + this.f20531d + ", needRecreateChannelId=" + this.f20532e + '}';
    }

    private i() {
    }
}
