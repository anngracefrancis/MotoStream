package cm.aptoide.pt.preferences;

import android.content.SharedPreferences;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class Preferences {
    private final SharedPreferences preferences;

    /* JADX INFO: renamed from: cm.aptoide.pt.preferences.Preferences$1, reason: invalid class name */
    class AnonymousClass1 implements rx.e.a<Void> {
        final /* synthetic */ String val$key;

        AnonymousClass1(String str) {
            this.val$key = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: lambda$call$0, reason: merged with bridge method [inline-methods] */
        public /* synthetic */ void a(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
            Preferences.this.preferences.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }

        @Override // rx.m.b
        public void call(final rx.j<? super Void> jVar) {
            final SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: cm.aptoide.pt.preferences.Preferences.1.1
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    if (jVar.isUnsubscribed() || !str.equals(AnonymousClass1.this.val$key)) {
                        return;
                    }
                    jVar.onNext(null);
                }
            };
            jVar.add(rx.t.e.a(new rx.m.a() { // from class: cm.aptoide.pt.preferences.d
                @Override // rx.m.a
                public final void call() {
                    this.f6844f.a(onSharedPreferenceChangeListener);
                }
            }));
            Preferences.this.preferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
        }
    }

    public Preferences(SharedPreferences sharedPreferences) {
        this.preferences = sharedPreferences;
    }

    private rx.e<Void> change(String str) {
        return rx.e.l(new AnonymousClass1(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getBoolean$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Boolean a(String str, boolean z, Void r3) {
        return Boolean.valueOf(this.preferences.getBoolean(str, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getInt$5, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Integer b(String str, int i2, Void r3) {
        return Integer.valueOf(this.preferences.getInt(str, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getString$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String c(String str, String str2, Void r3) {
        return this.preferences.getString(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$remove$6, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d(String str) {
        this.preferences.edit().remove(str).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void e(String str, boolean z) {
        this.preferences.edit().putBoolean(str, z).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void f(String str, String str2) {
        this.preferences.edit().putString(str, str2).commit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$save$4, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void g(String str, int i2) {
        this.preferences.edit().putInt(str, i2).commit();
    }

    public Single<Boolean> contains(String str) {
        return Single.m(Boolean.valueOf(this.preferences.contains(str)));
    }

    public rx.e<Boolean> getBoolean(final String str, final boolean z) {
        return change(str).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.f
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6849f.a(str, z, (Void) obj);
            }
        }).C0(Boolean.valueOf(this.preferences.getBoolean(str, z)));
    }

    public rx.e<Integer> getInt(final String str, final int i2) {
        return change(str).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.j
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6860f.b(str, i2, (Void) obj);
            }
        }).C0(Integer.valueOf(this.preferences.getInt(str, i2)));
    }

    public rx.e<String> getString(final String str, final String str2) {
        return change(str).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.k
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6863f.c(str, str2, (Void) obj);
            }
        }).C0(this.preferences.getString(str, str2));
    }

    public rx.b remove(final String str) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.preferences.i
            @Override // rx.m.a
            public final void call() {
                this.f6858f.d(str);
            }
        });
    }

    public rx.b save(final String str, final boolean z) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.preferences.e
            @Override // rx.m.a
            public final void call() {
                this.f6846f.e(str, z);
            }
        });
    }

    public rx.b save(final String str, final String str2) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.preferences.g
            @Override // rx.m.a
            public final void call() {
                this.f6852f.f(str, str2);
            }
        });
    }

    public rx.b save(final String str, final int i2) {
        return rx.b.t(new rx.m.a() { // from class: cm.aptoide.pt.preferences.h
            @Override // rx.m.a
            public final void call() {
                this.f6855f.g(str, i2);
            }
        });
    }
}
