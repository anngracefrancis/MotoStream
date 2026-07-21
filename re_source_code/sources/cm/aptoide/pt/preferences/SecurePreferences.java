package cm.aptoide.pt.preferences;

import android.content.SharedPreferences;
import cm.aptoide.pt.preferences.secure.SecureCoderDecoder;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class SecurePreferences extends Preferences {
    private final SecureCoderDecoder decoder;

    public SecurePreferences(SharedPreferences sharedPreferences, SecureCoderDecoder secureCoderDecoder) {
        super(sharedPreferences);
        this.decoder = secureCoderDecoder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$getString$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ String h(String str) {
        return this.decoder.decrypt(str);
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public Single<Boolean> contains(String str) {
        return super.contains(this.decoder.encrypt(str));
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.e<Boolean> getBoolean(String str, boolean z) {
        return getString(str, String.valueOf(z)).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.l
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf((String) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.e<Integer> getInt(String str, int i2) {
        return getString(str, String.valueOf(i2)).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.n
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Integer.valueOf((String) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.e<String> getString(String str, String str2) {
        return super.getString(this.decoder.encrypt(str), this.decoder.encrypt(str2)).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.m
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6867f.h((String) obj);
            }
        });
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.b remove(String str) {
        return super.remove(this.decoder.encrypt(str));
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.b save(String str, boolean z) {
        return save(str, String.valueOf(z));
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.b save(String str, String str2) {
        return super.save(this.decoder.encrypt(str), this.decoder.encrypt(str2));
    }

    @Override // cm.aptoide.pt.preferences.Preferences
    public rx.b save(String str, int i2) {
        return save(str, String.valueOf(i2));
    }
}
