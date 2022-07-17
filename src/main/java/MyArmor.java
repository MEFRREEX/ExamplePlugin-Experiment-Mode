import cn.nukkit.item.ItemArmor;
import cn.nukkit.item.customitem.ItemCustomArmor;

public class MyArmor extends ItemCustomArmor {

    public MyArmor() {
        super("blocklynukkit:bfj", "测试盔甲", "bfj");
    }

    @Override
    public boolean isChestplate() {
        return true;
    }

    @Override
    public int getTier() {
        return ItemArmor.TIER_DIAMOND;
    }

    @Override
    public int getMaxDurability() {
        return 666;
    }

    @Override
    public int getArmorPoints() {
        return 100;
    }
}
