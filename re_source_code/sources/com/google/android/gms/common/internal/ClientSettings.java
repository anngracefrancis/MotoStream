package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
@KeepForSdk
public final class ClientSettings {
    private final Account a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<Scope> f11944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Set<Scope> f11945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<Api<?>, OptionalApiSettings> f11946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f11947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final View f11948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f11949g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f11950h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final SignInOptions f11951i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f11952j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Integer f11953k;

    @KeepForSdk
    public static final class Builder {
        private Account a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private c.e.b<Scope> f11954b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Map<Api<?>, OptionalApiSettings> f11955c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private View f11957e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11958f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f11959g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f11961i;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f11956d = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private SignInOptions f11960h = SignInOptions.f18274f;

        public final Builder a(Collection<Scope> collection) {
            if (this.f11954b == null) {
                this.f11954b = new c.e.b<>();
            }
            this.f11954b.addAll(collection);
            return this;
        }

        @KeepForSdk
        public final ClientSettings b() {
            return new ClientSettings(this.a, this.f11954b, this.f11955c, this.f11956d, this.f11957e, this.f11958f, this.f11959g, this.f11960h, this.f11961i);
        }

        public final Builder c(Account account) {
            this.a = account;
            return this;
        }

        public final Builder d(String str) {
            this.f11959g = str;
            return this;
        }

        @KeepForSdk
        public final Builder e(String str) {
            this.f11958f = str;
            return this;
        }
    }

    public static final class OptionalApiSettings {
        public final Set<Scope> a;
    }

    public ClientSettings(Account account, Set<Scope> set, Map<Api<?>, OptionalApiSettings> map, int i2, View view, String str, String str2, SignInOptions signInOptions, boolean z) {
        this.a = account;
        Set<Scope> setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.f11944b = setUnmodifiableSet;
        map = map == null ? Collections.EMPTY_MAP : map;
        this.f11946d = map;
        this.f11948f = view;
        this.f11947e = i2;
        this.f11949g = str;
        this.f11950h = str2;
        this.f11951i = signInOptions;
        this.f11952j = z;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator<OptionalApiSettings> it = map.values().iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().a);
        }
        this.f11945c = Collections.unmodifiableSet(hashSet);
    }

    @KeepForSdk
    public static ClientSettings a(Context context) {
        return new GoogleApiClient.Builder(context).f();
    }

    @KeepForSdk
    public final Account b() {
        return this.a;
    }

    @KeepForSdk
    @Deprecated
    public final String c() {
        Account account = this.a;
        if (account != null) {
            return account.name;
        }
        return null;
    }

    @KeepForSdk
    public final Account d() {
        Account account = this.a;
        return account != null ? account : new Account(BaseGmsClient.DEFAULT_ACCOUNT, "com.google");
    }

    @KeepForSdk
    public final Set<Scope> e() {
        return this.f11945c;
    }

    @KeepForSdk
    public final Set<Scope> f(Api<?> api) {
        OptionalApiSettings optionalApiSettings = this.f11946d.get(api);
        if (optionalApiSettings == null || optionalApiSettings.a.isEmpty()) {
            return this.f11944b;
        }
        HashSet hashSet = new HashSet(this.f11944b);
        hashSet.addAll(optionalApiSettings.a);
        return hashSet;
    }

    public final Integer g() {
        return this.f11953k;
    }

    public final Map<Api<?>, OptionalApiSettings> h() {
        return this.f11946d;
    }

    public final String i() {
        return this.f11950h;
    }

    @KeepForSdk
    public final String j() {
        return this.f11949g;
    }

    @KeepForSdk
    public final Set<Scope> k() {
        return this.f11944b;
    }

    public final SignInOptions l() {
        return this.f11951i;
    }

    public final boolean m() {
        return this.f11952j;
    }

    public final void n(Integer num) {
        this.f11953k = num;
    }
}
