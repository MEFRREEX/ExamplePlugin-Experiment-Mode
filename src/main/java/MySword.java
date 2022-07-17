import cn.nukkit.item.ItemSwordDiamond;
import cn.nukkit.item.customitem.ItemCustomTool;

public class MySword extends ItemCustomTool {
    public MySword() {
        super("blocklynukkit:sh", "测试剑", "sh");
    }

    @Override
    public int getMaxDurability() {
        return 1000;
    }

    @Override
    public int getTier() {
        return ItemSwordDiamond.TIER_DIAMOND;
    }

    @Override
    public int getAttackDamage() {
        return 30;
    }
}
