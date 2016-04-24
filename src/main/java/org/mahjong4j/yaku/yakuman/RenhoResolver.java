package org.mahjong4j.yaku.yakuman;

import org.mahjong4j.GeneralSituation;
import org.mahjong4j.PersonalSituation;
import org.mahjong4j.hands.MentsuComp;

/**
 * @author yu1ro
 */
public class RenhoResolver implements YakumanResolver {
    private final MentsuComp comp;
    private final GeneralSituation generalSituation;
    private final PersonalSituation personalSituation;

    public RenhoResolver(MentsuComp comp, GeneralSituation generalSituation, PersonalSituation personalSituation) {

        this.comp = comp;
        this.generalSituation = generalSituation;
        this.personalSituation = personalSituation;
    }

    @Override
    public MahjongYakumanEnum getYakuman() {
        return MahjongYakumanEnum.RENHO;
    }

    @Override
    public boolean isMatch() {
        // avoid NullPointerException
        if (generalSituation == null || personalSituation == null) return false;
        return generalSituation.isFirstRound() && !personalSituation.isTsumo() && !personalSituation.isDealer();
    }
}