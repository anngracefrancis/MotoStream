package cm.aptoide.pt.view.rx;

import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: loaded from: classes.dex */
public class RxSwitch {
    private RxSwitch() {
        throw new AssertionError("No instances.");
    }

    public static rx.e<Boolean> checks(SwitchCompat switchCompat) {
        e.g.a.a.b.a(switchCompat, "switchCompat == null");
        return rx.e.l(new SwitchOnCheckOnSubscribe(switchCompat));
    }
}
