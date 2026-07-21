package cm.aptoide.pt.editorialList;

import cm.aptoide.pt.AppCoinsManager;
import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.reactions.ReactionsManager;
import cm.aptoide.pt.reactions.network.LoadReactionModel;
import cm.aptoide.pt.reactions.network.ReactionsResponse;
import java.util.List;
import rx.Single;

/* JADX INFO: loaded from: classes.dex */
public class EditorialListManager {
    private final AppCoinsManager appCoinsManager;
    private final EditorialCardListRepository editorialCardListRepository;
    private final ReactionsManager reactionsManager;

    public EditorialListManager(EditorialCardListRepository editorialCardListRepository, ReactionsManager reactionsManager, AppCoinsManager appCoinsManager) {
        this.editorialCardListRepository = editorialCardListRepository;
        this.reactionsManager = reactionsManager;
        this.appCoinsManager = appCoinsManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: getUpdatedCards, reason: merged with bridge method [inline-methods] */
    public Single<CurationCard> b(EditorialCardListModel editorialCardListModel, LoadReactionModel loadReactionModel, String str) {
        List<CurationCard> curationCards = editorialCardListModel.getCurationCards();
        for (CurationCard curationCard : curationCards) {
            if (curationCard.getId().equals(str)) {
                curationCard.setReactions(loadReactionModel.getTopReactionList());
                curationCard.setNumberOfReactions(loadReactionModel.getTotal());
                curationCard.setUserReaction(loadReactionModel.getMyReaction());
                this.editorialCardListRepository.updateCache(editorialCardListModel, curationCards);
                return Single.m(curationCard);
            }
        }
        curationCard = null;
        this.editorialCardListRepository.updateCache(editorialCardListModel, curationCards);
        return Single.m(curationCard);
    }

    static /* synthetic */ EditorialListModel lambda$loadEditorialListModel$0(EditorialCardListModel editorialCardListModel, BonusAppcModel bonusAppcModel) {
        return new EditorialListModel(editorialCardListModel, bonusAppcModel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadEditorialListModel$1, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single a(final EditorialCardListModel editorialCardListModel) {
        return g.a.a.a.d.d(this.appCoinsManager.getBonusAppc()).n(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.t
            @Override // rx.m.e
            public final Object call(Object obj) {
                return EditorialListManager.lambda$loadEditorialListModel$0(editorialCardListModel, (BonusAppcModel) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: lambda$loadReactionModel$3, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ Single c(final String str, final LoadReactionModel loadReactionModel) {
        return this.editorialCardListRepository.loadEditorialCardListModel(false).i(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.v
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5628f.b(loadReactionModel, str, (EditorialCardListModel) obj);
            }
        });
    }

    private Single<EditorialCardListModel> loadEditorialCardListModel(boolean z, boolean z2) {
        return z ? this.editorialCardListRepository.loadMoreCurationCards() : this.editorialCardListRepository.loadEditorialCardListModel(z2);
    }

    public Single<ReactionsResponse> deleteReaction(String str, String str2) {
        return this.reactionsManager.deleteReaction(str, str2);
    }

    public boolean hasMore() {
        return this.editorialCardListRepository.hasMore();
    }

    public Single<Boolean> isFirstReaction(String str, String str2) {
        return this.reactionsManager.isFirstReaction(str, str2);
    }

    Single<EditorialListModel> loadEditorialListModel(boolean z, boolean z2) {
        return loadEditorialCardListModel(z, z2).i(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.u
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5625f.a((EditorialCardListModel) obj);
            }
        });
    }

    public Single<CurationCard> loadReactionModel(final String str, String str2) {
        return this.reactionsManager.loadReactionModel(str, str2).i(new rx.m.e() { // from class: cm.aptoide.pt.editorialList.w
            @Override // rx.m.e
            public final Object call(Object obj) {
                return this.f5633f.c(str, (LoadReactionModel) obj);
            }
        });
    }

    public Single<ReactionsResponse> setReaction(String str, String str2, String str3) {
        return this.reactionsManager.setReaction(str, str2, str3);
    }
}
