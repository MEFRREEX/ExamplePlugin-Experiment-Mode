import cn.nukkit.Player;
import cn.nukkit.Server;
import cn.nukkit.block.Block;
import cn.nukkit.block.customblock.CustomBlock;
import cn.nukkit.block.customblock.type.MaterialsFactory;
import cn.nukkit.blockproperty.BlockProperties;
import cn.nukkit.blockproperty.BooleanBlockProperty;
import cn.nukkit.item.Item;
import cn.nukkit.math.BlockFace;
import cn.nukkit.math.Vector3;
import cn.nukkit.nbt.tag.CompoundTag;
import cn.nukkit.nbt.tag.FloatTag;
import cn.nukkit.nbt.tag.ListTag;
import cn.nukkit.nbt.tag.StringTag;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MySlab extends Block implements CustomBlock {
    public final BooleanBlockProperty BRIDGE_TOP_SLOT_BIT = new BooleanBlockProperty("bridge:top_slot_bit", false);
    public final BooleanBlockProperty BRIDGE_IS_FULL_BIT = new BooleanBlockProperty("bridge:is_full_bit", false);

    @Override
    public String getNamespace() {
        return "blocklynukkit:blue_mahoe_slab";
    }

    @Override
    public String getTexture() {
        return "blue_mahoe_planks";
    }

    @Override
    public String getGeometry() {
        return "geometry.custom_slab";
    }

    @Override
    public CompoundTag getMaterials() {
        return MaterialsFactory.of(new CompoundTag())
                .process("*", "opaque", getTexture())
                .process("down", "opaque", getTexture())
                .process("up", "opaque", getTexture())
                .build();
    }

    @Override
    public CompoundTag componentNBTProcessor(CompoundTag componentNBT) {
        return componentNBT
//                .putCompound("minecraft:on_player_placing", new CompoundTag()
//                        .putString("triggerType", "radio:up"))
                .putCompound("minecraft:part_visibility", new CompoundTag()
                        .putCompound("boneConditions", new CompoundTag()
                                .putCompound("lower", new CompoundTag()
                                        .putString("bone_condition", "!query.block_property('bridge:top_slot_bit') || query.block_property('bridge:is_full_bit')")
                                        .putString("bone_name", "lower")
                                        .putInt("molang_version", 6))
                                .putCompound("upper", new CompoundTag()
                                        .putString("bone_condition", "query.block_property('bridge:top_slot_bit') || query.block_property('bridge:is_full_bit')")
                                        .putString("bone_name", "upper")
                                        .putInt("molang_version", 6))));
    }

    @Nullable
    @Override
    public ListTag<CompoundTag> getPermutations() {
        var cmp1 = new CompoundTag()
                .putCompound("components", new CompoundTag()
                        .putCompound("minecraft:collision_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 0))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 8))
                                        .add(new FloatTag("", 16))))
                        .putCompound("minecraft:selection_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 0))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 8))
                                        .add(new FloatTag("", 16)))))
                .putString("condition", "query.block_property('bridge:top_slot_bit') == false && query.block_property('bridge:is_full_bit') == false");
        var cmp2 = new CompoundTag()
                .putCompound("components", new CompoundTag()
                        .putCompound("minecraft:collision_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 8))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))))
                        .putCompound("minecraft:selection_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 8))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16)))))
                .putString("condition", "query.block_property('bridge:top_slot_bit') == true && query.block_property('bridge:is_full_bit') == false");
        var cmp3 = new CompoundTag()
                .putList(new ListTag<StringTag>("blockTags").add(new StringTag("", "fence-connectable")))
                .putCompound("components", new CompoundTag()
                        .putCompound("minecraft:collision_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 0))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))))
                        .putCompound("minecraft:selection_box", new CompoundTag()
                                .putBoolean("enabled", true)
                                .putList(new ListTag<FloatTag>("origin")
                                        .add(new FloatTag("", -8))
                                        .add(new FloatTag("", 0))
                                        .add(new FloatTag("", -8)))
                                .putList(new ListTag<FloatTag>("size")
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16))
                                        .add(new FloatTag("", 16)))))
                .putString("condition", "query.block_property('bridge:is_full_bit') == true");
        return new ListTag<CompoundTag>().add(cmp1).add(cmp2).add(cmp3);
    }

    @Override
    public double calculateBreakTime(@NotNull Item item, @Nullable Player player) {
        return 3;
    }

    @Override
    public double getFrictionFactor() {
        return 0.1;
    }

    @Override
    public double getResistance() {
        return 5;
    }

    @Override
    public int getLightLevel() {
        return 15;
    }

    @Override
    public String getName() {
        return CustomBlock.super.getName();
    }

    @Override
    public int getId() {
        return CustomBlock.super.getId();
    }

    @Override
    public int getLightFilter() {
        return 15;
    }

    @Override
    public int getBurnAbility() {
        return 0;
    }

    @Override
    public int getBurnChance() {
        return 0;
    }

    @Override
    public int getItemMaxStackSize() {
        return 64;
    }

    public boolean isOnTop() {
        return getBooleanValue(BRIDGE_TOP_SLOT_BIT);
    }

    public boolean isFull() {
        return getBooleanValue(BRIDGE_IS_FULL_BIT);
    }

    @NotNull
    @Override
    public BlockProperties getProperties() {
        return new BlockProperties(
                BRIDGE_TOP_SLOT_BIT, BRIDGE_IS_FULL_BIT
        );
    }

    @Override
    public boolean place(@NotNull Item item, @NotNull Block block, @NotNull Block target, @NotNull BlockFace face, double fx, double fy, double fz, @Nullable Player player) {
        setBooleanValue(BRIDGE_IS_FULL_BIT, false);
        if (face == BlockFace.DOWN) {
            if (target instanceof MySlab) {//如果往上层半砖下方放置半砖，且不完整,则设为完整
                if (target.getBooleanValue(BRIDGE_TOP_SLOT_BIT) && !target.getBooleanValue(BRIDGE_IS_FULL_BIT)) {
                    setBooleanValue(BRIDGE_TOP_SLOT_BIT, false);
                    setBooleanValue(BRIDGE_IS_FULL_BIT, true);
                    this.getLevel().setBlock(target, this, true);
                    //todo 未知原因导致客户端生成假方块，需要发送UpdateBlockPacket解决
                    this.getLevel().sendBlocks(Server.getInstance().getOnlinePlayers().values().toArray(new Player[0]), new Vector3[]{block});
                    return true;
                } else if (!target.getBooleanValue(BRIDGE_TOP_SLOT_BIT) || target.getBooleanValue(BRIDGE_IS_FULL_BIT)) {
                    setBooleanValue(BRIDGE_TOP_SLOT_BIT, true);
                    this.getLevel().setBlock(this, this, true);
                    return true;
                } else return false;
            } else {
                setBooleanValue(BRIDGE_TOP_SLOT_BIT, true);
                this.getLevel().setBlock(this, this, true);
                return true;
            }
        } else if (face == BlockFace.UP) {//如果往下层半砖上方放置半砖，且不完整,则设为完整
            if (target instanceof MySlab) {
                if (!target.getBooleanValue(BRIDGE_TOP_SLOT_BIT) && !target.getBooleanValue(BRIDGE_IS_FULL_BIT)) {
                    setBooleanValue(BRIDGE_TOP_SLOT_BIT, false);
                    setBooleanValue(BRIDGE_IS_FULL_BIT, true);
                    this.getLevel().setBlock(target, this, true);
                    this.getLevel().sendBlocks(Server.getInstance().getOnlinePlayers().values().toArray(new Player[0]), new Vector3[]{block});
                    return true;
                } else if (target.getBooleanValue(BRIDGE_TOP_SLOT_BIT) || target.getBooleanValue(BRIDGE_IS_FULL_BIT)) {
                    setBooleanValue(BRIDGE_TOP_SLOT_BIT, false);
                    this.getLevel().setBlock(this, this, true);
                    return true;
                } else return false;
            } else {
                setBooleanValue(BRIDGE_TOP_SLOT_BIT, false);
                this.getLevel().setBlock(this, this, true);
            }
        } else {
            setBooleanValue(BRIDGE_TOP_SLOT_BIT, fy > 0.5);
            this.getLevel().setBlock(this, this, true);
            return true;
        }
        return false;
    }
}
