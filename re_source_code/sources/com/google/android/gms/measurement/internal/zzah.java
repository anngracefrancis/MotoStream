package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import cm.aptoide.pt.notification.PullingContentService;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzah extends q4 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f18055c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f18056d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Boolean f18057e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AccountManager f18058f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Boolean f18059g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f18060h;

    zzah(zzfx zzfxVar) {
        super(zzfxVar);
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzw G() {
        return super.G();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzah e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Context f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzfu g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ zzet h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.r4, com.google.android.gms.measurement.internal.s4
    public final /* bridge */ /* synthetic */ Clock j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzer k() {
        return super.k();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzkk l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ r3 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.r4
    public final /* bridge */ /* synthetic */ zzx n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.q4
    protected final boolean s() {
        Calendar calendar = Calendar.getInstance();
        this.f18055c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f18056d = sb.toString();
        return false;
    }

    public final boolean u(Context context) {
        if (this.f18057e == null) {
            G();
            this.f18057e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f18057e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f18057e.booleanValue();
    }

    public final long v() {
        p();
        return this.f18055c;
    }

    public final String w() {
        p();
        return this.f18056d;
    }

    final long x() {
        d();
        return this.f18060h;
    }

    final void y() {
        d();
        this.f18059g = null;
        this.f18060h = 0L;
    }

    final boolean z() {
        d();
        long jA = j().a();
        if (jA - this.f18060h > PullingContentService.UPDATES_INTERVAL) {
            this.f18059g = null;
        }
        Boolean bool = this.f18059g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (androidx.core.content.a.a(f(), "android.permission.GET_ACCOUNTS") != 0) {
            h().L().a("Permission error checking for dasher/unicorn accounts");
            this.f18060h = jA;
            this.f18059g = Boolean.FALSE;
            return false;
        }
        if (this.f18058f == null) {
            this.f18058f = AccountManager.get(f());
        }
        try {
            Account[] result = this.f18058f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
            if (result != null && result.length > 0) {
                this.f18059g = Boolean.TRUE;
                this.f18060h = jA;
                return true;
            }
            Account[] result2 = this.f18058f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
            if (result2 != null && result2.length > 0) {
                this.f18059g = Boolean.TRUE;
                this.f18060h = jA;
                return true;
            }
            this.f18060h = jA;
            this.f18059g = Boolean.FALSE;
            return false;
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            h().I().b("Exception checking account types", e2);
        }
    }
}
