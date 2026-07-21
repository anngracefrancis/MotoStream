package cm.aptoide.pt.preferences;

/* JADX INFO: loaded from: classes.dex */
public class LocalPersistenceAdultContent {
    private static final String ADULT_CONTENT_PIN_PREFERENCES_KEY = "Maturepin";
    private static final String ADULT_CONTENT_PREFERENCES_KEY = "matureChkBox";
    private final Preferences preferences;
    private final SecurePreferences securePreferences;

    public LocalPersistenceAdultContent(Preferences preferences, SecurePreferences securePreferences) {
        this.preferences = preferences;
        this.securePreferences = securePreferences;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$enable$2, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b a(int i2, Integer num) {
        return num.equals(Integer.valueOf(i2)) ? enable() : rx.b.s(new SecurityException("Pin does not match."));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$removePin$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ rx.b b(int i2, Integer num) {
        return num.equals(Integer.valueOf(i2)) ? this.securePreferences.remove(ADULT_CONTENT_PIN_PREFERENCES_KEY) : rx.b.s(new SecurityException("Pin does not match."));
    }

    public rx.b disable() {
        return this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, false);
    }

    public rx.b enable() {
        return this.preferences.save(ADULT_CONTENT_PREFERENCES_KEY, true);
    }

    public rx.e<Boolean> enabled() {
        return this.preferences.getBoolean(ADULT_CONTENT_PREFERENCES_KEY, false);
    }

    public rx.e<Boolean> pinRequired() {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).X(new rx.m.e() { // from class: cm.aptoide.pt.preferences.c
            @Override // rx.m.e
            public final Object call(Object obj) {
                return Boolean.valueOf(((Integer) obj).intValue() != -1);
            }
        });
    }

    public rx.b removePin(final int i2) {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.preferences.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6841f.b(i2, (Integer) obj);
            }
        });
    }

    public rx.b requirePin(int i2) {
        return this.securePreferences.save(ADULT_CONTENT_PIN_PREFERENCES_KEY, i2);
    }

    public rx.b enable(final int i2) {
        return this.securePreferences.getInt(ADULT_CONTENT_PIN_PREFERENCES_KEY, -1).E().Z0().j(new rx.m.e() { // from class: cm.aptoide.pt.preferences.a
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f6839f.a(i2, (Integer) obj);
            }
        });
    }
}
