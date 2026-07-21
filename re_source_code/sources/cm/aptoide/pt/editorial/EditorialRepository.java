package cm.aptoide.pt.editorial;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import okhttp3.HttpUrl;
import rx.Single;

/* JADX INFO: compiled from: EditorialRepository.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/editorial/EditorialRepository;", HttpUrl.FRAGMENT_ENCODE_SET, "editorialService", "Lcm/aptoide/pt/editorial/EditorialService;", "(Lcm/aptoide/pt/editorial/EditorialService;)V", "cachedEditorialViewModel", "Lcm/aptoide/pt/editorial/EditorialViewModel;", "loadEditorialViewModel", "Lrx/Single;", "editorialLoadSource", "Lcm/aptoide/pt/editorial/EditorialLoadSource;", "saveResponse", "editorialViewModel", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EditorialRepository {
    private EditorialViewModel cachedEditorialViewModel;
    private final EditorialService editorialService;

    public EditorialRepository(EditorialService editorialService) {
        kotlin.jvm.internal.m.f(editorialService, "editorialService");
        this.editorialService = editorialService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadEditorialViewModel$lambda-0, reason: not valid java name */
    public static final EditorialViewModel m145loadEditorialViewModel$lambda0(EditorialRepository editorialRepository, EditorialViewModel editorialViewModel) {
        kotlin.jvm.internal.m.f(editorialRepository, "this$0");
        kotlin.jvm.internal.m.e(editorialViewModel, "editorialViewModel");
        return editorialRepository.saveResponse(editorialViewModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: loadEditorialViewModel$lambda-1, reason: not valid java name */
    public static final EditorialViewModel m146loadEditorialViewModel$lambda1(EditorialRepository editorialRepository, EditorialViewModel editorialViewModel) {
        kotlin.jvm.internal.m.f(editorialRepository, "this$0");
        kotlin.jvm.internal.m.e(editorialViewModel, "editorialViewModel");
        return editorialRepository.saveResponse(editorialViewModel);
    }

    private final EditorialViewModel saveResponse(EditorialViewModel editorialViewModel) {
        if (!editorialViewModel.hasError() && !editorialViewModel.isLoading()) {
            this.cachedEditorialViewModel = editorialViewModel;
        }
        return editorialViewModel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Single<EditorialViewModel> loadEditorialViewModel(EditorialLoadSource editorialLoadSource) {
        Single singleN;
        kotlin.jvm.internal.m.f(editorialLoadSource, "editorialLoadSource");
        EditorialViewModel editorialViewModel = this.cachedEditorialViewModel;
        if (editorialViewModel != null) {
            Single<EditorialViewModel> singleM = Single.m(editorialViewModel);
            kotlin.jvm.internal.m.e(singleM, "just(cachedEditorialViewModel)");
            return singleM;
        }
        if (editorialLoadSource instanceof CardId) {
            singleN = this.editorialService.loadEditorialViewModel(((CardId) editorialLoadSource).getCardId()).n(new rx.m.e() { // from class: cm.aptoide.pt.editorial.d6
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return EditorialRepository.m145loadEditorialViewModel$lambda0(this.f5314f, (EditorialViewModel) obj);
                }
            });
        } else {
            if (!(editorialLoadSource instanceof Slug)) {
                throw new NoWhenBranchMatchedException();
            }
            singleN = this.editorialService.loadEditorialViewModelWithSlug(((Slug) editorialLoadSource).getSlug()).n(new rx.m.e() { // from class: cm.aptoide.pt.editorial.c6
                @Override // rx.m.e
                public final Object call(Object obj) {
                    return EditorialRepository.m146loadEditorialViewModel$lambda1(this.f5302f, (EditorialViewModel) obj);
                }
            });
        }
        kotlin.jvm.internal.m.e(singleN, "when (editorialLoadSourc…wModel)\n        }\n      }");
        return singleN;
    }
}
