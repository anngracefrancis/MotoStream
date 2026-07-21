package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdky;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdkx<T_WRAPPER extends zzdky<T_ENGINE>, T_ENGINE> {
    private static final Logger a = Logger.getLogger(zzdkx.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final List<Provider> f15959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final zzdkx<zzdkz, Cipher> f15960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final zzdkx<zzdld, Mac> f15961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final zzdkx<zzdlf, Signature> f15962e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final zzdkx<zzdle, MessageDigest> f15963f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final zzdkx<zzdla, KeyAgreement> f15964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final zzdkx<zzdlc, KeyPairGenerator> f15965h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final zzdkx<zzdlb, KeyFactory> f15966i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private T_WRAPPER f15967j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private List<Provider> f15968k = f15959b;
    private boolean l = true;

    static {
        if (zzdlv.a()) {
            String[] strArr = {"GmsCore_OpenSSL", "AndroidOpenSSL"};
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
                String str = strArr[i2];
                Provider provider = Security.getProvider(str);
                if (provider != null) {
                    arrayList.add(provider);
                } else {
                    a.logp(Level.INFO, "com.google.crypto.tink.subtle.EngineFactory", "toProviderList", String.format("Provider %s not available", str));
                }
            }
            f15959b = arrayList;
        } else {
            f15959b = new ArrayList();
        }
        f15960c = new zzdkx<>(new zzdkz());
        f15961d = new zzdkx<>(new zzdld());
        f15962e = new zzdkx<>(new zzdlf());
        f15963f = new zzdkx<>(new zzdle());
        f15964g = new zzdkx<>(new zzdla());
        f15965h = new zzdkx<>(new zzdlc());
        f15966i = new zzdkx<>(new zzdlb());
    }

    private zzdkx(T_WRAPPER t_wrapper) {
        this.f15967j = t_wrapper;
    }

    private final boolean a(String str, Provider provider) {
        try {
            this.f15967j.a(str, provider);
            return true;
        } catch (Exception e2) {
            zzdmb.d(e2);
            return false;
        }
    }

    public final T_ENGINE b(String str) throws GeneralSecurityException {
        for (Provider provider : this.f15968k) {
            if (a(str, provider)) {
                return (T_ENGINE) this.f15967j.a(str, provider);
            }
        }
        if (this.l) {
            return (T_ENGINE) this.f15967j.a(str, null);
        }
        throw new GeneralSecurityException("No good Provider found.");
    }
}
