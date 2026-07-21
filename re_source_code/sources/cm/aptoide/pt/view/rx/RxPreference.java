package cm.aptoide.pt.view.rx;

import androidx.preference.CheckBoxPreference;
import androidx.preference.Preference;

/* JADX INFO: loaded from: classes.dex */
public class RxPreference {
    private RxPreference() {
        throw new AssertionError("No instances.");
    }

    public static rx.e<Boolean> checks(CheckBoxPreference checkBoxPreference) {
        e.g.a.a.b.a(checkBoxPreference, "preference == null");
        return rx.e.l(new PreferenceOnCheckOnSubscribe(checkBoxPreference));
    }

    public static rx.e<Preference> clicks(Preference preference) {
        e.g.a.a.b.a(preference, "preference == null");
        return rx.e.l(new PreferenceClickOnSubscribe(preference));
    }
}
