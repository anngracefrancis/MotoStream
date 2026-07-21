package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes.dex */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f11640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile String f11641c;

    public GoogleSignatureVerifier(Context context) {
        this.f11640b = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier a(Context context) {
        Preconditions.k(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (a == null) {
                k.d(context);
                a = new GoogleSignatureVerifier(context);
            }
        }
        return a;
    }

    static final g d(PackageInfo packageInfo, g... gVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        h hVar = new h(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (gVarArr[i2].equals(hVar)) {
                return gVarArr[i2];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z) {
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? d(packageInfo, j.a) : d(packageInfo, j.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final m f(String str, boolean z, boolean z2) {
        m mVarC;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return m.c("null pkg");
        }
        if (str.equals(this.f11641c)) {
            return m.b();
        }
        if (k.e()) {
            mVarC = k.b(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f11640b.getPackageManager().getPackageInfo(str, 64);
                boolean zHonorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b);
                if (packageInfo == null) {
                    mVarC = m.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        mVarC = m.c("single cert required");
                    } else {
                        h hVar = new h(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        m mVarA = k.a(str2, hVar, zHonorsDebugCertificates, false);
                        mVarC = (!mVarA.f12088b || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !k.a(str2, hVar, false, true).f12088b) ? mVarA : m.c("debuggable release cert app rejected");
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                return m.d("no pkg ".concat(str), e2);
            }
        }
        if (mVarC.f12088b) {
            this.f11641c = str;
        }
        return mVarC;
    }

    @KeepForSdk
    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean c(int i2) {
        m mVarC;
        String[] packagesForUid = this.f11640b.getPackageManager().getPackagesForUid(i2);
        if (packagesForUid == null || (packagesForUid.length) == 0) {
            mVarC = m.c("no pkgs");
        } else {
            mVarC = null;
            for (String str : packagesForUid) {
                mVarC = f(str, false, false);
                if (!mVarC.f12088b) {
                }
            }
            Preconditions.k(mVarC);
        }
        mVarC.e();
        return mVarC.f12088b;
    }
}
