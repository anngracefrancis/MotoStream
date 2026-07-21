package cm.aptoide.pt.view.fragment;

import cm.aptoide.pt.presenter.Presenter;
import cm.aptoide.pt.presenter.View;
import rx.e;

/* JADX INFO: loaded from: classes.dex */
public class BaseDialogView extends BaseDialogFragment implements View {

    /* JADX INFO: renamed from: cm.aptoide.pt.view.fragment.BaseDialogView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent;

        static {
            int[] iArr = new int[com.trello.rxlifecycle.g.b.values().length];
            $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent = iArr;
            try {
                iArr[com.trello.rxlifecycle.g.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DETACH.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[com.trello.rxlifecycle.g.b.DESTROY.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: convertToEvent, reason: merged with bridge method [inline-methods] */
    public e<View.LifecycleEvent> d(com.trello.rxlifecycle.g.b bVar) {
        switch (AnonymousClass1.$SwitchMap$com$trello$rxlifecycle$android$FragmentEvent[bVar.ordinal()]) {
            case 1:
            case 2:
                return e.B();
            case 3:
                return e.S(View.LifecycleEvent.CREATE);
            case 4:
                return e.S(View.LifecycleEvent.START);
            case 5:
                return e.S(View.LifecycleEvent.RESUME);
            case 6:
                return e.S(View.LifecycleEvent.PAUSE);
            case 7:
                return e.S(View.LifecycleEvent.STOP);
            case 8:
                return e.S(View.LifecycleEvent.DESTROY);
            case 9:
            case 10:
                return e.B();
            default:
                throw new IllegalStateException("Unrecognized event: " + bVar.name());
        }
    }

    @Override // cm.aptoide.pt.presenter.View
    public void attachPresenter(Presenter presenter) {
        presenter.present();
    }

    @Override // cm.aptoide.pt.presenter.View
    public final <T> com.trello.rxlifecycle.b<T> bindUntilEvent(View.LifecycleEvent lifecycleEvent) {
        return com.trello.rxlifecycle.c.b(getLifecycleEvent(), lifecycleEvent);
    }

    @Override // cm.aptoide.pt.presenter.View
    public e<View.LifecycleEvent> getLifecycleEvent() {
        return lifecycle().G(new rx.m.e() { // from class: cm.aptoide.pt.view.fragment.b
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f8056f.d((com.trello.rxlifecycle.g.b) obj);
            }
        });
    }
}
